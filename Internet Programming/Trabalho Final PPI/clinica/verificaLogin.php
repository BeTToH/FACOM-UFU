<?php
function checkLogin($pdo, $email, $senha)
{
    $sql = <<<SQL
        SELECT senha_hash
        FROM funcionario fu
        LEFT JOIN pessoa pe on pe.codigo = fu.codigo
        WHERE email = ?
    SQL;

    try{
        $stmt = $pdo->prepare($sql);
        $stmt->execute([$email]);
        $row = $stmt->fetch();
        if(!$row)
            return false;
        else {
            return password_verify($senha, $row['senha_hash']);
        }
    }catch (Exception $e){
        exit('Falha inesperada: ' . $e->getMessage());
    }
}

function getCodMedico($pdo, $email){
    $sql = <<<SQL
        SELECT med.CODIGO 
        FROM medico as med 
        LEFT JOIN pessoa as pe on pe.codigo = med.codigo 
        WHERE email = ? 
    SQL;

    try{
        $stmt = $pdo->prepare($sql);
        $stmt->execute([$email]);
        $cod_medico = $stmt->fetch(PDO::FETCH_COLUMN);
        if(!$cod_medico)
            return 0;
        else {
            return $cod_medico;
        }
    }catch (Exception $e){
        exit('Falha inesperada: ' . $e->getMessage());
    }
}

$errorMsg = "";
require "db_connection.php";

$pdo = getConnection();

header('Content-type: application/json');

if (isset($_POST["email"])) $email = $_POST["email"];
else {
    echo json_encode(['success'=>false, 'msgErro'=>'É necessário inserir o e-mail!']);
}
if (isset($_POST["password"])) $password = $_POST["password"];
else
    echo json_encode(['success'=>false, 'msgErro'=>'É necessário inserir a senha!']);

if(checkLogin($pdo, $email, $password)){
    session_start();
    $_SESSION["email"] = $email;
    $_SESSION["nome"] = $password;
    $cod_medico = getCodMedico($pdo, $email);
    if($cod_medico > 0)
        $_SESSION["COD_MEDICO"] = $cod_medico;
    echo json_encode(['success'=>true]);
} else {
    $errorMsg = 'O e-mail e a senha fornecidos não correspondem às informações em nossos registros. Verifique-as e tente novamente!';
    echo json_encode(['success'=>false, 'msgErro'=>$errorMsg]);
}
