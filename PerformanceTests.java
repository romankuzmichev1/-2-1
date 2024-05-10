import org.junit.jupiter.api.Test;
public class PerformanceTests {
    @Test
    public void performanceTest() throws IOException {
        List<Integer> largeList = new Random().ints(1_000_000, 1, 100).boxed().collect(Collectors.toList());
        long startTime, endTime;
        startTime = System.currentTimeMillis();
        NumberProcessor._min(largeList);
        endTime = System.currentTimeMillis();
        System.out.println("Время выполнения _min: " + (endTime - startTime) + "ms");
        startTime = System.currentTimeMillis();
        NumberProcessor._max(largeList);
        endTime = System.currentTimeMillis();
        System.out.println("Время выполнения _max: " + (endTime - startTime) + "ms");
        startTime = System.currentTimeMillis();
        NumberProcessor._sum(largeList);
        endTime = System.currentTimeMillis();
        System.out.println("Время выполнения _sum: " + (endTime - startTime) + "ms");
        startTime = System.currentTimeMillis();
        NumberProcessor._mult(largeList);
        endTime = System.currentTimeMillis();
        System.out.println("Время выполнения _mult: " + (endTime - startTime) + "ms");
    }
}
