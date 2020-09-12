/*
 * CorreuElectronicMidlet.java
 *
 * Created on 5 / abril / 2006, 18:18
 */

package edu.escolatreball.correuelectronic;

import java.util.Calendar;
import java.util.Date;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/**
 *
 * @author sergi.tur
 */
public class CorreuElectronicMidlet extends MIDlet implements CommandListener {
    
    /**
     * Creates a new instance of CorreuElectronicMidlet
     */
    public CorreuElectronicMidlet() {
    }
    
    private Form FrmDadesCorreu;//GEN-BEGIN:MVDFields
    private StringItem helloStringItem;
    private Command exitCommand;
    private org.netbeans.microedition.lcdui.SplashScreen splashScreenLogoEscolaTreball;
    private List LstMenu;
    private Alert alertOpcioNoImplementada;
    private ImageItem imageItem1;
    private TextField txtFieldDestinatari;
    private TextField txtFieldTema1;
    private Spacer spacer1;
    private Command cancelCommand1;
    private Command CmdEscriureText;
    private TextBox txtBoxMissatge;
    private Command EnviarMissatge;
    private org.netbeans.microedition.lcdui.WaitScreen waitScreenEnviantMissatge;
    private Alert alertErrorEnviar;
    private Alert alertOkEnviar;
    private org.netbeans.microedition.util.SimpleCancellableTask Esperar;
    private Command exitCommand1;
    private Command okCommand1;
    private List LstMissatges;
    private Form frmMissatge;
    private TextField txtFieldDe;
    private TextField txtFieldTema;
    private Spacer spacer2;
    private DateField dateField1;
    private Command CmdLlegirMissatge;
    private TextBox txtBoxLlegirMissatge;
    private Image logoEscolaTreballPantallaInici;
    private Ticker TickerSplashScreen;//GEN-END:MVDFields
    
//GEN-LINE:MVDMethods

    /** This method initializes UI of the application.//GEN-BEGIN:MVDInitBegin
     */
    private void initialize() {//GEN-END:MVDInitBegin
        // Insert pre-init code here
        getDisplay().setCurrent(get_splashScreenLogoEscolaTreball());//GEN-LINE:MVDInitInit
        // Insert post-init code here
    }//GEN-LINE:MVDInitEnd
    
