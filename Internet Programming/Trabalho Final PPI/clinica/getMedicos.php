<?php
require "db_connection.php";

$pdo = getConnection();

$especialidade = $_GET["especialidade"];

$sql = <<<SQL
    SELECT med.codigo, nome 
    FROM medico med
    LEFT JOIN pessoa pe on pe.codigo = med.CODIGO
    WHERE especialidade = ? 
SQL;

try {
    $stmt = $pdo->prepare($sql);
    $stmt->execute([$especialidade]);
    $medicos = $stmt->fetchAll();

} catch (Exception $e) {
    exit('Falha inesperada: ' . $e->getMessage());
}
header('Content-type: application/json');
echo json_encode($medicos);