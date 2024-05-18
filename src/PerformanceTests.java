import org.junit.Test;
import java.io.IOException;
import java.util.List;
import java.math.BigInteger;
import static org.junit.Assert.*;

public class PerformanceTests {
    public PerformanceTests() {
    }

    @Test
    public void performanceTestNumberTxt() throws IOException {
        List<Integer> numbers = NumberProcessor.readNumbersFromFile("number.txt");

        assertNotNull(numbers);
        assertEquals(1, NumberProcessor._min(numbers));
        assertEquals(5, NumberProcessor._max(numbers));
        assertEquals(15, NumberProcessor._sum(numbers));
        assertEquals(BigInteger.valueOf(120), NumberProcessor._mult(numbers));
    }

    @Test
    public void performanceTestNumbersTxt() throws IOException {
        List<Integer> numbers = NumberProcessor.readNumbersFromFile("numbers.txt");

        assertNotNull(numbers);
        assertEquals(1, NumberProcessor._min(numbers));
        assertEquals(100, NumberProcessor._max(numbers));
        assertEquals(5050, NumberProcessor._sum(numbers));
        // Проверка на положительное произведение, так как реальное значение очень велико.
        assertTrue(NumberProcessor._mult(numbers).compareTo(BigInteger.ZERO) > 0);
    }
}
