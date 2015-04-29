angular.module('meus-contatos')
    .factory('telefoneService', ['$resource', function ($resource) {

        return $resource($SERVICES_CONTEXT + 'telefone/:params', {}, {

            tipos: {
                method: 'GET',
                params: {params: 'tipo'},
                isArray: true
            }
        });

    }]);