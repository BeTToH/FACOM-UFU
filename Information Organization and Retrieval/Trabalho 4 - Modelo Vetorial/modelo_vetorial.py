import sys
from math import sqrt
from os import getcwd
from manipula_arquivos import obter_arquivos_base
from tf_idf import get_tf_idf, calcula_tf_idf_consulta
from indice_invertido import get_indice_invertido


def calcula_similaridade(pesos_consulta, pesos_base):
    dict_similaridade = {}

    # Calcula o valor do numerador
    for arquivo in pesos_base:
        for termo in pesos_consulta:
            if termo in pesos_base[arquivo].keys():
                if arquivo not in dict_similaridade.keys():
                    dict_similaridade[arquivo] = pesos_base[arquivo][termo] * pesos_consulta[termo]
                else:
                    dict_similaridade[arquivo] += pesos_base[arquivo][termo] * pesos_consulta[termo]

    # Calcular a somatória dos pesos ao quadrado da consulta
    somatoria_consulta = somatoria_quadrado_pesos_arquivo(pesos_consulta)

    # Calcular a somatoria dos pesos ao quadrado dos arquivos da base + Calculo final
    for arquivo in pesos_base:
        if arquivo in dict_similaridade.keys():
            dict_similaridade[arquivo] = dict_similaridade[arquivo] / (sqrt(somatoria_quadrado_pesos_arquivo(pesos_base[arquivo])) * sqrt(somatoria_consulta))

    return dict_similaridade


def somatoria_quadrado_pesos_arquivo(pesos: dict):
    soma = 0
    for termo in pesos:
        soma += pesos[termo]*pesos[termo]

    return soma


def filtra_sim(sim, valor=0.001):
    filtered_dict = {}
    for arquivo in sim:
        if sim[arquivo] >= valor:
            filtered_dict[arquivo] = sim[arquivo]

    return filtered_dict


base = sys.argv[1]
consulta = sys.argv[2]

# Obtem os pesos da base
docs, base_dir = obter_arquivos_base(base)

dict_indice_invertido, dict_arquivos = get_indice_invertido(docs, base_dir)

pesos_base, idf_termos = get_tf_idf(dict_indice_invertido, dict_arquivos, True)

# Obtem os pesos dos termos da consulta
arquivos_consulta = [consulta]
dict_indice_invertido_consulta, dict_arquivos_consulta = get_indice_invertido(arquivos_consulta, getcwd())

pesos_consulta = calcula_tf_idf_consulta(dict_indice_invertido_consulta, dict_arquivos_consulta, idf_termos)

dict_similaridade = calcula_similaridade(pesos_consulta, pesos_base)
dict_similaridade = filtra_sim(dict_similaridade)
dict_similaridade_ordenado = dict(sorted(dict_similaridade.items(), key=lambda item: item[1], reverse=True))

txt_pesos = str(len(dict_similaridade)) + '\n'
for arquivo in dict_similaridade_ordenado:
    txt_pesos += f"{dict_arquivos[arquivo]}: {str(dict_similaridade_ordenado[arquivo])}\n"

# Preenche arquivo indice invertido
with open("resposta.txt", 'w+') as arquivo_sim:
    arquivo_sim.write(txt_pesos)
    arquivo_sim.close()
