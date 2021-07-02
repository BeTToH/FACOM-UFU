<?php

function getConnection()
{
    $db_host = "fdb30.awardspace.net";
    $db_username = "3767401_finalproj";
    $db_password = "d3#T2zHg12oBfl9O";
    $db_name = "3767401_finalproj";

    $dsn = "mysql:host=$db_host;dbname=$db_name;charset=utf8mb4";

    $options = [
        PDO::ATTR_EMULATE_PREPARES => false,
        PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
        PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC
    ];

    try {
        $pdo =  new PDO($dsn, $db_username, $db_password, $options);
        return $pdo;
    } catch (Exception $e) {
        exit('Falha na conexão com o banco de dados: ' . $e->getMessage());
    }
}