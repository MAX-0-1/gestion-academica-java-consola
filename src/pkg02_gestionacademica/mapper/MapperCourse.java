package pkg02_gestionacademica.mapper;
import java.util.List;
import pkg02_gestionacademica.dto.CourseRequestDTO;
import pkg02_gestionacademica.dto.CourseRosterDTO;
import pkg02_gestionacademica.dto.CourseSimpleDTO;
import pkg02_gestionacademica.dto.EnrollmentStudentDTO;
import pkg02_gestionacademica.entity.Course;
import pkg02_gestionacademica.entity.Enrollment;
public class MapperCourse {
    public static Course toEntity(CourseRequestDTO dto) {
        Course entity = new Course();
        entity.setName(dto.name());
        entity.setCredits(dto.credits());
        return entity;
    }
    public static CourseSimpleDTO toSimpleDto(Course entity) {
        return new CourseSimpleDTO(entity.getId(), entity.getName(), entity.getCredits());
    }
    public static CourseRosterDTO toRosterDto(Course entity, List<Enrollment> enrollment) {
        List<EnrollmentStudentDTO> enrollmentStudentRoster = enrollment.stream().map(MapperEnrollment::toStudentDto).toList();
        return new CourseRosterDTO(entity.getId(), entity.getName(), enrollmentStudentRoster);}
}
