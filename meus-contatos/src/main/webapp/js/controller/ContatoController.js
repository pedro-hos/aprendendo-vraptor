var ContatoController = function($scope, ContatoService, TelefoneService) {
	
	$scope.number = 1;
	$scope.getNumber = function() {
		return new Array($scope.number);
	};
	
	$scope.addPhone = function() { 
		$scope.number = $scope.number + 1;
	}
	
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
		contato.$remove({params:contato.id}, function(res) {
			$scope.contatos = ContatoService.list();
		});
	};
	
	$scope.save = function(){
		
		console.log($scope.contato);
		
		if($scope.contato.id > 0){
			$scope.update();
		}else{
			$scope.contato.$create(function(){
				$scope.contatos = ContatoService.list();
				$scope.reset();
			});
		}
	};
	
	$scope.update = function(){
		$scope.contato.$update(function(){
			$scope.contatos = ContatoService.list();
			$scope.reset();
		});
	};

};

ContatoController.$inject = ['$scope', 'ContatoService', 'TelefoneService'];