window.onload = () => { // após o término do carregamento da página ele executa o código
    const itemInput = document.getElementById('add-item-input'); // a constante recebe o elemento especificado - no caso, pelo id
    itemInput.addEventListener("keyup", e => { // adiciona um evento q sera chamado quando uma tecla for "levantada" (pressionada)
        if(e.key === 'Enter') // verifica se a tecla 'levantada' foi a tecla enter
            addItemList(); // caso sim, chama a função
    });
}

function addItemList() {
    const itemInput = document.getElementById('add-item-input'); // a constante recebe o elemento especificado - no caso, pelo id
    if (itemInput.value === "") { // verifica se o campo de input está vazio
        alert("É necessário preencher o campo!") // caso sim, mostra um alerta
        return false // e sai da função
    }

    const list = document.getElementById('list'); // a constante recebe o elemente especificado

    const novoLi = document.createElement('li'); // cria-se um novo elemento do tipo 'li' e designa-o para a constante
    const novoSpan = document.createElement('span'); // cria-se um novo elemento do tipo 'span' e designa-o para a constante
    const novoBtn = document.createElement('button'); // cria-se um novo elemento do tipo 'button' e designa-o para a constante

    novoSpan.textContent = itemInput.value; // o conteúdo de texto do elemento 'novoSpan' recebe o valor dentro do elemento 'add-item-input'
    novoBtn.textContent = 'X'; // o conteúdo de texto do elemento 'novoBtn' recebe 'X'

    novoLi.appendChild(novoSpan); // adiciona-se um elemento filho - no caso, o elemento armazenado na constante 'novoSpan' - ao elemento armazenado na constante 'novoLi'
    novoLi.appendChild(novoBtn) // adiciona-se um elemento filho - no caso, o elemento armazenado na constante 'novoBtn' - ao elemento armazenado na constante 'novoLi'
    list.appendChild(novoLi); // adiciona-se um elemento filho - no caso, o elemento armazenado na constante 'novoLi' - ao elemento armazenado na constante 'list'

    novoBtn.onclick = () => { // adiciona-se um evento ao elemento armazenado na constante 'novoBtn' ao clicá-lo
        list.removeChild(novoLi); // o evento é a remoção do filho especificado do elemento armazenado na constante 'list'
    }

    itemInput.value = ""; // o valor do elemento armazenado na constante 'itemInput' recebe uma string vazia
}
