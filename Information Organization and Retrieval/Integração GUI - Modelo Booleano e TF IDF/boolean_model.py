from indice_invertido import get_indice_invertido
from nltk.stem import RSLPStemmer


def search(query, document_base):
    st = RSLPStemmer()

    dict_indice_invertido, dict_arquivos = get_indice_invertido(document_base)

    # Realiza a consulta
    consultas = query.split('|')  # Primeiramente, divide a consulta pelos operadores OR existentes

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
                    except KeyError:
                        conjunto = {}
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
        resposta.close()
