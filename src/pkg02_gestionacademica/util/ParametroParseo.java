package pkg02_gestionacademica.util;
import java.util.List;
public class ParametroParseo {
    public static Long isLongNotNull(String isLong, String campo, List<String> errores) {
        try {
            if (isLong == null || isLong.isBlank()) {
                errores.add("El " + campo + " no puede ser nulo.");
                return null;
            }
            return Long.valueOf(isLong);
        } catch (NumberFormatException e) {
            errores.add("El " + campo + " debe ser numerico.");
            return null;
        }
    }  
    public static Double isDoubleNotNull(String isDouble, String campo, List<String> errores){
        try {
            if (isDouble == null || isDouble.isBlank()) {
                errores.add("El " + campo + " no puede ser nulo.");
                return null;
            }
            return Double.valueOf(isDouble);
        } catch (NumberFormatException e) {
            errores.add("El " + campo + " debe ser numerico.");
            return null;
        }
    }  
    public static Integer isIntegerNotNull(String isInteger, String campo, List<String>errores){
        try {
            if (isInteger == null || isInteger.isBlank()) {
                errores.add("El " + campo + " no puede ser nulo.");
                return null;
            }
            return Integer.valueOf(isInteger);
        } catch (NumberFormatException e) {
            errores.add("El " + campo + " debe ser numerico.");
            return null;
        }
    }
}
