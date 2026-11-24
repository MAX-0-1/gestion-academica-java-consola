package pkg02_gestionacademica.mapper;
import java.util.List;
import pkg02_gestionacademica.dto.EnrollmentSimpleDTO;
import pkg02_gestionacademica.dto.StudentProfileDTO;
import pkg02_gestionacademica.dto.StudentRequestDTO;
import pkg02_gestionacademica.dto.StudentSimpleDTO;
import pkg02_gestionacademica.entity.Enrollment;
import pkg02_gestionacademica.entity.Student;
public class MapperStudent {
    public static Student toEntity(StudentRequestDTO dto) {
        Student entity = new Student();
        entity.setName(dto.name());
        entity.setEmail(dto.email());
        return entity;
    }
    public static StudentSimpleDTO toSimpleDTO(Student entity) {
        return new StudentSimpleDTO(entity.getId(), entity.getName(), entity.getEmail());
    }
    public static StudentProfileDTO toProfileDTO(Student entity, List<Enrollment> enrollmentRoster) {
        List<EnrollmentSimpleDTO> dtoEnrollmentDto = enrollmentRoster.stream().map(MapperEnrollment::toSimpleDto).toList();
        return new StudentProfileDTO(entity.getId(), entity.getName(), dtoEnrollmentDto);}
}
