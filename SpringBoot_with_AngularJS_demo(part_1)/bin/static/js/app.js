
var app = angular.module('crudApp',['ui.router','ngStorage']);
 
app.constant('urls', {
    BASE: 'http://localhost:8443',
    TASK_SERVICE_API : 'http://localhost:8443/entity/product/'
});
 
app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {
 
        $stateProvider
            .state('home', {
                url: '/',
                templateUrl: 'partials/list',
                controller:'ProductController',
                controllerAs:'ctrl',
                resolve: {
                    task: function ($q, ProductService) {
                        console.log('Load all Product');
                        var deferred = $q.defer();
                        ProductService.loadAllProducts().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    }
                }
            });
        $urlRouterProvider.otherwise('/');
    }]);