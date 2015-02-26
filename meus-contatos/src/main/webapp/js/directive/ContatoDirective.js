$app.directive('addInput', ['$compile', function ($compile) {
    return {
        restrict: 'A',
        link: function (scope, element, attrs) {
            element.find('button').bind('click', function () {
                var input = angular.element('<div id="_telefones">' + 
                								'<div class="form-group">' + 
                									'<label for="_ddd" class="col-sm-2 control-label">Telefone</label>' +
                									'<div class="col-sm-2">' +
                										'<input id="_ddd" type="text" class="form-control" placeholder="DDD" ng-model="telefones[' + scope.inputCounter + '].ddd">' +
                									'</div>' +
                									'<div class="col-sm-3">' +
                										'<input id="_telefone" type="text" class="form-control" placeholder="Telefone" ng-model="telefones[' + scope.inputCounter + '].telefone">' +
                									'</div>' +
                								'</div>' +
                								'<div class="form-group">' +
                									'<label for="_tipoTelefone" class="col-sm-2 control-label">Tipo Telefone</label>' +
                									'<div class="col-sm-5">' +
                										'<select id="_tipoContato" class="form-control" ng-model="telefones[' + scope.inputCounter + '].tipoTelefone">' +
                											'<option value=""> -- Escolha um Tipo -- </option>' +
                											'<option ng-repeat="tipo in telefoneTipos" value="{{tipo}}"> {{tipo}} </option>' +
                										'</select>' +
                									'</div>' +
                								'</div>' +
											'</div>');
                
                var compile = $compile(input)(scope);
               element.append(input);
               scope.inputCounter++;
            });
        }
    }
}]);

