package WavesMashup.remote.views;

import WavesMashup.service.dtos.WavesInterestDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PyWavesInterestOverview {

  @JsonProperty(value = "nsbt-apy")
  private PyWavesInterestView nsbt;

  @JsonProperty(value = "usdt-apy")
  private PyWavesInterestView usdt;

  @JsonProperty(value = "usdc-apy")
  private PyWavesInterestView usdc;

  @JsonProperty(value = "btc-apy")
  private PyWavesInterestView btc;

  @JsonProperty(value = "eth-apy")
  private PyWavesInterestView eth;

  @JsonProperty(value = "usdn-apy")
  private PyWavesInterestView usdn;

  @JsonProperty(value = "eurn-apy")
  private PyWavesInterestView eurn;

  @JsonProperty(value = "uahn-apy")
  private PyWavesInterestView uahn;

  @JsonProperty(value = "rubn-apy")
  private PyWavesInterestView rubn;

  @JsonProperty(value = "cnyn-apy")
  private PyWavesInterestView cnyn;

  @JsonProperty(value = "jpyn-apy")
  private PyWavesInterestView jpyn;

  @JsonProperty(value = "brln-apy")
  private PyWavesInterestView brln;

  @JsonProperty(value = "gbpn-apy")
  private PyWavesInterestView gbpn;

  @JsonProperty(value = "tryn-apy")
  private PyWavesInterestView tryn;

  public PyWavesInterestView getNsbt() {
    return nsbt;
  }

  public void setNsbt(PyWavesInterestView nsbt) {
    this.nsbt = nsbt;
  }

  public PyWavesInterestView getUsdt() {
    return usdt;
  }

  public void setUsdt(PyWavesInterestView usdt) {
    this.usdt = usdt;
  }

  public PyWavesInterestView getUsdc() {
    return usdc;
  }

  public void setUsdc(PyWavesInterestView usdc) {
    this.usdc = usdc;
  }

  public PyWavesInterestView getBtc() {
    return btc;
  }

  public void setBtc(PyWavesInterestView btc) {
    this.btc = btc;
  }

  public PyWavesInterestView getEth() {
    return eth;
  }

  public void setEth(PyWavesInterestView eth) {
    this.eth = eth;
  }

  public PyWavesInterestView getUsdn() {
    return usdn;
  }

  public void setUsdn(PyWavesInterestView usdn) {
    this.usdn = usdn;
  }

  public PyWavesInterestView getEurn() {
    return eurn;
  }

  public void setEurn(PyWavesInterestView eurn) {
    this.eurn = eurn;
  }

  public PyWavesInterestView getUahn() {
    return uahn;
  }

  public void setUahn(PyWavesInterestView uahn) {
    this.uahn = uahn;
  }

  public PyWavesInterestView getRubn() {
    return rubn;
  }

  public void setRubn(PyWavesInterestView rubn) {
    this.rubn = rubn;
  }

  public PyWavesInterestView getCnyn() {
    return cnyn;
  }

  public void setCnyn(PyWavesInterestView cnyn) {
    this.cnyn = cnyn;
  }

  public PyWavesInterestView getJpyn() {
    return jpyn;
  }

  public void setJpyn(PyWavesInterestView jpyn) {
    this.jpyn = jpyn;
  }

  public PyWavesInterestView getBrln() {
    return brln;
  }

  public void setBrln(PyWavesInterestView brln) {
    this.brln = brln;
  }

  public PyWavesInterestView getGbpn() {
    return gbpn;
  }

  public void setGbpn(PyWavesInterestView gbpn) {
    this.gbpn = gbpn;
  }

  public PyWavesInterestView getTryn() {
    return tryn;
  }

  public void setTryn(PyWavesInterestView tryn) {
    this.tryn = tryn;
  }

  public List<WavesInterestDto> toWavesInterestDtoList() {
    List<WavesInterestDto> wavesInterestDtos = new ArrayList<>();

    wavesInterestDtos.add(this.nsbt.toWavesInteresDto("nsbt"));
    wavesInterestDtos.add(this.usdt.toWavesInteresDto("usdt"));
    wavesInterestDtos.add(this.usdc.toWavesInteresDto("usdc"));
    wavesInterestDtos.add(this.btc.toWavesInteresDto("btc"));
    wavesInterestDtos.add(this.eth.toWavesInteresDto("eth"));
    wavesInterestDtos.add(this.usdn.toWavesInteresDto("usdn"));
    wavesInterestDtos.add(this.eurn.toWavesInteresDto("eurn"));
    wavesInterestDtos.add(this.uahn.toWavesInteresDto("uahn"));
    wavesInterestDtos.add(this.rubn.toWavesInteresDto("rubn"));
    wavesInterestDtos.add(this.cnyn.toWavesInteresDto("cnyn"));
    wavesInterestDtos.add(this.jpyn.toWavesInteresDto("jpyn"));
    wavesInterestDtos.add(this.brln.toWavesInteresDto("brln"));
    wavesInterestDtos.add(this.gbpn.toWavesInteresDto("gbpn"));
    wavesInterestDtos.add(this.tryn.toWavesInteresDto("tryn"));

    return wavesInterestDtos;
  }
}
