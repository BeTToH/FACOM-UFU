window.onload = () => {
    document.forms.formCadastro.onsubmit = validaForm; // determina uma função q será chamada quando o form for 'submetido'
}

function validaForm(e){
    let form = e.target; // variavel for recebe o elemento q acionou o evento/função
    let formValido = true; // determina q o formulario é valido

    const spanUsuario = form.usuario.nextElementSibling; // armazena o proximo elemento irmao do campo de input usuario do form - no caso, o elemento span - na constante
    const spanSenha = form.senha.nextElementSibling; // armazena o proximo elemento irmao do campo de input senha do form - no caso, o elemento span - na constante
    const spanEmail = form.email.nextElementSibling; // armazena o proximo elemento irmao do campo de input email do form - no caso, o elemento span - na constante

    spanUsuario.textContent = ''; // determina o conteudo de texto do elemento como uma string vazia
    spanSenha.textContent = ''; // determina o conteudo de texto do elemento como uma string vazia
    spanEmail.textContent = ''; // determina o conteudo de texto do elemento como uma string vazia

    if (form.usuario.value === ''){ // verifica se o valor do campo de input usuario é uma string vazia
        spanUsuario.textContent = "O usuário deve ser preenchido"; // determina o conteudo de texto do elemento 'spanUsuario'
        formValido = false; // determina q o form não é válido - devido esse campo não estar preenchido
    }

    if (form.senha.value === ''){ // verifica se o valor do campo de input senha é uma string vazia
        spanSenha.textContent = "A senha deve ser preenchida"; // determina o conteudo de texto do elemento 'spanSenha'
        formValido = false; // determina q o form não é válido - devido esse campo não estar preenchido
    }

    if (form.email.value === ''){ // verifica se o valor do campo de input email é uma string vazia
        spanEmail.textContent = "O e-mail deve ser preenchido"; // determina o conteudo de texto do elemento 'spanEmail'
        formValido = false; // determina q o form não é válido - devido esse campo não estar preenchido
    }

    return formValido // retorna se o form é válido ou não - caso seja, o formulário será processado, caso contrário nada acontece (além do aparecimento das mensagens nos campos span).
}