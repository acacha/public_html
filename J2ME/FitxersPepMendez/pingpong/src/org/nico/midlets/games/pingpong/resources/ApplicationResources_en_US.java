package org.nico.midlets.games.pingpong.resources;

import org.nico.midlets.resources.ListResourceBundle;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Comments: </p>
 * <p>Date: </p>
 * @author Pep Mendez
 * @version 1.0
 */

public class ApplicationResources_en_US extends ListResourceBundle {

  private Object[][] recursos = {
      {"pantalla.principal.titulo", "Ping Pong"},
      {"pantalla.creditos.titulo", "Credits"},
      {"pantalla.configuracion.titulo", "Configuration"},
      {"pantalla.reglas.titulo", "Game rules"},
      {"pantalla.reglas.subtitulo", "blablabla"},
      {"nivel.dificultad.1", "\tBasic"},
      {"nivel.dificultad.2", "\tMiddle"},
      {"nivel.dificultad.3", "\tAdvanced"},
      {"pantalla.principal.menu.salir", "Exit"},
      {"pantalla.principal.menu.jugar", "Play"},
      {"pantalla.principal.menu.pausa", "Pause"},
      {"pantalla.principal.menu.configuracion", "Configuration"},
      {"pantalla.principal.menu.creditos", "Credits"},
      {"pantalla.principal.menu.instrucciones", "Instructions"},
      {"pantalla.principal.etiqueta.jugador.1", "PDA"},
      {"pantalla.principal.etiqueta.jugador.2", "Human"},
      {"pantalla.principal.etiqueta.final.juego", "Game over"},
      {"pantalla.configuracion.menu.aceptar", "Accept"},
      {"pantalla.configuracion.menu.cancelar", "Cancel"},
      {"pantalla.configuracion.etiqueta.selector.nivel", "Level selector"},
      {"pantalla.configuracion.etiqueta.nivel.seleccionado", "Level game selected: "},
      {"pantalla.configuracion.etiqueta.selector.pelotas", "Ball number selector"},
      {"pantalla.configuracion.etiqueta.choice.reduccion.progresiva", "Progressive raquet reduction"},
      {"pantalla.configuracion.etiqueta.choice.reduccion.seleccionada", "Progressive reduction: "},
      {"pantalla.configuracion.etiqueta.choice.reduccion.0", "Activated"},
      {"pantalla.configuracion.etiqueta.choice.reduccion.1", "Desactivated"},
      {"pantalla.configuracion.etiqueta.pelotas.seleccionadas", "Ball number selected: "},
      {"tiempo.transcurrido", "Elapsed time: 00:00:00"},
      {"etiqueta.tiempo.transcurrido", "Elapsed time: "},
      {"url.fichero.creditos", "/org/nico/midlets/games/pingpong/credits/creditos_en_US.xml"},
  };

  /**
   * getContents
   * @return Object[][]
   */
  public Object[][] getContents() {
    return recursos;
  }
}
