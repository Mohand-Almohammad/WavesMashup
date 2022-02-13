package WavesMashup.remote.views;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WavePriceView {

  private String id;
  private String name;
  private String shortcode;
  private long totalSupply;
  private int precision;
  private long trades;

  private WavePriceDataView data;

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

  public String getShortcode() {
    return shortcode;
  }

  public void setShortcode(String shortcode) {
    this.shortcode = shortcode;
  }

  public long getTotalSupply() {
    return totalSupply;
  }

  public void setTotalSupply(long totalSupply) {
    this.totalSupply = totalSupply;
  }

  public int getPrecision() {
    return precision;
  }

  public void setPrecision(int precision) {
    this.precision = precision;
  }

  public long getTrades() {
    return trades;
  }

  public void setTrades(long trades) {
    this.trades = trades;
  }

  public WavePriceDataView getData() {
    return data;
  }

  public void setData(WavePriceDataView data) {
    this.data = data;
  }
}
