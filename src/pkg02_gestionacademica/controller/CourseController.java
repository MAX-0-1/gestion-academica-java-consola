package pkg02_gestionacademica.controller;
import java.util.ArrayList;
import java.util.List;
import pkg02_gestionacademica.dto.CourseRequestDTO;
import pkg02_gestionacademica.dto.CourseRosterDTO;
import pkg02_gestionacademica.dto.CourseSimpleDTO;
import pkg02_gestionacademica.service.CourseService;
import pkg02_gestionacademica.util.ParametroParseo;
public class CourseController {
    private final CourseService courseService;
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    public CourseSimpleDTO crearCurso(String name, String credits) {
        List<String> errores = new ArrayList();
        Integer creditsValid = ParametroParseo.isIntegerNotNull(credits, "CREDITOS", errores);
        if (!errores.isEmpty()) {
            throw new IllegalArgumentException("Error al parsear datos:\n" + String.join("\n", errores));
        }
        CourseRequestDTO dto = new CourseRequestDTO(name, creditsValid);
        errores.addAll(dto.validar());
        if (!errores.isEmpty()) {
            throw new IllegalArgumentException("Error al DTO datos:\n" + String.join("\n", errores));
        }
        return courseService.crear(dto);
    }
    public CourseSimpleDTO actualizarCurso(String idCourse, String name, String credits) {
        List<String> errores = new ArrayList<>();
        Long idCourseValid = ParametroParseo.isLongNotNull(idCourse, "ID", errores);
        Integer creditsValid = ParametroParseo.isIntegerNotNull(credits, "CREDITOS", errores);
        if (!errores.isEmpty()) {
            throw new IllegalArgumentException("Error al parsear datos:\n" + String.join("\n", errores));
        }
        CourseRequestDTO dto = new CourseRequestDTO(name, creditsValid);
        errores.addAll(dto.validar());
        if (!errores.isEmpty()) {
            throw new IllegalArgumentException("Error al DTO datos:\n" + String.join("\n", errores));
        }
        return courseService.actualizar(idCourseValid, dto);
    }
    public void eliminarCurso(String idCourse) {
        List<String> errores = new ArrayList<>();
        Long isCourseValida = ParametroParseo.isLongNotNull(idCourse, "ID", errores);
        if (!errores.isEmpty()) {
            throw new IllegalArgumentException("Error al parsear datos:\n" + String.join("\n", errores));
        }
        courseService.eliminar(isCourseValida);
    }
    public List<CourseSimpleDTO> listarTodosCursos() {
        return courseService.listarTodos();
    }
    public CourseRosterDTO obtenerListaDelCursoAlumnos(String idCourse) {
        List<String> errores = new ArrayList<>();
        Long idCourseValid = ParametroParseo.isLongNotNull(idCourse, "ID", errores);
        if (!errores.isEmpty()) {
            throw new IllegalArgumentException("Error al parsear datos:\n" + String.join("\n", errores));
        }
        return courseService.obtenerRosterDelCurso(idCourseValid);
    }
}
