package com.poc.patient.visualization;

import java.util.List;

public class VegaMarkEncodeUpdate {
	private VegaMarkEncodeFill fill;

	private VegaMarkEncodeUpdateObject x;
	private VegaMarkEncodeUpdateObject y;
	private VegaMarkEncodeUpdateObject text;
	private List<VegaMarkEncodeUpdateFillOpacity> fillOpacity;
	
	public VegaMarkEncodeFill getFill() {
		return fill;
	}

	public void setFill(VegaMarkEncodeFill fill) {
		this.fill = fill;
	}

	public VegaMarkEncodeUpdateObject getX() {
		return x;
	}

	public void setX(VegaMarkEncodeUpdateObject x) {
		this.x = x;
	}

	public VegaMarkEncodeUpdateObject getY() {
		return y;
	}

	public void setY(VegaMarkEncodeUpdateObject y) {
		this.y = y;
	}

	public VegaMarkEncodeUpdateObject getText() {
		return text;
	}

	public void setText(VegaMarkEncodeUpdateObject text) {
		this.text = text;
	}

	public List<VegaMarkEncodeUpdateFillOpacity> getFillOpacity() {
		return fillOpacity;
	}

	public void setFillOpacity(List<VegaMarkEncodeUpdateFillOpacity> fillOpacitys) {
		this.fillOpacity = fillOpacitys;
	}
	
	
}
