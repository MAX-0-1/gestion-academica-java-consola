package pkg02_gestionacademica.dto;
import java.util.ArrayList;
import java.util.List;
public record StudentRequestDTO(String name, String email) {
    public List<String> validar() {
        List<String> errores = new ArrayList<>();
        if (name == null || name.isBlank()) {
            errores.add("Nombre no puede estar vacio");
        }
        if (email == null || email.isBlank() || !email.contains("@")) {
            errores.add("Email no puede estar vacio, debe contener @");
        }
        return errores;
    }
}
