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
    <link rel="stylesheet" href="/board/css/login.css"/>
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
            padding-top: 10%;
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
    </ul>
</nav>

<div class="back_img">
    <div class="container">
        <div class="login-form">
            <div class="main-div">
                <div class="panel">
                    <h2>SignUp</h2>
                    <p>Please enter your nickname,<br> email and password</p>
                </div>
                <form id="Login" method="post" action="/signup-proc">

                    <div class="form-group">
                        <input type="email" class="form-control" name="input_Email" placeholder="Email Address">
                    </div>

                    <div class="form-group">
                        <input type="text" class="form-control" name="input_Password" placeholder="Password">
                    </div>

                    <div class="form-group">
                        <input type="text" class="form-control" name="input_Name" placeholder="Name">
                    </div>

                    <button type="submit" class="btn btn-primary">SignUp</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
