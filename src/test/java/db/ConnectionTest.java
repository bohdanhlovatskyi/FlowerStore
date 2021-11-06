package db;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConnectionTest {

    Connection c1, c2;

    @BeforeEach
    void setUp() {
        this.c1 = Connection.getConnection();
        this.c2 = Connection.getConnection();
    }

    @Test
    void getConnection() {
        assertEquals(c1, c2);
    }
}