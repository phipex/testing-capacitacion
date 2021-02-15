package co.com.ies.cap.repository;

import co.com.ies.cap.domain.Employee;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class EmployeeRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EmployeeRepository employeeRepository;

    //when then

    @Test
    public void whenFindByName_thenReturnEmployee() {
        //Given ... Arrange
        Employee alex = new Employee("alex");
        entityManager.persistAndFlush(alex);

        //When ... Act
        Employee found = employeeRepository.findByName(alex.getName());

        //Then ... Assert
        //regular
        assertThat(found.getName()).isEqualTo(alex.getName());

        //malo
        assertThat(employeeRepository.findByName(alex.getName()).getName())
                .isEqualTo(alex.getName());

        assertEquals(found.getName(), alex.getName());
    }

    @Test
    public void whenFindByName_thenReturnEmployee2() {
        final String alexOriginalName = "alex";
        Employee alex = new Employee(alexOriginalName);
        entityManager.persistAndFlush(alex);

        final String alexName = alex.getName();
        Employee found = employeeRepository.findByName(alexName);

        //actual
        final String actual = found.getName();
        final String foundName = found.getName();

        final String actualFoundName = found.getName();

        //expected
        final String expectedAlexName = alexOriginalName;

        final String expected = alexOriginalName;


        //standar, dificil de leer? pero no dice nada
        assertThat(actual).isEqualTo(expected);
        assertEquals(actual, expected);

        //no standar, dice mucho pero un poco dificil de leer
        assertThat(found.getName()).isEqualTo(alex.getName());
        assertEquals(found.getName(), alex.getName());

        //no standar, dice mucho, facil de leer
        assertThat(foundName).isEqualTo(alexName);
        assertEquals(found.getName(), alex.getName());

        //no standar, dice mucho, facil de leer .... tiene otro expected?
        assertThat(foundName).isEqualTo(alexOriginalName);
        assertEquals(found.getName(), alex.getName());

        //standar, dice mucho y es facil de leer
        assertThat(actualFoundName).isEqualTo(expectedAlexName);
        assertEquals(found.getName(), alex.getName());
    }

    @Test
    public void whenInvalidName_thenReturnNull() {
        Employee fromDb = employeeRepository.findByName("doesNotExist");
        assertThat(fromDb).isNull();
    }

    @Test
    public void whenFindById_thenReturnEmployee() {
        Employee emp = new Employee("test");
        entityManager.persistAndFlush(emp);

        Employee fromDb = employeeRepository.findById(emp.getId()).orElse(null);
        assertThat(fromDb.getName()).isEqualTo(emp.getName());
    }

    @Test
    public void whenInvalidId_thenReturnNull() {
        Employee fromDb = employeeRepository.findById(-11l).orElse(null);
        assertThat(fromDb).isNull();
    }

    @Test
    public void givenSetOfEmployees_whenFindAll_thenReturnAllEmployees() {
        Employee alex = new Employee("alex");
        Employee ron = new Employee("ron");
        Employee bob = new Employee("bob");

        entityManager.persist(alex);
        entityManager.persist(bob);
        entityManager.persist(ron);
        entityManager.flush();

        List<Employee> allEmployees = employeeRepository.findAll();

        assertThat(allEmployees).hasSize(3).extracting(Employee::getName).containsOnly(alex.getName(), ron.getName(), bob.getName());
    }

}