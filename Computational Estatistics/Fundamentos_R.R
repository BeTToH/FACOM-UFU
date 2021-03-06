# mod - ou resto da divis�o
56 %% 9

# guardando valores dentro de um objeto
a <- 2+2
b = 3+4 

# sortear numeros aleatorios
# runif(n, min=0, max=1) - sorteia n numeros entre min e max
runif(2)

# criando vetores no R
vetor <- c(5,10,15)
vetor[1] # No R, o index de um vetor come�a em 1 

vetor[c(2,3,2)]

a <- 10:21
a[1:5]

w <- c(TRUE, FALSE, TRUE) # vetor l�gico
class(w)
class(vetor)

sum(w) # True = 1; False = 0

vetor[w] # Vetor l�gico define quais itens ser�o selecionados


y <- seq(2, 78, by=3) 
length(y)
y[c(21,18)]

y < 33
y[y < 33] # Seleciona os valores do vetor que s�o menores que 33

z <- seq(2, 8, by=2)

z+12 # soma 12 em todos os valores do vetor
z-1
z/2
z*2
z**2

k <- seq(1, 7, by=2)
z
k
z + k # soma o valor dos respectivos �ndices

# se um vetor � maior que o outro, 
#os valores do menor s�o reciclados

k <- seq(1, 15, by=2)
z
k
z + k


x <- "robert"
class(x)

frutas <- c('manga', 'pera', 'ma��')
frutas
class(frutas)

# N�o � poss�vel vetores com tipos diferentes
vetor_misto <- c(z, frutas)
class(vetor_misto)

vetor_logico <- c(TRUE, FALSE, FALSE)
vetor_misto <- c(vetor_logico, z)
vetor_misto
class(vetor_misto)

vetor_misto <- c(vetor_logico, frutas)
vetor_misto
class(vetor_misto)

# --------------------------
y
y[c(1,2)][y[c(1,2)] %% 2 == 0]

          
# Fun��es �teis
v <- sample(3 : 500, size=56, replace=TRUE)
v
length(v)
max(v)
min(v)
sum(v)
mean(v)
var(v) # vari�ncia
sqrt(var(v)) # raiz quadrada da vari�ncia -> desvio padr�o
sd(v) # standard variation ou desvio padr�o

v
sort(v) # Ordera o vetor
order(v) # Returns the indices that would put the initial vector x in order
rank(v) #  Returns a vector with the "rank" of each value

# Matrizes
A <- matrix(data=c(12, 23, 14, 0), nrow=2, byrow=TRUE)
A

A[1,]
A[2,]

A[,1]
A[,3]

A[,2][2]

A[2, 3] <- 'w'
A

t(A) # Transposta
diag(A) # Diagonal

A %*% A# Operador de produto de matriz

isSymmetric(A) # Verifica se a matriz � sim�trica

# Uma Matriz � sim�trica se a sua tranposta for igual a ela
sum(t(A) == A) == 4 

A

det(A) # Determinante
solve(A) # Inversa

# Fun��o Sample
?sample
sample(10) # Rearranja os numeros de 1 a 10

sample(10, replace=TRUE) # Sorteia 10 elementos de 1 a 10

sample(10:15, size=10, replace=TRUE) # Sorteia 10 numeros de 10 a 15 

dado1 <- sample(1:6, size=100000, replace=TRUE)
vezes_deu_1 <- sum(dado1 == 1) # Qnts vezes saiu o numero 1
vezes_deu_1 / 100000
1/6

dado2 <- sample(1:6, size=100000, replace=TRUE, 
                prob=c(1/12, 1/12, 1/12, 1/12, 1/12, 7/12))
vezes_deu_6 <- sum(dado2 == 6) # Qnts vezes saiu o numero 1
vezes_deu_6 / 100000
7/12

vezes_deu_1 <- sum(dado2 == 1) # Qnts vezes saiu o numero 1
vezes_deu_1 / 100000
1/12

dado2 <- sample(1:6, size=100000, replace=TRUE)
# Soma do lan�amento de dois dados
dado1
dado2
soma <- dado1 + dado2
soma

sum(soma == 2) / 100000
1/36
