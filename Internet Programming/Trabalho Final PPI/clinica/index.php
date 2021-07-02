<?php
session_start();
?>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="description" content="Clínica Geral Asylum. Agende consultas sem sair de casa.">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="styles/layout.css">
    <link rel="stylesheet" href="styles/index.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <title>Home</title>
</head>
<body>
<header>
    <nav class="navbar navbar-expand-lg navbar-light" id="navbar">
        <h1 class="ativo"><a href="">Clínica Asylum</a></h1>

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
                        <a class="nav-link" href="novoEndereco">Novo Endereço&nbsp;<i class="bi bi-geo-alt"></i> </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="agendamento">Agendamento&nbsp;<i class="bi bi-calendar-event"></i></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="galeria">Galeria&nbsp;<i class="bi bi-images"></i></a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownAddPerson" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Adicionar Pessoa &nbsp;<i class="bi bi-person-plus"></i>
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdownAddPerson">
                            <li class="nav-item">
                                <a class="nav-link" href="novoFuncionario">Novo Funcionário</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="novoPaciente">Novo Paciente</a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownList" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Listas &nbsp;<i class="bi bi-card-list"></i>
                        </a>
                        <ul class="dropdown-menu drop-menu" aria-labelledby="navbarDropdownList">
                            <li class="nav-item">
                                <a class="nav-link" href="listarFuncionarios">Funcionários</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="listarPacientes">Pacientes</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="listarEnderecos">Endereços</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="listarAgendamentos">Agendamentos</a>
                            </li>' . $agendamentosMed . '
                        </ul>
                    </li>                    
                    <li class="nav-item">
                        <a class="nav-link" href="logout.php?token='. md5(session_id()) .'">Sair&nbsp;<i class="bi bi-box-arrow-in-left"></i> </a>
                    </li>';
                    echo $menu;
                }
                else {
                    echo <<<HTML
                    <li class="nav-item">
                        <a class="nav-link" href="novoEndereco">Novo Endereço&nbsp;<i class="bi bi-geo-alt"></i> </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="agendamento">Agendamento&nbsp;<i class="bi bi-calendar-event"></i></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="galeria">Galeria&nbsp;<i class="bi bi-images"></i></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="login">Entrar&nbsp;<i class="bi bi-box-arrow-in-right"></i> </a>
                    </li>
                    HTML;
                }
                ?>
            </ul>
        </div>
    </nav>
</header>
<main>
    <section>
        <div class="col-12">
            <img src="imgs/fachada.jpg" class="responsive" alt="Fachada da Clínica Ypsilum">
        </div>
    </section>

    <section id="sobre-nos" class="container">
        <div class="row">
            <div class="col-md-8">
                <div class="col-md-12">
                    <h2>
                        Sobre Nós
                    </h2>
                </div>
                <div class="col-md-12">
                    <p>
                        Nunc euismod non ligula non lobortis. Morbi tristique fringilla viverra. Aliquam erat volutpat. In lorem tellus, pulvinar quis ultrices vel, maximus nec lacus.
                        Mauris quis semper magna. Curabitur sagittis augue eu lectus lacinia, ut pulvinar dui elementum. Donec at ligula ullamcorper, faucibus arcu sit amet, efficitur quam.
                        Donec imperdiet felis nisi, vel fringilla orci lacinia a. Nunc iaculis enim vel commodo eleifend.
                    </p>
                </div>
            </div>

            <div class="col-md-4">
                <div>
                    <h2>Nossos Valores</h2>
                </div>

                <div id="valores">
                    <h5>Conforto</h5>
                    <h5>Confiança</h5>
                    <h5>Amor</h5>
                </div>
            </div>
        </div>
    </section>
</main>

<footer>
    <p>Desenvoldido por Roberto F. Branco - 2021</p>
</footer>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>

</body>
</html>