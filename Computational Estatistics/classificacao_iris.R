data(iris)
iris <- iris[sample(nrow(iris)),]
iris

z <- round(0.8*nrow(iris))

# Dataset de treino engloba 80% dos dados do dataset total
treino <- iris[1:z,] 

# Dataset de teste será formado pelo restante dos dados
teste <- iris[(z+1):nrow(iris),] 


# Separa por tipo
setosa <- treino[treino$Species == "setosa",]

versicolor <- treino[treino$Species == "versicolor",]

virginica <- treino[treino$Species == "virginica",]

# Monta o gráfico
plot(treino$Petal.Length, treino$Petal.Width, type = "n", 
     xlab = "Tamanho da Pétala", ylab = "Largura da Pétala")

points(setosa$Petal.Length, setosa$Petal.Width, pch=16, col="red")

points(versicolor$Petal.Length, versicolor$Petal.Width, pch=16, col="blue")

points(virginica$Petal.Length, virginica$Petal.Width, pch=16, col="green")


sort(versicolor$Petal.Width)

abline(v=2.5) # Linha corta o gráfico por completo

segments(x0=2.5, y0=1.65, x1=8, y1=1.65) # Conecta dois pontos


# Criando uma árvore de decisão
classificacao <- c()
for (j in 1:nrow(teste)){
  if(teste$Petal.Length[j] < 2.5)
    classificacao[j] <- "setosa"
  else {
    if(teste$Petal.Width[j] < 1.65)
      classificacao[j] <- "versicolor"
    else 
      classificacao[j] <- "virginica"
  }
}
classificacao == teste$Species
mean(classificacao == teste$Species)

table(classificacao, teste$Species)
