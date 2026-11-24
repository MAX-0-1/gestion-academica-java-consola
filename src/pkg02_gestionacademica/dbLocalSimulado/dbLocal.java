package pkg02_gestionacademica.dbLocalSimulado;
import java.util.ArrayList;
import java.util.List;
import pkg02_gestionacademica.entity.Course;
import pkg02_gestionacademica.entity.Enrollment;
import pkg02_gestionacademica.entity.Student;
public class dbLocal {
    private static dbLocal instancia;
    private final List<Course> listaCourse;
    private final List<Student> listaStudent;
    private final List<Enrollment> listaEnrollment;
    private long idCourse = 0;
    private long idStudent = 0;
    private long idEnrollment = 0;
    public long idCourseIncrement() {return idCourse++;}
    public long idStudentIncrement() {return idStudent++;}
    public long idEnrollmentIncrement() {return idEnrollment++;}
    private dbLocal() {
        listaCourse = new ArrayList<>();
        listaStudent = new ArrayList<>();
        listaEnrollment = new ArrayList<>();
    }
    public static dbLocal getInstance() {
        if (instancia == null) {
            instancia = new dbLocal();
        }
        return instancia;
    }
    public List<Course> getListaCourse() {return listaCourse;}
    public List<Student> getListaStudent() {return listaStudent;}
    public List<Enrollment> getListaEnrollment() {return listaEnrollment;}
}
