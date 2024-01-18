package com.healthcare.medicalrecordservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Document
@Data
public class MedicalRecord {
    @Id
    private String id;
    private String patientId;
    private LocalDate recordDate;
    private String details;  // Details of the medical record
  
}
