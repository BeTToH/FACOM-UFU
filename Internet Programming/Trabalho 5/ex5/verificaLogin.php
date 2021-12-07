<?php
session_start();

function carregaString($arquivo){
    $arq = fopen($arquivo, "r");
    $string = fgets($arq);
    fclose($arq);
    return $string;
}

$emailBD = carregaString("email.txt");
$passwordBD = carregaString("senhaHash.txt");

$emailBD = htmlspecialchars($emailBD);
$passwordBD = htmlspecialchars($passwordBD);

$email = $_POST["email"];
$password = $_POST["password"];

if(password_verify($password, $passwordBD) && $emailBD == $email) {
    $_SESSION["error"] = false;
    header("Location: sucesso.html");
} else{
    $_SESSION["error"] = true;
    $_SESSION["errorMsg"] = "Usuário e/ou senha incorreto(s)";
    header("Location: login.php");
}
exit();
