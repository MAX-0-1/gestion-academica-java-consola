package pkg02_gestionacademica.controller;
import java.util.ArrayList;
import java.util.List;
import pkg02_gestionacademica.dto.EnrollmentRequestDTO;
import pkg02_gestionacademica.dto.EnrollmentSimpleDTO;
import pkg02_gestionacademica.service.EnrollmentService;
import pkg02_gestionacademica.util.ParametroParseo;
public class EnrollmentController {    
    private final EnrollmentService EnrollmentService;
    public EnrollmentController(EnrollmentService EnrollmentService) {
        this.EnrollmentService = EnrollmentService;
    }
    public EnrollmentSimpleDTO matricular(String term, String studentId, String courseId) {
        List<String> errores = new ArrayList();
        Long studentIdValid = ParametroParseo.isLongNotNull(studentId, "ID ESTUDIANTE", errores);
        Long courseIdValid = ParametroParseo.isLongNotNull(courseId, "ID CURSO", errores);
        if (!errores.isEmpty()) {
            throw new IllegalArgumentException("Errores de parseo:\n" + String.join("\n", errores));
        }
        EnrollmentRequestDTO dto = new EnrollmentRequestDTO(term, studentIdValid, courseIdValid);
        errores.addAll(dto.validar());
        if (!errores.isEmpty()) {
            throw new IllegalArgumentException("Errores en DTO:\n" + String.join("\n", errores));
        }
        return EnrollmentService.matricular(dto);
    }
    public void darDeBajaMatricula(String enrollmentId) {
        List<String> errores = new ArrayList<>();
        Long enrollmentIdValid = ParametroParseo.isLongNotNull(enrollmentId, "ID", errores);
        if (!errores.isEmpty()) {
            throw new IllegalArgumentException("Errores de parseo:\n" + String.join("\n", errores));
        }
        EnrollmentService.darDeBajaMatricula(enrollmentIdValid);
    }
}
