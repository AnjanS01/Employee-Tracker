package id_new.demo1.entity;

public class Employee {
    private Long id;
    private String empId;
    private String name;
    private Long phnumber;
    private String email;
    private String workingType;

    public Employee() {}

    public Employee(String empId, String name, Long phnumber, String email, String workingType) {
        this.empId = empId;
        this.name = name;
        this.phnumber = phnumber;
        this.email = email;
        this.workingType = workingType;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getEmpId() { return empId; }
    public void setEmpId(String empId) { this.empId = empId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Long getPhnumber() { return phnumber; }
    public void setPhnumber(Long phnumber) { this.phnumber = phnumber; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getWorkingType() { return workingType; }
    public void setWorkingType(String workingType) { this.workingType = workingType; }
}
