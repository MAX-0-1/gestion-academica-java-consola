package pkg02_gestionacademica.repository;
import java.util.List;
import java.util.Optional;
import pkg02_gestionacademica.dbLocalSimulado.dbLocal;
import pkg02_gestionacademica.entity.Student;
public class StudentRepositoryImpl implements StudentRepository {
    private final dbLocal db;
    public StudentRepositoryImpl(dbLocal db) {
        this.db = db;
    }

    @Override
    public Student save(Student entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Estudiante no puede ser nulo");
        }

        if (entity.getId() == null) {
            entity.setId(db.idStudentIncrement());
            db.getListaStudent().add(entity);
            return entity;
        }

        for (int i = 0; i < db.getListaStudent().size(); i++) {
            if (db.getListaStudent().get(i).getId().equals(entity.getId())) {
                db.getListaStudent().set(i, entity);
                return entity;
            }
        }

        throw new IllegalArgumentException("Estudiante invalido");
    }

    @Override
    public Optional<Student> findById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id de estudiante a buscar no puede ser nulo");
        }
        return db.getListaStudent().stream().filter(entity -> entity.getId().equals(id)).findFirst();
    }

    @Override
    public List<Student> findAll() {
        return List.copyOf(db.getListaStudent());
    }

    @Override
    public void deleteById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id de estudiante a eliminar no puede ser nulo");
        }
        if (!existById(id)) {
            throw new IllegalArgumentException("Id de estudiante a eliminar no puede ser nulo");
        }

        db.getListaStudent().removeIf(entity -> entity.getId().equals(id));
    }

    @Override
    public boolean existById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id de estudiante a verificar existencia no puede ser nulo");
        }
        boolean exist = false;
        for (int i = 0; i < db.getListaStudent().size(); i++) {
            if (db.getListaStudent().get(i).getId().equals(id)) {
                exist = true;
                return exist;
            }
        }
        return exist;
    }
}
