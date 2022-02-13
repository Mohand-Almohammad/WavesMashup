package WavesMashup.service.dtos;

public class WavesInterestDto {

  private String asset;
  private double latest;
  private double threeDayAvg;
  private double sevenDayAvg;
  private double thirtyDayAvg;
  private double sixtyDayAvg;

  public String getAsset() {
    return asset;
  }

  public void setAsset(String asset) {
    this.asset = asset;
  }

  public double getLatest() {
    return latest;
  }

  public void setLatest(double latest) {
    this.latest = latest;
  }

  public double getThreeDayAvg() {
    return threeDayAvg;
  }

  public void setThreeDayAvg(double threeDayAvg) {
    this.threeDayAvg = threeDayAvg;
  }

  public double getSevenDayAvg() {
    return sevenDayAvg;
  }

  public void setSevenDayAvg(double sevenDayAvg) {
    this.sevenDayAvg = sevenDayAvg;
  }

  public double getThirtyDayAvg() {
    return thirtyDayAvg;
  }

  public void setThirtyDayAvg(double thirtyDayAvg) {
    this.thirtyDayAvg = thirtyDayAvg;
  }

  public double getSixtyDayAvg() {
    return sixtyDayAvg;
  }

  public void setSixtyDayAvg(double sixtyDayAvg) {
    this.sixtyDayAvg = sixtyDayAvg;
  }
}
