import nltk.tokenize
from nltk.corpus import stopwords
from nltk.stem.lancaster import LancasterStemmer
import sys
import collections
import os

docs = []
tokenizer = nltk.tokenize.RegexpTokenizer(r'\w+')
st = LancasterStemmer()

#base = sys.argv[1]
#base = os.path.join(os.getcwd(), base)
base = os.path.join(os.getcwd(), "base_samba")
arquivo_consulta = "amou & amassou" # sys.argv[2]

dict_arquivos = {}
try:
    # Constrói o índice invertido
    dict_indice_invertido = {}
    cont_arquivo = 0
    for file in os.listdir(base):
        file_path = os.path.join(base, file)
        cont_arquivo += 1
        dict_arquivos[cont_arquivo] = file  # Dicionário que armazena como chave a posição do arquivo e como valor o seu nome
        with open(file_path, 'r') as f:
            txt_arquivo = f.read()

            palavras = tokenizer.tokenize(txt_arquivo)
            palavras_nao_stopword = [palavra for palavra in palavras if
                    palavra not in stopwords.words('portuguese')]
            radical_palavras = [st.stem(palavra) for palavra in palavras_nao_stopword]

            for palavra in radical_palavras:
                if palavra not in dict_indice_invertido.keys():
                    dict_indice_invertido[palavra] = {cont_arquivo: 1}
                else:
                    if cont_arquivo not in dict_indice_invertido[palavra].keys():
                        dict_indice_invertido[palavra][cont_arquivo] = 1
                    else:
                        dict_indice_invertido[palavra][cont_arquivo] += 1

    dict_indice_invertido_ordenado = collections.OrderedDict(sorted(dict_indice_invertido.items()))  # Gera um dicionário ordenado, para melhor preencher o arquivo indice invertido

    txt_indice_invertido = ""
    for word in dict_indice_invertido_ordenado:
        txt_indice_invertido += f"{word}: {str(dict_indice_invertido_ordenado[word]).replace('{', '').replace('}', '').replace(',', '').replace(': ', ',')}\n"

    with open("inverted_index.txt", 'w+') as arquivo_indice_invertido:
        arquivo_indice_invertido.write(txt_indice_invertido)
        f.close()

    # Consulta
    with open(arquivo_consulta, 'r') as f:
        consulta = f.read()  # Lê o arquivo com a consulta e armazena ela em uma variável
        f.close()

    consultas = consulta.split('|')  # Primeiramente, divide a consulta pelos operadores OR existentes

    conjunto_final = set()
    conjunto = set()
    for consulta in consultas:  # Realiza um consulta separada para cada uma anteriormente dividida
        consulta = consulta.split('&')

        count = 0
        for palavra in consulta:
            palavra = st.stem(palavra.strip())
            if count == 0:
                if '!' in palavra:
                    conjunto = set(dict_arquivos.keys())                    
                    conjunto = conjunto.difference(dict_indice_invertido[st.stem(palavra.lstrip('!'))].keys())
                else:
                    try:
                        conjunto = set(dict_indice_invertido[palavra].keys())
                        print(conjunto)
                    except KeyError:
                        conjunto = set()
            else:
                if '!' in palavra:
                    conjunto = conjunto.intersection(set(dict_arquivos.keys()).difference(dict_indice_invertido[st.stem(palavra.lstrip('!'))].keys()))
                else:
                    try:
                        conjunto = conjunto.intersection(set(dict_indice_invertido[palavra].keys()))
                    except KeyError:
                        conjunto = {}
            count += 1

        conjunto_final = conjunto_final.union(conjunto)

    txt_arquivos = ''
    for file in conjunto_final:
        txt_arquivos += dict_arquivos[file] + '\n'

    with open("answer.txt", 'w+') as resposta:
        resposta.write(str(len(conjunto_final)) + '\n' + txt_arquivos)
        f.close()

except FileNotFoundError as ex:
    print("Erro: arquivo base não é válido!")
