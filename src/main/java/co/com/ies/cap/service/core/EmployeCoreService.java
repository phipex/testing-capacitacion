package co.com.ies.cap.service.core;

import co.com.ies.cap.domain.Employee;
import co.com.ies.cap.domain.core.EmployeDomainCoreService;
import co.com.ies.cap.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeCoreService extends EmployeDomainCoreService {

    private final EmployeeService employeeService;

    public EmployeCoreService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public List<Employee> getAll() {
        return employeeService.getAllEmployees();
    }
}
