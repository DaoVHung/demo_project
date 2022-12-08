<!DOCTYPE html>
<html lang="en">

<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animejs/2.2.0/anime.min.js">

    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://rsms.me/inter/inter-ui.css" rel="stylesheet">
    <link rel="stylesheet" href="ADMIN.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/View/User/css/admin.css">
    <link rel="stylesheet" href="https://codepen.io/USERNAME/pen/SLUG/?editors=1010">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animejs/2.2.0/anime.min.js">

    <title>Document</title>
    <style>
        img {
            position: absolute;
            max-width: 100%;
        }

    </style>
</head>
<img
        src="<%=request.getContextPath()%>/View/User/images/drink-alcohol-whisky-brand-whiskey-bottle-582893-wallhere.com.jpg"
        alt="">

<body>
<div class="page">
    <div class="container">
        <div class="left">
            <div class="login">For Admin</div>
            <div class="eula">Login with admin account to administrate the restaurant website</div>
        </div>
        <div class="right">
            <svg viewBox="0 0 320 300">
                <defs>
                    <linearGradient inkscape:collect="always" id="linearGradient" x1="13" y1="193.49992" x2="307"
                                    y2="193.49992"
                                    gradientUnits="userSpaceOnUse">
                        <stop style="stop-color:#ff00ff;" offset="0" id="stop876"/>
                        <stop style="stop-color:#ff0000;" offset="1" id="stop878"/>
                    </linearGradient>
                </defs>
                <path
                        d="m 40,120.00016 239.99984,-3.2e-4 c 0,0 24.99263,0.79932 25.00016,35.00016 0.008,34.20084 -25.00016,35 -25.00016,35 h -239.99984 c 0,-0.0205 -25,4.01348 -25,38.5 0,34.48652 25,38.5 25,38.5 h 215 c 0,0 20,-0.99604 20,-25 0,-24.00396 -20,-25 -20,-25 h -190 c 0,0 -20,1.71033 -20,25 0,24.00396 20,25 20,25 h 168.57143"/>
            </svg>
            <div class="form">
                <form action="<%=request.getContextPath()%>/UserServlet" method="get">
                    <label for="email">UserName</label>
                    <input type="username" name="username" id="email">
                    <label for="password">Password</label>
                    <input type="password" name="passwords" id="password">
                    <input type="submit" id="submit" value="Login" name="action" >
                </form>
            </div>
        </div>
    </div>
</div>

<script>
    var current = null;
    document.querySelector('#email').addEventListener('focus', function (e) {
        if (current) current.pause();
        current = anime({
            targets: 'path',
            strokeDashoffset: {
                value: 0,
                duration: 700,
                easing: 'easeOutQuart'
            },
            strokeDasharray: {
                value: '240 1386',
                duration: 700,
                easing: 'easeOutQuart'
            }
        });
    });
    document.querySelector('#password').addEventListener('focus', function (e) {
        if (current) current.pause();
        current = anime({
            targets: 'path',
            strokeDashoffset: {
                value: -336,
                duration: 700,
                easing: 'easeOutQuart'
            },
            strokeDasharray: {
                value: '240 1386',
                duration: 700,
                easing: 'easeOutQuart'
            }
        });
    });
    document.querySelector('#submit').addEventListener('focus', function (e) {
        if (current) current.pause();
        current = anime({
            targets: 'path',
            strokeDashoffset: {
                value: -730,
                duration: 700,
                easing: 'easeOutQuart'
            },
            strokeDasharray: {
                value: '530 1386',
                duration: 700,
                easing: 'easeOutQuart'
            }
        });
    });
</script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/animejs/2.2.0/anime.min.js"></script>
</body>

</html>