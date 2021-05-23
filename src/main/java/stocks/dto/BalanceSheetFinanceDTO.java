package stocks.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.google.gson.annotations.SerializedName;

public class BalanceSheetFinanceDTO {

    // "date" : "2019-09-28",
    @SerializedName("date")
    private String date;

    // "Cash and cash equivalents" : "48844000000.0",
    @SerializedName("Cash and cash equivalents")
    private String cashEquivalents;

    // "Short-term investments" : "51713000000.0",
    @SerializedName("Short-term investments")
    private String shortTermInvestiments;

    // "Cash and short-term investments" : "100557000000.0",
    @SerializedName("Cash and short-term investments")
    private String cashAndShortTermInvestiments;

    // "Receivables" : "45804000000.0",
    @SerializedName("Receivables")
    private String receivables;

    // "Inventories" : "4106000000.0",
    @SerializedName("Inventories")
    private String inventories;

    // "Total current assets" : "162819000000.0",
    @SerializedName("Total current assets")
    private String totlaCurrentAssets;

    // "Property, Plant & Equipment Net" : "37378000000.0",
    @SerializedName("Property, Plant & Equipment Net")
    private String propertyPlantEquipmentNet;

    // "Goodwill and Intangible Assets" : "0.0",
    @SerializedName("Goodwill and Intangible Assets")
    private String goodwillAndIntangibleAssets;

    // "Long-term investments" : "105341000000.0",
    @SerializedName("Long-term investments")
    private String longTermInvestiments;

    // "Tax assets" : "0.0",
    @SerializedName("Tax assets")
    private String taxAssets;

    // "Total non-current assets" : "175697000000.0"
    @SerializedName("Total non-current assets")
    private String totalNonCurrentAssets;

    // "Total assets" : "338516000000.0",
    @SerializedName("Total assets")
    private String totalAssets;

    // "Payables" : "46236000000.0",
    @SerializedName("Payables")
    private String payables;

    // "Short-term debt" : "16240000000.0"
    @SerializedName("Short-term debt")
    private String shortTermDebt;

    // "Total current liabilities" : "105718000000.0",
    @SerializedName("Total current liabilities")
    private String totalCurrentLiabilities;

    // "Long-term debt" : "91807000000.0",
    @SerializedName("Long-term debt")
    private String longTermDebt;

    // "Total debt" : "108047000000.0",
    @SerializedName("otal debt")
    private String totalDebt;

    // "Deferred revenue" : "5522000000.0",
    @SerializedName("Deferred revenue")
    private String deferredRevenue;

    // "Tax Liabilities" : "0.0",
    @SerializedName("Tax Liabilities")
    private String taxLiabilities;

    // "Deposit Liabilities" : "0.0",
    @SerializedName("Deposit Liabilities")
    private String depositLiabilities;

    // "Total non-current liabilities" : "142310000000.0",
    @SerializedName("Total non-current liabilities")
    private String totalNonCurrentLiabilities;

    // "Total liabilities" : "248028000000.0",
    @SerializedName("Total liabilities")
    private String totalLiabilities;

    // "Other comprehensive income" : "-584000000.0",
    @SerializedName("Other comprehensive income")
    private String otherComprehensiveIncome;

    // "Retained earnings (deficit)" : "45898000000.0",
    @SerializedName("Retained earnings (deficit)")
    private String reatinedEarnings;

    // "Total shareholders equity" : "90488000000.0",
    @SerializedName("Total shareholders equity")
    private Double taoatlShareHoldersEquity;

    // "Investments" : "157054000000.0",
    @SerializedName("Investments")
    private String investments;

    // "Net Debt" : "7490000000.0",
    @SerializedName("Net Debt")
    private String netDebt;

    // "Other Assets" : "12352000000.0",
    @SerializedName("Other Assets")
    private String otherAssets;

    // "Other Liabilities" : "43242000000.0"
    @SerializedName("Other Liabilities")
    private String otherLiabilities;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCashEquivalents() {
        return cashEquivalents;
    }

    public void setCashEquivalents(String cashEquivalents) {
        this.cashEquivalents = cashEquivalents;
    }

    public String getShortTermInvestiments() {
        return shortTermInvestiments;
    }

    public void setShortTermInvestiments(String shortTermInvestiments) {
        this.shortTermInvestiments = shortTermInvestiments;
    }

    public String getCashAndShortTermInvestiments() {
        return cashAndShortTermInvestiments;
    }

    public void setCashAndShortTermInvestiments(
            String cashAndShortTermInvestiments) {
        this.cashAndShortTermInvestiments = cashAndShortTermInvestiments;
    }

    public String getReceivables() {
        return receivables;
    }

    public void setReceivables(String receivables) {
        this.receivables = receivables;
    }

    public String getInventories() {
        return inventories;
    }

    public void setInventories(String inventories) {
        this.inventories = inventories;
    }

