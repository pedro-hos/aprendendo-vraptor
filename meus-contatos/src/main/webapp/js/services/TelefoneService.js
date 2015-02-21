$app.factory('TelefoneService', [ '$resource', function($resource) {
	
	return $resource('telefone/:params', {}, {
		list : {
			method : 'GET',
			params:{ params:'tipo' },
			isArray : true
		}
	});

} ]);