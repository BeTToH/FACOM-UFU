import sys
from math import log, log10
from indice_invertido import get_indice_invertido

log = log10


def gera_tf_idf(base):
    # Obtem a estrutura do indice invertido da base
    dict_indice_invertido, dict_arquivos = get_indice_invertido(base)

    qntd_arquivos = len(dict_arquivos)
    pesos = {}
    idf_termo = {}
    for termo in dict_indice_invertido:
        idf_termo[termo] = log(qntd_arquivos / len(dict_indice_invertido[termo]))  # Calcula idf do termo
        if idf_termo[termo] == 0:
            continue
        for arquivo in dict_arquivos:
            if arquivo in dict_indice_invertido[termo].keys():
                tf = 1 + log(dict_indice_invertido[termo][arquivo])  # Calcula tf
                if tf == 0:
                    continue
                if arquivo not in pesos.keys():
                    pesos[arquivo] = {termo: tf * idf_termo[termo]}
                else:
                    pesos[arquivo][termo] = tf * idf_termo[termo]

    txt_pesos = ""
    for arquivo in pesos:
        txt_pesos += f"{dict_arquivos[arquivo]}: {str(pesos[arquivo]).replace('{', '').replace('}', '').replace(',', ' ').replace(': ', ', ')}\n"

    # Preenche arquivo indice invertido
    with open("pesos.txt", 'w+') as arquivo_pesos:
        arquivo_pesos.write(txt_pesos)
        arquivo_pesos.close()
