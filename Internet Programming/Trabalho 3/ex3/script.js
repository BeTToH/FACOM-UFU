window.onload = () => { // após o término do carregamento da página ele executa o código
    const buttons = document.querySelectorAll('nav button'); // armazena um array com todos os elementos buttons filhos de um elemento nav na constante
    for (let button of buttons) { // percorre todos os botões
        button.addEventListener('click', changeTab); // para cada um deles adiciona um evento ao ser clicado chamando a função especificada - no caso, 'changeTab'
    }
    openTab(0); // chama a função 'openTab' passando como paramentro o numero 0, assim ao abrir a pagina a section aparecendo será a primeira
}

function changeTab(e){ // declara a função que recebe como parametro informações sobre o evento
    const btnAcionado = e.target; // recebe o objeto que disparou o evento
    const liDoBtn = btnAcionado.parentNode; // obtem o elemento pai do botão, no caso um li
    const nodes = Array.from(liDoBtn.parentNode.children); // obtem o pai do li, no caso um ul e, após, os filhos desse elemento ul - um conjunto de elementos li - e os armazenam em um array
    const index = nodes.indexOf(liDoBtn); // obtem a posição no array do elemento li a qual o botão pressionado é filho
    openTab(index); // chama a função passando como parametro tal posição
}

function openTab(i){ // declara a função que recebe como parametro um valor inteiro que refere a posição no array
    const tabAtiva = document.querySelector('.tabAtiva'); // seleciona o primeiro elemento com a classe 'tabAtiva'
    if (tabAtiva !== null) // verifica se o elemento não é nulo, caso seja nulo não há nenhum elemento com a classe especificada anteriormente
        tabAtiva.className = ""; // caso n seja nulo, retira a classe q ele tinha ('tabAtiva')

    const btnAtivo = document.querySelector('.btnAtivo'); // seleciona o primeiro elemento com a classe 'btnAtivo'
    if (btnAtivo !== null) // verifica se o elemento não é nulo
        btnAtivo.className = ""; // caso n seja nulo, retira a classe q ele tinha ('btnAtivo')

    document.querySelectorAll('.tabs section')[i].className = 'tabAtiva'; // seleciona o elemento com os atributos especificado na posição recebida como parametro e designa sua classe para 'tabAtiva' para que ela se torne visivel
    document.querySelectorAll('nav button')[i].className = 'btnAtivo'; // realiza o msm processo, porém com o botão da barra de navegação
}