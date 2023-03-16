package sol;

import model.Articulo;
import model.ExcepcionDeAplicacion;



public class practica3 {
    public static void main(String[] args) {
        Articulo a= null;
        GestorBD gbd = null;
        try {

            gbd = new GestorBD();
            a = gbd.getArticulo("Fag/133MO");
            System.out.println(a);
        } catch (ExcepcionDeAplicacion e) {
            e.printStackTrace();
        }
    }
}
