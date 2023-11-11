<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Recipe Display</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f8f8f8;
            margin: 20px;
        }

        h2 {
            color: #333;
            border-bottom: 2px solid #333;
            padding-bottom: 5px;
            margin-bottom: 15px;
        }

        h3 {
            color: #555;
        }

        ul, ol {
            margin-bottom: 20px;
            margin-left: 0;
            padding-left: 20px;
        }

        li {
            margin-bottom: 8px;
        }

        ol {
            list-style-type: decimal;
        }

        p {
            color: #666;
        }
    </style>
</head>
<body>

<?php
$recipes = simplexml_load_file('recipes.xml');

foreach ($recipes->recipe as $recipe) {
    echo '<h2>' . $recipe->name . '</h2>';
    
    echo '<h3>Ingredients:</h3>';
    echo '<ul>';
    foreach ($recipe->ingredients->ingredient as $ingredient) {
        echo '<li>' . $ingredient . '</li>';
    }
    echo '</ul>';

    echo '<h3>Instructions:</h3>';
    echo '<ol>';
    foreach ($recipe->instructions->step as $step) {
        echo '<li>' . $step . '</li>';
    }
    echo '</ol>';

    echo '<p>Enjoy your delicious ' . $recipe->name . '!</p>';
}
?>

</body>
</html>
