package twonyizin.springframework.image.imageupload.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import twonyizin.springframework.image.imageupload.entity.Employee;
import twonyizin.springframework.image.imageupload.models.response.EmployeeResponse;
import twonyizin.springframework.image.imageupload.repositories.EmployeeRepository;

@Component
public class BootStrapData implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;

    public BootStrapData( EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Employee employee = new Employee();
        employee.setEmployeeName("NyiNyiZin");
        employeeRepository.save(employee);
    }
}
