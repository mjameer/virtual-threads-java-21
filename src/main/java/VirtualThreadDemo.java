import java.util.function.IntFunction;
import java.util.stream.IntStream;

public class VirtualThreadDemo {

    public static void main(String[] args) throws InterruptedException {


        var start = System.currentTimeMillis();
        var totalThread = 10000;

        IntFunction<Object> objectIntFunctionPlatformThread = thCount -> Thread.ofPlatform().unstarted(() -> {  });
        IntFunction<Object> objectIntFunctionVirtualThread = thCount -> Thread.ofVirtual().unstarted(() -> {  });

        System.out.println(callThread(totalThread, objectIntFunctionPlatformThread, start));
        System.out.println(callThread(totalThread, objectIntFunctionVirtualThread, start));

    }

    private static String callThread(int totalThread, IntFunction<Object> objectIntFunctionVirtualThread, long start) throws InterruptedException {
        var threads = IntStream.range(0, totalThread)
                .mapToObj(
                        objectIntFunctionVirtualThread).toList();
        threads.forEach(Thread::start);
        for (Thread thread : threads) {
            thread.join();
        }
        var end = System.currentTimeMillis();
        return "Millis used to launch " + totalThread + " threads:" + (end - start) + "ms";
    }
}
