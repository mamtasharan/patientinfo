package com.poc.patient.visualization;

import java.util.List;

public class VegaData {
	private String name;
	private List<VegaDataValue> values;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<VegaDataValue> getValues() {
		return values;
	}
	public void setValues(List<VegaDataValue> values) {
		this.values = values;
	}
	
	
}
