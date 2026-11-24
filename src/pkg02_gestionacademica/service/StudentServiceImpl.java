package pkg02_gestionacademica.service;
import java.util.List;
import pkg02_gestionacademica.dto.StudentProfileDTO;
import pkg02_gestionacademica.dto.StudentRequestDTO;
import pkg02_gestionacademica.dto.StudentSimpleDTO;
import pkg02_gestionacademica.entity.Enrollment;
import pkg02_gestionacademica.entity.Student;
import pkg02_gestionacademica.mapper.MapperStudent;
import pkg02_gestionacademica.repository.EnrollmentRepository;
import pkg02_gestionacademica.repository.StudentRepository;
public class StudentServiceImpl implements StudentService {
    private final StudentRepository repoStudent;
    private final EnrollmentRepository repoEnrollment;
    public StudentServiceImpl(StudentRepository repoStudent, EnrollmentRepository repoEnrollment) {
        this.repoStudent = repoStudent;
        this.repoEnrollment = repoEnrollment;
    }

    @Override
    public StudentSimpleDTO crear(StudentRequestDTO dto) {
        if (dto == null) {
            throw new IllegalArgumentException("Dto para crear estudiante no puede ser nulo");
        }
        Student entity = MapperStudent.toEntity(dto);
        return MapperStudent.toSimpleDTO(repoStudent.save(entity));
    }
    @Override
    public StudentSimpleDTO actualizar(Long idStudent, StudentRequestDTO dto) {
        if (idStudent == null || dto == null) {
            throw new IllegalArgumentException("Id de estudiante/dto a actualizar no puede ser nulo");
        }

        Student update = repoStudent.findById(idStudent).orElseThrow(() -> new IllegalArgumentException("No existe Id de estudiante"));
        update.setName(dto.name());
        update.setEmail(dto.email());
        return MapperStudent.toSimpleDTO(repoStudent.save(update));
    }

    @Override
    public void eliminar(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id de estudiante a eliminar no puede ser nulo");
        }
        repoStudent.deleteById(id);
    }

    @Override
    public List<StudentSimpleDTO> listarTodos() {
        return repoStudent.findAll().stream().map(MapperStudent::toSimpleDTO).toList();
    }

    @Override
    public StudentProfileDTO obtenerPerfilCompleto(Long studentId) {
        if (studentId == null) {
            throw new IllegalArgumentException("Id de estudiante para ver perfil completo no puede ser nulo");
        }
        Student student = repoStudent.findById(studentId).orElseThrow(() -> new IllegalArgumentException("Id de estudiante para ver perfil completo no existe"));
        List<Enrollment> listaEnrollment = repoEnrollment.findByStudentId(studentId);
        return MapperStudent.toProfileDTO(student, listaEnrollment);
    }
}
