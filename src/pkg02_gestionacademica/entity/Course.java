package pkg02_gestionacademica.entity;

public class Course {
    private Long id;
    private String name;
    private Integer credits;
    private Boolean active = true;
    public Course(Long id, String name, Integer credits, Boolean active) {
        this.id = id;
        this.name = name;
        this.credits = credits;
        this.active = active != null ? active : this.active;
    }
    public Course() {}
    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public Integer getCredits() {return credits;}

    public void setCredits(Integer credits) {this.credits = credits;}

    public Boolean getActive() {return active;}

    public void setActive(Boolean active) {this.active = active;}
}
