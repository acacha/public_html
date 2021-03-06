package org.nico.midlets.games.pingpong.controller;

import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;

import org.nico.midlets.games.pingpong.interfaces.IPingPongConstants;
import org.nico.midlets.games.pingpong.view.PingPongDisplay;
import org.nico.midlets.games.pingpong.view.PingPongSplash;
import org.nico.midlets.multimedia.PlayMelodyThread;
import org.nico.midlets.multimedia.PlayThread;

/**
 * <p>Title: Ping Pong Game </p>
 * <p>Description: Ping pong interactivo para dispositivos moviles</p>
 * <p>Comments: CLDL 1.1 MIDP 2.0</p>
 * <p>Media Supported Protocols: device, http, file and capture</p>
 * <p>Supported Content Type: audio/x-tone-seq, audio/x-wav, audio/midi, audio/sp_midi, image/gif, video/mpeg and video/vnd.sun.rgb565
 * <p>Date: 12/03/06 </p>
 * @author Pep Mendez
 * @version 1.0
 */
public class PingPong
    extends MIDlet implements IPingPongConstants {
  // MIDlet, componente para dispositivos moviles
  private static PingPong instance;
  // Display, clase que representa el controlador de la pantalla y dispositivos de entrada del sistema en un dispositivo movil
  private Display display = null;
  // Displayable, son los objetos con capacidad de ser visibles en un objeto Display
  private PingPongDisplay displayable = new PingPongDisplay(true);
  private final boolean VERSION_FINAL = false;

  public PingPong() {
    instance = this;
  }

  public void startApp() {
    if (display == null) {
      display = Display.getDisplay(this);
      new PingPongSplash(display, displayable);
    }
//    new Thread(new PlayThread(PING_PONG_GAME_URL)).start();
    if (VERSION_FINAL) {
      // toca melodia, del libro j2me java 2 micro edition completa
      new Thread(new PlayMelodyThread(MELODIA_COMPLETA)).start();
    }
    else {
      // toca melodia, del libro j2me java 2 micro edition reducida
      new Thread(new PlayMelodyThread(MELODIA_CORTA)).start();
    }

  }

  public void pauseApp() {
  }

  public void destroyApp(boolean unconditional) {
  }

  public static void quitApp() {
    instance.destroyApp(true);
    instance.notifyDestroyed();
    instance = null;
  }

  public static PingPong getInstance() {
    return instance;
  }

  public Display getDisplay() {
    return display;
  }

  public PingPongDisplay getDisplayable() {
    return displayable;
  }

}
