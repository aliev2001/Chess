<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chess</title>
    <link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootswatch/4.5.2/pulse/bootstrap.min.css'>
    <link rel='stylesheet' href='../assets/css/paper-kit.css'>
</head>
<body>
<form action="${pageContext.request.contextPath}/create" method="post">
    <div class='form-group'>
        <label>
            <input type='text' name='servername' class='form-control' placeholder='Name of the Server'>
        </label>
    </div>
    <select name="color" id="">
        <option value="White">White</option>
        <option value="Black">Black</option>
    </select>
    <input type='submit' class='btn btn-primary' value='Create'>

</form>
</body>
</html>