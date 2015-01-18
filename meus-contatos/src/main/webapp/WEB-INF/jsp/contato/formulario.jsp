<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
				
				<form class="form-horizontal" action="${linkTo[ContatoController].novo}" method="post" role="form">
					<div class="form-group">
						<label for="_nome" class="col-sm-2 control-label">Nome</label>
						<div class="col-sm-5">
							<input id="_nome" type="text" class="form-control" placeholder="Nome" name="contato.nome">
						</div>
					</div>
					
					<div class="form-group">
						<label for="_email" class="col-sm-2 control-label">E-mail</label>
						<div class="col-sm-5">
							<input id="_email" type="email" class="form-control" placeholder="E-mail" name="contato.email">
						</div>
					</div>
					
					<div class="form-group">
						<label for="_tipoContato" class="col-sm-2 control-label">Tipo Contato</label>
						<div class="col-sm-5">
							<select id="_tipoContato" class="form-control" name="contato.tipoContato">
								<c:forEach items="${tipoContatoList}" var="tipoContato">
								  <option value="${tipoContato}">
								  	<c:out value="${tipoContato}"/>
								  </option>
								</c:forEach>
							</select>
						</div>
					</div>
					
					<div id="_telefones">
					
						<h4>Telefone 01</h4>
					
						<div class="form-group">
							<label for="_ddd_01" class="col-sm-2 control-label">Telefone</label>
							<div class="col-sm-2">
								<input id="_ddd_01" type="text" class="form-control" placeholder="DDD" name="contato.telefones[0].ddd">
							</div>
							<div class="col-sm-3">
								<input id="_telefone_01" type="text" class="form-control" placeholder="Telefone" 
									name="contato.telefones[0].telefone">
							</div>
						</div>
						
						<div class="form-group">
							<label for="_tipoTelefone_01" class="col-sm-2 control-label">Tipo Telefone</label>
							<div class="col-sm-5">
								<select id="_tipoTelefone_01" class="form-control" name="contato.telefones[0].tipoTelefone">
									<c:forEach items="${tipoTelefoneList}" var="tipoTelefone">
									  <option value="${tipoTelefone}">
									  	<c:out value="${tipoTelefone}"/>
									  </option>
									</c:forEach>
								</select>
							</div>
						</div>
						
						<!-- TELEFONE 02 -->
						<h4>Telefone 02</h4>
						
						<div class="form-group">
							<label for="_ddd_02" class="col-sm-2 control-label">Telefone</label>
							<div class="col-sm-2">
								<input id="_ddd_02" type="text" class="form-control" placeholder="DDD" name="contato.telefones[1].ddd">
							</div>
							<div class="col-sm-3">
								<input id="_telefone_02" type="text" class="form-control" placeholder="Telefone" 
										name="contato.telefones[1].telefone">
							</div>
						</div>
						
						<div class="form-group">
							<label for="_tipoTelefone_02" class="col-sm-2 control-label">Tipo Telefone</label>
							<div class="col-sm-5">
								<select id="_tipoTelefone_02" class="form-control" name="contato.telefones[1].tipoTelefone">
									<c:forEach items="${tipoTelefoneList}" var="tipoTelefone">
									  <option value="${tipoTelefone}">
									  	<c:out value="${tipoTelefone}"/>
									  </option>
									</c:forEach>
								</select>
							</div>
						</div>
					</div>
					
					<button type="submit" class="btn btn-primary">Salvar</button>
					
				</form>
				
			</div>
	    </div>
	    
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/dist/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/dist/js/docs.min.js"></script>
	</body>
</html>