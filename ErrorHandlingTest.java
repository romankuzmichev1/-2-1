import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class ErrorHandlingTest {
    @Test
    public void testWithErrorInFile() {
        Assertions.assertThrows(IOException.class, () -> {
            NumberProcessor.readNumbersFromFile("path_to_error_file.txt");
        });
    }
}
