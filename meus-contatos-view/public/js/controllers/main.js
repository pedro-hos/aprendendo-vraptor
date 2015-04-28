angular.module('meus-contatos')
	.controller('MainController', function ($scope, contatoService) {

		$scope.contato = new contatoService();
		$scope.contatos = contatoService.query();

		console.log($scope.contatos);

	});