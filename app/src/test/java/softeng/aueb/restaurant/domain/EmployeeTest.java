package softeng.aueb.restaurant.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void getEmail() {
        Employee e = new Employee("odycaptain@gmail.com", "123","ody","chef");
        assertEquals("odycaptain@gmail.com",e.getEmail());
    }

    @Test
    void setEmail() {
        Employee e = new Employee("odycaptain@gmail.com", "123","ody","chef");
        e.setEmail("odycaptain@gmail2.com");
        assertEquals("odycaptain@gmail2.com",e.getEmail());

    }

    @Test
    void getPassword() {
        Employee e = new Employee("odycaptain@gmail.com", "123","ody","chef");
        assertEquals("123",e.getPassword());
    }

    @Test
    void setPassword() {
        Employee e = new Employee("odycaptain@gmail.com", "123","ody","chef");
        e.setPassword("1234");
        assertEquals("1234",e.getPassword());
    }
}