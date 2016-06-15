bitcoinApp.controller('HomeCtrl', ['$scope','$http', 'RateService',
    function ($scope,$http, RateService) {
        $http.get('/home')
            .then(function(res){
                 console.log(res);
                RateService(res.data.bitcoins, 'AUD').then(function(res) {
                    $scope.rate = res.rate;
                    $scope.aud = res.value;
                });
                $scope.profile= res.data.profile;
                $scope.bitcoins= res.data.bitcoins;
            });
            $scope.myFacebookLogin = function() {
              FB.login(function(){}, {scope: 'publish_actions'});
            }
    }]);

bitcoinApp.controller('TransferCtrl', ['$scope','$http', 'RateService', function ($scope,$http, RateService) {
    var data = {
        "amount": $scope.amount,
        "to": $scope.to
    };
    $http({
            'url' : '/transfer',
            'method' : 'POST',
            'headers': {'Content-Type' : 'application/json'},
            'data' : data
        }).success(function(data){
            console.log(data);
            $scope.success= data.success;
            FB.login(function(){
              // Note: The call will only work if you accept the permission request
              FB.api('/me/feed', 'post', {message: res.data.success});
            }, {scope: 'publish_actions'});
        })
}]);