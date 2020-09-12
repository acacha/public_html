package org.nico.midlets.games.sudoku.model;

import org.nico.midlets.resources.ResourceBundle;

/**
 * <p>Title: Sudoku</p>
 * <p>Description: Juego japones</p>
 * <p>Comments: Version recursiva</p>
 * <p>Date: 06/07/06</p>
 * <p>Last update: 06/07/06</p>
 * @author Pep Mendez
 */
public class SudokuConfig {
  private int level;
  private boolean ayudaOnLine;
  private ResourceBundle bundle;
  private int presentation; // numeros, letras
  public SudokuConfig(int level, boolean ayudaOnLine, int presentation, ResourceBundle bundle) {
    this.level = level;
    this.ayudaOnLine = ayudaOnLine;
    this.presentation = presentation;
    this.bundle = bundle;
  }

  public int getLevel() {
    return level;
  }

  public boolean isAyudaOnLine() {
    return ayudaOnLine;
  }

  public ResourceBundle getBundle() {
    return bundle;
  }

  public int getPresentation() {
    return presentation;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  public void setAyudaOnLine(boolean ayudaOnLine) {
    this.ayudaOnLine = ayudaOnLine;
  }

  public void setBundle(ResourceBundle bundle) {
    this.bundle = bundle;
  }

  public void setPresentation(int presentation) {
    this.presentation = presentation;
  }
}
