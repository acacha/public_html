package org.nico.midlets.games.pingpong.model;

import org.nico.midlets.resources.ResourceBundle;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Comments: </p>
 * <p>Date: </p>
 * @author Pep Mendez
 * @version 1.0
 */
public class PingPongConfig {
  private int nivel;
  private int numeroPelotas;
  private ResourceBundle bundle;
  private boolean reduccionProgresiva;
  public int getNivel() {
    return nivel;
  }

  public int getNumeroPelotas() {
    return numeroPelotas;
  }

  public ResourceBundle getBundle() {
    return bundle;
  }

  public boolean isReduccionProgresiva() {
    return reduccionProgresiva;
  }

  public void setNivel(int nivel) {
    this.nivel = nivel;
  }

  public void setNumeroPelotas(int numeroPelotas) {
    this.numeroPelotas = numeroPelotas;
  }

  public void setBundle(ResourceBundle bundle) {
    this.bundle = bundle;
  }

  public void setReduccionProgresiva(boolean reduccionProgresiva) {
    this.reduccionProgresiva = reduccionProgresiva;
  }

  /**
   * PingPongConfig
   *
   * @param nivel int
   * @param numeroPelotas int
   * @param bundle ResourceBundle
   */
  public PingPongConfig(int nivel, int numeroPelotas, ResourceBundle bundle, boolean reduccionProgresiva) {
    this.nivel = nivel;
    this.numeroPelotas = numeroPelotas;
    this.bundle = bundle;
    this.reduccionProgresiva = reduccionProgresiva;
  }

}
