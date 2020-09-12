package org.nico.midlets.games.sudoku.interfaces;

import javax.microedition.media.control.ToneControl;


/**
 * <p>Title: ISudokuConstants</p>
 * <p>Description: Constantes de la aplicacion</p>
 * <p>Comments: Version recursiva</p>
 * <p>Date: 06/07/06</p>
 * <p>Last update: 13/08/06</p>
 * @author Pep Mendez
 */
public interface ISudokuConstants {
  // comunes
  public final int EMPTY = 0;
  public final int ROWS = 9;
  public final int COLS = 9;
  public final int CELLS = ROWS * COLS;
  public final int MAX_VAL = 9;
  // SudokuDisplay
  final int margen_sup = 0;
  final int margen_lat = 0;
  final String imagen_creditos = "/org/nico/midlets/games/sudoku/images/pep.png";
  final String imagen_ganador = "/org/nico/midlets/games/sudoku/images/payaso.png";
  final String imagen_reglas = "/org/nico/midlets/games/sudoku/images/nena.png";
  final String imagen_mosca = "/org/nico/midlets/games/sudoku/images/mosca.png";
  final int ganador_retardo = 30000;
  final int COLOR_BLACK = 0x000000; // negro
  final int COLOR_WHITE = 0xffffff; // blanco
  final int COLOR_GREY = 0xc0c0c0; // gris
  final int COLOR_RED = 0xff0000;
  final int COLOR_GREEN = 0x00ff00;
  final int COLOR_BLUE = 0x0000ff;
  final int COLOR_DARK_GREY = 0x808080;
  final int OFFSET = 2;
  final int POINTER_DELAY = 250;
  final int NIVEL_INICIAL = 1;
//  final int SEED_INICIAL = 3; // numero de bloques a rellenar
  final int SIMBOLOS_INICIALES = 0;
  public final String RSConfig = "config";
  public final String RSLastGame = "lastgame";
  final int MAX_PISTAS = 3;
  final int PISTAS_POR_NIVEL = 1;
  final int LAZY = 0;
  final int THINKING = 1;
  final int GAME_SOLVED = 2;
  final String SUCCESS_WAV_URL =
      "/org/nico/midlets/games/sudoku/sounds/sudoku_felicidades_";
  final String RESOURCES_BASE_URL = "org.nico.midlets.games.sudoku.resources.ApplicationResources";
  // SudokuFormConfig
  final int NIVEL_MAXIMO = 9;
  final int SEED_MAXIMA = 3; // cajas que relleno aleatorianente
  final String ON_IMAGE = "/org/nico/midlets/games/sudoku/images/on.png";
  final String OFF_IMAGE = "/org/nico/midlets/games/sudoku/images/off.png";
  // SPlash
  final int DELAY_SPLASH = 6000; // ms
  final String SPLASH_IMAGE_URL = "/org/nico/midlets/games/sudoku/images/splash.png";

  // Sudoku Midlet
  final String SUDOKU_GAME_URL =
      "/org/nico/midlets/games/sudoku/sounds/sudoku_game.wav";
  byte[] melodiaCompleta = {
      ToneControl.VERSION, 1, ToneControl.TEMPO, 22, ToneControl.BLOCK_START, 0,
      60, 8, 62, 4, 64, 4, 65, 4, 67, 4, 69, 4, 71, 4, 72, 4, 74, 4, 76, 4, 77,
      4, 79, 4, 81, 4, 83, 4, 84, 4, 83, 4, 81, 4, 80, 4, 81, 4, 86, 4, 84, 4,
      83, 4, 81, 4, 81, 4, 79, 4, 78, 4, 79, 4, 60, 4, 79, 4, 88, 4, 79, 4, 57,
      4, 77, 4, 88, 4, 77, 4, 59, 4, 77, 4, 86, 4, 77, 4, 56, 4, 76, 4, 86, 4,
      76, 4, 57, 4, 76, 4, 84, 4, 76, 4, 53, 4, 74, 4, 84, 4, 74, 4, 55, 4, 74,
      4, 83, 4, 74, 4, 84, 16, ToneControl.SILENCE, 16, ToneControl.BLOCK_END,
      0, ToneControl.BLOCK_START, 1, 79, 4, 84, 4, 88, 4, 86, 4, 84, 4, 83, 4,
      81, 4, 79, 4, 77, 4, 76, 4, 74, 4, 72, 4, 71, 4, 69, 4, 67, 4, 65, 4, 64,
      8, 76, 8, 77, 8, 78, 8, 79, 12, 76, 4, 74, 8, ToneControl.SILENCE, 8,
      ToneControl.BLOCK_END, 1, ToneControl.SET_VOLUME, 100,
      ToneControl.PLAY_BLOCK, 0, ToneControl.SET_VOLUME, 50,
      ToneControl.PLAY_BLOCK, 0, ToneControl.SET_VOLUME, 100,
      ToneControl.PLAY_BLOCK, 1, ToneControl.SET_VOLUME, 50,
      ToneControl.PLAY_BLOCK, 1, ToneControl.SET_VOLUME, 100,
      ToneControl.PLAY_BLOCK, 0,
  };
  byte[] melodiaCorta = {
      ToneControl.VERSION, 1, ToneControl.TEMPO, 22, ToneControl.BLOCK_START, 0,
      60, 8, 62, 4, 64, 4, 65, 4, 67, 4, 69, 4, 71, 4, 72, 4, 74, 4, 76, 4, 77,
      4, 79, 4, 81, 4, 83, 4, 84, 4, 83, 4, 81, 4, 80, 4, 81, 4, 86, 4, 84, 4,
      83, 4, 81, 4, 81, 4, 79, 4, 78, 4, 79, 4, 60, 4, 79, 4, 88, 4, 79, 4, 57,
      4, 77, 4, 88, 4, 77, 4, 59, 4, 77, 4, 86, 4, 77, 4, 56, 4, 76, 4, 86, 4,
      76, 4, 57, 4, 76, 4, 84, 4, 76, 4, 53, 4, 74, 4, 84, 4, 74, 4, 55, 4, 74,
      4, 83, 4, 74, 4, 84, 16, ToneControl.SILENCE, 16, ToneControl.BLOCK_END,
      0, ToneControl.BLOCK_START, 1, 79, 4, 84, 4, 88, 4, 86, 4, 84, 4, 83, 4,
      81, 4, 79, 4, 77, 4, 76, 4, 74, 4, 72, 4, 71, 4, 69, 4, 67, 4, 65, 4, 64,
      8, 76, 8, 77, 8, 78, 8, 79, 12, 76, 4, 74, 8, ToneControl.SILENCE, 8,
      ToneControl.BLOCK_END, 1, ToneControl.SET_VOLUME, 50,
      ToneControl.PLAY_BLOCK, 1,
  };
}