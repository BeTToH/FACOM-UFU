import os
import random
import sys
from bs4 import BeautifulSoup as bs

# read from cmd line
dir_name = "base0"

# get files from dir
base_path = os.path.join(os.getcwd(), dir_name)
files = [f for f in os.listdir(base_path) if os.path.isfile(os.path.join(base_path, f))]

# Get docs info
number_of_docs = len(files)
origin_links = {}
destiny_links = {}
doc_accessibility = {}  # Acessibilidade pelo método de amostragem
doc_accessibility_i = {}  # Acessibilidade pelo método iterativo

for file in files:
    doc_accessibility[file] = 0
    doc_accessibility_i[file] = 1/number_of_docs

    with open(os.path.join(base_path, file)) as f:
        soup = bs(f, "html.parser")
        f.close()

    links = [link["href"] for link in soup.findAll('a')]
    links = list(set(links))

    origin_links[file] = []
    for point_to in links:
        origin_links[file].append(point_to)

        if point_to not in destiny_links.keys():
            destiny_links[point_to] = [file]
        else:
            destiny_links[point_to].append(file)

for file in files:
    if file not in destiny_links.keys():
        destiny_links[file] = []

# Calc page rank
print("Calculando PageRank...\n")

# Método de amostragem
dumping_factor = 0.85
transitions_number = 1000
current_doc = random.choice(files)  # Select initial document

# Simulating transitions
for i in range(0, 1000):
    if random.random() < dumping_factor:
        next = random.choice(origin_links[current_doc])
    else:
        next = random.choice(files)

    doc_accessibility[next] += 1
    current_doc = next

for key in doc_accessibility.keys():
    doc_accessibility[key] = doc_accessibility[key] / transitions_number


# Método iterativo
criterio_parada = 0.000001

FLAG = True
while FLAG:
    doc_accessibility_i_aux = doc_accessibility_i.copy()  # Copia os valores p/ um dict auxiliar

    # Atualiza os valores do PR de cada doc
    for file in files:
        p_random = (1 - dumping_factor)/number_of_docs

        p_link = 0
        for reference_file in destiny_links[file]:
            num_links = len(origin_links[reference_file])
            pr = doc_accessibility_i_aux[reference_file]
            p_link += pr/num_links
        p_link *= dumping_factor

        doc_accessibility_i[file] = p_random + p_link

    # Corrige os PR's p/ que a soma seja 1
    divisor = 0
    for file_i in files:
        divisor += doc_accessibility_i[file_i]

    for file_j in files:
        doc_accessibility_i[file_j] = doc_accessibility_i[file_j] / divisor

    # Verifica se houve mudança significativa em todos os PR
    for file in files:
        if abs(doc_accessibility_i_aux[file] - doc_accessibility_i[file]) <= criterio_parada:
            FLAG = False
            break

'''

WRITE FILES
-----------------------------------------------------------

Nome: links_origem.txt
Corpo: <doc>: <lista de documentos para os quais o doc aponta>

'''

txt = ""
for file in files:
    txt += file + ': '
    txt += ', '.join(str(f) for f in origin_links[file])
    txt += '\n'

with open("links_origem.txt", 'w+') as links_origem:
    links_origem.write(txt)
    links_origem.close()


'''
-------------------------------------------------------

Nome: links_destino.txt
Corpo: <doc>: <lista de documentos que apontam para o doc>

'''

txt = ""
for file in files:
    txt += file + ': '
    txt += ', '.join(str(f) for f in destiny_links[file])
    txt += '\n'

with open("links_destino.txt", 'w+') as links_destino:
    links_destino.write(txt)
    links_destino.close()

'''
-------------------------------------------------------

Nome: pg_amostragem.txt
Corpo: nome_arquivo valor_page_rank
Cálculo do PageRank de cada arquivo pelo método de amostragem
Nº transições: 1000
Fator de dumping: 85%

'''

txt = ""
for file in files:
    txt += file + ': ' + str(doc_accessibility[file]) + '\n'

with open("pg_amostragem.txt", 'w+') as pg_amostragem:
    pg_amostragem.write(txt)
    pg_amostragem.close()

'''
-------------------------------------------------------

Nome: pg_iterativo.txt
Corpo: nome_arquivo valor_page_rank
Cáculo do PageRank de cada arquivo pelo método iterativo.
Para o critério de parada do algoritmo,
considere que os valores de PageRank convergiram quando a diferença entre os PageRank’s de duas
iterações consecutivas não é maior que 10^-6


'''

txt = ""
for file in files:
    txt += file + ': ' + str(doc_accessibility_i[file]) + '\n'

with open("pg_iterativo.txt", 'w+') as pg_iterativo:
    pg_iterativo.write(txt)
    pg_iterativo.close()

print("Arquivos gerados!\n")