<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link href="${pageContext.request.contextPath}/dist/css/bootstrap.min.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/dist/css/bootstrap-theme.min.css" rel="stylesheet" id="bs-theme-stylesheet">
		
		<style type="text/css">
			body {
				padding-top: 50px;
			}
			.starter-template {
				padding: 40px 15px;
				text-align: center;
			}
		</style>
		
		<title>Contatos</title>
	</head>
	<body>
	
	
		<div class="container">
			<div class="starter-template">
	        	<h1>Meus Contatos</h1>
				<br>
				
				<form class="form-horizontal">
					<div class="form-group">
						<label for="_nome" class="col-sm-2 control-label">Nome</label>
						<div class="col-sm-5">
							<input type="text" class="form-control" id="_nome" placeholder="Nome">
						</div>
					</div>
					
					<div class="form-group">
						<label for="_email" class="col-sm-2 control-label">E-mail</label>
						<div class="col-sm-5">
							<input type="email" class="form-control" id="_email" placeholder="E-mail">
						</div>
					</div>
					
					<div class="form-group">
						<label for="_tipoContato" class="col-sm-2 control-label">Tipo Contato</label>
						<div class="col-sm-5">
							<select class="form-control" id="_tipoContato">
							  <option>1</option>
							</select>
						</div>
					</div>
					
				</form>
				
			</div>
	    </div>
	    
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/dist/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/dist/js/docs.min.js"></script>
	</body>
</html>