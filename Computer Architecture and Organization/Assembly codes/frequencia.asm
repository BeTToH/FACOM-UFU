.data
str1: .asciiz "Insira um valor inteiro: "
str2: .asciiz "O valor aparece "
str3: .asciiz " vez(es) no array."

array: .word 1, 1, 2, 3, 2, 4, 5, 6, 5, 4, 8, 9, 1, 1, 14
size: .word 15
i: .word 0

.text
# Ler elemento
la $a0, str1
li $v0, 4
syscall
   
li $v0, 5
syscall

move $s3, $v0
# ------------

la $s0, array
lw $s1, i
lw $s2, size
# $s3 -> valor passado pelo usuario
# $s4 -> aux p/ armazenar elemento do index
li $s6, 0 # Conta qnts vezes o elemento aparece

loop:
   bgt $s1, $s2, fim
   
   sll $s4, $s1, 2 # 4 * i - acessar endereço do array
   add $s4, $s4, $s0
   
   lw $s5, 0($s4)
   
   beq $s3, $s5, add_   
   add $s1, $s1, 1 
   j loop
   
add_:
  add $s6 $s6, 1
  add $s1, $s1, 1 
  j loop
  
fim:
 la $a0, str2
 li $v0, 4
 syscall
   
 move $a0, $s6
 li $v0, 1
 syscall
 
 la $a0, str3
 li $v0, 4    
 syscall
  