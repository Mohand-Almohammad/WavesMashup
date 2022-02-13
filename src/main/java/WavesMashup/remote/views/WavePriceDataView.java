package WavesMashup.remote.views;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WavePriceDataView {
  private double firstPrice_tryn;
  private double lastPrice_tryn;
  private double firstPrice_brln;
  private double lastPrice_brln;
  private double firstPrice_gbpn;
  private double lastPrice_gbpn;
  private double firstPrice_ngnn;
  private double lastPrice_ngnn;
  private double firstPrice_uahn;
  private double lastPrice_uahn;
  private double firstPrice_jpyn;
  private double lastPrice_jpyn;
  private double firstPrice_cnyn;
  private double lastPrice_cnyn;
  private double firstPrice_rubn;
  private double lastPrice_rubn;
  private double firstPrice_eurn;
  private double lastPrice_eurn;

  @JsonProperty(value = "firstPrice_usd-n")
  private double firstPrice_usd_n;

  @JsonProperty(value = "lastPrice_usd-n")
  private double lastPrice_usd_n;
  private double firstPrice_waves;
  private double lastPrice_waves;
  private double firstPrice_btc;
  private double lastPrice_btc;
  private double firstPrice_eth;
  private double lastPrice_eth;

  public double getFirstPrice_tryn() {
    return firstPrice_tryn;
  }

  public void setFirstPrice_tryn(double firstPrice_tryn) {
    this.firstPrice_tryn = firstPrice_tryn;
  }

  public double getLastPrice_tryn() {
    return lastPrice_tryn;
  }

  public void setLastPrice_tryn(double lastPrice_tryn) {
    this.lastPrice_tryn = lastPrice_tryn;
  }

  public double getFirstPrice_brln() {
    return firstPrice_brln;
  }

  public void setFirstPrice_brln(double firstPrice_brln) {
    this.firstPrice_brln = firstPrice_brln;
  }

  public double getLastPrice_brln() {
    return lastPrice_brln;
  }

  public void setLastPrice_brln(double lastPrice_brln) {
    this.lastPrice_brln = lastPrice_brln;
  }

  public double getFirstPrice_gbpn() {
    return firstPrice_gbpn;
  }

  public void setFirstPrice_gbpn(double firstPrice_gbpn) {
    this.firstPrice_gbpn = firstPrice_gbpn;
  }

  public double getLastPrice_gbpn() {
    return lastPrice_gbpn;
  }

  public void setLastPrice_gbpn(double lastPrice_gbpn) {
    this.lastPrice_gbpn = lastPrice_gbpn;
  }

  public double getFirstPrice_ngnn() {
    return firstPrice_ngnn;
  }

  public void setFirstPrice_ngnn(double firstPrice_ngnn) {
    this.firstPrice_ngnn = firstPrice_ngnn;
  }

  public double getLastPrice_ngnn() {
    return lastPrice_ngnn;
  }

  public void setLastPrice_ngnn(double lastPrice_ngnn) {
    this.lastPrice_ngnn = lastPrice_ngnn;
  }

  public double getFirstPrice_uahn() {
    return firstPrice_uahn;
  }

  public void setFirstPrice_uahn(double firstPrice_uahn) {
    this.firstPrice_uahn = firstPrice_uahn;
  }

  public double getLastPrice_uahn() {
    return lastPrice_uahn;
  }

  public void setLastPrice_uahn(double lastPrice_uahn) {
    this.lastPrice_uahn = lastPrice_uahn;
  }

  public double getFirstPrice_jpyn() {
    return firstPrice_jpyn;
  }

  public void setFirstPrice_jpyn(double firstPrice_jpyn) {
    this.firstPrice_jpyn = firstPrice_jpyn;
  }

  public double getLastPrice_jpyn() {
    return lastPrice_jpyn;
  }

  public void setLastPrice_jpyn(double lastPrice_jpyn) {
    this.lastPrice_jpyn = lastPrice_jpyn;
  }

  public double getFirstPrice_cnyn() {
    return firstPrice_cnyn;
  }

  public void setFirstPrice_cnyn(double firstPrice_cnyn) {
    this.firstPrice_cnyn = firstPrice_cnyn;
  }

  public double getLastPrice_cnyn() {
    return lastPrice_cnyn;
  }

  public void setLastPrice_cnyn(double lastPrice_cnyn) {
    this.lastPrice_cnyn = lastPrice_cnyn;
  }

  public double getFirstPrice_rubn() {
    return firstPrice_rubn;
  }

  public void setFirstPrice_rubn(double firstPrice_rubn) {
    this.firstPrice_rubn = firstPrice_rubn;
  }

  public double getLastPrice_rubn() {
    return lastPrice_rubn;
  }

  public void setLastPrice_rubn(double lastPrice_rubn) {
    this.lastPrice_rubn = lastPrice_rubn;
  }

  public double getFirstPrice_eurn() {
    return firstPrice_eurn;
  }

  public void setFirstPrice_eurn(double firstPrice_eurn) {
    this.firstPrice_eurn = firstPrice_eurn;
  }

  public double getLastPrice_eurn() {
    return lastPrice_eurn;
  }

  public void setLastPrice_eurn(double lastPrice_eurn) {
    this.lastPrice_eurn = lastPrice_eurn;
  }

  public double getFirstPrice_usd_n() {
    return firstPrice_usd_n;
  }

  public void setFirstPrice_usd_n(double firstPrice_usd_n) {
    this.firstPrice_usd_n = firstPrice_usd_n;
  }

  public double getLastPrice_usd_n() {
    return lastPrice_usd_n;
  }

  public void setLastPrice_usd_n(double lastPrice_usd_n) {
    this.lastPrice_usd_n = lastPrice_usd_n;
  }

  public double getFirstPrice_waves() {
    return firstPrice_waves;
  }

  public void setFirstPrice_waves(double firstPrice_waves) {
    this.firstPrice_waves = firstPrice_waves;
  }

  public double getLastPrice_waves() {
    return lastPrice_waves;
  }

  public void setLastPrice_waves(double lastPrice_waves) {
    this.lastPrice_waves = lastPrice_waves;
  }

  public double getFirstPrice_btc() {
    return firstPrice_btc;
  }

  public void setFirstPrice_btc(double firstPrice_btc) {
    this.firstPrice_btc = firstPrice_btc;
  }

  public double getLastPrice_btc() {
    return lastPrice_btc;
  }

  public void setLastPrice_btc(double lastPrice_btc) {
    this.lastPrice_btc = lastPrice_btc;
  }

  public double getFirstPrice_eth() {
    return firstPrice_eth;
  }

  public void setFirstPrice_eth(double firstPrice_eth) {
    this.firstPrice_eth = firstPrice_eth;
  }

  public double getLastPrice_eth() {
    return lastPrice_eth;
  }

  public void setLastPrice_eth(double lastPrice_eth) {
    this.lastPrice_eth = lastPrice_eth;
  }
}
