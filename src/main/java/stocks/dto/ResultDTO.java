package stocks.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class ResultDTO {

    private String symbol;
    private double mkB;
    private double eqB;
    private double index;

    public ResultDTO(String symbol, double mkB, double eqB, double index) {
        super();
        this.symbol = symbol;
        this.mkB = mkB;
        this.eqB = eqB;
        this.index = index;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getMkB() {
        return mkB;
    }

    public void setMkB(double mkB) {
        this.mkB = mkB;
    }

    public double getEqB() {
        return eqB;
    }

    public void setEqB(double eqB) {
        this.eqB = eqB;
    }

    public double getIndex() {
        return index;
    }

    public void setIndex(double index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
