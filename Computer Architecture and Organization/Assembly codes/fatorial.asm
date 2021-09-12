.data
  str1: .asciiz "Insira o valor de N: "
  str2: .asciiz "O fatorial de N eh: "
  
.text
  # Ler valor de N
  la $a0, str1
  li $v0, 4
  syscall
   
  li $v0, 5 # Valor do input armazenado em $v0
  syscall
  # ---------------

  li $s0, 1 # Armazena o resultado
   
  move $s1, $v0 # $s1 passa
   
 calculaF:     
  mul $s0, $s0, $s1
  sub $s1, $s1, 1 
  bne $s1, 0, calculaF
      
  la $a0, str2
  li $v0, 4
  syscall
  
  move $a0, $s0
  li $v0, 1  
  syscall
   