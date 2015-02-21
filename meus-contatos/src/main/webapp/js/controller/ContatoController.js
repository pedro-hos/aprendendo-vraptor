var ContatoController = function($scope, ContatoService, TelefoneService) {
	
	$scope.contatos = ContatoService.list();
	$scope.contatoTipos = ContatoService.tipos();
	$scope.telefoneTipos = TelefoneService.list();
	
	$scope.reset = function() {
		$scope.contato = new ContatoService();
	};
	
	$scope.edit= function(contato){
		$scope.contato = contato;
	};
	
	$scope.remove = function(contato) {
		contato.$remove({params:contato.id}, function(res) {
			$scope.contatos = ContatoService.list();
		});
	};

};

ContatoController.$inject = ['$scope', 'ContatoService', 'TelefoneService'];