package principal;

import java.io.File;
import java.io.IOException;
import avatarwirelesscrackingtool.*;
import java.io.BufferedWriter;

public class Configuracion {

    /* Aqui se encuentran las opcines para:    
        Crear y ubicar el directorio donde se almacenaran los archivos temporales .cap
        generados por aircrack-ng.
    */
    private Shell ejecutor = new Shell();

    public Configuracion() {

    }

    public void CambiarNombreNetworkInterface() throws IOException {
        //ln Un enlace de un determinado archivo.
        //Ej:ln doc1 doc2.  Ahora doc2 es un enlace al archivo doc1.

        String t = "ln -s /dev/null /etc/udev/rules.d/80-net-setup-link.rules";

        ejecutor.ExecuteToString(t);

        String homeUsuario = System.getProperty("user.home");
        //se verifica la existencia del archivo recidual, si no lo encuentra se ejecuta
        //la clase de Autorizacion en donde se creara dicho archivo
        String sFichero = homeUsuario + "/.AWCTool/AWCrakingToolWLANOK";

        File fichero = new File(sFichero);

    }

    public void Reiniciar() throws IOException {

        String cmd = "reboot";
        //se ejecuta el arreglo de comandos 

        ejecutor.ExecuteToString(cmd);
    }

    public boolean katoolin() throws IOException {

        boolean R = false;
        /*Array cmd[] con todo los comando necesarios para isntalar los programas requediso para el funcionamiento de katoolin*/
        String cmd = "";
        if (verProg() == true) {
            R = false;
            //System.out.println("Todos los programas necesarios instalados");
        } else {
            //Matriz String de comandos de katoolin para instalar programas necesario si es que se necesitara.
            //sudo su

            cmd = "sudo apt-get update && sudo apt-get install git -y && "
                    + "sudo apt-key adv --keyserver pgp.mit.edu --recv-keys ED444FF07D8D0BF6 && "
                    + "sudo cp /etc/apt/sources.list /etc/apt/sources.list-BAK && "
                    + "sudo echo 'deb http://http.kali.org/kali kali-rolling main contrib non-free >> /etc/apt/sources.list && "
                    + "sudo echo 'deb http://repo.kali.org/kali kali-bleeding-edge main' >> /etc/apt/sources.list && "
                    + "sudo apt-get update && sudo apt-get install aircrack-ng -y && "
                    + "sudo apt-get install reaver -y "
                    + "sudo apt-get install xterm -y && sudo rm /etc/sources.list && "
                    + "sudo cp /etc/sources.list-BAK /etc/sources.list && "
                    + "sudo rm /etc/sources.list-BAK && "
                    + "sudo apt-get update";

            ejecutor.ExecuteToString(cmd);
            R = true;
        }
        return R;
    }

    public boolean verProg() throws IOException {
        boolean R = false;
        String cmd[] = new String[4];
       

        cmd[1] = "dpkg -l | grep aircrack-ng";
        cmd[2] = "dpkg -l | grep reaver";
        //cmd[3] = "dpkg -l | grep mkd3";
        cmd[3] = "dpkg -l | grep gnome-terminal";

        for (int i = 0; i < cmd.length; i++) {
       
            if (ejecutor.EjVerProgramasInstalados(cmd) == null) {
                R = false;
                break;
            
            } else {

                R = true;
                break;
            }
        }
        return R;
    }

    public static void crearDir(String msj) throws IOException {
        /*para crear un directorio dentro de /home/usuario Para almacenar los archivos temporales*/
        //String homeUsuario = System.getProperty("user.home");//Obtenemos el Nombre del Usuario
        String cmd = "/tmp/.AWCTool/AircrackTemp";
// Direcotrio para archivos temporales de Airckar-ng
//Ademas crearmos archivo temporal para almacenar las Network Interfaces
        String cmd1 = "/tmp/.AWCTool/AdminData"; //Directorio para almacenar Datos de Administracion
        File directorio1 = new File(cmd);
        File direcotiro2 = new File(cmd1);
        directorio1.mkdirs();
        direcotiro2.mkdirs();
        Root root = new Root();
        root.crearArchivo(msj);

    }

    void ejecutor(String cmd[]) throws IOException {
        ejecutor.ExecuteCommand(cmd);

    }

    /*
    public void TXTtoCSV(String dirArchivo) throws IOException{
        Metodo especial para transformar archivos.txt a archivos.csv
        Este metodo servira para transformar los archivos necesarios para su
        posterior manejo de datos
        
        String cmd[]=new String[1];
        cmd[0]="sed 's/[[:space:]]\\+/,/g' "+dirArchivo+"memory.txt > "+dirArchivo+"memory.csv";
        ejecutor(cmd);

    }
     */
}
