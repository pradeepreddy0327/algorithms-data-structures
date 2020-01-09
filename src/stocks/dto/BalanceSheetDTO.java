package stocks.dto;

import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class BalanceSheetDTO {

    private String symbol;

    private List<BalanceSheetFinanceDTO> financials;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public List<BalanceSheetFinanceDTO> getFinancials() {
        return financials;
    }

    public void setFinancials(List<BalanceSheetFinanceDTO> financials) {
        this.financials = financials;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
