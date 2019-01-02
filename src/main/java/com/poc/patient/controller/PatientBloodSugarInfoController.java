package com.poc.patient.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.poc.patient.dao.PatientBloodsugarInfoDao;
import com.poc.patient.entity.PatientBloodsugarInfo;
import com.poc.patient.service.PatientBloodSugarLevelInfoService;
import com.poc.patient.visualization.VegaVisual;

@CrossOrigin
@RestController
public class PatientBloodSugarInfoController {

    private static Logger logger = LoggerFactory.getLogger(PatientBloodSugarInfoController.class.getName());

    @Autowired
    private PatientBloodSugarLevelInfoService patientBloodSugarLevelInfoService;
    
    @CrossOrigin
    @RequestMapping(path="/patientbloodsugarinfo/patientid/{id}", method=RequestMethod.GET)
    public ResponseEntity<VegaVisual> getAll(@PathVariable int id) {
        logger.info("PatientBloodsugarInfo list is checking from cassandra for id::"+id);
        ResponseEntity<VegaVisual> response = null;
        VegaVisual visual = patientBloodSugarLevelInfoService.getVisualizationForPatientBloodSugarLevel(id);
        if(null != visual) {
        	response = new ResponseEntity<VegaVisual>(visual, HttpStatus.OK);
        }else {
        	response = new ResponseEntity<VegaVisual>(visual, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response ;
    }

	private String getJsonString(List<PatientBloodsugarInfo> data) {
		boolean dataAdded = false;
		StringBuffer buff = new StringBuffer("{\n" + 
				"  \"$schema\": \"https://vega.github.io/schema/vega/v4.json\",\n" + 
				"  \"width\": 400,\n" + 
				"  \"height\": 200,\n" + 
				"  \"padding\": 5,\n" + 
				"\n" + 
				"  \"data\": [\n" + 
				"    {\n" + 
				"      \"name\": \"table\",\n" + 
				"      \"values\":["); 
		
		for(PatientBloodsugarInfo model : data) {
			buff.append("{\"recordedAt\":\"" + model.getRecorded_at() + "\",").append("\"bloodSugarReading\":\"" + model.getBloodsugarlevel() + "\"},");
			dataAdded = true;
		}
		if(dataAdded)
			buff.deleteCharAt(buff.length()-1);
		
		buff.append("]\n" + 
				"    }\n" + 
				"  ],\n" + 
				"\n" + 
				"  \"signals\": [\n" + 
				"    {\n" + 
				"      \"name\": \"tooltip\",\n" + 
				"      \"value\": {},\n" + 
				"      \"on\": [\n" + 
				"        {\"events\": \"rect:mouseover\", \"update\": \"datum\"},\n" + 
				"        {\"events\": \"rect:mouseout\",  \"update\": \"{}\"}\n" + 
				"      ]\n" + 
				"    }\n" + 
				"  ],\n" + 
				"\n" + 
				"  \"scales\": [\n" + 
				"    {\n" + 
				"      \"name\": \"xscale\",\n" + 
				"      \"type\": \"band\",\n" + 
				"      \"domain\": {\"data\": \"table\", \"field\": \"recordedAt\"},\n" + 
				"      \"range\": \"width\",\n" + 
				"      \"padding\": 0.05,\n" + 
				"      \"round\": true\n" + 
				"    },\n" + 
				"    {\n" + 
				"      \"name\": \"yscale\",\n" + 
				"      \"domain\": {\"data\": \"table\", \"field\": \"bloodSugarReading\"},\n" + 
				"      \"nice\": true,\n" + 
				"      \"range\": \"height\"\n" + 
				"    }\n" + 
				"  ],\n" + 
				"\n" + 
				"  \"axes\": [\n" + 
				"    { \"orient\": \"bottom\", \"scale\": \"xscale\" },\n" + 
				"    { \"orient\": \"left\", \"scale\": \"yscale\" }\n" + 
				"  ],\n" + 
				"\n" + 
				"  \"marks\": [\n" + 
				"    {\n" + 
				"      \"type\": \"rect\",\n" + 
				"      \"from\": {\"data\":\"table\"},\n" + 
				"      \"encode\": {\n" + 
				"        \"enter\": {\n" + 
				"          \"x\": {\"scale\": \"xscale\", \"field\": \"recordedAt\"},\n" + 
				"          \"width\": {\"scale\": \"xscale\", \"band\": 1},\n" + 
				"          \"y\": {\"scale\": \"yscale\", \"field\": \"bloodSugarReading\"},\n" + 
				"          \"y2\": {\"scale\": \"yscale\", \"value\": 0}\n" + 
				"        },\n" + 
				"        \"update\": {\n" + 
				"          \"fill\": {\"value\": \"steelblue\"}\n" + 
				"        },\n" + 
				"        \"hover\": {\n" + 
				"          \"fill\": {\"value\": \"red\"}\n" + 
				"        }\n" + 
				"      }\n" + 
				"    },\n" + 
				"    {\n" + 
				"      \"type\": \"text\",\n" + 
				"      \"encode\": {\n" + 
				"        \"enter\": {\n" + 
				"          \"align\": {\"value\": \"center\"},\n" + 
				"          \"baseline\": {\"value\": \"bottom\"},\n" + 
				"          \"fill\": {\"value\": \"#333\"}\n" + 
				"        },\n" + 
				"        \"update\": {\n" + 
				"          \"x\": {\"scale\": \"xscale\", \"signal\": \"tooltip.recordedAt\", \"band\": 0.5},\n" + 
				"          \"y\": {\"scale\": \"yscale\", \"signal\": \"tooltip.bloodSugarReading\", \"offset\": -2},\n" + 
				"          \"text\": {\"signal\": \"tooltip.bloodSugarReading\"},\n" + 
				"          \"fillOpacity\": [\n" + 
				"            {\"test\": \"datum === tooltip\", \"value\": 0},\n" + 
				"            {\"value\": 1}\n" + 
				"          ]\n" + 
				"        }\n" + 
				"      }\n" + 
				"    }\n" + 
				"  ]\n" + 
				"}");
		return buff.toString();
	}

}
