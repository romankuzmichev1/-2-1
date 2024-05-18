import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberProcessor {
    public NumberProcessor() {
    }

    public static void main(String[] args) {
        Scanner consoleScanner = new Scanner(System.in);
        System.out.println("Введите имя файла:");
        String fileName = consoleScanner.nextLine();

        try {
            List<Integer> numbers = readNumbersFromFile(fileName);

            if (numbers != null) {
                System.out.println("Минимальное: " + _min(numbers));
                System.out.println("Максимальное: " + _max(numbers));
                System.out.println("Сумма: " + _sum(numbers));
                System.out.println("Произведение: " + _mult(numbers));
            } else {
                System.out.println("Файл содержит некорректные данные.");
            }
        } catch (IOException var2) {
            System.out.println("Ошибка при чтении файла: " + var2.getMessage());
        }
    }

    public static List<Integer> readNumbersFromFile(String filePath) throws FileNotFoundException {
        List<Integer> numbers = new ArrayList<>();
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);

        try {
            while (scanner.hasNext()) {
                if (!scanner.hasNextInt()) {
                    System.err.println("Файл содержит некорректные данные.");
                    return null;
                }
                numbers.add(scanner.nextInt());
            }
        } catch (Throwable var7) {
            try {
                scanner.close();
            } catch (Throwable var6) {
                var7.addSuppressed(var6);
            }
            throw var7;
        }

        scanner.close();
        return numbers;
    }

    public static int _min(List<Integer> numbers) {
        return numbers.stream().min(Integer::compare).orElseThrow();
    }

    public static int _max(List<Integer> numbers) {
        return numbers.stream().max(Integer::compare).orElseThrow();
    }

    public static int _sum(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }

    public static int _mult(List<Integer> numbers) {
        return numbers.stream().reduce(1, (a, b) -> a * b);
    }
}
