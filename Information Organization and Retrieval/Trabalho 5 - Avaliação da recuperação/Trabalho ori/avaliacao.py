import numpy as np
import matplotlib.pyplot as plt
import sys

referencia = sys.argv[1]

'''
    Leitura do arquivo de referencia
'''
with open(referencia, 'r') as f:
    linhas = f.read().split('\n')

    qtd_consulta = int(linhas[0])  # Primeira linha armazena a quantidade de consultas realizadas

    if qtd_consulta < 0:
        print("O arquivo referência não possui nenhuma consulta!\n")
        exit()

    # Processo para obter as respostas ideais e as obtidas pelo algoritmo sendo testado
    resposta_ideal = {}
    ultima_linha_resposta_ideal = qtd_consulta

    resposta_obtida = {}
    ultima_linha_resposta_obtida = qtd_consulta * 2

    for i in range(1, ultima_linha_resposta_ideal + 1):
        resposta_ideal[i] = linhas[i].split(' ')

    for i in range(ultima_linha_resposta_ideal + 1, ultima_linha_resposta_obtida + 1):
        resposta_obtida[i-qtd_consulta] = linhas[i].split(' ')

    f.close()

'''
    Obtenção dos valores precisao X revocacao
'''

precisao_revocacao_por_consulta = {}
for consulta in range(1, qtd_consulta+1):
    precisao_por_revocacao = {}  # Dicionário que tem como chave e valor, respectivamente, a revocação e a precisão

    qtd_docs_relevantes_observados = 0
    total_docs_observados = 0

    docs_relevantes = resposta_ideal[consulta]
    docs_recuperados = resposta_obtida[consulta]

    for doc in docs_recuperados:  # Percorre cada documento relevante obtido pelo algoritmo sendo avaliado
        total_docs_observados += 1
        if doc in docs_relevantes:
            qtd_docs_relevantes_observados += 1

            revocacao = qtd_docs_relevantes_observados/len(docs_relevantes) * 100
            precisao = qtd_docs_relevantes_observados / total_docs_observados

            precisao_por_revocacao[revocacao] = precisao

    precisao_revocacao_por_consulta[consulta] = precisao_por_revocacao

'''
    Reagrupamento dos valores de precisão para as revocações (0, 10, 20,...,100)
'''

precisao_revocacao_por_consulta_reagrupada = {}
for consulta in precisao_revocacao_por_consulta:
    precisao_por_revocacao_reagrupada = {}

    for i in range(0, 101, 10):
        precisoes_validas = [p for r, p in precisao_revocacao_por_consulta[consulta].items() if r >= i]

        if len(precisoes_validas) == 0:
            # Caso não possua nenhuma precisão válida, ou seja, o array é vazio
            # então a precisão é igual a zero
            precisao_por_revocacao_reagrupada[i] = 0
        else:
            # Caso contrário, atribui a maior precisão
            precisao_por_revocacao_reagrupada[i] = np.max(precisoes_validas)

    precisao_revocacao_por_consulta_reagrupada[consulta] = precisao_por_revocacao_reagrupada

'''
    Calculo da media das precisões p/ cada nível de revocação
'''

precisao_media_por_revocacao = {r: 0 for r in range(0, 101, 10)}
for i in range(0, 101, 10):
    for consulta in precisao_revocacao_por_consulta_reagrupada:
        precisao_media_por_revocacao[i] += precisao_revocacao_por_consulta_reagrupada[consulta][i]

    precisao_media_por_revocacao[i] /= qtd_consulta

'''
    Escrita do arquivo media.txt
'''

frase = [str(precisao_media_por_revocacao[r]) for r in precisao_media_por_revocacao.keys()]

with open("media.txt", 'w+') as f:
    f.write(" ".join(frase))
    print("Arquivo media.txt foi gerado!\n")
    f.close()

'''
    Geração dos gráficos
'''

r = precisao_media_por_revocacao.keys()  # [0...100]

input("Aperte ENTER p/ ver os gráfico da precisão por revocação do algoritmo avaliado\n")

for i in range(1, qtd_consulta+1):
    p = [value * 100 for value in precisao_revocacao_por_consulta_reagrupada[i].values()]

    plt.title(f"Gráfico de precisão por revocação da consulta {i}")
    plt.ylabel('% Precisão')
    plt.xlabel('% Revocação')
    plt.xticks(np.arange(0, 101, step=10))
    plt.plot(r, p)
    plt.show()

p = [value * 100 for value in precisao_media_por_revocacao.values()]

plt.title('Gráfico da precisão média por revocação do sistema')
plt.ylabel('% Precisão')
plt.xlabel('% Revocação')
plt.xticks(np.arange(0, 101, step=10))
plt.plot(r, p)
plt.show()
