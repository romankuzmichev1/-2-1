import org.junit.jupiter.api.Test;
public class ErrorHandlingTest {
    @Test
    public void testWithErrorInFile() {
        Assertions.assertThrows(IOException.class, () -> {
            NumberProcessor.readNumbersFromFile("path_to_error_file.txt");
        });
    }
}
