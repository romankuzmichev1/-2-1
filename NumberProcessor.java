import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
public class NumberProcessor {
    public static void main(String[] args) {
        try {
            List<Integer> numbers = readNumbersFromFile("number.txt");
            assert numbers != null;
            System.out.println("Минимальное: " + _min(numbers));
            System.out.println("Максимальное: " + _max(numbers));
            System.out.println("Сумма: " + _sum(numbers));
            System.out.println("Произведение: " + _mult(numbers));
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
    public static List<Integer> readNumbersFromFile(String filePath) throws FileNotFoundException {
        List<Integer> numbers = new ArrayList<>();
        File file = new File(filePath);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    numbers.add(scanner.nextInt());
                } else {
                    System.err.println("Файл содержит некорректные данные.");
                    return null;
                }
            }
        }
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
