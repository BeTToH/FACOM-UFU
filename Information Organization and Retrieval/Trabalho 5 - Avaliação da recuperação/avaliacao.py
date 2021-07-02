import numpy as np
import matplotlib.pyplot as plt
import sys


arq_referencia = 'referencia.txt'#sys.argv[1]

# Lê o arquivo de referencia e extrai os dados
with open(arq_referencia, 'r') as f:
    linhas_arq = f.read().split('\n')

    qntd_consultas = int(linhas_arq[0])

    resposta_ideal = {}
    resposta_obtida = {}

    for i in range(1, qntd_consultas+1):
        resposta_ideal[i] = linhas_arq[i].split(' ')

    for i in range(qntd_consultas+1, (qntd_consultas*2+1)):
        resposta_obtida[i-qntd_consultas] = linhas_arq[i].split(' ')

    f.close()

# Obtem os valores precisao X revocacao p/ cada consulta realizada
precisao_revocacao_por_doc = {}
for consulta in range(1, qntd_consultas+1):  # percorre cada consulta
    precisao_por_revocacao = {}

    qntd_docs_relevantes_observados = 0
    qntd_docs_observados = 0
    docs_relevantes = resposta_ideal[consulta]
    docs_recuperados = resposta_obtida[consulta]
    for doc in docs_recuperados:  # percorre cada doc relevante obtido pelo algoritmo sendo avaliados
        qntd_docs_observados += 1
        if doc in docs_relevantes:
            qntd_docs_relevantes_observados += 1
            precisao_por_revocacao[qntd_docs_relevantes_observados/len(docs_relevantes)*100] = qntd_docs_relevantes_observados / qntd_docs_observados

    precisao_revocacao_por_doc[consulta] = precisao_por_revocacao

precisao_revocacao_por_doc_formatada = {}
for doc in precisao_revocacao_por_doc:
    precisao_por_revocacao_formatada = {}
    for i in range(0, 110, 10):
        precisoes_validas = [p for r, p in precisao_revocacao_por_doc[doc].items() if r >= i]
        if len(precisoes_validas) == 0:
            precisao_por_revocacao_formatada[i] = 0
        else:
            precisao_por_revocacao_formatada[i] = np.max(precisoes_validas)
    precisao_revocacao_por_doc_formatada[doc] = precisao_por_revocacao_formatada


precisao_media_por_revocacao = {}
for doc in precisao_revocacao_por_doc_formatada:
    for i in range(0 , 110, 10):
        if i in precisao_media_por_revocacao.keys():
            precisao_media_por_revocacao[i] += precisao_revocacao_por_doc_formatada[doc][i]
        else:
            precisao_media_por_revocacao[i] = precisao_revocacao_por_doc_formatada[doc][i]

txt_media = ""
for key in precisao_media_por_revocacao:
    precisao_media_por_revocacao[key] /= qntd_consultas
    txt_media += str(precisao_media_por_revocacao[key]) + " "

with open("media.txt", 'w+') as f:
    f.write(txt_media)
    f.close()

r = precisao_media_por_revocacao.keys()  # [0...100]

yticks = 0
while yticks != 1 and yticks != 2:
    yticks = int(input("Os gráficos serão mostrados a seguir!\nDeseja q os pontos no eixo y sejam marcados sobre o valor da precisão?\n 1 - Nao\n 2 - Sim\n"))

for i in range(1, qntd_consultas+1):
    input("Pressione ENTER p/ ver o gráfico da consulta " + str(i) + "\n")
    p = precisao_revocacao_por_doc_formatada[i].values()
    p = [value*100 for value in p]
    plt.title("Gráfico da da consulta " + str(i))
    plt.ylabel('Precisão em %')
    plt.xlabel('Revocação em %')
    plt.xticks(np.arange(0, 110, step=10))
    if yticks == 2:
        plt.yticks(p)
    plt.plot(r, p)
    plt.show()

p = precisao_media_por_revocacao.values()
p = [value*100 for value in p]
input("Pressione ENTER p/ ver o gráfico da Média do sistema\n")

plt.title('Gráfico da Média')
plt.ylabel('Precisão em %')
plt.xlabel('Revocação em %')
plt.xticks(np.arange(0, 110, step=10))
if yticks == 2:
    plt.yticks(p)
plt.plot(r, p)
plt.show()
