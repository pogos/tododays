package pl.pogos.stock.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "SESSION_VALUE")
public class SessionValue {

    @Id
    @GeneratedValue(generator = "VALUE_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "VALUE_SEQ", sequenceName = "VALUE_SEQ")
    private Long id;

    private Date timestamp;
    private Date providerTimestamp;

    @NotNull
    @Column(name = "NAME", nullable = false)
    private String name;
    private String symbol;
    private Double stockRate;
    private Double stockRateDiff;
    private Double stockRateDiffPercent;
    private Double minStockRate;
    private Double maxStockRate;
    private Double tradingVolume;
    private Double tradingValue;

    public SessionValue() {
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

    public Date getProviderTimestamp() {
        return providerTimestamp;
    }

    public void setProviderTimestamp(Date providerTimestamp) {
        this.providerTimestamp = providerTimestamp;
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
}
