package pkg02_gestionacademica;

import pkg02_gestionacademica.controller.CourseController;
import pkg02_gestionacademica.controller.EnrollmentController;
import pkg02_gestionacademica.controller.StudentController;
import pkg02_gestionacademica.dbLocalSimulado.dbLocal;
import pkg02_gestionacademica.repository.CourseRepository;
import pkg02_gestionacademica.repository.CourseRepositoryImpl;
import pkg02_gestionacademica.repository.EnrollmentRepository;
import pkg02_gestionacademica.repository.EnrollmentRepositoryImpl;
import pkg02_gestionacademica.repository.StudentRepository;
import pkg02_gestionacademica.repository.StudentRepositoryImpl;
import pkg02_gestionacademica.service.CourseService;
import pkg02_gestionacademica.service.CourseServiceImpl;
import pkg02_gestionacademica.service.EnrollmentService;
import pkg02_gestionacademica.service.EnrollmentServiceImpl;
import pkg02_gestionacademica.service.StudentService;
import pkg02_gestionacademica.service.StudentServiceImpl;

public class Main {

    public static void main(String[] args) {
        dbLocal db = dbLocal.getInstance();
        StudentRepository studentRepo = new StudentRepositoryImpl(db);
        CourseRepository courseRepo = new CourseRepositoryImpl(db);
        EnrollmentRepository enrollmentRepo = new EnrollmentRepositoryImpl(db);
        StudentService studentService = new StudentServiceImpl(studentRepo, enrollmentRepo);
        CourseService courseService = new CourseServiceImpl(courseRepo, enrollmentRepo);
        EnrollmentService enrollmentService = new EnrollmentServiceImpl(courseRepo, studentRepo, enrollmentRepo);
        StudentController studentController = new StudentController(studentService);
        CourseController courseController = new CourseController(courseService);
        EnrollmentController enrollmentController = new EnrollmentController(enrollmentService);
        try {
            //Probar controller estudiante
            studentController.crearEstudiante("Primero", "Primero@utp");
            studentController.crearEstudiante("Segundo", "Segundo@utp");
            studentController.crearEstudiante("Tercero", "Tercero@utp");
            studentController.crearEstudiante("Cuarto", "Cuarto@utp");
            studentController.listarTodosEstudiantes().forEach(e -> System.out.println("\n" + e.id() + "\n" + e.name() + "\n" + e.email()));
            studentController.actualizarEstudiante("0", "PrimeroActualizado", "PrimeroActualizado@utp");
            studentController.listarTodosEstudiantes().forEach(e -> System.out.println("\n" + e.id() + "\n" + e.name() + "\n" + e.email()));
            System.out.println(studentController.obtenerPerfilCompletoDeEstudiante("0"));
            System.out.println("----------------------------------------");
            //Probar controller curso
            courseController.crearCurso("POO", "5");
            courseController.crearCurso("MATEMATICA", "5");
            courseController.crearCurso("INGLES", "3");
            courseController.eliminarCurso("2");
            courseController.listarTodosCursos().forEach(e -> System.out.println("\n" + e.name() + "\n" + e.credits()));
            courseController.actualizarCurso("0", "Programacion Orientado a Objetos", "10");
            courseController.listarTodosCursos().forEach(e -> System.out.println("\n" + e.name() + "\n" + e.credits()));
            System.out.println(courseController.obtenerListaDelCursoAlumnos("1"));
            System.out.println("---------------------------------------");
            //Probar controller Inscripciones
            System.out.println(enrollmentController.matricular("FEB-1", "1", "1"));
            System.out.println("---------------------------------------");
            System.out.println(studentController.obtenerPerfilCompletoDeEstudiante("1"));
            System.out.println(courseController.obtenerListaDelCursoAlumnos("1"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
