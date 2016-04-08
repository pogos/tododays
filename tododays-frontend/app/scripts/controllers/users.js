'use strict';

angular.module('tododaysApp')
  .controller('UserController', function($scope) {

    $scope.users = [{username: 'admin', login: 'admin', password: 'koala'}];



  });
