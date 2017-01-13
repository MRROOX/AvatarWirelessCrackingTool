package avatarwirelesscrackingtool;

import java.io.File;

/**
 *
 * @author MrRoox
 */
public class AvatarWirelessCrackingTool {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Se ejecuta la Ventana en la cual se aprueba la Autorizacion de y todo los Riesgos que Implica la ejecucion de Avatar Wireless Testing
        String homeUsuario = System.getProperty("user.home");
        //se verifica la existencia del archivo recidual, si no lo encuentra se ejecuta
        //la clase de Autorizacion en donde se creara dicho archivo
        String sFichero = homeUsuario + "/.AWCTool/AWCrakingTool";
        File fichero = new File(sFichero);
        if (fichero.exists()) {
            AuthRoot root = new AuthRoot();
            root.setVisible(true);
        } else {
            Autorizacion VA = new Autorizacion();
            VA.setVisible(true);

        }

    }

}
