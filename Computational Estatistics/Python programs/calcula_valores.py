from math import sqrt
elementos = [25, 16, 14, 10, 19, 15, 19, 16, 19, 18]
elementos = sorted(elementos)
n = len(elementos)

print(f"Elementos: {elementos}")
print(f"Quantidade de elementos: {n}")

if n % 2 == 0:
    mediana = (elementos[n//2-1] + elementos[n//2]) / 2
else:
    mediana = elementos[n//2]
print(f"Mediana: {mediana}")
    
media = 0
for i in range(0, n):
    media += elementos[i]

media /= n
print("Media: " + str(media))

variancia = 0
for i in range(n):
    variancia += (elementos[i]-media)**2

var_amostral = variancia / (n-1)
print(f"Variância amostral: {var_amostral}")

var_pop = variancia / n
print(f"Variância populacional: {var_pop}")

dp = sqrt(var_amostral)
print(f"Desvio padrão: {dp}")

cv = 100 * (dp/media)
print(f"Coeficiente de var: {cv}")
