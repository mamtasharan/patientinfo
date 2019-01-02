package com.poc.patient.dao;


import com.poc.patient.entity.PatientBloodsugarInfo;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface PatientBloodsugarInfoDao extends CrudRepository<PatientBloodsugarInfo, String> {

    @Query("Select * from Patient_Bloodsugar_Info where id=?0")
    List<PatientBloodsugarInfo> findById(int id);

}