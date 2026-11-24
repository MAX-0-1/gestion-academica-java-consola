package pkg02_gestionacademica.repository;

import java.util.List;
import java.util.Optional;
import pkg02_gestionacademica.entity.Course;

public interface CourseRepository {
    Course save(Course entity);

    Optional<Course> findById(Long id);

    List<Course> findAll();

    void deleteById(Long id);

    boolean existById(Long id);
}
