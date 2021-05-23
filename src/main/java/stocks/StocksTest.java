package stocks;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.opencsv.CSVReader;

import com.opencsv.exceptions.CsvValidationException;
import stocks.dto.BalanceSheetDTO;
import stocks.dto.ResultDTO;
import stocks.dto.StockDTO;

public class StocksTest {
    // https://financialmodelingprep.com/api/v3/company/profile/AAPL
    // https://financialmodelingprep.com/api/v3/financials/balance-sheet-statement/AAPL?period=quarter
    static final Integer BILLION = 1000000000;

    public static void main(String[] args) throws IOException, CsvValidationException {

        RestClient rc = new RestClient();

        List<String> stocks = readFile();

        List<ResultDTO> results = new ArrayList<>();
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
        printResults(results);
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

    public static List<String> readFile() throws IOException, CsvValidationException {
        File csvFile = new File(
                "/Users/pmuchchanthula/Desktop/Stocks_Data/companylist.csv");
        CSVReader br = new CSVReader(new FileReader(csvFile));
        List<String> l = new ArrayList<>();
        br.readNext();
        String[] row = br.readNext();
        int c = 0;
        while (row != null && c < 100) {
            l.add(row[0]);
            row = br.readNext();
        }
        return l;
    }

}
