.data
	array: .space 168
	msgInput: .asciiz "Insira um numero inteiro: "
	msgSoma: .asciiz "O resultado da soma eh: "
	msgMenor: .asciiz "O menor valor eh: "
	msgMaior: .asciiz "O maior valor eh: "
	barra_n: .asciiz "\n"
	
	counter: .word 0
	size: .word 42
.text
j _start

# funções
somaValoresArray:
	beq $s0, $s1, saiFunc
	
	lw	 $t0, 0($s7)
	addiu $s7, $s7, 4
	
	addu $s6, $s6, $t0
	
	addi $s0, $s0, 1
	j somaValoresArray
	
# --	

menorValorArray:	
	beq $s0, $s1, saiFunc
	
	lw	 $t0, 0($s7)
	addiu $s7, $s7, 4				
	
	beq $s0, $zero, salvaMenorValor
	
	slt $t1, $s5, $t0
	beq $t1, $zero, salvaMenorValor
		
	addi $s0, $s0, 1
	j menorValorArray
	
salvaMenorValor:
	add $s5, $zero, $t0
	addi $s0, $s0, 1
	j	menorValorArray
	
# --

maiorValorArray:	
	beq $s0, $s1, saiFunc
	
	lw	 $t0, 0($s7)
	addiu $s7, $s7, 4				
	
	beq $s0, $zero, salvaMaiorValor
	
	slt $t1, $t0, $s4
	beq $t1, $zero, salvaMaiorValor
	
	addi $s0, $s0, 1
	j maiorValorArray
	
salvaMaiorValor:
	add $s4, $zero, $t0
	addi $s0, $s0, 1
	j	maiorValorArray
	
# --

saiFunc:
	jr $ra
	
# -------

_start:	
	# $t0 -> aux valor
	# $t1 -> aux comparação
	
	lw $s0, counter 
	lw $s1, size
	li $s4, 0 # maior valor
	li $s5, 0 # menor valor
	li $s6, 0 # soma
	la $s7, array	

leArray:
	beq $s0, $s1, saida

	la $a0, msgInput
	li $v0, 4
	syscall
		
	addiu $v0 , $zero, 5
	syscall
	
	sw	 $v0, 0($s7)
	addiu $s7, $s7, 4
	
	addi $s0, $s0, 1
	j leArray
	
saida:
	li $s0, 0
	la $s7, array
	
	jal somaValoresArray
	
	la $a0, msgSoma
	li $v0, 4
	syscall
	
	add $a0, $zero, $s6
	li $v0, 1
	syscall
	
	la $a0, barra_n
	li $v0, 4
	syscall
	
	li $s0, 0
	la $s7, array
	
	jal menorValorArray		
	
	la $a0, msgMenor
	li $v0, 4
	syscall
	
	add $a0, $zero, $s5
	li $v0, 1
	syscall
	
	la $a0, barra_n
	li $v0, 4
	syscall	
	
	li $s0, 0
	la $s7, array
	
	jal maiorValorArray
	
	la $a0, msgMaior
	li $v0, 4
	syscall
	
	add $a0, $zero, $s4
	li $v0, 1
	syscall
	
	addiu $v0, $zero, 10
	syscall