    public String getTotlaCurrentAssets() {
        return totlaCurrentAssets;
    }

    public void setTotlaCurrentAssets(String totlaCurrentAssets) {
        this.totlaCurrentAssets = totlaCurrentAssets;
    }

    public String getPropertyPlantEquipmentNet() {
        return propertyPlantEquipmentNet;
    }

    public void setPropertyPlantEquipmentNet(String propertyPlantEquipmentNet) {
        this.propertyPlantEquipmentNet = propertyPlantEquipmentNet;
    }

    public String getGoodwillAndIntangibleAssets() {
        return goodwillAndIntangibleAssets;
    }

    public void setGoodwillAndIntangibleAssets(
            String goodwillAndIntangibleAssets) {
        this.goodwillAndIntangibleAssets = goodwillAndIntangibleAssets;
    }

    public String getLongTermInvestiments() {
        return longTermInvestiments;
    }

    public void setLongTermInvestiments(String longTermInvestiments) {
        this.longTermInvestiments = longTermInvestiments;
    }

    public String getTaxAssets() {
        return taxAssets;
    }

    public void setTaxAssets(String taxAssets) {
        this.taxAssets = taxAssets;
    }

    public String getTotalNonCurrentAssets() {
        return totalNonCurrentAssets;
    }

    public void setTotalNonCurrentAssets(String totalNonCurrentAssets) {
        this.totalNonCurrentAssets = totalNonCurrentAssets;
    }

    public String getTotalAssets() {
        return totalAssets;
    }

    public void setTotalAssets(String totalAssets) {
        this.totalAssets = totalAssets;
    }

    public String getPayables() {
        return payables;
    }

    public void setPayables(String payables) {
        this.payables = payables;
    }

    public String getShortTermDebt() {
        return shortTermDebt;
    }

    public void setShortTermDebt(String shortTermDebt) {
        this.shortTermDebt = shortTermDebt;
    }

    public String getTotalCurrentLiabilities() {
        return totalCurrentLiabilities;
    }

    public void setTotalCurrentLiabilities(String totalCurrentLiabilities) {
        this.totalCurrentLiabilities = totalCurrentLiabilities;
    }

    public String getLongTermDebt() {
        return longTermDebt;
    }

    public void setLongTermDebt(String longTermDebt) {
        this.longTermDebt = longTermDebt;
    }

    public String getTotalDebt() {
        return totalDebt;
    }

    public void setTotalDebt(String totalDebt) {
        this.totalDebt = totalDebt;
    }

    public String getDeferredRevenue() {
        return deferredRevenue;
    }

    public void setDeferredRevenue(String deferredRevenue) {
        this.deferredRevenue = deferredRevenue;
    }

    public String getTaxLiabilities() {
        return taxLiabilities;
    }

    public void setTaxLiabilities(String taxLiabilities) {
        this.taxLiabilities = taxLiabilities;
    }

    public String getDepositLiabilities() {
        return depositLiabilities;
    }

    public void setDepositLiabilities(String depositLiabilities) {
        this.depositLiabilities = depositLiabilities;
    }

    public String getTotalNonCurrentLiabilities() {
        return totalNonCurrentLiabilities;
    }

    public void setTotalNonCurrentLiabilities(
            String totalNonCurrentLiabilities) {
        this.totalNonCurrentLiabilities = totalNonCurrentLiabilities;
    }

    public String getTotalLiabilities() {
        return totalLiabilities;
    }

    public void setTotalLiabilities(String totalLiabilities) {
        this.totalLiabilities = totalLiabilities;
    }

    public String getOtherComprehensiveIncome() {
        return otherComprehensiveIncome;
    }

    public void setOtherComprehensiveIncome(String otherComprehensiveIncome) {
        this.otherComprehensiveIncome = otherComprehensiveIncome;
    }

    public String getReatinedEarnings() {
        return reatinedEarnings;
    }

    public void setReatinedEarnings(String reatinedEarnings) {
        this.reatinedEarnings = reatinedEarnings;
    }

    public Double getTaoatlShareHoldersEquity() {
        return taoatlShareHoldersEquity;
    }

    public void setTaoatlShareHoldersEquity(Double taoatlShareHoldersEquity) {
        this.taoatlShareHoldersEquity = taoatlShareHoldersEquity;
    }

    public String getInvestments() {
        return investments;
    }

    public void setInvestments(String investments) {
        this.investments = investments;
    }

    public String getNetDebt() {
        return netDebt;
    }

    public void setNetDebt(String netDebt) {
        this.netDebt = netDebt;
    }

    public String getOtherAssets() {
        return otherAssets;
    }

    public void setOtherAssets(String otherAssets) {
        this.otherAssets = otherAssets;
    }

    public String getOtherLiabilities() {
        return otherLiabilities;
    }

    public void setOtherLiabilities(String otherLiabilities) {
        this.otherLiabilities = otherLiabilities;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

}
