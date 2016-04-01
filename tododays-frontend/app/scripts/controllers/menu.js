/**
 * Controller using for manage menu
 * Created by Sebastian on 31.03.2016.
 */
'use strict';

angular.module('tododaysApp')
  .controller('MenuCtrl', function ($scope, $location) {

    $scope.menuItems = [
      {label: 'Home', path: '/'},
      {label: 'About', path: '/about'},
      {label: 'Contact', path: ''}
    ];


    $scope.isActive = function(item) {
      return $location.path() === item.path ? 'active' : ''
    };
  });
