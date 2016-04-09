'use strict';

angular.module('tododaysApp')
  .controller('LoginController', function ($scope, UserService, $rootScope, $location) {

    $scope.error = false;
    $scope.credentials = {};

    $scope.login = function() {

      console.log('Login');
      if (UserService.authenticate($scope.credentials)) {
        $scope.error = false;
        $rootScope.authenticated = true;
        $rootScope.username = $scope.credentials.username;
        $location.path('/');
      } else {
        $scope.error = true;
        $rootScope.authenticated = false;
        $rootScope.username = '';
      }
    };


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


  });
