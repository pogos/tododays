'use strict';

angular.module('tododaysApp')
  .controller('TaskController', function ($scope, $location, TasksService, Task, Category) {

    $scope.error = false;

    $scope.task = {};

    $scope.tasks = TasksService.getTasks();

    $scope.priorities = [{'name': 'Low', 'value': 1}, {'name': 'Normal', 'value': 2}, {'name': 'High', 'value': 3}, {'name': 'Urgent', 'value': 4}];

    $scope.categories = [{'name': 'Home', 'value': 1}, {'name': 'Work', 'value': 2}, {'name': 'Other', 'value': 3}];

    Task.get(function(data) {
      $scope.tasks = data.data;
    });

    Category.get(function(data) {
      $scope.categories = data.data;
    });

    $scope.addTask = function() {
      console.log('Add task');
      Task.save($scope.task, function() {
        console.log('Saved')
      });
    }


  });
