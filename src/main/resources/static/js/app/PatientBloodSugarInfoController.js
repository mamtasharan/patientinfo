'use strict'

var module = angular.module('patientInfoUIApp.controllers', []);
module.controller("PatientBloodSugarInfoController", [ "$scope", "PatientBloodSugarInfoService",
		function($scope, PatientBloodSugarInfoService) {

			$scope.patientBloodSugarInfo = {
				id : null,
				bloodsugarlevel : null,
				recorded_at : null
			};
			
			PatientBloodSugarInfoService.getAllPatientBloodSugarInfo().then(function(value) {
				$scope.allPatientBloodSugarInfo= value.data;
			}, function(reason) {
				console.log("error occured");
			}, function(value) {
				console.log("no callback");
			});
			
			$scope.getAllPatientBloodSugarInfo = function() {
				
				PatientBloodSugarInfoService.getAllPatientBloodSugarInfo().then(function(value) {
					$scope.allPatientBloodSugarInfo= value.data;
				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});
			};
		}
	} ]);