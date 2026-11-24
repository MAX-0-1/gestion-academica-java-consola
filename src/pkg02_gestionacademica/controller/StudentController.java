package pkg02_gestionacademica.controller;
import java.util.ArrayList;
import java.util.List;
import pkg02_gestionacademica.dto.StudentProfileDTO;
import pkg02_gestionacademica.dto.StudentRequestDTO;
import pkg02_gestionacademica.dto.StudentSimpleDTO;
import pkg02_gestionacademica.service.StudentService;
import pkg02_gestionacademica.util.ParametroParseo;
public class StudentController {
    private final StudentService StudentService;
    public StudentController(StudentService StudentService) {
        this.StudentService = StudentService;
    }
    public StudentSimpleDTO crearEstudiante(String name, String email) {
        List<String> errores = new ArrayList<>();
        StudentRequestDTO dto = new StudentRequestDTO(name, email);
        errores.addAll(dto.validar());
        if (!errores.isEmpty()) {
            throw new IllegalArgumentException("Error al parsear datos:\n" + String.join("\n", errores));
        }
        return StudentService.crear(dto);
    }
    public StudentSimpleDTO actualizarEstudiante(String idStudent, String name, String email) {
        List<String> errores = new ArrayList<>();
        Long idStudentValid = ParametroParseo.isLongNotNull(idStudent, "ID", errores);
        if (!errores.isEmpty()) {
            throw new IllegalArgumentException("Error al parsear datos:\n" + String.join("\n", errores));
        }
        StudentRequestDTO dto = new StudentRequestDTO(name, email);
        errores.addAll(dto.validar());
        if (!errores.isEmpty()) {
            throw new IllegalArgumentException("Error DTO datos:\n" + String.join("\n", errores));
        }
        return StudentService.actualizar(idStudentValid, dto);
    }
    public void EliminarEstudiante(String idStudent) {
        List<String> errores = new ArrayList<>();
        Long idStudentValid = ParametroParseo.isLongNotNull(idStudent, "ID", errores);
        if (!errores.isEmpty()) {
            throw new IllegalArgumentException("Error al parsear datos:\n" + String.join("\n", errores));
        }
        StudentService.eliminar(idStudentValid);
    }
    public List<StudentSimpleDTO> listarTodosEstudiantes() {
        return StudentService.listarTodos();
    }
    public StudentProfileDTO obtenerPerfilCompletoDeEstudiante(String idStudent) {
        List<String> errores = new ArrayList<>();
        Long idStudentValid = ParametroParseo.isLongNotNull(idStudent, "ID", errores);
        if (!errores.isEmpty()) {
            throw new IllegalArgumentException("Error al parsear datos:\n" + String.join("\n", errores));
        }
        return StudentService.obtenerPerfilCompleto(idStudentValid);
    }
}
