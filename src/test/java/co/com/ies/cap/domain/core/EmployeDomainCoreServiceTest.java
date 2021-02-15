package co.com.ies.cap.domain.core;

import co.com.ies.cap.domain.Employee;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

class EmployeDomainCoreServiceTest {

    private static Long ID_DEFAULT = 1L;
    private static String VALID_EMPLOYE_NAME = "valid";
    private static String INVALID_EMPLOYE_NAME = "__valid";

    @Test
    void validate_success(){
        //given
        EmployeDomainCoreService service = spy(EmployeDomainCoreService.class);
        Employee employe = new Employee();
        employe.setName(VALID_EMPLOYE_NAME);
        employe.setId(ID_DEFAULT);

        //then
        final boolean validateActual = service.validate(employe);

        //when
        assertTrue(validateActual);
    }

    @Test
    void validate_fail(){
        //given
        EmployeDomainCoreService service = spy(EmployeDomainCoreService.class);
        Employee employe = new Employee();
        employe.setName(INVALID_EMPLOYE_NAME);
        employe.setId(ID_DEFAULT);

        //then
        final boolean validateActual = service.validate(employe);

        //when
        assertFalse(validateActual);
    }

    @Test
    void validateAll_success(){
        //given
        EmployeDomainCoreService service = spy(EmployeDomainCoreService.class);

        List<Employee> employeeList = new ArrayList<>();
        Employee employe = new Employee();
        employe.setName(VALID_EMPLOYE_NAME);
        employe.setId(ID_DEFAULT);

        when(service.getAll()).thenReturn(employeeList);

        //then
        final boolean validateActual = service.validateAll();

        //when
        assertTrue(validateActual);
    }


    @Test
    void validateAll_fail(){
        //given
        EmployeDomainCoreService service = spy(EmployeDomainCoreService.class);

        List<Employee> employeeList = new ArrayList<>();
        Employee employe = new Employee();
        employe.setName(INVALID_EMPLOYE_NAME);
        employe.setId(ID_DEFAULT);
        employeeList.add(employe);

        when(service.getAll()).thenReturn(employeeList);

        //then
        final boolean validateActual = service.validateAll();

        //when
        assertFalse(validateActual);
    }


}