package WavesMashup.remote.views;

import WavesMashup.service.dtos.WavesInterestDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PyWavesInterestView {

  @JsonProperty(value = "last")
  private double latest;

  @JsonProperty(value = "3d")
  private double threeDayAvg;

  @JsonProperty(value = "7d")
  private double sevenDayAvg;

  @JsonProperty(value = "30d")
  private double thirtyDayAvg;

  @JsonProperty(value = "60d")
  private double sixtyDayAvg;

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

  public WavesInterestDto toWavesInteresDto(String asset) {
    WavesInterestDto wavesInterestDto = new WavesInterestDto();

    wavesInterestDto.setAsset(asset);
    wavesInterestDto.setLatest(this.latest);
    wavesInterestDto.setThreeDayAvg(this.threeDayAvg);
    wavesInterestDto.setSevenDayAvg(this.sevenDayAvg);
    wavesInterestDto.setThirtyDayAvg(this.thirtyDayAvg);
    wavesInterestDto.setSixtyDayAvg(this.sixtyDayAvg);

    return wavesInterestDto;
  }
}
