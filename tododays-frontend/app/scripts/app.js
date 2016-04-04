'use strict';

/**
 * @ngdoc overview
 * @name yeomanApp
 * @description
 * # yeomanApp
 *
 * Main module of the application.
 */
angular
  .module('tododaysApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainController',
        controllerAs: 'main'
      })
      .when('/about', {
        templateUrl: 'views/about.html',
        controller: 'AboutController',
        controllerAs: 'about'
      })
      .when('/task', {
        templateUrl: 'views/task.html',
        controller: 'TaskController',
        controllerAs: 'tasks'
      })
      .when('/tasks', {
        templateUrl: 'views/tasks.html',
        controller: 'TaskController',
        controllerAs: 'tasks'
      })
      .when('/login', {
        templateUrl: 'views/login.html',
        controller: 'LoginController',
        controllerAs: 'tasks'
      })
      .when('/register', {
        templateUrl: 'views/register.html',
        controller: 'TaskController',
        controllerAs: 'tasks'
      })
      .otherwise({
        redirectTo: '/'
      });
  });
