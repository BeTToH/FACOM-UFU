<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $errorMsg = "";
    require "db_connection.php";

    $pdo = getConnection();

    header('Content-type: application/json');

    if (isset($_POST["nome"])) $nome = $_POST["nome"];
    if (isset($_POST["sexo"])) $sexo= $_POST["sexo"];
    if (isset($_POST["email"])) $email = $_POST["email"];


    if (isset($_POST["medico"])) $medico = $_POST["medico"];
    if (isset($_POST["dataConsulta"])) $data = $_POST["dataConsulta"];
    if (isset($_POST["horario"])) $horario = $_POST["horario"];

    $phpdate = strtotime($data);
    $mysqldate = date( 'Y-m-d H:i:s', $phpdate );

    $msg = "";
    try {
        $sql = <<<SQL
        INSERT INTO agenda (DATA_, HORARIO, NOME, SEXO, EMAIL, CODIGO_MEDICO)
        VALUES (?, ?, ?, ?, ?, ?)
        SQL;

        $stmt = $pdo->prepare($sql);
        $stmt->execute([
            $mysqldate, $horario, $nome, $sexo, $email, $medico
        ]);
        echo json_encode(true);
    } catch (Exception $e) {
        $msg = 'Falha ao cadastrar os dados';
        echo json_encode(false);
    }
}



