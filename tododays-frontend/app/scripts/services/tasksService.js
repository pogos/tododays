'use strict';

angular.module('tododaysApp')
  .service('TasksService', function () {

      this.tasks = [
        {name: 'Task 1', description: 'Task 1 long description', priority: 1, status: 'New', category: 'Task'},
        {name: 'Task 2', description: 'Task 2 long description', priority: 1, status: 'New', category: 'Task'},
        {name: 'Task 3', description: 'Task 3 long description', priority: 1, status: 'New', category: 'Task'},
        {name: 'Task 4', description: 'Task 4 long description', priority: 1, status: 'New', category: 'Task'},
        {name: 'Task 5', description: 'Task 5 long description', priority: 1, status: 'New', category: 'Task'},
        {name: 'Task 6', description: 'Task 6 long description', priority: 1, status: 'New', category: 'Task'},
        {name: 'Task 7', description: 'Task 7 long description', priority: 1, status: 'New', category: 'Task'},
        {name: 'Task 8', description: 'Task 8 long description', priority: 1, status: 'New', category: 'Task'}

      ];

    }
  );
