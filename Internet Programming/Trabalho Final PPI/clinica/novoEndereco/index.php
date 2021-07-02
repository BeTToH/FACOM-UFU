<?php
session_start();
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    require "../db_connection.php";
    $pdo = getConnection();

    $cep = $logradouro = $cidade = $estado = "";

    if (isset($_POST["cep"])) $cep = $_POST["cep"];
    if (isset($_POST["logradouro"])) $logradouro = $_POST["logradouro"];
    if (isset($_POST["cidade"])) $cidade = $_POST["cidade"];
    if (isset($_POST["estado"])) $estado = $_POST["estado"];

    $msg = "";
    try {
        $sql = <<<SQL
    INSERT INTO base_enderecos_ajax (CEP, LOGRADOURO, CIDADE, ESTADO)
    VALUES (?, ?, ?, ?)
    SQL;

        $stmt = $pdo->prepare($sql);
        $stmt->execute([
            $cep, $logradouro, $cidade, $estado
        ]);
        $msg = "Endereço inserido com sucesso!";
    } catch (Exception $e) {
        if ($e->errorInfo[1] === 1062)
            $msg = 'Dados duplicados: esse endereço já foi registrado!';
        else
            $msg = 'Falha ao cadastrar os dados: ' . $e->getMessage();
    }
}
?>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="description" content="Clínica Geral Asylum. Agende consultas sem sair de casa.">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="../styles/layout.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <title>Novo Endereço</title>
    <style>
        div+div{
            margin-bottom: 1rem;
        }
        h2{
            text-align: left;
            padding: 2rem;
        }
        form button{
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
                $agendamentosMed = '';
                if(isset($_SESSION["COD_MEDICO"]))
                    $agendamentosMed = '<li class="nav-item">
                                    <a class="nav-link" href="../listarAgendamentos/index.php?medico='. $_SESSION["COD_MEDICO"] .'">Meus Agendamentos</a>
                                </li>';

                if(isset($_SESSION["email"])) {
                    $menu = '
                    <li class="nav-item">
                        <a class="nav-link ativo" href="../novoEndereco">Novo Endereço&nbsp;<i class="bi bi-geo-alt"></i> </a>
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
                                <a class="nav-link" href="../listarAgendamentos">Agendamentos</a>
                            </li>' . $agendamentosMed . '
                        </ul>
                    </li>                    
                    <li class="nav-item">
                        <a class="nav-link" href="../logout.php?token='. md5(session_id()) .'">Sair&nbsp;<i class="bi bi-box-arrow-in-left"></i> </a>
                    </li>';
                    echo $menu;
                }
                else {
                    echo <<<HTML
                    <li class="nav-item">
                        <a class="nav-link ativo" href="../novoEndereco">Novo Endereço&nbsp;<i class="bi bi-geo-alt"></i> </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="../agendamento">Agendamento&nbsp;<i class="bi bi-calendar-event"></i></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="../galeria">Galeria&nbsp;<i class="bi bi-images"></i></a>
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
<main>
    <div class="container">
        <div class="row m-2">
            <h2>Insira os dados para cadastar um novo endereço</h2>
        </div>
        <?php
        if($_SERVER["REQUEST_METHOD"] == "POST" && $msg !== ""){
            echo <<<HTML
                <div class="msgDiv row m-2">
                    <strong>$msg</strong>                    
                </div>
                <br>
                HTML;
        }
        ?>
        <form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>" method="post" class="formAzul">
            <div class="row m-2">
                <div class="col-md-3 mt-2">
                    <div class="form-floating">
                        <input class="form-control" type="text" id="cep" name="cep" placeholder="" required>
                        <label class="form-label" for="cep">CEP</label>
                    </div>
                </div>
                <div class="col-md-9 mt-2">
                    <div class="form-floating">
                        <input class="form-control" type="text" id="logradouro" name="logradouro" placeholder="" required>
                        <label class="form-label" for="logradouro">Logradouro</label>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="form-floating">
                        <select class="form-control" id="estado" name="estado">
                            <option value="AC">Acre</option>
                            <option value="AL">Alagoas</option>
                            <option value="AP">Amapá</option>
                            <option value="AM">Amazonas</option>
                            <option value="BA">Bahia</option>
                            <option value="CE">Ceará</option>
                            <option value="DF">Distrito Federal</option>
                            <option value="ES">Espírito Santo</option>
                            <option value="GO">Goiás</option>
                            <option value="MA">Maranhão</option>
                            <option value="MT">Mato Grosso</option>
                            <option value="MS">Mato Grosso do Sul</option>
                            <option value="MG">Minas Gerais</option>
                            <option value="PA">Pará</option>
                            <option value="PB">Paraíba</option>
                            <option value="PR">Paraná</option>
                            <option value="PE">Pernambuco</option>
                            <option value="PI">Piauí</option>
                            <option value="RJ">Rio de Janeiro</option>
                            <option value="RN">Rio Grande do Norte</option>
                            <option value="RS">Rio Grande do Sul</option>
                            <option value="RO">Rondônia</option>
                            <option value="RR">Roraima</option>
                            <option value="SC">Santa Catarina</option>
                            <option value="SP">São Paulo</option>
                            <option value="SE">Sergipe</option>
                            <option value="TO">Tocantins</option>
                        </select>
                        <label class="form-label" for="estado">Estado</label>
                    </div>
                </div>
                <div class="col-md-9">
                    <div class="form-floating">
                        <input class="form-control" type="text" id="cidade" name="cidade" placeholder="" required>
                        <label class="form-label" for="cidade">Cidade</label>
                    </div>
                </div>
                <div class="col-12">
                    <button type="submit" class="btn btn-primary">
                        Cadastrar&nbsp;<i class="bi bi-check2"></i>
                    </button>
                </div>
            </div>
        </form>
    </div>
</main>

<footer>
    <p>Desenvoldido por Roberto F. Branco - 2021</p>
</footer>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>

</body>
</html>