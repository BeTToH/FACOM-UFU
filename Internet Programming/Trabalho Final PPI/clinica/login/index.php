<?php
session_start();
if(isset($_SESSION["email"])) {
    header("location: ../");
    exit();
}
?>
<!DOCTYPE html>
<html lang="pt-Br">
<head>
    <meta charset="UTF-8">
    <meta name="description" content="Clínica Geral Asylum. Agende consultas sem sair de casa.">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="../styles/layout.css">
    <link rel="stylesheet" href="../styles/login.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <title>Login</title>
</head>
<body>
<main>
    <div class="containerLogin">
        <div class="loginBox">
            <div class="row">
                <h3><a href="index.php">Clínica Ypsilum</a></h3>
            </div>
            <div class="row">
                <h2>Faça seu login</h2>
            </div>
            <div id="errorMsg" class="msgDiv" hidden>
            </div>
            <form>
                <label for="email">E-mail:</label>
                <input type="email" id="email" name="email" required>

                <label for="password">Senha:</label>
                <input type="password" id="password" name="password" required>

                <button type="button" id="btnLogin">Entrar&nbsp;<i class="bi bi-box-arrow-in-right"></i></button>
            </form>
        </div>
    </div>
</main>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
<script>
    window.onload = () =>{
        document.getElementById('btnLogin').addEventListener('click', logar);
    }

    async function logar(){
        let meuForm= document.querySelector("form");
        let formData = new FormData(meuForm);

        const options = {
            method: "POST",
            body: formData
        }

        const res = await fetch('/clinica/verificaLogin.php', options)
        if(!res.ok)
            throw new Error("Falha inesperada: " + res.status);

        const data = await res.json();
        if (data.success) {
            window.location.href = 'index.php'
        } else {
            const msgDiv = document.getElementById('errorMsg');
            msgDiv.innerHTML = "<strong>" + data.msgErro + "</strong>"
            msgDiv.removeAttribute("hidden");
        }
    }
</script>
</body>
</html>

