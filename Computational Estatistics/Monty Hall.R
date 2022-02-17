runs <- 100000

portasPadrao <- c('right', 'wrong', 'wrong')

nvAcertosMantendoEscolha <- 0
nvAcertosMudandoEscolha <- 0

# Experimento  
for(i in 1:runs){
  portas <- sample(portasPadrao)
  portas
  
  portasErradasIndex <- which(portas %in% "wrong")
  portasErradasIndex
  
  chosenDoorIndex <- sample(1:3, 1)
  chosenDoorIndex
  chosenDoor <- portas[chosenDoorIndex]
  
  portaErradaIndex <- 0
  if(chosenDoor == "wrong") {
    portaErradaIndex <- portasErradasIndex[portasErradasIndex != chosenDoorIndex]
  } else {
    portaErradaIndex <- sample(portasErradasIndex, 1)
  }
  portaErradaIndex
  
  # Mantendo escolha
  if (chosenDoor == "right"){
    nvAcertosMantendoEscolha <- nvAcertosMantendoEscolha + 1
  }
  
  # Mudando escolha
  outraPortaIndex <- c(1:3)[c(1:3) != chosenDoorIndex]
  outraPortaIndex <- outraPortaIndex[outraPortaIndex != portaErradaIndex]
  
  outraPortaIndex
  chosenDoor <- portas[outraPortaIndex]
  if (chosenDoor == "right"){
    nvAcertosMudandoEscolha <- nvAcertosMudandoEscolha + 1
  }
}

nvAcertosMantendoEscolha / runs * 100
nvAcertosMudandoEscolha / runs * 100
