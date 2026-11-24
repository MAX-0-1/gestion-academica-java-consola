package pkg02_gestionacademica.mapper;
import pkg02_gestionacademica.dto.EnrollmentRequestDTO;
import pkg02_gestionacademica.dto.EnrollmentSimpleDTO;
import pkg02_gestionacademica.dto.EnrollmentStudentDTO;
import pkg02_gestionacademica.entity.Course;
import pkg02_gestionacademica.entity.Enrollment;
import pkg02_gestionacademica.entity.Student;
public class MapperEnrollment {
    public static Enrollment toEntity(EnrollmentRequestDTO enrollmentDTO, Student student, Course course) {
        Enrollment entity = new Enrollment();
        entity.setTerm(enrollmentDTO.term());
        entity.setStudent(student);
        entity.setCourse(course);
        return entity;
    }
    public static EnrollmentSimpleDTO toSimpleDto(Enrollment entity) {
        return new EnrollmentSimpleDTO(entity.getId(), entity.getTerm(), entity.getStatus(), MapperCourse.toSimpleDto(entity.getCourse()));
    }
    public static EnrollmentStudentDTO toStudentDto(Enrollment entity) {
        return new EnrollmentStudentDTO(entity.getId(), entity.getTerm(), entity.getStatus(), MapperStudent.toSimpleDTO(entity.getStudent()));}
}
