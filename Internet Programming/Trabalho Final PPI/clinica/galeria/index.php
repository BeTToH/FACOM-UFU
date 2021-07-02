<?php
session_start();
?>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="description" content="Clínica Geral Asylum. Agende consultas sem sair de casa.">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="../styles/galeria.css">
    <link rel="stylesheet" href="../styles/layout.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <title>Galeria</title>
</head>
<body>
<header>
    <nav class="navbar navbar-expand-lg navbar-light" id="navbar">
        <h1><a href="../">Clínica Asylum</a></h1>

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarBtns" aria-controls="navbarBtns" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarBtns">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <?php
                $agendamentosMed = '';
                if(isset($_SESSION["COD_MEDICO"]))
                    $agendamentosMed = '<li class="nav-item">
                                    <a class="nav-link" href="/listarAgendamentos?medico='. $_SESSION["COD_MEDICO"] .'">Meus Agendamentos</a>
                                </li>';

                if(isset($_SESSION["email"])) {
                    $menu = '
                    <li class="nav-item">
                        <a class="nav-link" href="../novoEndereco">Novo Endereço&nbsp;<i class="bi bi-geo-alt"></i> </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="../agendamento">Agendamento&nbsp;<i class="bi bi-calendar-event"></i></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link ativo" href="../galeria">Galeria&nbsp;<i class="bi bi-images"></i></a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownAddPerson" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Adicionar Pessoa &nbsp;<i class="bi bi-person-plus"></i>
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdownAddPerson">
                            <li class="nav-item">
                                <a class="nav-link" href="../novoFuncionario">Novo Funcionário</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="../novoPaciente">Novo Paciente</a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownList" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Listas &nbsp;<i class="bi bi-card-list"></i>
                        </a>
                        <ul class="dropdown-menu drop-menu" aria-labelledby="navbarDropdownList">
                            <li class="nav-item">
                                <a class="nav-link" href="../listarFuncionarios">Funcionários</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="../listarPacientes">Pacientes</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="../listarEnderecos">Endereços</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="../listarAgendamentos">Agendamentos</a>
                            </li>' . $agendamentosMed . '
                        </ul>
                    </li>                    
                    <li class="nav-item">
                        <a class="nav-link" href="logout?token='. md5(session_id()) .'">Sair&nbsp;<i class="bi bi-box-arrow-in-left"></i> </a>
                    </li>';
                    echo $menu;
                }
                else {
                    echo <<<HTML
                    <li class="nav-item">
                        <a class="nav-link" href="../novoEndereco">Novo Endereço&nbsp;<i class="bi bi-geo-alt"></i> </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="../agendamento">Agendamento&nbsp;<i class="bi bi-calendar-event"></i></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link ativo" href="../galeria">Galeria&nbsp;<i class="bi bi-images"></i></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="../login">Entrar&nbsp;<i class="bi bi-box-arrow-in-right"></i> </a>
                    </li>
                    HTML;
                }
                ?>
            </ul>
        </div>
    </nav>
</header>

<main class="container">
    <section>
        <div class="row">
            <h2>Galeria de Imagens da Ypsilum</h2>
        </div>
        <div class="row responsive">
            <div id="galeria-imgs">
            </div>
        </div>
        <br>
        <div class="row" style="display: flex; justify-content: space-evenly">
            <img id="seta-esquerda" class="col-2 seta seta-inversa" src="../imgs/setaDireita.jpg">
            <div id="other-imgs" class="col-8" style="display: inline">
            </div>
            <img id="seta-direita" class="col-2 seta" src="../imgs/setaDireita.jpg">
        </div>
    </section>
</main>

<footer>
    <p>Desenvoldido por Roberto F. Branco - 2021</p>
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<script>
    window.onload = () => {
        carregaImgs(1);
        document.getElementById('seta-direita').addEventListener('click', changeNextPic);
        document.getElementById('seta-esquerda').addEventListener('click', changePrevPic);
    }

    function carregaImgs(imgSelected) {
        const otherImgs = document.getElementById('other-imgs');
        otherImgs.innerHTML = "";

        const section = document.getElementById('galeria-imgs');
        section.innerHTML = "";
        for (let i = 1; i < 9; i++){
            let img = document.createElement('img');
            img.src = `../imgs/Clinica${i}.jpg`
            img.classList.add('col-sm-12')
            img.dataset.index = (i).toString();
            if(i !== imgSelected) {
                img.style.width = '14%'

                otherImgs.append(img)
            }
            else{
                img.style.width = '60%';
                img.id = 'selected';
                section.append(img);
            }
        }
    }

    function changeNextPic(){
        const picAtual = document.getElementById('selected');

        let proxImg = parseInt(picAtual.dataset.index)+1;
        if(proxImg === 8) {
            carregaImgs(1);
        } else {
            carregaImgs(proxImg);
        }

    }

    function changePrevPic(){
        const picAtual = document.getElementById('selected');

        let prevImg = parseInt(picAtual.dataset.index)-1;
        if(prevImg === 0) {
            carregaImgs(8);
        } else {
            carregaImgs(prevImg);
        }
    }
</script>
</body>
</html>