'use strict';

angular.module('tododaysApp')
  .controller('RegisterController', function($scope, UserService) {

    $scope.error = null;

    $scope.user = {};

    $scope.register = function() {
      if (this.validate()) {//TODO fix me
        UserService.register($scope.user);
      } else {

      }
    };

    this.validate = function() {

    };

  });

