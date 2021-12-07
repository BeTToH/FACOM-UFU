# mod - ou resto da divisão
56 %% 9

# guardando valores dentro de um objeto
a <- 2+2
b = 3+4 

# sortear numeros aleatorios
# runif(n, min=0, max=1) - sorteia n numeros entre min e max
runif(2)

# criando vetores no R
vetor <- c(5,10,15)
vetor[1] # No R, o index de um vetor começa em 1 

vetor[c(2,3,2)]

a <- 10:21
a[1:5]

sum(vetor)
mean(vetor)

w <- c(TRUE, FALSE, TRUE) # vetor lógico
class(w)
class(vetor)

sum(w) # True = 1; False = 0

vetor[w] # Vetor lógico define quais itens serão selecionados


y <- seq(2, 78, by=3) 
length(y)
y[c(21,18)]

y < 33
y[y < 33] # Seleciona os valores do vetor que são menores que 33

z <- seq(2, 8, by=2)

z+12 # soma 12 em todos os valores do vetor
z-1
z/2
z*2
z**2

k <- seq(1, 7, by=2)
z
k
z + k # soma o valor dos respectivos índices

# se um vetor é maior que o outro, 
#os valores do menor são reciclados

k <- seq(1, 15, by=2)
z
k
z + k


x <- "robert"
class(x)

frutas <- c('manga', 'pera', 'maçã')
frutas
class(frutas)

# Não é possível vetores com tipos diferentes
vetor_misto <- c(z, frutas)
class(vetor_misto)

vetor_logico <- c(TRUE, FALSE, FALSE)
vetor_misto <- c(vetor_logico, z)
vetor_misto
class(vetor_misto)

vetor_misto <- c(vetor_logico, frutas)
vetor_misto
class(vetor_misto)
