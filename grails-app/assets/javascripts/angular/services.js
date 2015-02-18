'use strict';

/* Services */

var condorServices = angular.module('condorServices', ['ngResource']);

condorServices.factory('AnimalTypes', ['$resource',
  function($resource){
    return $resource('api/animals', {}, {
      query: {method:'GET', isArray:true}
    });
  }]);
