package softeng.aueb.restaurant.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class OwnerTest {

    @Test
    void getUsername() {
        Owner o = new Owner("o","odycaptain@gmail.com","123",4);
        assertEquals("o",o.getUsername());

    }

    @Test
    void setUsername() {
        Owner o = new Owner("o","odycaptain@gmail.com","123",4);
        o.setUsername("e");
        assertEquals("e",o.getUsername());
    }

    @Test
    void getEmail() {
        Owner o = new Owner("o","odycaptain@gmail.com","123",4);
        assertEquals("odycaptain@gmail.com",o.getEmail());
    }

    @Test
    void setEmail() {
        Owner o = new Owner("o","odycaptain@gmail.com","123",4);
        o.setEmail("odycaptain2@gmail.com");
        assertEquals("odycaptain2@gmail.com",o.getEmail());
    }

    @Test
    void getPassword() {
        Owner o = new Owner("o","odycaptain@gmail.com","123",4);
        assertEquals("123",o.getPassword());
    }

    @Test
    void setPassword() {
        Owner o = new Owner("o","odycaptain@gmail.com","123",4);
        o.setPassword("1234");
        assertEquals("1234",o.getPassword());
    }

    @Test
    void getNumberofTables() {
        Owner o = new Owner("o","odycaptain@gmail.com","123",4);
        assertEquals(4,o.getNumberofTables());
    }

    @Test
    void setNumberofTables() {
        Owner o = new Owner("o","odycaptain@gmail.com","123",4);
        o.setNumberofTables(5);
        assertEquals(5,o.getNumberofTables());
    }

}