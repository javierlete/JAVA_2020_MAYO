<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Importar CSV</title>
</head>
<body>

<!-- https://stackoverflow.com/questions/2422468/how-to-upload-files-to-server-using-jsp-servlet -->

<form action="csv" method="post" enctype="multipart/form-data">
	<input type="file" name="ficherocsv" />
	<button>Importar</button>
</form>

</body>
</html>