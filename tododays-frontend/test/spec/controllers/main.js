'use strict';

describe('Controller: MainCtrl', function () {

  // load the controller's module
  beforeEach(module('tododaysApp'));

  var MainController,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    MainController = $controller('MainController', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.tasks.length).toBe(5);
  });
});
