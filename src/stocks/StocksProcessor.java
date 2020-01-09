package stocks;

import java.util.Collections;
import java.util.List;

import stocks.dto.ResultDTO;

public class StocksProcessor {

    private static final int totalStocks = 3565;
    private static final int threadSize = 50;

    public static void main(String[] args) throws Exception {
        int numberOfThreads = (int) Math
                .ceil((double) totalStocks / threadSize);
        for (int i = 0; i < numberOfThreads; i++) {
            StocksThread t = new StocksThread(threadSize * i,
                    threadSize * (i + 1));
            t.run();
        }
        while (StocksThread.completedThreads < numberOfThreads) {
            System.out.println(
                    "Completed Threads : "
                    + StocksThread.completedThreads);
            Thread.sleep(30000);
        }
        printResults(StocksThread.results);
    }

    private static void printResults(List<ResultDTO> results) {
        Collections.sort(results, (a, b) -> {
            if (a.getIndex() > b.getIndex()) {
                return -1;
            }
            if (a.getIndex() < b.getIndex()) {
                return 1;
            }
            return 0;
        });
        for (ResultDTO resultDTO : results) {
            System.out.println(resultDTO.toString());
        }
    }

}
