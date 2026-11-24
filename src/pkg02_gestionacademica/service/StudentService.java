package pkg02_gestionacademica.service;

import java.util.List;
import pkg02_gestionacademica.dto.StudentProfileDTO;
import pkg02_gestionacademica.dto.StudentRequestDTO;
import pkg02_gestionacademica.dto.StudentSimpleDTO;

public interface StudentService {

    StudentSimpleDTO crear(StudentRequestDTO dto);
    StudentSimpleDTO actualizar(Long idStudent, StudentRequestDTO dto);
    void eliminar(Long id);
    List<StudentSimpleDTO> listarTodos();
    StudentProfileDTO obtenerPerfilCompleto(Long studentId);
}
