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

			<table class="table table-hover">
				<thead>
					<tr>
						<th>#</th>
						<th>Nome</th>
						<th>Email</th>
						<th>Tipo Contato</th>
						<th>Telefones</th>
						<th>Ação</th>
					</tr>
				</thead>
				<tbody>
			     	<c:if test="${not empty contatoList }">
			     		<c:forEach items="${contatoList}" var="contato">
							<tr id="_contato">
								<th scope="row">
									<c:out value="${contato.id}"/>
								</th>
								<td> 
									<c:out value="${contato.nome}"/>
								</td> 
								<td>
									<c:out value="${contato.email}"/>
								</td>
								<td>
									<c:out value="${contato.tipoContato}"/>
								</td>
								<td>
									<c:out value="(${contato.telefones[0].ddd}) ${contato.telefones[0].telefone}"/>
									/
									<c:out value="(${contato.telefones[1].ddd}) ${contato.telefones[1].telefone}"/>
								</td>
								<td>
									<a id="_editar" class="btn btn-default" href="${linkTo[ContatoController].editar(contato.id)}" role="button">
										<span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
									</a>
									
									<input id = "_urlRemocao" value="${linkTo[ContatoController].remover(contato.id)}" type="hidden">
									<a id="_remover" class="btn btn-default" href="#" role="button">
										<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
									</a>
								</td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
			
	    </div>
	    
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/dist/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/dist/js/docs.min.js"></script>
		<script type="text/javascript">
			$(function() {

				var contato = $('#_contato');
				
				$("#_remover").click(function() {
					$.ajax({
						url: $('#_urlRemocao').attr("value"),
						type: 'POST',
						data: { _method: "DELETE"}
					}).done(function(data, textStatus, jqXHR){
						contato.fadeOut();
					}).fail(function(jqXHR, textStatus, errorThrown){
						alert("Deu erro na parada!");
					});
				});
			})
		</script>
	</body>
</html>