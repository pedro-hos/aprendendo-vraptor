angular.module('meus-contatos')
	.controller('MainController', function ($scope, contatoService, telefoneService) {

		$scope.contato       = new contatoService();
		$scope.contatos      = contatoService.query();
		$scope.contatoTipos  = contatoService.tipos();
		$scope.telefoneTipos = telefoneService.tipos();
		$scope.contato.telefones = [];


		$scope.salvar = function() {
			$scope.contato.id > 0 ? atualizar() : novo();
		};

		function novo() {

			console.log($scope.contato);

			$scope.contato.$save().then(function(){
				$scope.contato = new contatoService();
			});

		};
		
		function atualizar() {

			$scope.contato.$update( { params: $scope.contato.id }, 
									function() { 
										$scope.contato  = new contatoService();
										$scope.contatos = contatoService.query();
									}
			);

		};

		$scope.edit = function(contato) {
			$scope.contato = contato;
		};

		$scope.remove = function(contato) {

			if (confirm('Você têm certeza que deseja excluir?')) { 
				contatoService.delete( { params: contato.id }, 
					                   function() {
					                   		$scope.contatos = contatoService.query();
					                   } );
			}

		};

	});