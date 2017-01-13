package avatarwirelesscrackingtool;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Shell extends Thread {

    private static String[] c = null;
    private static String s;
    
    public void run(){
    
    
    }

    public Shell() {
    }

    //Shell generica donde se ingresan comandos desde consola.
    public static void SimpleExecute(String cmd) throws IOException {
        //Shell generica se ingresa un string como comando.
        try {

            Runtime.getRuntime().exec(cmd);
        } catch (IOException ioe) {
            //System.out.println ("Error "+ioe);
        }
    }

    public void ExecuteCommand(String f[]) throws IOException {
        //  Shell que recibe codigos desde otras clases.
        for (int i = 0; i < f.length; i++) {
            String x = "" + f[i];
            try {
                String g[] = {"/bin/bash", "-c", "echo " + Passwd() + "| sudo -S " + x};
                execCommand(g);

            } catch (IOException e) {
                //System.out.println("Error "+e);
            }
        }
    }

    public void ExecuteCommandString(String cmd) throws IOException {
        //Shell que recibe codigos en String desde otras clases. Ejecuta y retorna un string
        String Str = null;
        try {
            String g[] = {"/bin/bash", "-c", "echo " + Passwd() + "| sudo -S " + cmd};
            execCommand(g);

        } catch (IOException e) {
            //System.out.println("Error "+e);
        }

    }

    public String ExecuteArrToString(String f[]) throws IOException {
        //Shell que recibe codigos ena arreglos desde otras clases. Ejecuta y retorna un string
        String Str = null;
        for (int i = 0; i < f.length; i++) {
            String x = "" + f[i];
            try {
                String g[] = {"/bin/bash", "-c", "echo " + Passwd() + "| sudo -S " + x};
                Str = execCommand(g).toString().substring(1, execCommand(g).toString().length() - 1);

            } catch (IOException e) {
                //System.out.println("Error "+e);
            }
        }
        return Str;
    }

    public String ExecuteToString(String cmd) throws IOException {
        //Shell que recibe codigos en String desde otras clases. Ejecuta y retorna un string
        String Str = null;
        try {
            String g[] = {"/bin/bash", "-c", "echo " + Passwd() + "| sudo -S " + cmd};
            Str = execCommand(g).toString().substring(1, execCommand(g).toString().length() - 1);

        } catch (IOException e) {
            //System.out.println("Error "+e);
        }

        return Str;
    }

    public String[] EjVerProgramasInstalados(String f[]) throws IOException {
        //Shell que recibe los comandos para verificar si estan instalados

        ArrayList<String> cmdOutput = new ArrayList<>();
        for (int i = 0; i < f.length; i++) {
            String x = "" + f[i];
            try {

                if ("exit".equals(f)) {
                    System.exit(0);
                } else {
                    String g[] = {"/bin/bash", "-c", "echo " + Passwd() + "| sudo -S " + x};
                    //System.out.println(execCommand(g));
                    cmdOutput = execCommand(g);

                }
            } catch (IOException e) {
                //System.out.println("Error");
            }
        }
        String arrayOutput[] = new String[cmdOutput.size()];
        arrayOutput = cmdOutput.toArray(arrayOutput);

        return arrayOutput;
    }

    public boolean RunCheck(String passwd) throws IOException {
//  Metodo para validar la clave de Super Administrador

        boolean r = false;

        String g[] = {"/bin/bash", "-c", "echo " + passwd + "| sudo -S id"};
        String ROOTrtn = execCommand(g).toString().substring(1, execCommand(g).toString().length() - 1);
        //System.out.println(ROOTrtn);
        String ROOTOK = "uid=0(root) gid=0(root) grupos=0(root)";

        if (ROOTOK == null ? ROOTrtn == null : ROOTOK.equals(ROOTrtn)) {
            r = true;

        }

        return r;
    }

    public void ExcSavePasswd(String passwd, String cmd) throws IOException {
        //Shell que recibe codigos en String desde otras clases. Ejecuta y retorna un string
        String Str = null;
        try {
            String g[] = {"/bin/bash", "-c", "echo " + passwd + "| sudo -S " + cmd};
            execCommand(g);

        } catch (IOException e) {
            //System.out.println("Error");
        }

    }

    public static String Passwd() throws FileNotFoundException, IOException {
//metodo que toma la clave validada y la guarda en un archivo temporal miestras se ejecutar el programa
        String retorno = null;
        String Salida = "";
        StringBuffer contenido = new StringBuffer();
        String sep = "";
        String n = "/tmp/.AWTesting/AdminData/rootpasswd.txt";
        FileReader archivo = new FileReader(n);
        BufferedReader clave = new BufferedReader(archivo);
        while ((Salida = clave.readLine()) != null) {
            contenido.append(sep + Salida);
            sep = "\n";
        }
        retorno = contenido.toString();
        return retorno;
    }

    public static ArrayList<String> execCommand(String[] command) throws IOException {
        String so = System.getProperty("os.name");
        ArrayList<String> cmdOutput = new ArrayList<>();
        if (so.equals("Linux")) {
            try {
                Process p = Runtime.getRuntime().exec(command);
                BufferedReader bri = new BufferedReader(new InputStreamReader(p.getInputStream()));
                String tmpLine = "";
                while ((tmpLine = bri.readLine()) != null) {
                    cmdOutput.add(tmpLine);
                }
                BufferedReader Error = new BufferedReader(new InputStreamReader(p.getErrorStream()));
                String e = "";
                while ((e = Error.readLine()) != null) {
                    // System.out.println(e);
                }
            } catch (IOException e) {
                // System.out.println("Error.");
            }

        } else {
            //System.out.println("Sistema Operativo no Adminito!!!!");
        }
        return cmdOutput;
    }

}
