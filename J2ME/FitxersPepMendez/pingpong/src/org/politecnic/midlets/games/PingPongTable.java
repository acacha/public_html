package org.politecnic.midlets.games;

import javax.microedition.lcdui.*;
import java.util.Timer;
import javax.microedition.media.Manager;
import java.util.Random;
import javax.microedition.media.*;
import java.io.*;
//import javax.microedition.media.control.ToneControl;

/**
 * <p>Title: Ping Pong Tabale </p>
 * <p>Description: Ping pong interactivo para dispositivos moviles</p>
 * <p>Comments: CLDL 1.1 MIDP 2.0</p>
 * <p>Date: 12/03/06 </p>
 * @author Pep Mendez
 * @version 1.0
 */
public class PingPongTable
    extends Canvas implements CommandListener {
  private final boolean VERSION_FINAL = false;
  private final int ancho = getWidth();
  private final int alto = getHeight();
  private final int margen_sup = (int) (alto * 0.1);
  private final int margen_inf = margen_sup * 3;
  private final int margen_lat = (int) (ancho * 0.05);
  private final Font fuente = Font.getFont(Font.FACE_PROPORTIONAL,
                                           Font.STYLE_BOLD,
                                           Font.SIZE_MEDIUM);
  private final int altura_fuente = fuente.getHeight();
  private final String titulo = "Ping Pong Game";
  private final String titulo_creditos = "Cr�ditos";
  private final String titulo_creditos2 =
      "Ping Pong Game v. 3.0\nPep M�ndez\nSUN Java Programmer, Developer & Web Component Developer Certified.\nComentarios y sugerencias a jmendez1@xtec.net\n(12/03/2006)";
  private final String imagen_creditos =
      "/org/politecnic/midlets/games/pep.png";
  private final int longitud_titulo = fuente.stringWidth(titulo);
  private final String jugador1 = "PDA";
  private final String jugador2 = "Humano";
  private final String tituo_final_de_juego = "Game Over";
  private final int longitud_titulo_final_de_juego = fuente.stringWidth(
      tituo_final_de_juego);
//  private int longitud_jugador1 = fuente.stringWidth(jugador1);
//  private int longitud_jugador2 = fuente.stringWidth(jugador2);
  private final int color_fondo = 0x000000; // blanco
  private final int color_primer_plano = 0xffffff; // negro
  private final int diametro_pelota_inicial = 3;
  private final int despl = 3;
  private final int anchura_campo = ancho - margen_lat * 2;
  private final int altura_campo = (alto - margen_inf - margen_sup);
  private final int altura_campo_medios = altura_campo / 2;
  private final int x_raqueta_pda = margen_lat + despl;
  private final int x_raqueta_humano = ancho - margen_lat - despl;
  private final int altura_marcador = margen_sup;
  private final int longitud_raqueta_inicial = 20;
  private final int incremento_longitud_raqueta = -2;
  private int diametro_pelota = diametro_pelota_inicial;
  // toman valores entre longitud_raqueta_medios y altura_campo-longitud_raqueta_medios
  private int y_raqueta_pda = altura_campo_medios;
  private int y_raqueta_humano = y_raqueta_pda;
  private int x_pelota = ancho / 2 + despl;
  private int y_pelota = new Random().nextInt(altura_campo);

  private int longitud_raqueta = 20;
  private int longitud_raqueta_medios = longitud_raqueta / 2;
  private int y1_raqueta_humano;
  private int y2_raqueta_humano;
  private int y1_raqueta_pda = altura_campo_medios + margen_sup -
      longitud_raqueta_medios;
  private int y2_raqueta_pda = y1_raqueta_pda + longitud_raqueta;
  private int marcador_humano = 0;
  private int marcador_pda = 0;
  private int incremento_x = diametro_pelota;
  private int incremento_y = diametro_pelota;
  private final int limite_retardo_temporizador = 25;
  private final int retardo_temporizador_inicial = 75;
  private int retardo_temporizador = retardo_temporizador_inicial;
  private final int incremento_retardo_temporizador = -10;
  private int raquetazos = 0;
  private final int limite_raquetazos = 5;
  private boolean fin_de_juego = false;
  private final int limite_juego = 3;
  private boolean juego_nuevo = false;
  private boolean turno_pda = false;
  private boolean juego_pausado = false;
  private boolean juego_iniciado = false;
  private boolean game_over_dicho = false;
  private long tiempo_inicial = System.currentTimeMillis();
  private long tiempo_transcurrido = 0;
  private long tiempo_inicial_en_pausa = 0;
  private long tiempo_final_en_pausa = 0;
  private long tiempo_total_en_pausa = 0;
  private String cadena_tiempo_transcurrido = "Tiempo transcurrido: 00:00:00";
  private Timer timer = new Timer();
  private Command salir = new Command("Salir", Command.EXIT, 1);
  private Command jugar = new Command("Jugar", Command.OK, 1);
  private Command pausa = new Command("Pausa", Command.CANCEL, 1);
  private Command creditos = new Command("Cr�ditos", Command.HELP, 1);
  private Alert aCreditos = new Alert("Creditos");

  /**
   * Constructor
   */
  public PingPongTable() {
    try {
      jbInit();
    }
    catch (Exception e) {
      Alert error = new Alert("Error");
      error.setTimeout(Alert.FOREVER);
      error.setString(e.getMessage());
      Display.getDisplay(PingPong.getInstance()).setCurrent(error);
    }
  }

  private void jbInit() throws Exception {
    // Set up this Displayable to listen to command events
    setCommandListener(this);
    aCreditos.setTitle(titulo_creditos);
    aCreditos.setString(titulo_creditos2);
    aCreditos.setTimeout(Alert.FOREVER);
    aCreditos.setImage(Image.createImage(imagen_creditos));
    InputStream is = this.getClass().getResourceAsStream("/org/politecnic/midlets/games/configuracion.xml");
    InputStreamReader reader = new InputStreamReader(is);
//    SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
//    parser.parse(is,new MyEventHandler());
    // add the Exit command
    addCommand(salir);
    addCommand(jugar);
    addCommand(creditos);
  }

  private void resetJuego() {
    fin_de_juego = false;
    // true para quitar el titulo 'game over'
    juego_nuevo = true;
    retardo_temporizador = retardo_temporizador_inicial;
    raquetazos = 0;
    x_pelota = ancho / 2 + despl;
    y_pelota = new Random().nextInt(altura_campo);
    incremento_x = diametro_pelota;
    incremento_y = diametro_pelota;
    marcador_humano = marcador_pda = 0;
    turno_pda = false;
    longitud_raqueta = longitud_raqueta_inicial;
    longitud_raqueta_medios = longitud_raqueta / 2;
    y1_raqueta_pda = altura_campo_medios + margen_sup -
        longitud_raqueta_medios;
    y2_raqueta_pda = y1_raqueta_pda + longitud_raqueta;
    juego_pausado = false;
    juego_iniciado = true;
    tiempo_inicial_en_pausa = 0;
    tiempo_final_en_pausa = 0;
    tiempo_total_en_pausa = 0;
    cadena_tiempo_transcurrido = "Tiempo transcurrido: 00:00:00";
    game_over_dicho = false;
  }

  public void commandAction(Command command, Displayable displayable) {
    if (command.getCommandType() == Command.EXIT) {
      // stop the MIDlet
      if (timer != null) {
        timer.cancel();
        timer = null;
      }
      PingPong.quitApp();
    }
    // jugar
    else if (command.getCommandType() == Command.OK) {
      // start game
      juego_iniciado = true;
      if (!juego_pausado) {
        tiempo_inicial = System.currentTimeMillis();
      }
      else { // juego pausado
        tiempo_final_en_pausa = System.currentTimeMillis();
        tiempo_total_en_pausa +=
            (tiempo_final_en_pausa - tiempo_inicial_en_pausa);
      }
      removeCommand(creditos);
      removeCommand(jugar);
      addCommand(pausa);
      if (fin_de_juego) {
        resetJuego();
      }
      if (timer == null) {
        timer = new Timer();
      }
      timer.schedule(new MuevePelota(), 0, retardo_temporizador); // intervalos en ms
      juego_pausado = false;
    }
    // pausa
    else if (command.getCommandType() == Command.CANCEL) {
      // pause game
      tiempo_inicial_en_pausa = System.currentTimeMillis();
      removeCommand(pausa);
      addCommand(jugar);
      addCommand(creditos);
      juego_pausado = true;
      timer.cancel();
      timer = null;
    }
    else if (command.getCommandType() == Command.HELP) {
      Display.getDisplay(PingPong.getInstance()).setCurrent(aCreditos);
      new Thread() {
        public void run() {
          try {
            final String url =
                "/org/politecnic/midlets/games/pingpongcreditos.wav";
            InputStream is = this.getClass().getResourceAsStream(url);
            Player p = Manager.createPlayer(is, "audio/x-wav");
            p.start();
          }
          catch (Exception ex) {
            ex.printStackTrace();
          }
        }
      }.start();
    }
  }

  /**
   *
   * @return String
   */
  private String tiempoTranscurrido() {
    // tiempo transcurrido
    long tiempo_actual = System.currentTimeMillis();
    tiempo_transcurrido = tiempo_actual - tiempo_inicial;
    tiempo_transcurrido -= tiempo_total_en_pausa;
    int horas = (int) (tiempo_transcurrido / 3600000);
    tiempo_transcurrido -= horas * 3600000;
    int minutos = (int) (tiempo_transcurrido / 60000);
    tiempo_transcurrido -= minutos * 60000;
    int segundos = (int) (tiempo_transcurrido / 1000);
    StringBuffer msg = new StringBuffer("Tiempo transcurrido: ");
    if (horas < 10) {
      msg.append("0");
    }
    msg.append(horas);
    msg.append(":");
    if (minutos < 10) {
      msg.append("0");
    }
    msg.append(minutos);
    msg.append(":");
    if (segundos < 10) {
      msg.append("0");
    }
    msg.append(segundos);
    return msg.toString();
  }

  protected void paint(Graphics g) {
    g.translate(0, 0);
    // pintamos el titulo
    g.setColor(0x0000ff);
    g.fillRoundRect(margen_lat, despl, ancho - margen_lat * 2,
               margen_sup - despl * 3, 15, 15); // width y height al final
    g.setColor(0x000000);
    g.drawRoundRect(margen_lat, despl, ancho - margen_lat * 2,
               margen_sup - despl * 3, 15, 15);
    g.setColor(0xffffff);
    // !!! salta una excepcion IllegalArgumentEception
    g.drawString(titulo, (ancho - longitud_titulo) / 2,
                 margen_sup - despl * 3 - 1,
                 g.BASELINE);
//    g.drawString(titulo, );
    // pintamos el campo
    g.setColor(color_fondo);
    g.fillRect(margen_lat, margen_sup, ancho - margen_lat * 2,
               alto - margen_sup - margen_inf);
    g.setColor(color_primer_plano);
    g.drawRect(margen_lat, margen_sup, ancho - margen_lat * 2,
               alto - margen_sup - margen_inf);
    /// pintamos la linea del medio
    g.setStrokeStyle(g.DOTTED);
    g.drawLine(ancho / 2, margen_sup, ancho / 2, alto - margen_inf);
    g.setStrokeStyle(g.SOLID);
    // pintamos la raqueta pda, izda solo cuando es el turno del pda

    int distancia = Math.abs(y1_raqueta_pda - y_pelota);
    if (incremento_x < 0 && distancia >= 0 && distancia <= diametro_pelota ||
        (incremento_x < 0 && x_pelota < ancho / 2)) {
      turno_pda = true;
    }
    if (turno_pda) {
      y1_raqueta_pda = margen_sup + y_raqueta_pda -
          longitud_raqueta_medios;
      // ajustes sobre y1_raqueta_pda para que no se salga media raqueta
      if (y1_raqueta_pda < margen_sup) {
        y1_raqueta_pda = margen_sup;
      }
      else if (y1_raqueta_pda + longitud_raqueta > margen_sup + altura_campo) {
        y1_raqueta_pda = margen_sup + altura_campo - longitud_raqueta;
      }
      y2_raqueta_pda = y1_raqueta_pda + longitud_raqueta;
    }
    g.drawLine(x_raqueta_pda, y1_raqueta_pda, x_raqueta_pda, y2_raqueta_pda);
    // pintamos la raqueta humano, dcha
    y1_raqueta_humano = margen_sup + y_raqueta_humano -
        longitud_raqueta_medios;
    y2_raqueta_humano = y1_raqueta_humano + longitud_raqueta;
    g.drawLine(x_raqueta_humano, y1_raqueta_humano, x_raqueta_humano,
               y2_raqueta_humano);

    // pintamos la pelota
    if (y_pelota < margen_sup) {
      y_pelota = margen_sup;
    }
    if (y_pelota + diametro_pelota > margen_sup + altura_campo) {
      y_pelota = margen_sup + altura_campo - diametro_pelota;
    }
    g.fillArc(x_pelota, y_pelota, diametro_pelota, diametro_pelota, 0, 360);
    // pintamos el marcador
    g.translate(0, alto - margen_inf);
    g.setColor(0x00ff00);
    g.fillRect(margen_lat, margen_sup / 2, anchura_campo, altura_marcador);
    g.setColor(0x000000);
    g.drawRect(margen_lat, margen_sup / 2, anchura_campo / 2 - 1,
               altura_marcador);
    g.drawRect(margen_lat + anchura_campo / 2 + 1, margen_sup / 2,
               anchura_campo / 2 - 1, altura_marcador);
    g.setColor(0xc0c0c0);
    g.drawLine(ancho / 2, margen_sup / 2, ancho / 2,
               margen_sup / 2 + altura_marcador);
    g.setColor(0xff0000);
    int y = (altura_marcador / 2 + altura_fuente / 2) + margen_sup / 2 - 2;
    // pda
    g.drawString(jugador1 + ": " + marcador_pda, margen_lat + despl * 4, y,
                 g.BASELINE);
    // humano
    g.drawString(jugador2 + ": " + marcador_humano, ancho / 2 + despl * 4, y,
                 g.BASELINE);
    // poner triangulo en el jugador que tiene el turno
    if (incremento_x > 0) { // tiene el turno humano
      // quito triuangulo pda
      g.setColor(0xc0c0c0);
      g.fillTriangle(ancho / 2 - anchura_campo / 4, 1,
                     ancho / 2 - anchura_campo / 4 + despl, despl + 1,
                     ancho / 2 - anchura_campo / 4 - despl, despl + 1);
      // pongo triuangulo humano
      g.setColor(0xff0000);
      g.fillTriangle(ancho / 2 + anchura_campo / 4, 1,
                     ancho / 2 + anchura_campo / 4 + despl, despl + 1,
                     ancho / 2 + anchura_campo / 4 - despl, despl + 1);
    }
    else { // tiene el turno pda
      // quito triangulo humano
      g.setColor(0xc0c0c0);
      g.fillTriangle(ancho / 2 + anchura_campo / 4, 1,
                     ancho / 2 + anchura_campo / 4 + despl, despl + 1,
                     ancho / 2 + anchura_campo / 4 - despl, despl + 1);
      // pongo triuangulo pda
      g.setColor(0xff0000);
      g.fillTriangle(ancho / 2 - anchura_campo / 4, 1,
                     ancho / 2 - anchura_campo / 4 + despl, despl + 1,
                     ancho / 2 - anchura_campo / 4 - despl, despl + 1);
    }
    // poner tiempo transcurrido si el juego no esta pausado
    g.setColor(0x8080c0);
    y = margen_sup / 2 + altura_marcador + despl * 2;
    g.fillRect(margen_lat, y, anchura_campo, altura_marcador / 2);
    g.setColor(0xc0c0c0);
    if (juego_iniciado && !juego_pausado) {
      cadena_tiempo_transcurrido = tiempoTranscurrido();
    }
    int longitud_t = fuente.stringWidth(cadena_tiempo_transcurrido);
    int x = (ancho - longitud_t) / 2;
    g.drawString(cadena_tiempo_transcurrido, x, y + altura_marcador / 2 - 2,
                 g.BASELINE);

    // quitar game over
    if (juego_nuevo) {
      juego_nuevo = false;
      g.setColor(0xc0c0c0);
      y = margen_sup / 2 + altura_marcador + despl * 2;
      g.fillRect(margen_lat, y, anchura_campo, altura_marcador / 2);
    }
    if (fin_de_juego) {

      if (!game_over_dicho) {
        game_over_dicho = true;
        new Thread() {
          public void run() {
            try {
              final String url = "/org/politecnic/midlets/games/gameover.wav";
              InputStream is = this.getClass().getResourceAsStream(url);
              Player p = Manager.createPlayer(is, "audio/x-wav");
              p.start();
            }
            catch (Exception ex) {
              ex.printStackTrace();
            }

          }
        }.start();
      }
      g.setColor(0xff0000);
      y = margen_sup / 2 + altura_marcador + despl * 2;
      g.fillRect(margen_lat, y, anchura_campo, altura_marcador / 2);
      g.setColor(0xc0c0c0);
      x = (ancho - longitud_titulo_final_de_juego) / 2;
      g.drawString(tituo_final_de_juego, x, y + altura_marcador / 2 - 2,
                   g.BASELINE);

      timer.cancel();
      timer = null;
      removeCommand(pausa);
      addCommand(jugar);
      addCommand(creditos);
    }
  }

  /**
   *
   * @param tecla int
   */
  private void processKey(int tecla) {
    switch (tecla) {
      case UP:
        y_raqueta_humano -= longitud_raqueta_medios;
        y_raqueta_humano = Math.max(longitud_raqueta_medios, y_raqueta_humano);
        break;
      case DOWN:
        y_raqueta_humano += longitud_raqueta_medios;
        y_raqueta_humano = Math.min(altura_campo - longitud_raqueta_medios,
                                    y_raqueta_humano);
        break;
      case RIGHT:
        y_raqueta_humano = altura_campo - longitud_raqueta_medios;
        break;
      case LEFT:
        y_raqueta_humano = longitud_raqueta_medios;
        break;
      case FIRE:
        y_raqueta_humano = y_pelota - margen_sup;
        y_raqueta_humano = Math.max(longitud_raqueta_medios, y_raqueta_humano);
        y_raqueta_humano = Math.min(altura_campo - longitud_raqueta_medios,
                                    y_raqueta_humano);
        break;
    }
    repaint();
  }

  /**
   * keyPressed
   *
   * @param keyCode int
   */
  protected void keyPressed(int keyCode) {
    processKey(getGameAction(keyCode));
  }

  /**
   * keyRepeated
   *
   * @param keyCode int
   */
  protected void keyRepeated(int keyCode) {
    processKey(getGameAction(keyCode));
  }

  /**
   *
   * @param x int
   * @param y int
   */
  private void processPointer(int x, int y) {
    if (y >= margen_sup && y <= alto - margen_inf) {
      y = (y < margen_sup + longitud_raqueta_medios) ?
          margen_sup + longitud_raqueta_medios : y;
      y = (y > alto - margen_inf - longitud_raqueta_medios) ?
          alto - margen_inf - longitud_raqueta_medios : y;
      y_raqueta_humano = y - margen_sup;
      repaint();
    }
  }

  /**
   * pointerDragged
   *
   * @param x int
   * @param y int
   */
  protected void pointerDragged(int x, int y) {
    processPointer(x, y);
  }

  /**
   * pointerPressed
   *
   * @param x int
   * @param y int
   */
  protected void pointerPressed(int x, int y) {
    processPointer(x, y);
  }

  /**
   * <p>Title: </p>
   * <p>Description: </p>
   * <p>Comments: </p>
   * <p>Date: </p>
   * @author Pep Mendez
   * @version 1.0
   */
  private class MuevePelota
      extends java.util.TimerTask {

    public void run() {
      try {
        // colision con raqueta humano
        if (x_pelota >= x_raqueta_humano - diametro_pelota &&
            y_pelota <= y2_raqueta_humano && y_pelota >= y1_raqueta_humano) {
          incremento_x = -diametro_pelota;
          raquetazos++;
          Manager.playTone(100, 100, 50); // nota(0,127), duracion (ms),volumen (0,100)
//          Thread.sleep(250);
          if (raquetazos > limite_raquetazos &&
              retardo_temporizador > limite_retardo_temporizador) {
            raquetazos = 0;
            retardo_temporizador += incremento_retardo_temporizador;
            longitud_raqueta += incremento_longitud_raqueta;
            longitud_raqueta_medios = longitud_raqueta / 2;
            timer.cancel();
            timer = new Timer();
            timer.schedule(new MuevePelota(), 0, retardo_temporizador); // intervalos en ms
          }
        }
        // colision con raqueta pda
        if (x_pelota <= x_raqueta_pda + diametro_pelota &&
            y_pelota <= y2_raqueta_pda && y_pelota >= y1_raqueta_pda) {
          incremento_x = diametro_pelota;
          raquetazos++;
          turno_pda = false;
          Manager.playTone(100, 100, 50); // nota(0,127), duracion (ms),volumen (0,100)
        }
        // se sale por la derecha PIERDE HUMANO
        if (x_pelota >= ancho - margen_lat - diametro_pelota) {
          incremento_x = diametro_pelota;
          marcador_humano++;
          x_pelota = ancho / 2 + despl;
          y_pelota = new Random().nextInt(altura_campo);
          Manager.playTone(50, 150, 75); // nota(0,127), duracion (ms),volumen (0,100)
          Thread.sleep(175);
          if (marcador_humano >= limite_juego) {
            fin_de_juego = true;
          }
        }
        // se sale por la izda PIERDE PDA
        if (x_pelota <= margen_lat) {
          incremento_x = -diametro_pelota;
          marcador_pda++;
          x_pelota = ancho / 2 - despl;
          y_pelota = new Random().nextInt(altura_campo);
          turno_pda = true;
          Manager.playTone(50, 150, 75); // nota(0,127), duracion (ms),volumen (0,100)
          Thread.sleep(175);
          if (marcador_pda >= limite_juego) {
            fin_de_juego = true;
          }
        }
        // se sale por abajo
        if (y_pelota >= alto - margen_inf - diametro_pelota) {
          incremento_y = -diametro_pelota;
        }
        // se sale por arriba
        if (y_pelota <= margen_sup) {
          incremento_y = diametro_pelota;
        }
        x_pelota += incremento_x;
        y_pelota += incremento_y;
        // calculo del offset
        y_raqueta_pda = y_pelota - margen_sup; // y_raqueta_pda va de 0 a altura_campo
        repaint();
      }
      catch (Exception e) {
      }
    }
  }
}
