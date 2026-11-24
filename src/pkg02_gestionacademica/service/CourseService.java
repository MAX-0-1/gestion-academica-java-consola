package pkg02_gestionacademica.service;

import java.util.List;
import pkg02_gestionacademica.dto.CourseRequestDTO;
import pkg02_gestionacademica.dto.CourseRosterDTO;
import pkg02_gestionacademica.dto.CourseSimpleDTO;

public interface CourseService {

    CourseSimpleDTO crear(CourseRequestDTO dto);

    CourseSimpleDTO actualizar(Long idCourse, CourseRequestDTO dto);

    void eliminar(Long id);

    List<CourseSimpleDTO> listarTodos();

    CourseRosterDTO obtenerRosterDelCurso(Long courseId);
}
