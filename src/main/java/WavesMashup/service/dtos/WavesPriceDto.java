package WavesMashup.service.dtos;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

public class WavesPriceDto {
  private double price;
  private LocalDate dateOfPrice;
  private Double movingAverage7Day;
  private Double movingAverage180Day;
  private Double sharpeRatio;

  public WavesPriceDto(long dateInMillis, double price) {
    this.price = price;
    this.dateOfPrice = Instant.ofEpochMilli(dateInMillis).atZone(ZoneId.systemDefault()).toLocalDate();
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public LocalDate getDateOfPrice() {
    return dateOfPrice;
  }

  public void setDateOfPrice(LocalDate dateOfPrice) {
    this.dateOfPrice = dateOfPrice;
  }

  public Double getMovingAverage7Day() {
    return movingAverage7Day;
  }

  public void setMovingAverage7Day(Double movingAverage7Day) {
    this.movingAverage7Day = movingAverage7Day;
  }

  public Double getMovingAverage180Day() {
    return movingAverage180Day;
  }

  public void setMovingAverage180Day(Double movingAverage180Day) {
    this.movingAverage180Day = movingAverage180Day;
  }

  public Double getSharpeRatio() {
    return sharpeRatio;
  }

  public void setSharpeRatio(Double sharpeRatio) {
    this.sharpeRatio = sharpeRatio;
  }
}
