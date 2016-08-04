'use strict';

angular.module('tododaysApp')
  .controller('LoginController', function ($scope, $resource, $http, $httpParamSerializer, $cookies, UserService, $rootScope, $location) {

    $scope.error = false;
    //$scope.credentials = {};

    $scope.credentials = {
      grant_type:"password", username: "", password: "", client_id: "tododays"
    };

    //$scope.login = function() {
    //
    //  console.log('Login');
    //  if (UserService.authenticate($scope.credentials)) {
    //    $scope.error = false;
    //    $rootScope.authenticated = true;
    //    $rootScope.username = $scope.credentials.username;
    //    $location.path('/');
    //  } else {
    //    $scope.error = true;
    //    $rootScope.authenticated = false;
    //    $rootScope.username = '';
    //  }
    //};


    $scope.encoded = btoa("tododays:secret");


    $scope.isAuthenticated = function() {
      return $rootScope.authenticated;
    };

    $scope.getCurrentUser = function() {
      return $rootScope.username;
    };

    $scope.logout = function() {
      $rootScope.authenticated = false;
      $rootScope.username = '';
    };


    $scope.login = function() {
      var req = {
        method: 'POST',
        url: "/api/login",
        headers: {
          "Authorization": "Basic " + $scope.encoded,
          "Content-type": "application/x-www-form-urlencoded; charset=utf-8"
        },
        data: $httpParamSerializer($scope.credentials)
      }
      $http(req).then(function(data){
        $http.defaults.headers.common.Authorization = 'Bearer ' + data.data.access_token;
        $cookies.put("access_token", data.data.access_token);
        $rootScope.authenticated = true;
        $rootScope.username = $scope.credentials.username;
        $location.path('/');
      });
    }

  });

