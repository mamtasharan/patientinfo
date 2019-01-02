package com.poc.patient.visualization;

public class VegaScale {
	private String name;
	private String type;
	private String range;
	private Double padding;
	private boolean round;
	private boolean nice;
	
	public boolean isNice() {
		return nice;
	}
	public void setNice(boolean nice) {
		this.nice = nice;
	}
	private VegaScaleDomain domain;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRange() {
		return range;
	}
	public void setRange(String range) {
		this.range = range;
	}
	public Double getPadding() {
		return padding;
	}
	public void setPadding(double padding) {
		this.padding = padding;
	}
	public boolean isRound() {
		return round;
	}
	public void setRound(boolean round) {
		this.round = round;
	}
	public VegaScaleDomain getDomain() {
		return domain;
	}
	public void setDomain(VegaScaleDomain domain) {
		this.domain = domain;
	}
}
