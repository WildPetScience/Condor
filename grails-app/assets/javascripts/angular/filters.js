'use strict';

/* Filters */

var condorFilters = angular.module('condorFilters', []);

condorFilters.filter('spacesToDashes', function() {
	return function (input) {
		input = input || '';
		return input.replace(new RegExp(' ', 'g'), '-');
	}
});
