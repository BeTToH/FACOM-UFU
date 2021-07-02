import os


def obter_arquivos_base(base):
    if '\\' in base:  # verificar se a base está em um outro diretório
        base_dir = base.split('\\')[0]
        # base_file = base.split('\\')[1]
    else:
        base_dir = os.getcwd()
    base = os.path.join(os.getcwd(), base)

    docs = []
    with open(base) as f:
        for line in f:
            docs.append(line.rstrip("\n"))
        f.close()

    return docs, base_dir
