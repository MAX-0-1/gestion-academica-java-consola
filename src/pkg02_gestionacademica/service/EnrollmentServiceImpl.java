package pkg02_gestionacademica.service;
import pkg02_gestionacademica.dto.EnrollmentRequestDTO;
import pkg02_gestionacademica.dto.EnrollmentSimpleDTO;
import pkg02_gestionacademica.entity.Course;
import pkg02_gestionacademica.entity.Enrollment;
import pkg02_gestionacademica.entity.Student;
import pkg02_gestionacademica.mapper.MapperEnrollment;
import pkg02_gestionacademica.repository.CourseRepository;
import pkg02_gestionacademica.repository.EnrollmentRepository;
import pkg02_gestionacademica.repository.StudentRepository;
public class EnrollmentServiceImpl implements EnrollmentService {
    private final CourseRepository repoCourse;
    private final StudentRepository repoStudent;
    private final EnrollmentRepository repoEnrollment;
    public EnrollmentServiceImpl(CourseRepository repoCourse, StudentRepository repoStudent, EnrollmentRepository repoEnrollment) {
        this.repoCourse = repoCourse;
        this.repoStudent = repoStudent;
        this.repoEnrollment = repoEnrollment;
    }
    @Override
    public EnrollmentSimpleDTO matricular(EnrollmentRequestDTO dto) {
        if (dto == null) {
            throw new IllegalArgumentException("Datos de la matricula a registrar no pueden ser nulos");
        }
        Course course = repoCourse.findById(dto.courseId()).orElseThrow(()->new IllegalArgumentException("Id de curso no existe"));
        Student student = repoStudent.findById(dto.studentId()).orElseThrow(()-> new IllegalArgumentException("Id de estudiante no existe"));
        Enrollment enrollment = MapperEnrollment.toEntity(dto, student, course);
        return MapperEnrollment.toSimpleDto(repoEnrollment.save(enrollment));
    }

    @Override
    public void darDeBajaMatricula(Long enrollmentId) {
        if (enrollmentId ==null) {
            throw new IllegalArgumentException("Id de matricula a dar de baja no puede ser nulo");
        }
        Enrollment update = repoEnrollment.findById(enrollmentId).orElseThrow(()-> new IllegalArgumentException("No existe Id de matricula a dar de baja"));
        update.setStatus(false);
    }
}
