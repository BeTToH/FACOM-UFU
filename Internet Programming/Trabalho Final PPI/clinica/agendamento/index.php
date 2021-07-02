<?php
session_start();
?>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="description" content="Clínica Geral Asylum. Agende consultas sem sair de casa.">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="../styles/layout.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <title>Agendamento de Consulta</title>
    <style>
        div+div{
            margin-bottom: 1rem;
        }
        h2{
            text-align: left;
            padding: 2rem;
        }
        h4{
            margin-bottom: 1rem;
            color: #F2B138;
        }

        .inputYellow:focus{
            outline: none;
            border-color: #F2B138;
            box-shadow: 0 0 10px #F2B138;
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
                        <a class="nav-link" href="../novoEndereco">Novo Endereço&nbsp;<i class="bi bi-geo-alt"></i> </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link ativo" href="../agendamento">Agendamento&nbsp;<i class="bi bi-calendar-event"></i></a>
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
                        <a class="nav-link" href="../novoEndereco">Novo Endereço&nbsp;<i class="bi bi-geo-alt"></i> </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link ativo" href="../agendamento">Agendamento&nbsp;<i class="bi bi-calendar-event"></i></a>
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
        <div class="row">
            <h2>Agendamento de Consulta</h2>
        </div>
        <div id="warnMsg" class="msgDiv" hidden>
        </div>
        <form class="formAzul" autocomplete="off">
            <div class="row m-2">
                <h4 class="col-12">Dados Pessoais</h4>
                <div class="col-md-10">
                    <div class="form-floating">
                        <input class="form-control inputYellow" type="text" id="nome" name="nome" placeholder="" required>
                        <label class="form-label" for="nome">Nome completo</label>
                    </div>
                </div>
                <div class="col-md-2">
                    <div class="form-floating">
                        <div class="form-floating">
                            <select class="form-control inputYellow" id="sexo" name="sexo">
                                <option value="F">Feminino</option>
                                <option value="M">Masculino</option>
                            </select>
                            <label class="form-label" for="sexo">Sexo</label>
                        </div>
                    </div>
                </div>
                <div class="col-md-12">
                    <div class="form-floating">
                        <input class="form-control inputYellow" type="email" id="email" name="email" placeholder="" required>
                        <label class="form-label" for="email">E-mail</label>
                    </div>
                </div>
                <h4 class="col-12">Consulta Médica</h4>
                <div class="col-md-6">
                    <div class="form-floating">
                        <select class="form-control inputYellow" id="especialidade" name="especialidade">
                            <option value="">Selecione...</option>
                        </select>
                        <label class="form-label" for="especialidade">Especialidade Médica Desejada</label>
                    </div>
                </div>
                <div class="col-md-6 hide">
                    <div class="form-floating">
                        <select class="form-control inputYellow" id="medico" name="medico">
                            <option value="">Selecione...</option>
                        </select>
                        <label class="form-label" for="medico">Nome do Médico Especialista</label>
                    </div>
                </div>
                <div class="col-md-6 hide">
                    <div class="form-floating">
                        <input class="form-control inputYellow" type="date" id="dataConsulta" name="dataConsulta" placeholder="" required>
                        <label class="form-label" for="dataConsulta">Data da Consulta</label>
                    </div>
                </div>
                <div class="col-md-6 hide">
                    <div class="form-floating">
                        <select class="form-control inputYellow" id="horario" name="horario">
                        </select>
                        <label class="form-label" for="horario">Horários Disponíveis</label>
                    </div>
                </div>
                <div class="col-12">
                    <button type="button" id="sendInfo" class="hide">
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
<script>
    window.onload = () => {
        getEspecialidades();
        document.getElementById('especialidade').addEventListener('change', searchMedico);
        document.getElementById('medico').addEventListener('change', showData);
        document.getElementById('dataConsulta').addEventListener('change', searchHorarios);
        document.getElementById('horario').addEventListener('change', (e) => {
            const horario = e.target;
            if(horario.value === "") {
                document.getElementById('sendInfo').style.display = 'none';
            } else {
                document.getElementById('sendInfo').style.display = 'block';
            }


        });
        document.getElementById('sendInfo').addEventListener('click', sendInfo);
    }

    function verificaCamposPreenchidos(){
        const warnMsg = document.getElementById('warnMsg');
        if(document.getElementById('nome').value === "") {
            warnMsg.innerText = "É preciso inserir seu nome!";
            warnMsg.removeAttribute("hidden");
            return false;
        } else if (document.getElementById('email').value === ""){
            warnMsg.innerText = "É preciso inserir seu e-mail!";
            warnMsg.removeAttribute("hidden");
            return false;
        }
        return true;
    }

    async function sendInfo(e){
        const warnMsg = document.getElementById('warnMsg');
        let meuForm = document.querySelector("form");
        let formData = new FormData(meuForm);

        if(!verificaCamposPreenchidos())
            return

        try{
            const options = {
                method: "POST",
                body: formData,
                dataType: 'json'
            }

            const res = await fetch('/clinica/agendaConsulta.php', options)
            if(!res.ok)
                throw new Error("Falha inesperada: " + res.status);

            let data = await res.json();

            let msg;
            if(data) {
                msg = "Consulta agendada com sucesso!";
                searchHorarios();
            }
            else
                msg = "Erro ao agendar consulta!";
            warnMsg.innerHTML = '<strong>' + msg + '</strong>'
            warnMsg.removeAttribute("hidden");
        } catch (e) {
            console.error(e);
        }
    }

    async function getEspecialidades(){
        const warnMsg = document.getElementById('warnMsg');
        try {
            const res = await fetch('/clinica/getEspecialidades.php?');
            if (!res.ok)
                throw new Error("Falha inesperada: " + res.status);

            let data = await res.json();

            if (data.success) {
                let especialidades = data.especialidades;
                let selectEspecialidade = document.getElementById('especialidade');
                selectEspecialidade.innerHTML = "";
                let option = document.createElement('option');
                option.innerText = "Selecione...";
                option.value = "";
                selectEspecialidade.append(option);
                if(especialidades.length > 0) {
                    for (let i = 0; i < especialidades.length; i++) {
                        let option = document.createElement('option');
                        option.innerText = especialidades[i];
                        option.value = especialidades[i];

                        selectEspecialidade.append(option);

                        warnMsg.setAttribute("hidden", 'hidden');
                    }
                } else {
                    warnMsg.innerHTML = '<strong>Nenhuma especialidade encontrada</strong>'
                    warnMsg.removeAttribute("hidden");
                }
            }
        } catch (e) {
            console.error(e);
        }
    }

    async function searchMedico(e){
        const selectEspecialidade = e.target;

        document.getElementById('dataConsulta').parentElement.parentElement.style.display = 'none';
        document.getElementById('horario').parentElement.parentElement.style.display = 'none';
        document.getElementById('sendInfo').style.display = 'none';
        document.getElementById('dataConsulta').value = "";

        if(selectEspecialidade.value === "") {
            document.getElementById('medico').parentElement.parentElement.style.display = 'none';
            return
        }

        const selectMedico = document.getElementById('medico');
        selectMedico.innerHTML = "";
        let option = document.createElement('option');
        option.innerText = "Selecione...";
        option.value = "";
        selectMedico.append(option);

        const warnMsg = document.getElementById('warnMsg');
        try {
            const res = await fetch('/clinica/getMedicos.php?especialidade=' + selectEspecialidade.value);
            if (!res.ok)
                throw new Error("Falha inesperada: " + res.status);

            let medicos = await res.json();
            if (medicos.length > 0) {
                for (let i = 0; i < medicos.length; i++) {
                    let option = document.createElement('option');
                    option.innerText = medicos[i].nome;
                    option.value = medicos[i].codigo;

                    selectMedico.append(option);
                }
                selectMedico.parentElement.parentElement.style.display = 'block'

                warnMsg.setAttribute("hidden", 'hidden');
            } else {
                warnMsg.innerHTML = '<strong>Nenhum Médico encontrado</strong>'
                warnMsg.removeAttribute("hidden");
            }
        } catch (e) {
            console.error(e);
        }
    }

    function showData(e){
        const medico = e.target;

        if(medico.value !== ""){
            document.getElementById('dataConsulta').parentElement.parentElement.style.display = 'block';
        } else {
            document.getElementById('dataConsulta').value = "";
            document.getElementById('horario').parentElement.parentElement.style.display = 'none';
            document.getElementById('sendInfo').style.display = 'none';
        }

    }

    async function searchHorarios(){
        const data = document.getElementById('dataConsulta');
        if(data.value === "") {
            document.getElementById('horario').parentElement.parentElement.style.display = 'none';
            document.getElementById('sendInfo').style.display = 'none';
            return
        }
        try {
            const selectHorario = document.getElementById('horario');
            selectHorario.innerHTML = ""
            let option = document.createElement('option');
            option.innerText = "Selecione...";
            option.value = "";
            selectHorario.append(option);

            const res = await fetch('/clinica/getHorarios.php?data=' + data.value);
            if (!res.ok)
                throw new Error("Falha inesperada: " + res.status);

            let dados = await res.json();

            let horariosIndisponiveis = dados.horariosIndisponiveis.map(a => a.horario);
            let todosHorarios = [8, 9, 10, 11, 12, 13, 14, 15, 16];
            let horariosDisponiveis = todosHorarios.filter(x => !horariosIndisponiveis.includes(x));
            if(horariosDisponiveis.length > 0) {
                for (let i = 0; i < horariosDisponiveis.length; i++) {
                    let option = document.createElement('option');
                    option.innerText = horariosDisponiveis[i] + " Horas";
                    option.value = horariosDisponiveis[i].toString();

                    selectHorario.append(option);
                }
                selectHorario.parentElement.parentElement.style.display = 'block';
            }
        } catch (e) {
            console.error(e);
        }
    }
</script>
</body>
</html>
