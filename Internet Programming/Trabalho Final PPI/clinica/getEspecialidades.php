<?php
require "db_connection.php";

$pdo = getConnection();

$sql = <<<SQL
    SELECT DISTINCT especialidade
    FROM medico    
SQL;

try {
    $stmt = $pdo->query($sql);
    $especialidades = $stmt->fetchAll(PDO::FETCH_COLUMN);

    $data = ['success'=>true, 'especialidades'=>$especialidades];
} catch (Exception $e) {
    exit('Falha inesperada: ' . $e->getMessage());
}
header('Content-type: application/json');
echo json_encode($data);