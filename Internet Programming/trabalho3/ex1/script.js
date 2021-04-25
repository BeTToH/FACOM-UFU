window.onload = alert('Para abrir a modal clique no botão "Ver mais" perto de "Melhores Momentos"') // Executa um alerta com a mensagem especificada após a página ter sido carregada

function openModal(){ // Declara a função
    const modal = document.getElementById('modal'); // a constante 'modal' recebe o elemento determinado - no caso, pelo id
    modal.style.display = 'block'; // altera o atributo css display do elemento anteriormente selecionado para que ele apareça na tela
}

function closeModal(){
    const modal = document.getElementById('modal'); // a constante 'modal' recebe o elemento determinado - no caso pelo id
    modal.style.display = 'none'; // altera o atributo css display do elemento anteriormente selecionado para que ele desapareça na tela
}