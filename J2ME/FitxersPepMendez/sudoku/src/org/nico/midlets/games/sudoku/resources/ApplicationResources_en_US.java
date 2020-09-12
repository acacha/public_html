package org.nico.midlets.games.sudoku.resources;

import org.nico.midlets.resources.ListResourceBundle;

/**
 * <p>Title: Sudoku</p>
 * <p>Description: Juego japones</p>
 * <p>Comments: Version recursiva</p>
 * <p>Date: 06/07/06</p>
 * @author Pep Mendez
 * @version 1.0
 */
public class ApplicationResources_en_US extends ListResourceBundle {

  public ApplicationResources_en_US() {
    super();
  }

  private Object[][] recursos = {
      {"titulo.principal", "Sudoku"},
      {"titulo.creditos", "Credits"},
      {"titulo.ganador", "Congratulations"},
      {"subtitulo.ganador", "Ohhhhhhhhhhhhhhhhhhhhh\nWell done\nTry again..."},
      {"titulo.reglas", "Rules of the game"},
      {"subtitulo.reglas", "Sudoku, from japanees su 'number' and doku 'alone', is played in a 9x9 board, 9 rows and 9 columns, that is made up by 9 3x3 boxes.\nInicially, some numbers are shown and you must place all missing numbers from 1 to 9 in every box, row and column.\nIt's recommended to start by the most populated box."},
      {"info.pensando", "Thinking..."},
      {"info.juego.inconsistente", "The game is not consistent"},
      {"info.juego.sin.solucion", "No solution found"},
      {"info.juego.generado", "Game generated in "},
      {"info.juego.solucionado", "Game solved in "},
      {"info.intentalo.de.nuevo", "Try again"},
      {"info.tablero.vacio", "Board is empty"},
      {"info.tablero.lleno", "Board is full"},
      {"info.correcto", "It looks good to me"},
      {"info.incorrecto", "It doesn't looks good to me"},
      {"info.pistas.disponibles", "There are no hints available"},
      {"nivel1", "\tElemental"},
      {"nivel2", "\tBasic"},
      {"nivel3", "\tVery easy"},
      {"nivel4", "\tEasy"},
      {"nivel5", "\tMidle"},
      {"nivel6", "\tDifficult"},
      {"nivel7", "\tVery difficult"},
      {"nivel8", "\tAdvanced"},
      {"nivel9", "\tProfessional"},
      {"ayuda0", "\tOn, on line help will be shown"},
      {"ayuda1", "\tOff, on line help will not be shown"},
      {"presentacion0", "\tNumbers will be shown \"1-9\""},
      {"presentacion1", "\tLetters will be shown \"A-I\""},
      {"menu.salir", "Exit"},
      {"menu.resolver", "Solve"},
      {"menu.reset", "Reset"},
      {"menu.nuevo", "New"},
      {"menu.plantear", "Suggest"},
      {"menu.configuracion", "Configuration"},
      {"menu.pista", "Hint"},
      {"menu.creditos", "Credits"},
      {"menu.revisar", "Check"},
      {"menu.reglas", "Rules"},
      {"alert.creditos", "Credits"},
      {"alert.felicidades", "Congratulations, game solved in "},
      {"etiqueta.fila", "In row "},
      {"etiqueta.columna", " column "},
      {"etiqueta.un", " a "},
      {"etiqueta.numero", " number "},
      {"etiqueta.letra", " letter "},
      {"formulario.configuracion.titulo", "Configuration"},
      {"formulario.configuracion.menu.aceptar", "Accept"},
      {"formulario.configuracion.menu.cancelar", "Cancel"},
      {"formulario.configuracion.ayuda.activada", "Activated"},
      {"formulario.configuracion.ayuda.desactivada", "Desactivated"},
      {"formulario.configuracion.ayuda.on.line", "Help on line"},
      {"formulario.configuracion.ayuda.interactiva", "Selected on line help: "},
      {"formulario.configuracion.selector.nivel", "Level selector"},
      {"formulario.configuracion.nivel.juego", "Selected game level: "},
      {"formulario.configuracion.presentacion.titulo", "Graphic rendering"},
      {"formulario.configuracion.presentacion.comentario", "Selected simbols: "},
      {"formulario.configuracion.presentacion.numeros", "Numbers"},
      {"formulario.configuracion.presentacion.letras", "Letters"},
      {"url.creditos.xml.file", "/org/nico/midlets/games/sudoku/credits/creditos_en_US.xml"},
  };

  /**
   * getContents
   * @return Object[][]
   */
  public Object[][] getContents() {
    return recursos;
  }

}
