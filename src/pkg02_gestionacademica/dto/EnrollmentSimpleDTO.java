package pkg02_gestionacademica.dto;
public record EnrollmentSimpleDTO(Long id, String term, Boolean status, CourseSimpleDTO course) {}