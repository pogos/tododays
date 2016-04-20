package pl.pogos.stock.dto;

import java.util.Date;

public class ValueDTO {

    private Long id;

    private Date timestamp;
    private Date providerTimestamp;
    private String name;
    private String symbol;
    private Double stockRate;
    private Double stockRateDiff;
    private Double stockRateDiffPercent;
    private Double minStockRate;
    private Double maxStockRate;
    private Double tradingVolume;
    private Double tradingValue;

    public ValueDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Double getStockRate() {
        return stockRate;
    }

    public void setStockRate(Double stockRate) {
        this.stockRate = stockRate;
    }

    public Double getStockRateDiff() {
        return stockRateDiff;
    }

    public void setStockRateDiff(Double stockRateDiff) {
        this.stockRateDiff = stockRateDiff;
    }

    public Double getStockRateDiffPercent() {
        return stockRateDiffPercent;
    }

    public void setStockRateDiffPercent(Double stockRateDiffPercent) {
        this.stockRateDiffPercent = stockRateDiffPercent;
    }

    public Double getMinStockRate() {
        return minStockRate;
    }

    public void setMinStockRate(Double minStockRate) {
        this.minStockRate = minStockRate;
    }

    public Double getMaxStockRate() {
        return maxStockRate;
    }

    public void setMaxStockRate(Double maxStockRate) {
        this.maxStockRate = maxStockRate;
    }

    public Double getTradingVolume() {
        return tradingVolume;
    }

    public void setTradingVolume(Double tradingVolume) {
        this.tradingVolume = tradingVolume;
    }

    public Double getTradingValue() {
        return tradingValue;
    }

    public void setTradingValue(Double tradingValue) {
        this.tradingValue = tradingValue;
    }

    public Date getProviderTimestamp() {
        return providerTimestamp;
    }

    public void setProviderTimestamp(Date providerTimestamp) {
        this.providerTimestamp = providerTimestamp;
    }

    @Override
    public String toString() {
        return "ValueDTO{" +
                "id=" + id +
                ", timestamp=" + timestamp +
                ", providerTimestamp=" + providerTimestamp +
                ", name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                ", stockRate=" + stockRate +
                ", stockRateDiff=" + stockRateDiff +
                ", stockRateDiffPercent=" + stockRateDiffPercent +
                ", minStockRate=" + minStockRate +
                ", maxStockRate=" + maxStockRate +
                ", tradingVolume=" + tradingVolume +
                ", tradingValue=" + tradingValue +
                '}';
    }
}
