package org.nico.midlets.games.sudoku.resources;

import org.nico.midlets.resources.ListResourceBundle;

/**
 * <p>Title: Sudoku</p>
 * <p>Description: Juego japones</p>
 * <p>Comments: Version recursiva</p>
 * <p>Date: 11/08/06</p>
 * <p>Last upate: 11/08/06</p>
 * @author Pep Mendez
 */
public class ApplicationResources_es_ES extends ListResourceBundle {

  public ApplicationResources_es_ES() {
    super();
  }
  private Object[][] recursos = {
      {"titulo.principal", "Sudoku"},
      {"titulo.creditos", "Cr�ditos"},
      {"titulo.ganador", "Felicidades"},
      {"subtitulo.ganador", "Ohhhhhhhhhhhhhhhhhhhhh\nFelicidades\nJuega de nuevo..."},
      {"titulo.reglas", "Reglas del juego"},
      {"subtitulo.reglas", "Sudoku, del japon�s su 'n�mero' i doku 'solo', se juega en un tablero de 9x9, 9 filas y 9 columnas, que est� dividido en 9 cajas de 3x3 celdas.\nInicialmente, se presentan algunos n�meros, y se trata de colocar los n�meros del 1 al 9 que faltan en cada caja, fila y columna.\nSe recomienda empezar por la cajas con m�s n�meros."},
      {"info.pensando", "Pensando..."},
      {"info.juego.inconsistente", "El juego no es consistente"},
      {"info.juego.sin.solucion", "No tiene soluci�n"},
      {"info.juego.generado", "Juego generado en "},
      {"info.juego.solucionado", "Juego solucionado en "},
      {"info.intentalo.de.nuevo", "Intentalo de nuevo"},
      {"info.tablero.vacio", "El tablero est� vacio"},
      {"info.tablero.lleno", "El tablero est� lleno"},
      {"info.correcto", "Correcto, puedes continuar"},
      {"info.incorrecto", "Incorrecto, corrige los errores"},
      {"info.pistas.disponibles", "No quedan pistas disponibles"},
      {"nivel1", "\tElemental"},
      {"nivel2", "\tB�sico"},
      {"nivel3", "\tMuy f�cil"},
      {"nivel4", "\tF�cil"},
      {"nivel5", "\tIntermedio"},
      {"nivel6", "\tDif�cil"},
      {"nivel7", "\tMuy dif�cil"},
      {"nivel8", "\tAvanzado"},
      {"nivel9", "\tProfesional"},
      {"ayuda0", "\tActivada, se mostrar�n mensajes de ayuda"},
      {"ayuda1", "\tDesactivada, no se mostrar�n mensajes de ayuda"},
      {"presentacion0", "\tSe mostrar�n n�meros \"1-9\""},
      {"presentacion1", "\tSe mostrar�n letras \"A-I\""},
      {"menu.salir", "Salir"},
      {"menu.resolver", "Resolver"},
      {"menu.reset", "Reset"},
      {"menu.nuevo", "Nuevo"},
      {"menu.plantear", "Plantear"},
      {"menu.configuracion", "Configuraci�n"},
      {"menu.pista", "Pista"},
      {"menu.creditos", "Cr�ditos"},
      {"menu.revisar", "Revisar"},
      {"menu.reglas", "Reglas"},
      {"alert.creditos", "Cr�ditos"},
      {"alert.felicidades", "Felicidades, juego resuelto en "},
      {"etiqueta.fila", "En la fila "},
      {"etiqueta.columna", " columna "},
      {"etiqueta.un", " un "},
      {"etiqueta.numero", " el n�mero "},
      {"etiqueta.letra", " la letra "},
      {"formulario.configuracion.titulo", "Configuraci�n"},
      {"formulario.configuracion.menu.aceptar", "Aceptar"},
      {"formulario.configuracion.menu.cancelar", "Cancelar"},
      {"formulario.configuracion.ayuda.activada", "Activada"},
      {"formulario.configuracion.ayuda.desactivada", "Desactivada"},
      {"formulario.configuracion.ayuda.on.line", "Ayuda en l�nea"},
      {"formulario.configuracion.ayuda.interactiva", "Ayuda interactiva seleccionada: "},
      {"formulario.configuracion.selector.nivel", "Selector de nivel"},
      {"formulario.configuracion.nivel.juego", "Nivel de juego seleccionado: "},
      {"formulario.configuracion.presentacion.titulo", "Representaci�n gr�fica"},
      {"formulario.configuracion.presentacion.comentario", "S�mbolos seleccionados: "},
      {"formulario.configuracion.presentacion.numeros", "N�meros"},
      {"formulario.configuracion.presentacion.letras", "Letras"},
      {"url.creditos.xml.file", "/org/nico/midlets/games/sudoku/credits/creditos_es_ES.xml"},
  };

  /**
   * getContents
   * @return Object[][]
   */
  public Object[][] getContents() {
    return recursos;
  }
}