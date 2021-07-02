<?php

if (isset($_GET["data"])){
    require "db_connection.php";

    $pdo = getConnection();

    $data = $_GET["data"];

    $sql = <<<SQL
        SELECT DISTINCT horario
        FROM agenda        
        WHERE data_ = ?
    SQL;

    try{
        $phpdate = strtotime($data);
        $mysqldate = date( 'Y-m-d H:i:s', $phpdate );

        $stmt = $pdo->prepare($sql);
        $stmt->execute([$mysqldate]);
        $horariosIndisponiveis = $stmt->fetchAll();

        $data = ['success'=>true, 'horariosIndisponiveis'=>$horariosIndisponiveis];

    }catch (Exception $e){
        exit('Falha inesperada: ' . $e->getMessage());
    }
} else {
    $data = ['success'=>false, 'msgErro'=>"Nenhum cep informado!"];
}
header('Content-type: application/json');
echo json_encode($data);
