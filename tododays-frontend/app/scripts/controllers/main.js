'use strict';

/**
 * @ngdoc function
 * @name yeomanApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the yeomanApp
 */
angular.module('tododaysApp')
  .controller('MainController', function ($scope, TasksService) {

    $scope.tasks = TasksService.topTasks();

  });
