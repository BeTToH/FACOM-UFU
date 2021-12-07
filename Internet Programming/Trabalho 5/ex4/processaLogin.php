<?php

    $email = $_POST["email"];
    $password = $_POST["password"];
    $passwordHash = password_hash($password, PASSWORD_DEFAULT);

    salvaString($email, "email.txt");
    salvaString($passwordHash, "senhaHash.txt");

    function salvaString($string, $arquivo){
        $arq = fopen($arquivo, "w");
        fwrite($arq, $string);
        fclose($arq);
    }

    header("Location: resgataInfo.php");
    exit();
?>
<!DOCTYPE html>
<html lang="pt-Br">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/ex3.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <title>Exercício 4</title>
</head>
<body>
<main>
    <div class="container">
        <div class="centralizado">
            <h2>Os dados foram inseridos com sucesso!</h2>
        </div>
    </div>
</main>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
</body>
</html>

