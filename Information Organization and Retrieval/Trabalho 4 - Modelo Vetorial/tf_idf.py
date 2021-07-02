from math import log10


def get_tf_idf(dict_indice_invertido, dict_arquivos, gerar_arquivo=False):
    qntd_arquivos = len(dict_arquivos)
    pesos = {}
    idf_termo = {}
    for termo in dict_indice_invertido:
        idf_termo[termo] = log10(qntd_arquivos / len(dict_indice_invertido[termo]))  # Calcula idf do termo
        if idf_termo[termo] == 0:
            continue
        for arquivo in dict_arquivos:
            if arquivo in dict_indice_invertido[termo].keys():
                tf = 1 + log10(dict_indice_invertido[termo][arquivo])  # Calcula tf
                if tf == 0:
                    continue
                if arquivo not in pesos.keys():
                    pesos[arquivo] = {termo: tf * idf_termo[termo]}
                else:
                    pesos[arquivo][termo] = tf * idf_termo[termo]

    if gerar_arquivo:
        txt_pesos = ""
        for arquivo in pesos:
            txt_pesos += dict_arquivos[arquivo] + ":" + str(pesos[arquivo]).replace('{', '').replace('}', '').replace(',', ' ').replace(': ', ', ').replace("'", "") + "\n"

        # Preenche arquivo indice invertido
        with open("pesos.txt", 'w+') as arquivo_pesos:
            arquivo_pesos.write(txt_pesos)
            arquivo_pesos.close()

    return pesos, idf_termo


def calcula_tf_idf_consulta(dict_indice_invertido, dict_arquivos, idf_termo, gerar_arquivo=False):
    pesos = {}

    for termo in dict_indice_invertido:
        if idf_termo[termo] == 0:
            continue
        for arquivo in dict_arquivos:
            if arquivo in dict_indice_invertido[termo].keys():
                tf = 1 + log10(dict_indice_invertido[termo][arquivo])  # Calcula tf
                if tf == 0:
                    continue
                if arquivo not in pesos.keys():
                    pesos[arquivo] = {termo: tf * idf_termo[termo]}
                else:
                    pesos[arquivo][termo] = tf * idf_termo[termo]

    if gerar_arquivo:
        txt_pesos = ""
        for arquivo in pesos:
            txt_pesos += f"{dict_arquivos[arquivo]}: {str(pesos[arquivo]).replace('{', '').replace('}', '').replace(',', ' ').replace(': ', ', ')}\n"
            txt_pesos += "\n-----------------------------------\n"

        # Preenche arquivo indice invertido
        with open("pesos.txt", 'w+') as arquivo_pesos:
            arquivo_pesos.write(txt_pesos)
            arquivo_pesos.close()

    return pesos[1]
