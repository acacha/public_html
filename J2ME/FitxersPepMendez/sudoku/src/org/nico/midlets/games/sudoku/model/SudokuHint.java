package org.nico.midlets.games.sudoku.model;

/**
 * <p>Title: Sudoku</p>
 * <p>Description: Juego japones</p>
 * <p>Comments: Version recursiva</p>
 * <p>Date: 06/07/06</p>
 * @author Pep Mendez
 * @version 1.0
 */
public class SudokuHint {
  private int fila;
  private int columna;
  private int valor;

  /**
   * Hint
   *
   * @param fila int
   * @param columna int
   * @param valor int
   */
  public SudokuHint(int fila, int columna, int valor) {
    this.fila = fila;
    this.columna = columna;
    this.valor = valor;
  }

  public int getFila() {
    return fila;
  }

  public int getColumna() {
    return columna;
  }

  public int getValor() {
    return valor;
  }

  public void setFila(int fila) {
    this.fila = fila;
  }

  public void setColumna(int columna) {
    this.columna = columna;
  }

  public void setValor(int valor) {
    this.valor = valor;
  }
}
