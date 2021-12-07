<?php
    function carregaString($arquivo){
        $arq = fopen($arquivo, "r");
        $string = fgets($arq);
        fclose($arq);
        return $string;
    }

    $email = carregaString("email.txt");
    $password = carregaString("senhaHash.txt");

    $email = htmlspecialchars($email);
    $password = htmlspecialchars($password);
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
        <div class="loginBox">
            <?php
            echo <<<HTML
            <label for="email">E-mail:</label>
            <input type="email" id="email" name="email" value={$email} readonly>

            <label for="password">Senha:</label>
            <input type="text" id="password" name="password" value={$password} readonly>
            HTML;
             ?>
        </div>
    </div>
</main>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
</body>
</html>
