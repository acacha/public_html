package org.nico.midlets.games.pingpong.interfaces;

import javax.microedition.lcdui.Font;
import javax.microedition.media.control.ToneControl;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Comments: </p>
 *
 * <p>Date: </p>
 *
 * @author Pep Mendez
 * @version 1.0
 */
public interface IPingPongConstants {
  Font fuente = Font.getFont(Font.FACE_PROPORTIONAL,
                             Font.STYLE_BOLD,
                             Font.SIZE_MEDIUM);
  int altura_fuente = fuente.getHeight();
  String imagen_creditos =
      "/org/nico/midlets/games/pingpong/images/pep.png";

  int color_fondo = 0x000000; // blanco
  int color_primer_plano = 0xffffff; // negro
  int diametro_pelota_inicial = 4;
  int desplazamineto_titulo = 3;
  int despl = 5;
  int longitud_raqueta_inicial = 20;
  int incremento_longitud_raqueta = -2;
  int limite_retardo_temporizador = 5;
  int retardo_temporizador_inicial = 75;
  int limite_raquetazos = 5;
//  String PATH_TO_CONFIG_FILE =
//      "/org/nico/midlets/games/pingpong/resources/configuracion.xml";
  int MILISECONDS_PER_HOUR = 3600000;
  int MILISECONDS_PER_MINUT = 60000;
  int MILISECONDS_PER_SECOND = 1000;
  int DELAY_SPLASH = 6000; // ms
  String SPLASH_IMAGE_URL =
      "/org/nico/midlets/games/pingpong/images/splash.png";
  int COLOR_BLACK = 0x000000; // negro
  int COLOR_WHITE = 0xffffff; // blanco
  int COLOR_GREY = 0xc0c0c0; // gris
  int COLOR_RED = 0xff0000;
  int COLOR_GREEN = 0x00ff00;
  int COLOR_BLUE = 0x0000ff;
  int COLOR_DARK_GREY = 0x808080;
  int OFFSET = 2;
  int POINTER_DELAY = 250;
  int NIVEL_INICIAL = 1;
  String PING_PONG_GAME_URL =
      "/org/nico/midlets/games/pingpong/sounds/pingponggame.wav";
  String RESOURCES_BASE_URL = "org.nico.midlets.games.pingpong.resources.ApplicationResources";
  String GAME_OVER_URL =
                  "/org/nico/midlets/games/pingpong/sounds/gameover.wav";
  byte[] MELODIA_COMPLETA = {
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
  byte[] MELODIA_CORTA = {
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
  byte tempo = 30; // set tempo to 120 bpm
  byte d = 8; // eighth-note

  byte C4 = ToneControl.C4;
  ;
  byte D4 = (byte) (C4 + 2); // a whole step
  byte E4 = (byte) (C4 + 4); // a major third
  byte G4 = (byte) (C4 + 7); // a fifth
  byte rest = ToneControl.SILENCE; // rest

  byte[] MARY_HAD_A_LITTLE_LAMB = {
      ToneControl.VERSION, 1, // version 1
      ToneControl.TEMPO, tempo, // set tempo
      ToneControl.BLOCK_START, 0, // start define "A" section
      E4, d, D4, d, C4, d, E4, d, // content of "A" section
      E4, d, E4, d, E4, d, rest, d,
      ToneControl.BLOCK_END, 0, // end define "A" section
      ToneControl.PLAY_BLOCK, 0, // play "A" section
      D4, d, D4, d, D4, d, rest, d, // play "B" section
      E4, d, G4, d, G4, d, rest, d,
      ToneControl.PLAY_BLOCK, 0, // repeat "A" section
      D4, d, D4, d, E4, d, D4, d, C4, d // play "C" section
  };
  int NIVEL_POR_DEFECTO = 1;
  int NIVEL_MAXIMO = 3;
  int NUMERO_PELOTAS_POR_DEFECTO = 3;
  int NUMERO_PELOTAS_MAXIMO = 5;
  boolean REDUCCION_PROGRESIVA_POR_DEFECTO = false;
  int RETARDO_TEMPORIZADOR_INICIAL = -10;
  String ON_IMAGE = "/org/nico/midlets/games/pingpong/images/on.png";
  String OFF_IMAGE = "/org/nico/midlets/games/pingpong/images/off.png";
  String PINGPONG = "/org/nico/midlets/games/pingpong/images/pingpong.png";
  String RSConfig = "config";

}