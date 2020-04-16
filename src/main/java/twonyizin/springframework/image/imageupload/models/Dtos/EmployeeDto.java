package twonyizin.springframework.image.imageupload.models.Dtos;

import org.springframework.hateoas.RepresentationModel;

public class EmployeeDto{

    private Long id;
    private String employeeName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

}
