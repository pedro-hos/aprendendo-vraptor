$app.config(function($routeProvider, $httpProvider) {

	$routeProvider.
		when("/", { templateUrl : "view/home.html", controller 	: ContatoController } ).
		
		otherwise({
			redirectTo:'/'
		});
});