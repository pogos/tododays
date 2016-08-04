angular.module('tododaysApp')
.factory('Category', function($resource) {
  return $resource('/api/categories/:id', {offset: 0, limit: 5})
});
