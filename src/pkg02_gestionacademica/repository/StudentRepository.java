package pkg02_gestionacademica.repository;

import java.util.List;
import java.util.Optional;
import pkg02_gestionacademica.entity.Student;

public interface StudentRepository {

    Student save(Student entity);

    Optional<Student> findById(Long id);

    List<Student> findAll();

    void deleteById(Long id);

    boolean existById(Long id);
}
