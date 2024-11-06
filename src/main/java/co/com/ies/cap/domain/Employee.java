package co.com.ies.cap.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "person")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min = 3, max = 20)
    private String name;

    public Employee() {
    }

    public Employee(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass () != o.getClass ()) return false;

        Employee employee = (Employee) o;
        return Objects.equals (getId (), employee.getId ()) && Objects.equals (getName (), employee.getName ());
    }

    @Override
    public int hashCode () {
        int result = Objects.hashCode (getId ());
        result = 31 * result + Objects.hashCode (getName ());
        return result;
    }

    @Override
    public String toString () {
        return "Employee{" +
               "id=" + getId () +
               ", name='" + getName () + '\'' +
               '}';
    }
}