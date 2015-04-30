angular.module('meus-contatos')
    .factory('contatoService', ['$resource', function ($resource) {

        return $resource($SERVICES_CONTEXT + 'contato/:params', {}, {
            update: {
                method: "PUT"
            },

            tipos: {
                method: 'GET',
                params: {params: 'tipo'},
                isArray: true
            }
            
        });

    }]);