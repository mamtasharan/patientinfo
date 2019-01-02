package com.poc.patient.entity;

import java.util.Date;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table(value="patient_bloodsugar_info")
public class PatientBloodsugarInfo {

    @PrimaryKey
    private int id;

    @Column
    private Date recorded_at;

    @Column
    private int bloodsugarlevel;

    public PatientBloodsugarInfo() {
    }

    public PatientBloodsugarInfo(int id, Date recorded_at, int bloodsugarlevel) {
        this.id = id;
        this.recorded_at = recorded_at;
        this.bloodsugarlevel = bloodsugarlevel;
    }

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the recorded_at
	 */
	public Date getRecorded_at() {
		return recorded_at;
	}

	/**
	 * @param recorded_at the recorded_at to set
	 */
	public void setRecorded_at(Date recorded_at) {
		this.recorded_at = recorded_at;
	}

	/**
	 * @return the bloodsugar_level
	 */
	public int getBloodsugarlevel() {
		return bloodsugarlevel;
	}

	/**
	 * @param bloodsugar_level the bloodsugar_level to set
	 */
	public void setBloodsugarlevel(int bloodsugarlevel) {
		this.bloodsugarlevel = bloodsugarlevel;
	}

}
