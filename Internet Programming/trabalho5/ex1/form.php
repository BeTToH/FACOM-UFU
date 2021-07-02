<?php

    if(isset($_POST["cep"]))
        $cep = $_POST["cep"];

    if(isset($_POST["logradouro"]))
        $logradouro = $_POST["logradouro"];

    if(isset($_POST["bairro"]))
        $bairro = $_POST["bairro"];

    if(isset($_POST["estado"]))
        $estado = $_POST["estado"];

    if(isset($_POST["cidade"]))
        $cidade = $_POST["cidade"];

?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">

    <title>Exercício 1 - Resultado</title>
</head>
<body>
<main>
    <div class="container">
        <div class="row">
            <div class="col-sm">
                <label for="cep" class="form-label">CEP:</label>
                <?php echo '<input value='.htmlspecialchars($cep).' id="cep" class="form-control" readonly>' ?>

            </div>
            <div class="col-sm">
                <label for="logradouro" class="form-label">Logradouro:</label>
                <?php echo '<input value='.htmlspecialchars($logradouro).' class="form-control" readonly>'?>
            </div>

            <div class="col-sm">
                <label for="bairro" class="form-label">Bairro:</label>
                <?php echo '<input value='.htmlspecialchars($bairro).' class="form-control" readonly>' ?>
            </div>

            <div class="col-sm">
                <label for="estado" class="form-label">Estado:</label>
                <select id="estado" name="estado" class="form-control" disabled>
                    <?php echo '<option value='.htmlspecialchars($estado).' >'.htmlspecialchars($estado).'</option>' ?>
                </select>
            </div>
            <div class="col-sm">
                <label for="cidade" class="form-label">Cidade:</label>
                <?php echo '<input value='.htmlspecialchars($cidade).' class="form-control" readonly>' ?>
            </div>
        </div>


    </div>
</main>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
</body>
</html>
