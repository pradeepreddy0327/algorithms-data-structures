package stocks.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class StockDTO {

    private String symbol;
    private StockProfileDTO profile;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public StockProfileDTO getProfile() {
        return profile;
    }

    public void setProfile(StockProfileDTO profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
