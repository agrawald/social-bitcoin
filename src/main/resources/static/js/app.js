var bitcoinApp = angular.module('BitcoinApp', ['ngRoute']);

bitcoinApp.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider
            .when("/", {
                templateUrl : "partials/home.html",
                controller : "HomeCtrl"
            })
            .when("/transfer", {
                templateUrl : "partials/success.html",
                controller : "TransferCtrl"
            })
            .otherwise({redirectTo: '/'});
     }
   ]);