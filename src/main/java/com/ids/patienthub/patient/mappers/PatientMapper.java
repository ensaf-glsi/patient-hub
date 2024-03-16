package com.ids.patienthub.patient.mappers;

import com.ids.patienthub.patient.dto.DetailPatientDto;
import com.ids.patienthub.patient.dto.PatientDto;
import com.ids.patienthub.patient.dto.PatientNameDto;
import com.ids.patienthub.patient.entity.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PatientMapper {
    PatientMapper INSTANCE = Mappers.getMapper(PatientMapper.class);

    @Mapping(source = "familyStatus", target = "status")
    DetailPatientDto toDto(Patient source);
    @Mapping(source = "status", target = "familyStatus")
    Patient fromDto(PatientDto source);
    List<PatientDto> patientsToPatientDtoList(List<Patient> patients);

    Patient fromPatienNameDto(PatientNameDto dto);
    PatientNameDto toPatienNameDto(Patient entity);

}
