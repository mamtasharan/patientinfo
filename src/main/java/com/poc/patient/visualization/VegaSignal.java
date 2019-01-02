package com.poc.patient.visualization;

import java.util.List;

import org.json.JSONObject;

public class VegaSignal {
	private String name;
	private JSONObject value;
	private List<VegaSignalOn> on;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public JSONObject getValue() {
		return value;
	}
	public void setValue(JSONObject value) {
		this.value = value;
	}
	public List<VegaSignalOn> getOn() {
		return on;
	}
	public void setOn(List<VegaSignalOn> on) {
		this.on = on;
	}
	
}
