'use strict'

var demoApp = angular.module('patientInfoUIApp', [ 'ui.bootstrap', 'patientInfoUIApp.controllers',
		'patientInfoUIApp.services' ]);
demoApp.constant("CONSTANTS", {
	getAllPatientBloodSugarInfo : "/patientbloodsugarinfo",
});