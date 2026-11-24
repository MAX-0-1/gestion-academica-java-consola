package pkg02_gestionacademica.dto;
import java.util.List;
public record StudentProfileDTO(Long id, String name, List<EnrollmentSimpleDTO> enrollments) {}
