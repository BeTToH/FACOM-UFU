<?php

if (isset($_GET["cep"])){
    require "db_connection.php";

    $pdo = getConnection();

    $cep = $_GET["cep"];
    $logradouro = $cidade = $estado = "";

    $sql = <<<SQL
        SELECT CIDADE, ESTADO, LOGRADOURO
        FROM base_enderecos_ajax        
        WHERE CEP = ?
    SQL;

    try{
        $stmt = $pdo->prepare($sql);
        $stmt->execute([$cep]);
        $row = $stmt->fetch();
        if(!$row)
            $data = ['success'=>false];
        else {
            $estado = $row['ESTADO'];
            $cidade = $row['CIDADE'];
            $logradouro = $row['LOGRADOURO'];
            $data = ['success'=>true, 'logradouro'=>$logradouro, 'cidade'=>$cidade, 'estado'=>$estado];
        }
    }catch (Exception $e){
        exit('Falha inesperada: ' . $e->getMessage());
    }
} else {
    $data = ['success'=>false, 'msgErro'=>"Nenhum cep informado!"];
}
header('Content-type: application/json');
echo json_encode($data);