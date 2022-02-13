package WavesMashup.model;

import lombok.Data;

@Data
public class Waves {

    private String id;
    private String name;
    private String shortCode;
    private int totalSupply;
    private int precision;
    private int trades;

    public Waves(String id, String name, String shortCode, int totalSupply, int precision, int trades) {
        this.id = id;
        this.name = name;
        this.shortCode = shortCode;
        this.totalSupply = totalSupply;
        this.precision = precision;
        this.trades = trades;
    }

    public Waves() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public int getTotalSupply() {
        return totalSupply;
    }

    public void setTotalSupply(int totalSupply) {
        this.totalSupply = totalSupply;
    }

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }

    public int getTrades() {
        return trades;
    }

    public void setTrades(int trades) {
        this.trades = trades;
    }
}
