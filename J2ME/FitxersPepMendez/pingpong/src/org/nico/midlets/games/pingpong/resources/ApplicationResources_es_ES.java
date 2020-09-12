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
public class ApplicationResources_es_ES extends ListResourceBundle {

  private Object[][] recursos = {
      {"pantalla.principal.titulo", "Ping Pong"},
      {"pantalla.creditos.titulo", "Créditos"},
      {"pantalla.configuracion.titulo", "Configuración"},
      {"pantalla.reglas.titulo", "Reglas del juego"},
      {"pantalla.reglas.subtitulo", "blablabla"},
      {"nivel.dificultad.1", "\tBásico"},
      {"nivel.dificultad.2", "\tIntermedio"},
      {"nivel.dificultad.3", "\tAvanzado"},
      {"pantalla.principal.menu.salir", "Salir"},
      {"pantalla.principal.menu.jugar", "Jugar"},
      {"pantalla.principal.menu.pausa", "Pausa"},
      {"pantalla.principal.menu.configuracion", "Configuración"},
      {"pantalla.principal.menu.creditos", "Créditos"},
      {"pantalla.principal.menu.instrucciones", "Instrucciones"},
      {"pantalla.principal.etiqueta.jugador.1", "PDA"},
      {"pantalla.principal.etiqueta.jugador.2", "Humano"},
      {"pantalla.principal.etiqueta.final.juego", "Final de juego"},
      {"pantalla.configuracion.menu.aceptar", "Aceptar"},
      {"pantalla.configuracion.menu.cancelar", "Cancelar"},
      {"pantalla.configuracion.etiqueta.selector.nivel", "Selector de nivel"},
      {"pantalla.configuracion.etiqueta.nivel.seleccionado", "Nivel de juego seleccionado: "},
      {"pantalla.configuracion.etiqueta.selector.pelotas", "Selector de número de pelotas"},
      {"pantalla.configuracion.etiqueta.choice.reduccion.progresiva", "Reducir raquetas progresivamente"},
      {"pantalla.configuracion.etiqueta.choice.reduccion.seleccionada", "Reducción progresiva: "},
      {"pantalla.configuracion.etiqueta.choice.reduccion.0", "Activada"},
      {"pantalla.configuracion.etiqueta.choice.reduccion.1", "Desactivada"},
      {"pantalla.configuracion.etiqueta.pelotas.seleccionadas", "Número de pelotas seleccionado: "},
      {"tiempo.transcurrido", "Tiempo transcurrido: 00:00:00"},
      {"etiqueta.tiempo.transcurrido", "Tiempo transcurrido: "},
      {"url.fichero.creditos", "/org/nico/midlets/games/pingpong/credits/creditos_es_ES.xml"},
  };

  /**
   * getContents
   * @return Object[][]
   */
  public Object[][] getContents() {
    return recursos;
  }
}
