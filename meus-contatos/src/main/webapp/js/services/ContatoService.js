$app.factory('ContatoService', [ '$resource', function($resource) {
	
	return $resource('contato/:params', {}, {
		create : {
			method : 'POST',
		},
		
		list : {
			method : 'GET',
			isArray : true
		},
		
		update :{
			method : "PUT"
		},
		
		remove :{
			method: "DELETE"
		},
		
		tipos :{
			method : 'GET',
			params:{ params:'tipo' },
			isArray : true
		}
	}

	);

} ]);