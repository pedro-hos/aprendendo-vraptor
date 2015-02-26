var ContatoController = function($scope, ContatoService, TelefoneService) {
	
	$scope.inputCounter = 0;
	$scope.telefones = [];
	
	$scope.contato = new ContatoService();

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
		contato.$remove({params:$scope.contato.id}, function(res) {
			$scope.contatos = ContatoService.list();
		});
	};
	
	$scope.save = function() {
		if($scope.contato.id > 0) {
			$scope.update();
		} else {
			
			$scope.contato.telefones = $scope.telefones;
			$scope.contato.$create(function() {
				$scope.contatos = ContatoService.list();
				$scope.reset();
			});
		}
	};
	
	$scope.update = function(){
		$scope.contato.$update({params:$scope.contato.id}, function(){
			$scope.contatos = ContatoService.list();
			$scope.reset();
		});
	};

};

ContatoController.$inject = ['$scope', 'ContatoService', 'TelefoneService'];