<!doctype html>
<html>
<head>
    <meta name="layout" content="main_old"/>
    <title>Login</title>

    <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />
</head>
<body>
<div class="col-lg-4"></div>
<div class="col-lg-4">
    <g:form action="login">
        <div class="modal-header">
            <h4 class="modal-title">Login</h4>
        </div>
        <div class="modal-body">
            <div class="form-group"><label>User Name</label>
                <input type="text" class="form-control"  name="username" required >
            </div>
            <div class="form-group"><label>Password</label>
                <input type="password" class="form-control" name="password" required>
            </div>
        </div>
        <div class="modal-footer">
            <button type="submit" class="btn btn-white">Login</button>
        </div>
    </g:form>
</div>
<div class="col-lg-4"></div>
</body>
</html>