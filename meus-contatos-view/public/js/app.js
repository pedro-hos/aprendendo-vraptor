angular
  .module('meus-contatos', [ 'ngResource', 'ngRoute' ])
  .config(function ($routeProvider) {
    $routeProvider

      .when('/', {
        templateUrl: 'public/views/main.html',
        controller: 'MainController'
      })

      .otherwise({
        redirectTo: '/'
      });

  });

    var $SERVICES_CONTEXT = "http://localhost:8080/meus-contatos/";