'use strict';

angular.module('tododaysApp')
  .controller('TaskController', function ($scope, $location, TasksService) {

    $scope.tasks = TasksService.getTasks();

  });
