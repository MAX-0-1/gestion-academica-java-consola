package pkg02_gestionacademica.entity;
public class Enrollment {
    private Long id;
    private String term;
    private Boolean status = true;
    private Student student;
    private Course course;
    public Enrollment(Long id, String term, Boolean status, Student student, Course course) {
        this.id = id;
        this.term = term;
        this.status = status != null ? status : this.status;
        this.student = student;
        this.course = course;
    }
    public Enrollment() {}
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getTerm() {return term;}
    public void setTerm(String term) {this.term = term;}
    public Boolean getStatus() {return status;}
    public void setStatus(Boolean status) {this.status = status;}
    public Student getStudent() {return student;}
    public void setStudent(Student student) {this.student = student;}
    public Course getCourse() {return course;}
    public void setCourse(Course course) {this.course = course;}
}
