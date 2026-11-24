package pkg02_gestionacademica.dto;
import java.util.List;
public record CourseRosterDTO(Long id, String name, List<EnrollmentStudentDTO> enrollments) {}
