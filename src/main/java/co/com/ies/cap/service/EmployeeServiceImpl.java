package co.com.ies.cap.service;

import java.util.List;

import co.com.ies.cap.domain.Employee;
import co.com.ies.cap.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Employee getEmployeeByName(String name) {
        return employeeRepository.findByName(name);
    }

    @Override
    public boolean exists(String name) {
        return employeeRepository.findByName(name) != null;
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}