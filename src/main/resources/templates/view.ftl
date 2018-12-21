<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>dhsong-board/home</title>
    <link rel="stylesheet" href="https://bootswatch.com/4/minty/bootstrap.min.css"/>
    <link rel="stylesheet" href="https://bootswatch.com/4/minty/bootstrap.css"/>
    <link rel="stylesheet" href="https://bootswatch.com/4/minty/_variables.scss"/>
    <link rel="stylesheet" href="https://bootswatch.com/4/minty/_bootswatch.scss"/>
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

        .container{
            padding-left: 5%;
            padding-right:5%;
            color: black;
            background-color: rgba( 255, 255, 255, 0.7 );
            border-radius: 20px;
            padding-top: 2%;
            padding-bottom: 2%;
        }
        .button{
            text-align: center;
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

<div class="back_img">
    <div class="container">
        <form>
            <fieldset>
                <legend><b>글 조회하기</b></legend>
                <div class="form-group">
                    <label>날짜 : ${board.date}</label>
                </div>

                <div class="form-group">
                    <label>제목 : ${board.title}</label>
                </div>

                <div class="form-group">
                    <label>내용<br> ${board.content}</label>
                </div>

                <button type="button" class="btn btn-primary"
                        onclick="location.href='http://localhost:8080/list/edit/${board.num}'">수정하기</button>
                <button type="button" class="btn btn-primary"
                        onclick="location.href='http://localhost:8080/list/delete/${board.num}'">삭제</button>
            </fieldset>
        </form>
    </div>
</div>

</body>
</html>