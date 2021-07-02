<?php
session_start();
if (!isset($_SESSION["email"])) {
    header("location: ../login");
    exit();
}

require "../db_connection.php";
$pdo = getConnection();

if (isset($_GET["medico"])) $medico = $_GET["medico"];
else $medico = 0;

try {
    if ($medico != 0) {
        $sql = <<<SQL
            SELECT data_, horario, ag.nome as paciente, ag.sexo as pac_sexo, ag.email as pac_email, pe.nome as medico
            FROM agenda ag
            LEFT JOIN pessoa pe on pe.codigo = ag.codigo_medico
            WHERE codigo_medico = ?
        SQL;
        $stmt = $pdo->prepare($sql);
        $stmt->execute([$medico]);
    } else {
        $sql = <<<SQL
            SELECT data_, horario, ag.nome as paciente, ag.sexo as pac_sexo, ag.email as pac_email, pe.nome as medico
            FROM agenda ag
            LEFT JOIN pessoa pe on pe.codigo = ag.codigo_medico
        SQL;
        $stmt = $pdo->query($sql);
    }
} catch (Exception $e) {
    exit('Falha inesperada: ' . $e->getMessage());
}

?>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="description" content="Clínica Geral Asylum. Agende consultas sem sair de casa.">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="../styles/layout.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <title>Novo Funcionário</title>
    <style>
        div + div {
            margin-bottom: 1rem;
        }

        h2 {
            text-align: left;
            padding: 2rem;
        }

        form button {
            float: right;
        }
    </style>
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
                if (isset($_GET["medico"])){
                    $medAtivo = "ativo";
                    $agAtivo = "";
                }
                else{
                    $agAtivo = "ativo";
                    $medAtivo = "";
                }


                $agendamentosMed = '';
                if(isset($_SESSION["COD_MEDICO"]))
                    $agendamentosMed = '<li class="nav-item">
                                    <a class="nav-link ' . $medAtivo . '" href="../listarAgendamentos/index.php?medico='. $_SESSION["COD_MEDICO"] .'">Meus Agendamentos</a>
                                </li>';

                echo '
                <li class="nav-item">
                    <a class="nav-link" href="../novoEndereco">Novo Endereço&nbsp;<i class="bi bi-geo-alt"></i> </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="../agendamento">Agendamento&nbsp;<i class="bi bi-calendar-event"></i></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="../galeria">Galeria&nbsp;<i class="bi bi-images"></i></a>
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
                            <a class="nav-link ativo" href="../listarAgendamentos">Agendamentos</a>
                        </li>' . $agendamentosMed . '
                    </ul>
                </li>                    
                <li class="nav-item">
                    <a class="nav-link" href="../logout.php?token='. md5(session_id()) .'">Sair&nbsp;<i class="bi bi-box-arrow-in-left"></i> </a>
                </li>';
                ?>
            </ul>
        </div>
    </nav>
</header>
<main>
    <div class="container">
        <div class="row m-2">
            <h2>Consultas Agendadas</h2>
        </div>
        <div class="table-responsive">
            <?php
            echo <<<HTML
                <table class="table table-bordered">
                    <thead>
                        <tr>                        
                            <th>DATA E HORÁRIO</th>                            
                            <th>PACIENTE</th>
                            <th>SEXO</th>
                            <th>E-MAIL</th>
                            <th>MEDICO RESPONSÁVEL</th>                            
                        </tr>
                    </thead>
                    <tbody>
                HTML;
            while ($row = $stmt->fetch()) {
                $nome = htmlspecialchars($row['paciente']);
                $sexo = htmlspecialchars($row['pac_sexo']);
                $email = htmlspecialchars($row['pac_email']);
                $horario = htmlspecialchars($row['horario']);
                $medico = htmlspecialchars($row['medico']);

                $data = new DateTime($row['data_']);
                $dataFormatada = $data->format('d/m/Y');

                echo <<<HTML
                        <tr>
                            <td>Dia $dataFormatada às $horario Horas</td>                            
                            <td>$nome</td>
                            <td>$sexo</td>
                            <td>$email</td>
                            <td>$medico</td>                                                                           
                        </tr>                        
                    HTML;
            }
            echo <<<HTML
                </tbody>
            </table>
            HTML;
            ?>
        </div>
    </div>
</main>

<footer>
    <p>Desenvoldido por Roberto F. Branco - 2021</p>
</footer>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
        crossorigin="anonymous"></script>
</body>
</html>
