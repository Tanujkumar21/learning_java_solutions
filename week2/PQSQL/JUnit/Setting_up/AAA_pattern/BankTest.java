import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class BankTest {

    private double balance;

    @Before
    public void setUp() {
        // Arrange: Initialize test data
        balance = 5000.0;
        System.out.println("Before each test");
    }

    @After
    public void tearDown() {
        // Cleanup if needed
        System.out.println("After each test");
    }

    @Test
    public void testWithdraw() {
        // Arrange done in @Before

        // Act
        double withdrawAmount = 1000.0;
        balance = balance - withdrawAmount;

        // Assert
        assertEquals(4000.0, balance, 0.01);
    }

    @Test
    public void testDeposit() {
        // Act
        double depositAmount = 2000.0;
        balance = balance + depositAmount;

        // Assert
        assertEquals(7000.0, balance, 0.01);
    }
}
