package co.com.ies.cap.domain.core;

import co.com.ies.cap.domain.Employee;

import java.util.List;

public abstract class EmployeDomainCoreService implements IEmployeDomainCoreService {

    public static final String FAIL_PREFIX = "__";

    public boolean validate(Employee employee){

        final String name = employee.getName();

        return !name.contains(FAIL_PREFIX);

    }

    public boolean validateAll(){

        List<Employee> all = getAll();
        System.out.println("all = " + all);
        for (Employee employee : all) {
            System.out.println("employee = " + employee);
            if (!validate(employee)){
                return false;
            }
        }

        return true;
    }



}
