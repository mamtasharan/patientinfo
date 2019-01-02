'use strict'

angular.module('patientInfoUIApp.services', []).factory('PatientBloodSugarInfoService',
		[ "$http", "CONSTANTS", function($http, CONSTANTS) {
			var service = {};
			
			service.getAllPatientBloodSugarInfo = function() {
				return $http.get(CONSTANTS.getAllPatientBloodSugarInfo);
			}
			return service;
		} ]);