package stocks;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

import stocks.dto.BalanceSheetDTO;
import stocks.dto.ResultDTO;
import stocks.dto.StockDTO;

public class StocksThread implements Runnable {

    static final Integer BILLION = 1000000000;
    static List<ResultDTO> results = new ArrayList<>();
    static int completedThreads = 0;
    private int start;
    private int end;

    public StocksThread(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        try {
            RestClient rc = new RestClient();
            List<String> stocks = readFile();
            for (String s : stocks) {
                try {
                    BalanceSheetDTO balSheetDTO = rc.getBalanceSheet(s);
                    StockDTO proflieDTO = rc.getProfile(s);
                    double mkB = proflieDTO.getProfile().getMktCap() / BILLION;
                    double eqB = balSheetDTO.getFinancials().get(0)
                            .getTaoatlShareHoldersEquity() / BILLION;
                    if (mkB > 0.2 && eqB / mkB > 0.75) {
                        results.add(new ResultDTO(s, mkB, eqB, eqB / mkB));
                    }
                } catch (Exception e) {
                    // e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            completedThreads++;
        }
    }

    public List<String> readFile() throws IOException {
        File csvFile = new File(
                "/Users/pmuchchanthula/Desktop/Stocks_Data/companylist.csv");
        CSVReader br = new CSVReader(new FileReader(csvFile));
        List<String> l = new ArrayList<>();
        br.readNext();
        String[] row = br.readNext();
        int c = 0;
        while (row != null && c < end) {
            if (c >= start) {
                l.add(row[0]);
            }
            row = br.readNext();
            c++;
        }
        return l;
    }

}
