package pkg02_gestionacademica.repository;

import java.util.List;
import java.util.Optional;
import pkg02_gestionacademica.entity.Enrollment;

public interface EnrollmentRepository {

    Enrollment save(Enrollment entity);

    Optional<Enrollment> findById(Long id);

    List<Enrollment> findAll();
    
    void deleteById(Long id);

    boolean existById(Long id);

    List<Enrollment> findByStudentId(Long studentId);

    List<Enrollment> findByCourseId(Long courseId);
}