    /** Called by the system to indicate that a command has been invoked on a particular displayable.//GEN-BEGIN:MVDCABegin
     * @param command the Command that ws invoked
     * @param displayable the Displayable on which the command was invoked
     */
    public void commandAction(Command command, Displayable displayable) {//GEN-END:MVDCABegin
        // Insert global pre-action code here
        if (displayable == LstMenu) {//GEN-BEGIN:MVDCABody
            if (command == LstMenu.SELECT_COMMAND) {
                switch (get_LstMenu().getSelectedIndex()) {
                    case 0://GEN-END:MVDCABody
                        // Insert pre-action code here
                        getDisplay().setCurrent(get_FrmDadesCorreu());//GEN-LINE:MVDCAAction12
                        // Insert post-action code here
                        break;//GEN-BEGIN:MVDCACase12
                    case 1://GEN-END:MVDCACase12
                        // Insert pre-action code here
                        getDisplay().setCurrent(get_LstMissatges());//GEN-LINE:MVDCAAction14
                        // Insert post-action code here
                        break;//GEN-BEGIN:MVDCACase14
                    case 2://GEN-END:MVDCACase14
                        // Insert pre-action code here
                        getDisplay().setCurrent(get_alertOpcioNoImplementada(), get_LstMenu());//GEN-LINE:MVDCAAction16
                        // Insert post-action code here
                        break;//GEN-BEGIN:MVDCACase16
                }
            } else if (command == exitCommand) {//GEN-END:MVDCACase16
                // Insert pre-action code here
                exitMIDlet();//GEN-LINE:MVDCAAction45
                // Insert post-action code here
            }//GEN-BEGIN:MVDCACase45
        } else if (displayable == txtBoxMissatge) {
            if (command == EnviarMissatge) {//GEN-END:MVDCACase45
                // Insert pre-action code here
                getDisplay().setCurrent(get_waitScreenEnviantMissatge());//GEN-LINE:MVDCAAction34
                // Insert post-action code here
            } else if (command == cancelCommand1) {//GEN-LINE:MVDCACase34
                // Insert pre-action code here
                getDisplay().setCurrent(get_LstMenu());//GEN-LINE:MVDCAAction47
                // Insert post-action code here
            }//GEN-BEGIN:MVDCACase47
        } else if (displayable == FrmDadesCorreu) {
            if (command == CmdEscriureText) {//GEN-END:MVDCACase47
                // Insert pre-action code here
                getDisplay().setCurrent(get_txtBoxMissatge());//GEN-LINE:MVDCAAction31
                // Insert post-action code here
            } else if (command == cancelCommand1) {//GEN-LINE:MVDCACase31
                // Insert pre-action code here
                getDisplay().setCurrent(get_LstMenu());//GEN-LINE:MVDCAAction29
                // Insert post-action code here
            }//GEN-BEGIN:MVDCACase29
        } else if (displayable == LstMissatges) {
            if (command == LstMissatges.SELECT_COMMAND) {
                switch (get_LstMissatges().getSelectedIndex()) {
                    case 0://GEN-END:MVDCACase29
                        // Insert pre-action code here
                        getDisplay().setCurrent(get_frmMissatge());//GEN-LINE:MVDCAAction51
                        // Insert post-action code here
                        break;//GEN-BEGIN:MVDCACase51
                    case 1://GEN-END:MVDCACase51
                        // Insert pre-action code here
                        getDisplay().setCurrent(get_frmMissatge());//GEN-LINE:MVDCAAction53
                        // Insert post-action code here
                        break;//GEN-BEGIN:MVDCACase53
                    case 2://GEN-END:MVDCACase53
                        // Insert pre-action code here
                        getDisplay().setCurrent(get_frmMissatge());//GEN-LINE:MVDCAAction55
                        // Insert post-action code here
                        break;//GEN-BEGIN:MVDCACase55
                }
            } else if (command == cancelCommand1) {//GEN-END:MVDCACase55
                // Insert pre-action code here
                getDisplay().setCurrent(get_LstMenu());//GEN-LINE:MVDCAAction67
                // Insert post-action code here
            }//GEN-BEGIN:MVDCACase67
        } else if (displayable == frmMissatge) {
            if (command == CmdLlegirMissatge) {//GEN-END:MVDCACase67
                // Insert pre-action code here
                getDisplay().setCurrent(get_txtBoxLlegirMissatge());//GEN-LINE:MVDCAAction63
                // Insert post-action code here
            } else if (command == cancelCommand1) {//GEN-LINE:MVDCACase63
                // Insert pre-action code here
                getDisplay().setCurrent(get_LstMissatges());//GEN-LINE:MVDCAAction62
                // Insert post-action code here
                
            }//GEN-BEGIN:MVDCACase62
        } else if (displayable == txtBoxLlegirMissatge) {
            if (command == okCommand1) {//GEN-END:MVDCACase62
                // Insert pre-action code here
                getDisplay().setCurrent(get_LstMissatges());//GEN-LINE:MVDCAAction66
                // Insert post-action code here
            } else if (command == cancelCommand1) {//GEN-LINE:MVDCACase66
                // Insert pre-action code here
                getDisplay().setCurrent(get_frmMissatge());//GEN-LINE:MVDCAAction68
                // Insert post-action code here
            }//GEN-BEGIN:MVDCACase68
        } else if (displayable == alertOpcioNoImplementada) {
            if (command == okCommand1) {//GEN-END:MVDCACase68
                // Insert pre-action code here
                getDisplay().setCurrent(get_LstMenu());//GEN-LINE:MVDCAAction69
                // Insert post-action code here
            }//GEN-BEGIN:MVDCACase69
        }//GEN-END:MVDCACase69
        // Insert global post-action code here
}//GEN-LINE:MVDCAEnd
    
