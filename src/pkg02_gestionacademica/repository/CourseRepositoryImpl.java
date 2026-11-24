package pkg02_gestionacademica.repository;
import java.util.List;
import java.util.Optional;
import pkg02_gestionacademica.dbLocalSimulado.dbLocal;
import pkg02_gestionacademica.entity.Course;
public class CourseRepositoryImpl implements CourseRepository {
    private final dbLocal db;
    public CourseRepositoryImpl(dbLocal db) {
        this.db = db;
    }

    @Override
    public Course save(Course entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Course no puede ser nulo");
        }

        if (entity.getId() == null) {
            entity.setId(db.idCourseIncrement());
            db.getListaCourse().add(entity);
            return entity;
        }

        for (int i = 0; i < db.getListaCourse().size(); i++) {
            if (db.getListaCourse().get(i).getId().equals(entity.getId())) {
                db.getListaCourse().set(i, entity);
                return entity;
            }
        }

        throw new IllegalArgumentException("Course no valido");
    }

    @Override
    public Optional<Course> findById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id a buscar no puede ser nulo");
        }
        return db.getListaCourse().stream().filter(entity -> entity.getId().equals(id)).findFirst();
    }

    @Override
    public List<Course> findAll() {
        return List.copyOf(db.getListaCourse());
    }

    @Override
    public void deleteById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id a eliminar no puede ser nulo");
        }

        if (!existById(id)) {
            throw new IllegalArgumentException("Id a eliminar no existe");
        }

        db.getListaCourse().removeIf(entity -> entity.getId().equals(id));
    }

    @Override
    public boolean existById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id a buscar existencia no puede ser nulo");
        }

        boolean exist = false;
        for (int i = 0; i < db.getListaCourse().size(); i++) {
            if (db.getListaCourse().get(i).getId().equals(id)) {
                exist = true;
                return exist;
            }
        }
        return exist;
    }
}
