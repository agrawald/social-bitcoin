
 bitcoinApp.factory('RateService', ['$http', function ($http) {
     return function(btc, to) {
        var data = {};
        return $http.get('https://api.bitcoinaverage.com/ticker/global/'+to+'/last')
                .then(function(res) {
                   return {rate:res.data, value: res.data * btc};
                });
     }
 }]);