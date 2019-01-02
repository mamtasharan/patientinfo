package com.poc.patient.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.patient.dao.PatientBloodsugarInfoDao;
import com.poc.patient.entity.PatientBloodsugarInfo;
import com.poc.patient.visualization.VegaAxis;
import com.poc.patient.visualization.VegaData;
import com.poc.patient.visualization.VegaDataValue;
import com.poc.patient.visualization.VegaMark;
import com.poc.patient.visualization.VegaMarkEncode;
import com.poc.patient.visualization.VegaMarkEncodeEnter;
import com.poc.patient.visualization.VegaMarkEncodeEnterObject;
import com.poc.patient.visualization.VegaMarkEncodeFill;
import com.poc.patient.visualization.VegaMarkEncodeHover;
import com.poc.patient.visualization.VegaMarkEncodeUpdate;
import com.poc.patient.visualization.VegaMarkEncodeUpdateFillOpacity;
import com.poc.patient.visualization.VegaMarkEncodeUpdateObject;
import com.poc.patient.visualization.VegaMarkFrom;
import com.poc.patient.visualization.VegaScale;
import com.poc.patient.visualization.VegaScaleDomain;
import com.poc.patient.visualization.VegaSignal;
import com.poc.patient.visualization.VegaSignalOn;
import com.poc.patient.visualization.VegaVisual;

@Service
public class PatientBloodSugarLevelInfoService {

	@Autowired
	 private PatientBloodsugarInfoDao repository;

	public VegaVisual getVisualizationForPatientBloodSugarLevel(int id){
		List<PatientBloodsugarInfo> data = this.repository.findById(id);
		return generateVegaVisualizationFromData(data);
	}

	private VegaVisual generateVegaVisualizationFromData(List<PatientBloodsugarInfo> data) {
		VegaVisual visual = new VegaVisual();
		
		visual.set$schema("https://vega.github.io/schema/vega/v4.json");
		visual.setWidth(400);
		visual.setHeight(200);
		visual.setPadding(5);
		
		List<VegaData> visualData = getVegaData(data);
		visual.setData(visualData);
		
		List<VegaSignal> signals = getVegaStandardSignals();
		visual.setSignals(signals);
		
		List<VegaScale> scales = getVegaStandardScales();
		visual.setScales(scales);
		
		List<VegaAxis> axes = getVegaStandardAxes();
		visual.setAxes(axes);
		
		List<VegaMark> marks = getVegaStandardMarks();
		visual.setMarks(marks);
		
		return visual;
	}

	private List<VegaMark> getVegaStandardMarks() {
		List<VegaMark> marks = new ArrayList<VegaMark>();
		
		VegaMark mark1 = new VegaMark();
		mark1.setType("rect");
		
		VegaMarkFrom from = new VegaMarkFrom();
		from.setData("table");
		
		mark1.setFrom(from);
		
		VegaMarkEncode encode = new VegaMarkEncode();
		
		VegaMarkEncodeEnter enter = new VegaMarkEncodeEnter();
		
		VegaMarkEncodeEnterObject x = new VegaMarkEncodeEnterObject();
		x.setField("recordedAt");
		x.setScale("xscale");
		enter.setX(x);
		
		VegaMarkEncodeEnterObject width = new VegaMarkEncodeEnterObject();
		width.setBand(1);
		width.setScale("xscale");
		enter.setWidth(width);
		
		VegaMarkEncodeEnterObject y = new VegaMarkEncodeEnterObject();
		y.setField("bloodSugarReading");
		y.setScale("yscale");
		enter.setY(y);
		
		VegaMarkEncodeEnterObject y2 = new VegaMarkEncodeEnterObject();
		y2.setValue(0);
		y2.setScale("yscale");
		enter.setY2(y2);
		
		encode.setEnter(enter);
		
		VegaMarkEncodeUpdate update = new VegaMarkEncodeUpdate();
		
		VegaMarkEncodeFill fill = new VegaMarkEncodeFill();
		fill.setValue("steelblue");
		update.setFill(fill);
		
		encode.setUpdate(update);
		
		VegaMarkEncodeHover hover = new VegaMarkEncodeHover();
		
		fill = new VegaMarkEncodeFill();
		fill.setValue("red");
		hover.setFill(fill);
		
		encode.setHover(hover);
		mark1.setEncode(encode);
		marks.add(mark1);
		
		VegaMark mark2 = new VegaMark();
		mark2.setType("text");
		encode = new VegaMarkEncode();
		enter = new VegaMarkEncodeEnter();
		
		VegaMarkEncodeFill align = new VegaMarkEncodeFill();
		align.setValue("center");
		enter.setAlign(align);
		
		VegaMarkEncodeFill baseline = new VegaMarkEncodeFill();
		baseline.setValue("bottom");
		enter.setBaseline(baseline);
		
		fill = new VegaMarkEncodeFill();
		fill.setValue("#333");
		enter.setFill(fill);
		
		encode.setEnter(enter);
		
		update = new VegaMarkEncodeUpdate();
		
		VegaMarkEncodeUpdateObject x_update = new VegaMarkEncodeUpdateObject();
		x_update.setScale("xscale");
		x_update.setSignal("tooltip.recordedAt");
		x_update.setBand(0.5);
		
		update.setX(x_update);
		
		VegaMarkEncodeUpdateObject y_update = new VegaMarkEncodeUpdateObject();
		y_update.setScale("yscale");
		y_update.setSignal("tooltip.bloodSugarReading");
		y_update.setOffset(-2);
		
		update.setY(y_update);
		
		VegaMarkEncodeUpdateObject text = new VegaMarkEncodeUpdateObject();
		text.setSignal("tooltip.bloodSugarReading");
		
		update.setText(text);
		
		List<VegaMarkEncodeUpdateFillOpacity> fillOpacityList = new ArrayList<VegaMarkEncodeUpdateFillOpacity>();
		VegaMarkEncodeUpdateFillOpacity fillOpacity1 = new VegaMarkEncodeUpdateFillOpacity();
		fillOpacity1.setTest("datum === tooltip");
		fillOpacity1.setValue(0);
		fillOpacityList.add(fillOpacity1);
		
		VegaMarkEncodeUpdateFillOpacity fillOpacity2 = new VegaMarkEncodeUpdateFillOpacity();
		fillOpacity2.setValue(1);
		fillOpacityList.add(fillOpacity2);
		
		update.setFillOpacity(fillOpacityList);
		
		encode.setUpdate(update);
		mark2.setEncode(encode);
		marks.add(mark2);
		
		
		return marks;
	}

