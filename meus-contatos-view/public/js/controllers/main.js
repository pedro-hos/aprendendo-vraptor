angular.module('meus-contatos')
	.controller('MainController', function ($scope, contatoService) {

		$scope.contato = new contatoService();

	});