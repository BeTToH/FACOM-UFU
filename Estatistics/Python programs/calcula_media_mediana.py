vetor = [7, 7.5, 8, 8, 8.5, 9]
vetor = sorted(vetor)
print(f"Elementos: {vetor}")
vetor_size = len(vetor)
print(f"Quantidade de elementos: {vetor_size}")
if vetor_size % 2 == 0:
    mediana = (vetor[vetor_size//2-1] + vetor[vetor_size//2]) / 2
else:
    mediana = vetor[vetor_size//2]

media = 0
for i in range(0, vetor_size):
    media += vetor[i]

media /= vetor_size

print(f"Mediana: {mediana}")
print(f"Media: {media}")
