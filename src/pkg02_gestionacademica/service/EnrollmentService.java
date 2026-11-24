package pkg02_gestionacademica.service;

import pkg02_gestionacademica.dto.EnrollmentRequestDTO;
import pkg02_gestionacademica.dto.EnrollmentSimpleDTO;

public interface EnrollmentService {
    
    EnrollmentSimpleDTO matricular (EnrollmentRequestDTO dto);
    void darDeBajaMatricula(Long enrollmentId);
}  