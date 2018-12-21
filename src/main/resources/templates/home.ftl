<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>dhsong-board/home</title>
    <link rel="stylesheet" href="/board/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/board/css/bootstrap.css"/>
    <link rel="stylesheet" href="/board/css/_variables.scss"/>
    <link rel="stylesheet" href="/board/css/_bootswatch.scss"/>
    <script src="/webjars/jquery/3.3.1/dist/jquery.min.js"></script>
    <script src="/webjars/bootstrap/3.3.4/dist/js/bootstrap.min.js"></script>

<style>
    .back_img{
        background-image: url("/board/img/home.png");
        backgroound-repeat: no-repeat;
        top:0;
        left:0;
        right:0;
        bottom:0;
        position: absolute;
        width: 100%;
        height: 100%;
        z-index:-1;
    }
    #center {
        position:absolute;
        top:35%;
        left:35%;
        padding: 60px;
        background-color: rgba( 255, 255, 255, 0.7 );
        font-size: 50pt;
        font-family: fantasy;
        text-align: center;
        color:black;
    }
</style>
</head>

<body>

<nav class="navbar navbar-expand-sm navbar-fixed-top navbar-dark bg-primary">
        <a class="navbar-brand" href="/home">DHSONG's BOARD</a>
    <ul class="navbar-nav">
        <li class="nav-item">
            <a class="nav-link" href="/login">/Login/</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/signup">/Signup/</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/list">/List/</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/logout">/Logout/</a>
        </li>
    </ul>
</nav>
<div class="back_img"><div id="center">Welcome My Board</div></div>

</body>
</html>