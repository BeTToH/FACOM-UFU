<?php

    $produtos = ['sprite', 'guarana', 'mineiro guarana', 'bolacha', 'detergente', 'produtoX', 'produtoY', 'cerveja', 'pão', 'mouse'];
    $descricao = ['refrigerante de limão', 'fruta tipica brasileira', 'refrigerante de guarana', 'biscoito com recheio',
                        'produto químico utilizado para higienização', 'descrição X', 'descrição Y', 'bebida alcoolica', 'pão de forma', 'periférico para computador'];

    $qde = $_GET["qde"];

?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <style>
        table {
            text-align: center;
        }
    </style>

    <title>Exercício 2</title>
</head>
<body>
<main>
    <div class="container">
        <table class="table table-responsive">
            <thead>
                <tr>
                    <th>Número sequencial</th>
                    <th>Nome Produto</th>
                    <th>Descrição Produto</th>
                </tr>
            </thead>
            <tbody>
                <?php
                    $ja_usado = [];
                    if($qde > count($produtos))
                        $qde = count($produtos);
                    for ($i = 0; $i < $qde; $i++) {
                        $num = rand(0,9);
                        while (in_array($num, $ja_usado)) {
                            $num = rand(0, 9);
                        }

                        array_push($ja_usado, $num);

                        echo '<tr>';
                        echo "<td>".($i+1)."</td>";
                        echo "<td>".ucwords($produtos[$num])."</td>";
                        echo "<td>".ucfirst($descricao[$num])."</td>";
                    }
                ?>
            </tbody>
        </table>
    </div>
</main>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
</body>
</html>

