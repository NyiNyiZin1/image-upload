package twonyizin.springframework.image.imageupload.services.Impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import twonyizin.springframework.image.imageupload.entity.Employee;
import twonyizin.springframework.image.imageupload.models.Dtos.EmployeeDto;
import twonyizin.springframework.image.imageupload.repositories.EmployeeRepository;
import twonyizin.springframework.image.imageupload.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto getEmployeeById(long employeeId) {
        ModelMapper modelMapper = new ModelMapper();
        Employee employee = employeeRepository.getOne(employeeId);
        return modelMapper.map(employee, EmployeeDto.class);
    }
}
