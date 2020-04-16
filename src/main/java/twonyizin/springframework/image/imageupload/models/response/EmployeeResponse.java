package twonyizin.springframework.image.imageupload.models.response;

import org.springframework.hateoas.RepresentationModel;
import twonyizin.springframework.image.imageupload.models.Dtos.EmployeeDto;

public class EmployeeResponse extends RepresentationModel<EmployeeResponse> {
    private Boolean result;
    private Long id;
    private String employeeName;

    public EmployeeResponse(Long id,String employeeName) {
        this.id = id;
        this.employeeName = employeeName;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

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
