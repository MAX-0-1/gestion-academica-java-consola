package pkg02_gestionacademica.dto;
import java.util.ArrayList;
import java.util.List;
public record EnrollmentRequestDTO(String term, Long studentId, Long courseId) {
    public List<String> validar() {
        List<String> errores = new ArrayList<>();
        if (term == null || term.isBlank()) {
            errores.add("Ciclo invalido");
        }
        if (studentId == null || studentId < 0) {
            errores.add("Id de estudiante invalido");
        }
        if (courseId == null || courseId < 0) {
            errores.add("Id de curso invalido");
        }
        return errores;
    }
}
