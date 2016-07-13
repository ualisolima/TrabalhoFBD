<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="inserirUsuario" method="post" enctype="multipart/form-data">
		Primeiro Nome: <input type="text" name="pNome" /> <br />
		Nome do Meio: <input type="text" name="mNome" /> <br />
		Ultimo Nome: <input type="text" name="uNome" /> <br />
		E-mail: <input type="email" name="email" /> <br />
		Senha: <input type="password" name="senha" /> <br />
		País: <input type="text" name="pais" /> <br />
		Estado: <input type="text" name="estado" /> <br />
		Cidade: <input type="text" name="cidade" /> <br />
		CEP: <input type="text" name="cep">
		Rua: <input type="text" name="rua" /> <br />
		Numero da Casa: <input type="text" name="pNome" /> <br />
		<input type="file" class="dropbtn" name="image" />
		<input type="submit" value="SALVAR" /> 
	</form>

</body>
</html>