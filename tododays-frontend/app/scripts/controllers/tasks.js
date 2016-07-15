'use strict';

angular.module('tododaysApp')
  .controller('TaskController', function ($scope, $location, TasksService, Task) {

    $scope.tasks = TasksService.getTasks();

    Task.get(function(data) {
      $scope.tasks = data.data;
    });

  });
