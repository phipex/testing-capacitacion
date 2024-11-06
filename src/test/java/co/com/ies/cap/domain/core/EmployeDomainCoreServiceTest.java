package co.com.ies.cap.domain.core;

import co.com.ies.cap.domain.Employee;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeDomainCoreServiceTest {

    private static Long ID_DEFAULT = 1L;
    private static String VALID_EMPLOYE_NAME = "valid";
    private static Long ID_DEFAULT2 = 2L;
    private static String VALID_EMPLOYE_NAME2 = "valid2";
    private static String INVALID_EMPLOYE_NAME = "__valid";
    private static Employee EMPLOYEE_NULL;


    @Test
    void validate_exception(){
        //given
        EmployeDomainCoreService service = spy(EmployeDomainCoreService.class);


        //then
        Exception exception = assertThrows(DomainException.class, () -> {
            final boolean validateActual = service.validate2(EMPLOYEE_NULL);
          });
        
//          Exception exception2 = assertThrows(NullPointerException.class, () -> {
//            final boolean validateActual = service.validate2(EMPLOYEE_NULL);
//          });

        //when
          assertEquals(DomainException.NO_DATA, exception.getMessage());
    }


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

    @Test
    void validate_validate(){
        //given
        EmployeDomainCoreService service = spy(EmployeDomainCoreService.class);

        List<Employee> employeeList = new ArrayList<>();
        Employee employe = new Employee();
        employe.setName(INVALID_EMPLOYE_NAME);
        employe.setId(ID_DEFAULT);
        employeeList.add(employe);

        Employee employe2 = new Employee();
        employe2.setName(VALID_EMPLOYE_NAME2);
        employe2.setId(ID_DEFAULT2);
        employeeList.add(employe2);

        when(service.getAll()).thenReturn(employeeList);

        //then
        final boolean validateActual = service.validateAll();

        //when
        assertFalse(validateActual);

        verify(service, times(1)).validate(Mockito.any());

        ArgumentCaptor<Employee> captor = ArgumentCaptor.forClass(Employee.class);
        verify(service).validate(captor.capture());
        Employee value = captor.getValue();
        System.out.println ("value = " + value);
        assertEquals(employe, value);
    }


}