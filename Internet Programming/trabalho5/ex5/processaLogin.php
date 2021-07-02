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

    header("Location: login.php");
    exit();
?>
