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

    $scope.tasks = TasksService.tasks;

    $scope.topTasks = function() {
      return $scope.tasks.slice(0, 5);
    };

    this.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
  });
