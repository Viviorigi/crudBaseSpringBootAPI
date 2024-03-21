package javaguide.crud.mapper;

import javaguide.crud.dto.EmployeeDto;
import javaguide.crud.entity.Employee;

public class EmployeeMapper {
    public static EmployeeDto maptoEmployeeDto(Employee employee){
        return new EmployeeDto(
                employee.get_id(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    public  static Employee mapToEmployee(EmployeeDto employeeDto){
        return  new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }
}
