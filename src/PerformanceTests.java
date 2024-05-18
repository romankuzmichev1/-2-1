import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class PerformanceTests {
    public PerformanceTests() {
    }

    @Test
    public void performanceTestNumberTxt() throws IOException {
        List<Integer> numbers = NumberProcessor.readNumbersFromFile("src/test/resources/number.txt");

        assertNotNull(numbers);
        assertEquals(1, NumberProcessor._min(numbers));
        assertEquals(5, NumberProcessor._max(numbers));
        assertEquals(15, NumberProcessor._sum(numbers));
        assertEquals(120, NumberProcessor._mult(numbers));
    }

    @Test
    public void performanceTestNumbersTxt() throws IOException {
        List<Integer> numbers = NumberProcessor.readNumbersFromFile("src/test/resources/numbers.txt");

        assertNotNull(numbers);
        assertEquals(1, NumberProcessor._min(numbers));
        assertEquals(100, NumberProcessor._max(numbers));
        assertEquals(5050, NumberProcessor._sum(numbers));
        // Проверка на положительное произведение, так как реальное значение очень велико.
        assertTrue(NumberProcessor._mult(numbers) > 0);
    }
}
