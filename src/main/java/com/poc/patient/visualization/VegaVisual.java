package com.poc.patient.visualization;

import java.util.List;

public class VegaVisual {
	private String $schema;
	private int width;
	private int height;
	private int padding;
	
	private List<VegaData> data;
	private List<VegaSignal> signals;
	private List<VegaScale> scales;
	private List<VegaAxis> axes;
	private List<VegaMark> marks;
	public String get$schema() {
		return $schema;
	}
	public void set$schema(String $schema) {
		this.$schema = $schema;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getPadding() {
		return padding;
	}
	public void setPadding(int padding) {
		this.padding = padding;
	}
	public List<VegaData> getData() {
		return data;
	}
	public void setData(List<VegaData> data) {
		this.data = data;
	}
	public List<VegaSignal> getSignals() {
		return signals;
	}
	public void setSignals(List<VegaSignal> signals) {
		this.signals = signals;
	}
	public List<VegaScale> getScales() {
		return scales;
	}
	public void setScales(List<VegaScale> scales) {
		this.scales = scales;
	}
	public List<VegaAxis> getAxes() {
		return axes;
	}
	public void setAxes(List<VegaAxis> axes) {
		this.axes = axes;
	}
	public List<VegaMark> getMarks() {
		return marks;
	}
	public void setMarks(List<VegaMark> marks) {
		this.marks = marks;
	}
}
