import nltk.tokenize
from nltk.corpus import stopwords, mac_morpho
from nltk.stem import RSLPStemmer
import sys
import collections
import os
import pickle

dict_indice_invertido = {}  # Dicionário que armazena como chave a posição do arquivo e como valor o seu nome
dict_arquivos = {}  # Dict{ Chave -> pos do arquivo na base, Valor -> Nome do arquivo }


def main():
    base = sys.argv[1]  # Recebe parametro do usuário

    if '\\' in base:  # verificar se a base está em um outro diretório
        base_dir = base.split('\\')[0]
        # base_file = base.split('\\')[1]
    else:
        base_dir = os.getcwd()
    base = os.path.join(os.getcwd(), base)

    docs = obter_arquivos_base(base)

    gera_indice_invertido(docs, base_dir)

    # Gera um dicionário ordenado, para melhor preencher o arquivo indice invertido
    dict_indice_invertido_ordenado = collections.OrderedDict(sorted(dict_indice_invertido.items()))

    # Gera uma string para preencher o arquivo indice_invertido
    txt_indice_invertido = ""
    for word in dict_indice_invertido_ordenado:
        txt_indice_invertido += f"{word}: {str(dict_indice_invertido_ordenado[word]).replace('{', '').replace('}', '').replace(',', '').replace(': ', ',')}\n"

    # Preenche arquivo indice invertido
    with open("indice_invertido.txt", 'w+') as arquivo_indice_invertido:
        arquivo_indice_invertido.write(txt_indice_invertido)
        arquivo_indice_invertido.close()


# Remove stopwords
def filtra_palavras(palavras):
    # Verifica se já existe o etiquetador treinado
    if os.path.exists("etiquetador.bin"):  # Se sim: apenas o carrega
        etiquetador = pickle.load(open("etiquetador.bin", "rb"))
    else:  # Se não: treina ele e o salva
        palavras_treinar = mac_morpho.tagged_sents()
        etiquetador = nltk.tag.UnigramTagger(palavras_treinar)
        pickle.dump(etiquetador, open("etiquetador.bin", "wb"))

    palavras_etiquetadas = etiquetador.tag(palavras)

    palavras_filtradas = []
    for palavra in palavras_etiquetadas:
        if palavra[0] not in stopwords.words('portuguese'):
            if not (palavra[1] == 'KS' or palavra[1] == 'KC' or palavra[1] == 'ART' or palavra[1] == 'PREP'):
                palavras_filtradas.append(palavra[0])

    return palavras_filtradas


def obter_arquivos_base(base):
    docs = []
    with open(base) as f:
        for line in f:
            docs.append(line.rstrip("\n"))
        f.close()

    return docs


# Gera dicionário indice invertido
def gera_indice_invertido(docs, base_dir):
    # Utilitários necessários
    tokenizer = nltk.tokenize.RegexpTokenizer(r'\w+')
    st = RSLPStemmer()
    # ------------------------------------------------

    cont_arquivo = 0
    for file in docs:
        cont_arquivo += 1
        dict_arquivos[cont_arquivo] = file

        caminho_arquivo = os.path.join(base_dir, file)
        with open(caminho_arquivo, 'r') as f:
            txt_arquivo = f.read()

            palavras = tokenizer.tokenize(txt_arquivo)

            palavras = filtra_palavras(palavras)

            radical_palavras = [st.stem(palavra) for palavra in palavras]  # Obtem apenas o radical de cada palavra

            for palavra in radical_palavras:
                if palavra not in dict_indice_invertido.keys():
                    dict_indice_invertido[palavra] = {cont_arquivo: 1}
                else:
                    if cont_arquivo not in dict_indice_invertido[palavra].keys():
                        dict_indice_invertido[palavra][cont_arquivo] = 1
                    else:
                        dict_indice_invertido[palavra][cont_arquivo] += 1
            f.close()

main()