    /**
     * This method should return an instance of the display.
     */
    public Display getDisplay() {//GEN-FIRST:MVDGetDisplay
        return Display.getDisplay(this);
    }//GEN-LAST:MVDGetDisplay
    
    /**
     * This method should exit the midlet.
     */
    public void exitMIDlet() {//GEN-FIRST:MVDExitMidlet
        getDisplay().setCurrent(null);
        destroyApp(true);
        notifyDestroyed();
    }//GEN-LAST:MVDExitMidlet
    
    /** This method returns instance for FrmDadesCorreu component and should be called instead of accessing FrmDadesCorreu field directly.//GEN-BEGIN:MVDGetBegin2
     * @return Instance for FrmDadesCorreu component
     */
    public Form get_FrmDadesCorreu() {
        if (FrmDadesCorreu == null) {//GEN-END:MVDGetBegin2
            // Insert pre-init code here
            FrmDadesCorreu = new Form(null, new Item[] {//GEN-BEGIN:MVDGetInit2
                get_helloStringItem(),
                get_txtFieldDestinatari(),
                get_txtFieldTema1(),
                get_imageItem1(),
                get_spacer1()
            });
            FrmDadesCorreu.addCommand(get_cancelCommand1());
            FrmDadesCorreu.addCommand(get_CmdEscriureText());
            FrmDadesCorreu.setCommandListener(this);//GEN-END:MVDGetInit2
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd2
        return FrmDadesCorreu;
    }//GEN-END:MVDGetEnd2
    
    /** This method returns instance for helloStringItem component and should be called instead of accessing helloStringItem field directly.//GEN-BEGIN:MVDGetBegin4
     * @return Instance for helloStringItem component
     */
    public StringItem get_helloStringItem() {
        if (helloStringItem == null) {//GEN-END:MVDGetBegin4
            // Insert pre-init code here
            helloStringItem = new StringItem("Escolliu la persona a la que voleu enviar el missatge i el tema del missatge:", "");//GEN-LINE:MVDGetInit4
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd4
        return helloStringItem;
    }//GEN-END:MVDGetEnd4
    
    /** This method returns instance for exitCommand component and should be called instead of accessing exitCommand field directly.//GEN-BEGIN:MVDGetBegin5
     * @return Instance for exitCommand component
     */
    public Command get_exitCommand() {
        if (exitCommand == null) {//GEN-END:MVDGetBegin5
            // Insert pre-init code here
            exitCommand = new Command("Sortir", Command.EXIT, 1);//GEN-LINE:MVDGetInit5
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd5
        return exitCommand;
    }//GEN-END:MVDGetEnd5

    /** This method returns instance for splashScreenLogoEscolaTreball component and should be called instead of accessing splashScreenLogoEscolaTreball field directly.//GEN-BEGIN:MVDGetBegin6
     * @return Instance for splashScreenLogoEscolaTreball component
     */
    public org.netbeans.microedition.lcdui.SplashScreen get_splashScreenLogoEscolaTreball() {
        if (splashScreenLogoEscolaTreball == null) {//GEN-END:MVDGetBegin6
            // Insert pre-init code here
            splashScreenLogoEscolaTreball = new org.netbeans.microedition.lcdui.SplashScreen(getDisplay());//GEN-BEGIN:MVDGetInit6
            splashScreenLogoEscolaTreball.setTitle("Correu Electr\u00F2nic");
            splashScreenLogoEscolaTreball.setTicker(get_TickerSplashScreen());
            splashScreenLogoEscolaTreball.setText("Correu Electr\u00F2nic");
            splashScreenLogoEscolaTreball.setImage(get_logoEscolaTreballPantallaInici());
            splashScreenLogoEscolaTreball.setNextDisplayable(get_LstMenu());//GEN-END:MVDGetInit6
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd6
        return splashScreenLogoEscolaTreball;
    }//GEN-END:MVDGetEnd6
 
    /** This method returns instance for LstMenu component and should be called instead of accessing LstMenu field directly.//GEN-BEGIN:MVDGetBegin9
     * @return Instance for LstMenu component
     */
    public List get_LstMenu() {
        if (LstMenu == null) {//GEN-END:MVDGetBegin9
            // Insert pre-init code here
            LstMenu = new List(null, Choice.IMPLICIT, new String[] {//GEN-BEGIN:MVDGetInit9
                "Enviar missatge",
                "Llegir missatges",
                "Configurar"
            }, new Image[] {
                null,
                null,
                null
            });
            LstMenu.addCommand(get_exitCommand());
            LstMenu.setCommandListener(this);
            LstMenu.setSelectedFlags(new boolean[] {
                false,
                false,
                false
            });//GEN-END:MVDGetInit9
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd9
        return LstMenu;
    }//GEN-END:MVDGetEnd9

    /** This method returns instance for alertOpcioNoImplementada component and should be called instead of accessing alertOpcioNoImplementada field directly.//GEN-BEGIN:MVDGetBegin17
     * @return Instance for alertOpcioNoImplementada component
     */
    public Alert get_alertOpcioNoImplementada() {
        if (alertOpcioNoImplementada == null) {//GEN-END:MVDGetBegin17
            // Insert pre-init code here
            alertOpcioNoImplementada = new Alert("Avis", "Perdoneu les mol\u00E8sties per\u00F2 aquesta opci\u00F3 encara no esta implementada...", null, AlertType.INFO);//GEN-BEGIN:MVDGetInit17
            alertOpcioNoImplementada.addCommand(get_okCommand1());
            alertOpcioNoImplementada.setCommandListener(this);
            alertOpcioNoImplementada.setTimeout(10000);//GEN-END:MVDGetInit17
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd17
        return alertOpcioNoImplementada;
    }//GEN-END:MVDGetEnd17
 
    /** This method returns instance for imageItem1 component and should be called instead of accessing imageItem1 field directly.//GEN-BEGIN:MVDGetBegin22
     * @return Instance for imageItem1 component
     */
    public ImageItem get_imageItem1() {
        if (imageItem1 == null) {//GEN-END:MVDGetBegin22
            // Insert pre-init code here
            imageItem1 = new ImageItem(" ", null, Item.LAYOUT_DEFAULT, null);//GEN-LINE:MVDGetInit22
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd22
        return imageItem1;
    }//GEN-END:MVDGetEnd22

    /** This method returns instance for txtFieldDestinatari component and should be called instead of accessing txtFieldDestinatari field directly.//GEN-BEGIN:MVDGetBegin23
     * @return Instance for txtFieldDestinatari component
     */
    public TextField get_txtFieldDestinatari() {
        if (txtFieldDestinatari == null) {//GEN-END:MVDGetBegin23
            // Insert pre-init code here
            txtFieldDestinatari = new TextField("destinatari:", null, 120, TextField.EMAILADDR);//GEN-LINE:MVDGetInit23
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd23
        return txtFieldDestinatari;
    }//GEN-END:MVDGetEnd23

    /** This method returns instance for txtFieldTema1 component and should be called instead of accessing txtFieldTema1 field directly.//GEN-BEGIN:MVDGetBegin24
     * @return Instance for txtFieldTema1 component
     */
    public TextField get_txtFieldTema1() {
        if (txtFieldTema1 == null) {//GEN-END:MVDGetBegin24
            // Insert pre-init code here
            txtFieldTema1 = new TextField("tema:", null, 120, TextField.ANY);//GEN-LINE:MVDGetInit24
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd24
        return txtFieldTema1;
    }//GEN-END:MVDGetEnd24

    /** This method returns instance for spacer1 component and should be called instead of accessing spacer1 field directly.//GEN-BEGIN:MVDGetBegin25
     * @return Instance for spacer1 component
     */
    public Spacer get_spacer1() {
        if (spacer1 == null) {//GEN-END:MVDGetBegin25
            // Insert pre-init code here
            spacer1 = new Spacer(1000, 1);//GEN-LINE:MVDGetInit25
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd25
        return spacer1;
    }//GEN-END:MVDGetEnd25
 
    /** This method returns instance for cancelCommand1 component and should be called instead of accessing cancelCommand1 field directly.//GEN-BEGIN:MVDGetBegin27
     * @return Instance for cancelCommand1 component
     */
    public Command get_cancelCommand1() {
        if (cancelCommand1 == null) {//GEN-END:MVDGetBegin27
            // Insert pre-init code here
            cancelCommand1 = new Command("Cancel\u00B7lar", Command.CANCEL, 1);//GEN-LINE:MVDGetInit27
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd27
        return cancelCommand1;
    }//GEN-END:MVDGetEnd27

    /** This method returns instance for CmdEscriureText component and should be called instead of accessing CmdEscriureText field directly.//GEN-BEGIN:MVDGetBegin30
     * @return Instance for CmdEscriureText component
     */
    public Command get_CmdEscriureText() {
        if (CmdEscriureText == null) {//GEN-END:MVDGetBegin30
            // Insert pre-init code here
            CmdEscriureText = new Command("Escriure", "Escriure Missatge", Command.SCREEN, 1);//GEN-LINE:MVDGetInit30
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd30
        return CmdEscriureText;
    }//GEN-END:MVDGetEnd30

    /** This method returns instance for txtBoxMissatge component and should be called instead of accessing txtBoxMissatge field directly.//GEN-BEGIN:MVDGetBegin32
     * @return Instance for txtBoxMissatge component
     */
    public TextBox get_txtBoxMissatge() {
        if (txtBoxMissatge == null) {//GEN-END:MVDGetBegin32
            // Insert pre-init code here
            txtBoxMissatge = new TextBox("Missatge Correu Electr\u00F2nic:", "", 120, TextField.ANY);//GEN-BEGIN:MVDGetInit32
            txtBoxMissatge.addCommand(get_EnviarMissatge());
            txtBoxMissatge.addCommand(get_cancelCommand1());
            txtBoxMissatge.setCommandListener(this);//GEN-END:MVDGetInit32
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd32
        return txtBoxMissatge;
    }//GEN-END:MVDGetEnd32

    /** This method returns instance for EnviarMissatge component and should be called instead of accessing EnviarMissatge field directly.//GEN-BEGIN:MVDGetBegin33
     * @return Instance for EnviarMissatge component
     */
    public Command get_EnviarMissatge() {
        if (EnviarMissatge == null) {//GEN-END:MVDGetBegin33
            // Insert pre-init code here
            EnviarMissatge = new Command("Enviar", "Enviar Missatge", Command.OK, 1);//GEN-LINE:MVDGetInit33
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd33
        return EnviarMissatge;
    }//GEN-END:MVDGetEnd33

    /** This method returns instance for waitScreenEnviantMissatge component and should be called instead of accessing waitScreenEnviantMissatge field directly.//GEN-BEGIN:MVDGetBegin35
     * @return Instance for waitScreenEnviantMissatge component
     */
    public org.netbeans.microedition.lcdui.WaitScreen get_waitScreenEnviantMissatge() {
        if (waitScreenEnviantMissatge == null) {//GEN-END:MVDGetBegin35
            // Insert pre-init code here
            waitScreenEnviantMissatge = new org.netbeans.microedition.lcdui.WaitScreen(getDisplay());//GEN-BEGIN:MVDGetInit35
            waitScreenEnviantMissatge.setNextDisplayable(get_alertOkEnviar(), get_LstMenu());
            waitScreenEnviantMissatge.setFailureDisplayable(get_alertErrorEnviar(), get_txtBoxMissatge());
            waitScreenEnviantMissatge.setTitle("Enviant missatge");
            waitScreenEnviantMissatge.setText("Enviant missatge ...");
            waitScreenEnviantMissatge.setTask(get_Esperar());//GEN-END:MVDGetInit35
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd35
        return waitScreenEnviantMissatge;
    }//GEN-END:MVDGetEnd35

    /** This method returns instance for alertErrorEnviar component and should be called instead of accessing alertErrorEnviar field directly.//GEN-BEGIN:MVDGetBegin38
     * @return Instance for alertErrorEnviar component
     */
    public Alert get_alertErrorEnviar() {
        if (alertErrorEnviar == null) {//GEN-END:MVDGetBegin38
            // Insert pre-init code here
            alertErrorEnviar = new Alert(null, "No s\'ha pogut enviar el missatge! Torni-ho a intentar m\u00E9s tard", null, AlertType.INFO);//GEN-BEGIN:MVDGetInit38
            alertErrorEnviar.setTimeout(-2);//GEN-END:MVDGetInit38
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd38
        return alertErrorEnviar;
    }//GEN-END:MVDGetEnd38

    /** This method returns instance for alertOkEnviar component and should be called instead of accessing alertOkEnviar field directly.//GEN-BEGIN:MVDGetBegin39
     * @return Instance for alertOkEnviar component
     */
    public Alert get_alertOkEnviar() {
        if (alertOkEnviar == null) {//GEN-END:MVDGetBegin39
            // Insert pre-init code here
            alertOkEnviar = new Alert(null, "Missatge Enviat Correctament!", null, AlertType.INFO);//GEN-BEGIN:MVDGetInit39
            alertOkEnviar.setTimeout(-2);//GEN-END:MVDGetInit39
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd39
        return alertOkEnviar;
    }//GEN-END:MVDGetEnd39
 
    /** This method returns instance for Esperar component and should be called instead of accessing Esperar field directly.//GEN-BEGIN:MVDGetBegin41
     * @return Instance for Esperar component
     */
    public org.netbeans.microedition.util.SimpleCancellableTask get_Esperar() {
        if (Esperar == null) {//GEN-END:MVDGetBegin41
            // Insert pre-init code here
            Esperar = new org.netbeans.microedition.util.SimpleCancellableTask();//GEN-BEGIN:MVDGetInit41
            Esperar.setExecutable(new org.netbeans.microedition.util.Executable() {
                public void execute() throws Exception {
                    synchronized (this) {
                        try {
                            wait(5000);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            });//GEN-END:MVDGetInit41
            // Insert post-init code here

        }//GEN-BEGIN:MVDGetEnd41
        return Esperar;
    }//GEN-END:MVDGetEnd41

    /** This method returns instance for exitCommand1 component and should be called instead of accessing exitCommand1 field directly.//GEN-BEGIN:MVDGetBegin43
     * @return Instance for exitCommand1 component
     */
    public Command get_exitCommand1() {
        if (exitCommand1 == null) {//GEN-END:MVDGetBegin43
            // Insert pre-init code here
            exitCommand1 = new Command("Exit", Command.EXIT, 1);//GEN-LINE:MVDGetInit43
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd43
        return exitCommand1;
    }//GEN-END:MVDGetEnd43

    /** This method returns instance for okCommand1 component and should be called instead of accessing okCommand1 field directly.//GEN-BEGIN:MVDGetBegin44
     * @return Instance for okCommand1 component
     */
    public Command get_okCommand1() {
        if (okCommand1 == null) {//GEN-END:MVDGetBegin44
            // Insert pre-init code here
            okCommand1 = new Command("Ok", Command.OK, 1);//GEN-LINE:MVDGetInit44
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd44
        return okCommand1;
    }//GEN-END:MVDGetEnd44

    /** This method returns instance for LstMissatges component and should be called instead of accessing LstMissatges field directly.//GEN-BEGIN:MVDGetBegin48
     * @return Instance for LstMissatges component
     */
    public List get_LstMissatges() {
        if (LstMissatges == null) {//GEN-END:MVDGetBegin48
            // Insert pre-init code here
            LstMissatges = new List("Missatges", Choice.IMPLICIT, new String[] {//GEN-BEGIN:MVDGetInit48
                "Missatge1",
                "Missatge2",
                "Missatge3"
            }, new Image[] {
                null,
                null,
                null
            });
            LstMissatges.addCommand(get_cancelCommand1());
            LstMissatges.setCommandListener(this);
            LstMissatges.setSelectedFlags(new boolean[] {
                false,
                false,
                false
            });//GEN-END:MVDGetInit48
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd48
        return LstMissatges;
    }//GEN-END:MVDGetEnd48

    /** This method returns instance for frmMissatge component and should be called instead of accessing frmMissatge field directly.//GEN-BEGIN:MVDGetBegin56
     * @return Instance for frmMissatge component
     */
    public Form get_frmMissatge() {
        if (frmMissatge == null) {//GEN-END:MVDGetBegin56
            // Insert pre-init code here
            frmMissatge = new Form("Missatge", new Item[] {//GEN-BEGIN:MVDGetInit56
                get_txtFieldDe(),
                get_txtFieldTema(),
                get_spacer2(),
                get_dateField1()
            });
            frmMissatge.addCommand(get_cancelCommand1());
            frmMissatge.addCommand(get_CmdLlegirMissatge());
            frmMissatge.setCommandListener(this);//GEN-END:MVDGetInit56
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd56
        return frmMissatge;
    }//GEN-END:MVDGetEnd56

    /** This method returns instance for txtFieldDe component and should be called instead of accessing txtFieldDe field directly.//GEN-BEGIN:MVDGetBegin57
     * @return Instance for txtFieldDe component
     */
    public TextField get_txtFieldDe() {
        if (txtFieldDe == null) {//GEN-END:MVDGetBegin57
            // Insert pre-init code here
            txtFieldDe = new TextField("de:", "pepito@gmail.com", 120, TextField.EMAILADDR);//GEN-LINE:MVDGetInit57
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd57
        return txtFieldDe;
    }//GEN-END:MVDGetEnd57

    /** This method returns instance for txtFieldTema component and should be called instead of accessing txtFieldTema field directly.//GEN-BEGIN:MVDGetBegin58
     * @return Instance for txtFieldTema component
     */
    public TextField get_txtFieldTema() {
        if (txtFieldTema == null) {//GEN-END:MVDGetBegin58
            // Insert pre-init code here
            txtFieldTema = new TextField("tema:", "Hey coneixes gmail?", 120, TextField.ANY);//GEN-LINE:MVDGetInit58
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd58
        return txtFieldTema;
    }//GEN-END:MVDGetEnd58

    /** This method returns instance for spacer2 component and should be called instead of accessing spacer2 field directly.//GEN-BEGIN:MVDGetBegin59
     * @return Instance for spacer2 component
     */
    public Spacer get_spacer2() {
        if (spacer2 == null) {//GEN-END:MVDGetBegin59
            // Insert pre-init code here
            spacer2 = new Spacer(1000, 1);//GEN-LINE:MVDGetInit59
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd59
        return spacer2;
    }//GEN-END:MVDGetEnd59

    /** This method returns instance for dateField1 component and should be called instead of accessing dateField1 field directly.//GEN-BEGIN:MVDGetBegin60
     * @return Instance for dateField1 component
     */
    public DateField get_dateField1() {
        if (dateField1 == null) {//GEN-END:MVDGetBegin60
            // Insert pre-init code here
            dateField1 = new DateField("Data:", DateField.DATE_TIME);//GEN-LINE:MVDGetInit60
            Date currentDate = new Date();
            
            dateField1.setDate(currentDate);
            /*Calendar cal = new GregorianCalendar();
    
            // Get the components of the time
            int hour12 = cal.get(Calendar.HOUR);            // 0..11
            int hour24 = cal.get(Calendar.HOUR_OF_DAY);     // 0..23
            int min = cal.get(Calendar.MINUTE);             // 0..59
            int sec = cal.get(Calendar.SECOND);             // 0..59
            int ms = cal.get(Calendar.MILLISECOND);         // 0..999
            int ampm = cal.get(Calendar.AM_PM);             // 0=AM, 1=PM
            
            Calendar cal = new GregorianCalendar();
    
            // Get the components of the date
            int era = cal.get(Calendar.ERA);               // 0=BC, 1=AD
            int year = cal.get(Calendar.YEAR);             // 2002
            int month = cal.get(Calendar.MONTH);           // 0=Jan, 1=Feb, ...
            int day = cal.get(Calendar.DAY_OF_MONTH);      // 1...
            int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 1=Sunday, 2=Monday, ...
            */
            
            
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd60
        return dateField1;
    }//GEN-END:MVDGetEnd60

    /** This method returns instance for CmdLlegirMissatge component and should be called instead of accessing CmdLlegirMissatge field directly.//GEN-BEGIN:MVDGetBegin61
     * @return Instance for CmdLlegirMissatge component
     */
    public Command get_CmdLlegirMissatge() {
        if (CmdLlegirMissatge == null) {//GEN-END:MVDGetBegin61
            // Insert pre-init code here
            CmdLlegirMissatge = new Command("Llegir", Command.SCREEN, 1);//GEN-LINE:MVDGetInit61
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd61
        return CmdLlegirMissatge;
    }//GEN-END:MVDGetEnd61

    /** This method returns instance for txtBoxLlegirMissatge component and should be called instead of accessing txtBoxLlegirMissatge field directly.//GEN-BEGIN:MVDGetBegin64
     * @return Instance for txtBoxLlegirMissatge component
     */
    public TextBox get_txtBoxLlegirMissatge() {
        if (txtBoxLlegirMissatge == null) {//GEN-END:MVDGetBegin64
            // Insert pre-init code here
            txtBoxLlegirMissatge = new TextBox("Missatge correu Electr\u00F2nic:", "Escolta avui he descobert gmail! \u00C9s una passada.......", 120, TextField.ANY);//GEN-BEGIN:MVDGetInit64
            txtBoxLlegirMissatge.addCommand(get_okCommand1());
            txtBoxLlegirMissatge.addCommand(get_cancelCommand1());
            txtBoxLlegirMissatge.setCommandListener(this);//GEN-END:MVDGetInit64
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd64
        return txtBoxLlegirMissatge;
    }//GEN-END:MVDGetEnd64

    /** This method returns instance for logoEscolaTreballPantallaInici component and should be called instead of accessing logoEscolaTreballPantallaInici field directly.//GEN-BEGIN:MVDGetBegin70
     * @return Instance for logoEscolaTreballPantallaInici component
     */
    public Image get_logoEscolaTreballPantallaInici() {
        if (logoEscolaTreballPantallaInici == null) {//GEN-END:MVDGetBegin70
            // Insert pre-init code here
            try {//GEN-BEGIN:MVDGetInit70
                logoEscolaTreballPantallaInici = Image.createImage("/edu/escolatreball/correuelectronic/logoEscolaDeTreballMobil.gif");
            } catch (java.io.IOException exception) {
            }//GEN-END:MVDGetInit70
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd70
        return logoEscolaTreballPantallaInici;
    }//GEN-END:MVDGetEnd70

    /** This method returns instance for TickerSplashScreen component and should be called instead of accessing TickerSplashScreen field directly.//GEN-BEGIN:MVDGetBegin71
     * @return Instance for TickerSplashScreen component
     */
    public Ticker get_TickerSplashScreen() {
        if (TickerSplashScreen == null) {//GEN-END:MVDGetBegin71
            // Insert pre-init code here
            TickerSplashScreen = new Ticker("Exercici J2ME!");//GEN-LINE:MVDGetInit71
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd71
        return TickerSplashScreen;
    }//GEN-END:MVDGetEnd71
    
    public void startApp() {
        initialize();
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }
    
}
