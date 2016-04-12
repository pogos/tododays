'use strict';

angular.module('tododaysApp')
  .controller('RegisterController', function($scope, UserService) {

    $scope.error = null;

    $scope.user = {};

    $scope.register = function() {
      console.log('register user: ' + $scope.user);
      if ($scope.validate()) {//TODO fix me
        UserService.register($scope.user);
      } else {

      }
    };

    $scope.validate = function() {

    };

  });