	private List<VegaAxis> getVegaStandardAxes() {
		List<VegaAxis> axes = new ArrayList<VegaAxis>();
		
		VegaAxis axis1 = new VegaAxis();
		axis1.setOrient("bottom");
		axis1.setScale("xscale");
		axes.add(axis1);
		
		VegaAxis axis2 = new VegaAxis();
		axis2.setOrient("left");
		axis2.setScale("yscale");
		axes.add(axis2);
		
		return axes;
	}

	private List<VegaScale> getVegaStandardScales() {
		List<VegaScale> scales = new ArrayList<VegaScale>();
		
		VegaScale scale1 = new VegaScale();
		scale1.setName("xscale");
		scale1.setType("band");
		
		VegaScaleDomain domain = new VegaScaleDomain();
		domain.setData("table");
		domain.setField("recordedAt");
		
		scale1.setDomain(domain);
		scale1.setRange("width");
		scale1.setPadding(0.05);
		scale1.setRound(true);
		
		scales.add(scale1);
		
		VegaScale scale2 = new VegaScale();
		scale2.setName("yscale");
		
		domain = new VegaScaleDomain();
		domain.setData("table");
		domain.setField("bloodSugarReading");
		
		scale2.setDomain(domain);
		scale2.setRange("height");
		scale2.setNice(true);
		
		scales.add(scale2);
		
		
		
		return scales;
	}

	private List<VegaSignal> getVegaStandardSignals() {
		List<VegaSignal> signals = new ArrayList<VegaSignal>();
		
		VegaSignal signal = new VegaSignal();
		signal.setName("tooltip");
		signal.setValue(new JSONObject());
		
		List<VegaSignalOn> ons = new ArrayList<VegaSignalOn>();
		VegaSignalOn on1 = new VegaSignalOn();
		on1.setEvents("rect:mouseover");
		on1.setUpdate("datum");
		ons.add(on1);
		
		VegaSignalOn on2 = new VegaSignalOn();
		on2.setEvents("rect:mouseout");
		on2.setUpdate("{}");
		ons.add(on2);
		
		signal.setOn(ons);
		
		signals.add(signal);
		return signals;
	}

	private List<VegaData> getVegaData(List<PatientBloodsugarInfo> data) {
		
		List<VegaData> dataList = new ArrayList<VegaData>();
		VegaData vegaData = new VegaData();
		vegaData.setName("table");
		
		List<VegaDataValue> values = new ArrayList<VegaDataValue>();
		
		
		for(PatientBloodsugarInfo model : data) {
			VegaDataValue dataValue = new VegaDataValue();
			dataValue.setRecordedAt(model.getRecorded_at().toString());
			dataValue.setBloodSugarReading(model.getBloodsugarlevel());
			values.add(dataValue);
		}
		vegaData.setValues(values);
		dataList.add(vegaData);
		return dataList;
	}
}
