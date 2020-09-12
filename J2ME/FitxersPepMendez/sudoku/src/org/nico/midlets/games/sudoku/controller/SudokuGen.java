package org.nico.midlets.games.sudoku.controller;

import java.util.Vector;

import org.nico.midlets.games.sudoku.interfaces.ISudokuConstants;
import org.nico.midlets.games.sudoku.model.SudokuHint;

/**
 * Juego generado
 * <p>Title: Sudoku</p>
 * <p>Description: Guarda un juego generado</p>
 * <p>Date: 06/07/06</p>
 * <p>Last update: 07/08/06</p>
 * @author Pep Mendez
 */
public class SudokuGen implements ISudokuConstants {
  // solucion
  private int[][] sol;
  // valores ofrecidos
  private boolean[][] gen;
  // matrix problema
  private int[][] problem;
  private Vector hints;

  public SudokuGen() {

  }

  public SudokuGen(int[][] problem, int[][] sol, boolean[][] gen, Vector hints) {
    this.problem = problem;
    this.sol = sol;
    this.gen = gen;
    this.hints = hints;
  }

  /**
   * true si la propuesta es identac a la solucion
   * @param propuesta int[][]
   * @return boolean
   */
  public boolean checkIt(int[][] propuesta) {
    for (int i = 0; i < sol.length; i++) {
      for (int j = 0; j < sol[i].length; j++) {
        if (sol[i][j] != propuesta[i][j]) {
          return false;
        }
      }
    }
    return true;
  }

  public boolean isPistaDisponible() {
    return!hints.isEmpty();
  }

  public SudokuHint siguientePista() {

    SudokuHint hint = null;

    if (isPistaDisponible()) {
      hint = (SudokuHint) hints.firstElement();
      hints.removeElementAt(0);
    }

    return hint;
  }

  public int[][] getSol() {
    return sol;
  }

  public boolean[][] getGen() {
    return gen;
  }

  public int[][] getProblem() {
    return problem;
  }

  public Vector getHints() {
    return hints;
  }

  public void setSol(int[][] sol) {
    this.sol = sol;
  }

  public void setGen(boolean[][] gen) {
    this.gen = gen;
  }

  public void setProblem(int[][] problem) {
    this.problem = problem;
  }

  public void setHints(Vector hints) {
    this.hints = hints;
  }

  // casillas en blanco de la matrix problema
  public int getEmptyCells() {
    int n = 0;

    for (int i = 0; i < ROWS; i++) {
      for (int j = 0; j < COLS; j++) {
        if (problem[i][j] == EMPTY) {
          ++n;
        }
      }
    }
    return n;
  }
}
