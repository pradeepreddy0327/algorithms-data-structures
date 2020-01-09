package stocks.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class StockProfileDTO {

    // "price" : 265.54,
    private double price;
    // "beta" : "1.139593",
    private double beta;
    // "volAvg" : "36724977",
    private double volAvg;
    // "mktCap" : "1226219640360.00",
    private double mktCap;
    // "lastDiv" : "2.92",
    private double lastDiv;
    // "range" : "142-233.47",
    private String range;
    // "changes" : -0.1,
    private double changes;
    // "changesPercentage" : "(-0.04%)",
    private String changesPercentage;
    // "companyName" : "Apple Inc.",
    private String companyName;
    // "exchange" : "Nasdaq Global Select",
    private String exchange;
    // "industry" : "Computer Hardware",
    private String industry;
    // "website" : "http://www.apple.com",
    private String website;
    private String description;
    // "ceo" : "Timothy D. Cook",
    private String ceo;
    // "sector" : "Technology",
    private String sector;
    // "image" : "https://financialmodelingprep.com/images-New-jpg/AAPL.jpg"
    private String image;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getBeta() {
        return beta;
    }

    public void setBeta(double beta) {
        this.beta = beta;
    }

    public double getVolAvg() {
        return volAvg;
    }

    public void setVolAvg(double volAvg) {
        this.volAvg = volAvg;
    }

    public double getMktCap() {
        return mktCap;
    }

    public void setMktCap(double mktCap) {
        this.mktCap = mktCap;
    }

    public double getLastDiv() {
        return lastDiv;
    }

    public void setLastDiv(double lastDiv) {
        this.lastDiv = lastDiv;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public double getChanges() {
        return changes;
    }

    public void setChanges(double changes) {
        this.changes = changes;
    }

    public String getChangesPercentage() {
        return changesPercentage;
    }

    public void setChangesPercentage(String changesPercentage) {
        this.changesPercentage = changesPercentage;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCeo() {
        return ceo;
    }

    public void setCeo(String ceo) {
        this.ceo = ceo;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
