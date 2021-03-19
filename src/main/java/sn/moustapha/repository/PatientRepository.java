package sn.moustapha.repository;

import sn.moustapha.domain.Patient;

import java.util.ArrayList;

public interface PatientRepository {
   void getAllPatient();
   Patient showCarnetPatient(int id);
   void createPatient();
   void updatePatient();
   Patient findPatientByID(int id);
   Patient findPatientByParent(int idParent);
   void showcarnetPatient(int id);
}
