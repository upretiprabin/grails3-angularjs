<!doctype html>
<html lang="en" class="no-js" ng-app="automation">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/><!-- Page title set in pageTitle directive -->
    <title page-title=""></title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <!-- CSS -->
    %{--<link rel="stylesheet" type="text/css" class="ui" href="./css/semantic.min.css">--}%
    %{--<link rel="stylesheet" type="text/css" class="ui" href="css/main.css">--}%

    <asset:stylesheet src="css/semantic.min.css"/>
    <asset:stylesheet src="css/main.css"/>
    <asset:stylesheet src="application.css"/>
    <asset:stylesheet src="vendor.css"/>
    <asset:javascript src="jquery-2.2.0.min.js"/>
    <asset:javascript src="semantic.min.js"/>
    <asset:javascript src="vendor.js"/>
    <asset:javascript src="application.js"/>
    <g:layoutHead/>
</head>
<body class="main-wrapper" ng-controller="baseController as main">

<div class="ui bottom attached segment pushable">
    <!-- Sidebar -->
    <side-bar class="ui visible inverted left vertical sidebar menu"></side-bar>

    <!-- Main view for templates -->
    <div ui-view class="pusher" id="main-content"></div>
</div>
</body>
</body>
</html>
</html>
