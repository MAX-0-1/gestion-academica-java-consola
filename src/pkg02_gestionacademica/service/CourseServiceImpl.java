package pkg02_gestionacademica.service;
import java.util.List;
import pkg02_gestionacademica.dto.CourseRequestDTO;
import pkg02_gestionacademica.dto.CourseRosterDTO;
import pkg02_gestionacademica.dto.CourseSimpleDTO;
import pkg02_gestionacademica.entity.Course;
import pkg02_gestionacademica.entity.Enrollment;
import pkg02_gestionacademica.mapper.MapperCourse;
import pkg02_gestionacademica.repository.CourseRepository;
import pkg02_gestionacademica.repository.EnrollmentRepository;
public class CourseServiceImpl implements CourseService {
    private final CourseRepository repoCourse;
    private final EnrollmentRepository repoEnrollment;  
    public CourseServiceImpl(CourseRepository repoCourse, EnrollmentRepository repoEnrollment) {
        this.repoCourse = repoCourse;
        this.repoEnrollment = repoEnrollment;
    }
    
    @Override
    public CourseSimpleDTO crear(CourseRequestDTO dto) {
        if (dto == null) {
            throw new IllegalArgumentException("Dto de course a crear no puede ser nulo");
        }
        Course entity = MapperCourse.toEntity(dto);
        return MapperCourse.toSimpleDto(repoCourse.save(entity));
    }
    
    @Override
    public CourseSimpleDTO actualizar(Long idCourse, CourseRequestDTO dto) {
        if (idCourse == null || dto == null) {
            throw new IllegalArgumentException("Id de curso a actualizar/dto no puede ser nulo");
        }
        Course update = repoCourse.findById(idCourse).orElseThrow(() -> new IllegalArgumentException("No existe Id del curso"));
        update.setName(dto.name());
        update.setCredits(dto.credits());
        return MapperCourse.toSimpleDto(repoCourse.save(update));
    }
    
    @Override
    public void eliminar(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id de curso a eliminar no existe");
        }
        repoCourse.deleteById(id);
    }
    
    @Override
    public List<CourseSimpleDTO> listarTodos() {
        return repoCourse.findAll().stream().map(MapperCourse::toSimpleDto).toList();
    }

    
    @Override
    public CourseRosterDTO obtenerRosterDelCurso(Long courseId) {
        if (courseId == null) {
            throw new IllegalArgumentException("Id de curso para obtener Roster no puede ser nulo");
        }
        Course entity = repoCourse.findById(courseId).orElseThrow(() -> new IllegalArgumentException("No existe curso con ese ID"));
        List<Enrollment> enrollmentStuden = repoEnrollment.findByCourseId(courseId);
        return MapperCourse.toRosterDto(entity, enrollmentStuden);
    }
    
}