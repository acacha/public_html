package org.nico.midlets.games.sudoku.resources;

import org.nico.midlets.resources.ListResourceBundle;

/**
 * <p>Title: Sudoku</p>
 * <p>Description: Juego japones</p>
 * <p>Comments: Version recursiva</p>
 * <p>Date: 06/07/06</p>
 * @author Pep Mendez
 */
public class ApplicationResources_fr_FR extends ListResourceBundle {

  public ApplicationResources_fr_FR() {
    super();
  }
  private Object[][] recursos = {
      {"titulo.principal", "Sudoku"},
      {"titulo.creditos", "Cr�dits"},
      {"titulo.ganador", "Felicitacions"},
      {"subtitulo.ganador", "Ohhhhhhhhhhhhhhhhhhhhh\nFelicitacions\nJouez de nouveau..."},
      {"titulo.reglas", "Regles du jeu"},
      {"subtitulo.reglas", "Sudoku, du japon su 'numero' et doku 'solitaire', est jou� en une table de 9x9, 9 files i 9 colonnes, qui sont divis�s par 9 cofre de 3x3 cellules.\nIniciamant, se presente quelque numeros, et est trait� de superposer les numeros de 1 a 9 qui manque dans chaque cofre, file et colonne.\nEst recomander de comencer par les cofres avec plus de numeros."},
      {"info.pensando", "Pens�..."},
      {"info.juego.inconsistente", "Le jeu n�est pas consistant"},
      {"info.juego.sin.solucion", "Il n�y a pas de solution"},
      {"info.juego.generado", "Jeu gener� en "},
      {"info.juego.solucionado", "Jeu solution�e en "},
      {"info.intentalo.de.nuevo", "Intante le de nouveau"},
//      {"info.tablero.vacio", "La table est vide, pose quelque numeros"},
      {"info.tablero.vacio", "La table est vide"},
//      {"info.tablero.lleno", "La table est pleine, choisi le menu/Reset"},
      {"info.tablero.lleno", "La table est pleine"},
      {"info.correcto", "Correcte, tu peux continuer"},
      {"info.incorrecto", "Incorrecte, corrige les erreurs"},
      {"info.pistas.disponibles", "Il n�y a plus de piste"},
      {"nivel1", "\tElemental"},
      {"nivel2", "\tBasic"},
      {"nivel3", "\tFacil"},
      {"nivel4", "\tTr�s facil"},
      {"nivel5", "\tIntermilieu"},
      {"nivel6", "\tDificil"},
      {"nivel7", "\tTr�s dificil"},
      {"nivel8", "\tAvanc�"},
      {"nivel9", "\tProfessional"},
      {"ayuda0", "\tActiv�e, montre les messages d�aide"},
      {"ayuda1", "\tDesactiv�e, ne montre pas de messege d�aide"},
      {"presentacion0", "\tMontre numeros \"1-9\""}, // !!!
      {"presentacion1", "\tMontre letras \"A-I\""}, // !!!
      {"menu.salir", "Sortir"},
      {"menu.resolver", "Resoudre"},
      {"menu.reset", "Reset"},
      {"menu.nuevo", "Nouveau"},
      {"menu.plantear", "sugg�rer"},
      {"menu.configuracion", "Configuration"},
      {"menu.pista", "Piste"},
      {"menu.creditos", "Cr�dits"},
      {"menu.revisar", "Reviser"},
      {"menu.reglas", "Instructions"},
      {"alert.creditos", "Cr�dits"},
      {"alert.felicidades", "Felicitacions, jeu resolu en "},
      {"etiqueta.fila", "A la file "},
      {"etiqueta.columna", " colonne "},
      {"etiqueta.un", " un "},
      {"etiqueta.numero", " el n�mero "},
      {"etiqueta.letra", " la letra "},
      {"formulario.configuracion.titulo", "Configuratio"},
      {"formulario.configuracion.menu.aceptar", "Accepter"},
      {"formulario.configuracion.menu.cancelar", "Annuler"},
      {"formulario.configuracion.ayuda.activada", "Activ�e"},
      {"formulario.configuracion.ayuda.desactivada", "Desactiv�e"},
      {"formulario.configuracion.ayuda.on.line", "Aide en ligne"},
      {"formulario.configuracion.ayuda.interactiva", "Aide interactive selection�e: "},
      {"formulario.configuracion.selector.nivel", "Selecteur de nivel"},
      {"formulario.configuracion.nivel.juego", "Nivel de jeu seleccion�: "},
      {"formulario.configuracion.presentacion.titulo", "Representaci�n gr�fica"}, // !!!
      {"formulario.configuracion.presentacion.comentario", "S�mbolos seleccionados: "}, // !!!
      {"formulario.configuracion.presentacion.numeros", "N�meros"}, // !!!
      {"formulario.configuracion.presentacion.letras", "Letras"}, // !!!
      {"url.creditos.xml.file", "/org/nico/midlets/games/sudoku/credits/creditos_fr_FR.xml"},
  };

  /**
   * getContents
   * @return Object[][]
   */
  public Object[][] getContents() {
    return recursos;
  }
}
