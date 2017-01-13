
package avatar.wireless.testing.principal;

import avatar.wireless.testing.Shell;
import java.io.IOException;

/**
 *
 * @author mrroox
 */
public class MetNetworkInterface {

    //clase para Interface propia de nuestro pc la utilizaremos en modo monitor
    Shell shell = new Shell();
    
    public MetNetworkInterface() {

    }

    public void modoMonitor(String monInterface) throws IOException {

        // metodo para generar modo monito de la NetworkInterface
        String cmd[] = new String[2];
        cmd[0] = "airmon-ng check kill"; // comando para matar todos lo procesos
        cmd[1] = "airmon-ng start " + monInterface; //comando para iniciar el modo monitor 
        //Este es un comando de del Script Aircrack-ng 

        shell.ExecuteCommand(cmd);

    }

    public void resetMonitor(String monInterface) throws IOException {
        //Comandos para Reestablecer la NetworkInterface
        String cmd[] = new String[2];
        cmd[0] = "airmon-ng stop " + monInterface;//Comando para Detener el modo monitor
        cmd[1] = "service network-manager start";//Comando para restablecer todos los servicios y Nuestra Network Interface
        shell.ExecuteCommand(cmd);
    }

}
