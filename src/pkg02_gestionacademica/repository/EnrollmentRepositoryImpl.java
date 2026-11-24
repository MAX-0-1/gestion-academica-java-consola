package pkg02_gestionacademica.repository;
import java.util.List;
import java.util.Optional;
import pkg02_gestionacademica.dbLocalSimulado.dbLocal;
import pkg02_gestionacademica.entity.Enrollment;
public class EnrollmentRepositoryImpl implements EnrollmentRepository {
    private final dbLocal db;
    public EnrollmentRepositoryImpl(dbLocal db) {
        this.db = db;
    }
    @Override
    public Enrollment save(Enrollment entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Enrollment no puede ser nulo");
        }

        if (entity.getId() == null) {
            entity.setId(db.idEnrollmentIncrement());
            db.getListaEnrollment().add(entity);
            return entity;
        }

        for (int i = 0; i < db.getListaEnrollment().size(); i++) {
            if (db.getListaEnrollment().get(i).getId().equals(entity.getId())) {
                db.getListaEnrollment().set(i, entity);
                return entity;
            }
        }
        throw new IllegalArgumentException("Enrollment invalido");
    }

    @Override
    public Optional<Enrollment> findById(Long id) {
        return db.getListaEnrollment().stream().filter(entity -> entity.getId().equals(id)).findFirst();
    }

    @Override
    public List<Enrollment> findAll() {
        return List.copyOf(db.getListaEnrollment());
    }

    @Override
    public void deleteById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id de Inscripcion a eliminar no puede ser nulo");
        }

        if (!existById(id)) {
            throw new IllegalArgumentException("Id de Inscripcion a eliminar no existe");
        }

        db.getListaEnrollment().removeIf(entity -> entity.getId().equals(id));
    }

    @Override
    public boolean existById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id de Inscripcion a verificar existencia no puede ser nulo");
        }
        boolean exist = false;

        for (int i = 0; i < db.getListaEnrollment().size(); i++) {
            if (db.getListaEnrollment().get(i).getId().equals(id)) {
                exist = true;
                return exist;
            }
        }
        return exist;
    }

    @Override
    public List<Enrollment> findByStudentId(Long studentId) {
        List<Enrollment> studentRoster = db.getListaEnrollment().stream().filter(entity -> entity.getStudent().getId().equals(studentId)).toList();
        return studentRoster;
    }

    @Override
    public List<Enrollment> findByCourseId(Long courseId) {
        List<Enrollment> courseRoster = db.getListaEnrollment().stream().filter(entity -> entity.getCourse().getId().equals(courseId)).toList();
        return courseRoster;
    }
}
