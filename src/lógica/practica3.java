package lógica;

import model.Articulo;
import model.Cliente;
import model.ExcepcionDeAplicacion;
import sol.GestorBD;

import java.util.Arrays;
import java.util.List;


public class practica3 {
    public static void main(String[] args) {
        Articulo a= null;
        Cliente c = null;
        GestorBD gbd = null;
        try {

            gbd = new GestorBD();
            a = gbd.getArticulo("Fag/133MO");
            c = gbd.getCliente("260001/99"); //pedimos un cliente que existe en la base de datos oracle
            System.out.println(a);
            System.out.println(c);
            datosTodosArtículosBD();
        } catch (ExcepcionDeAplicacion e) {
            e.printStackTrace();
        }
    }

    public static void datosTodosArtículosBD(){
        GestorBD gbd = null;

        List<String> codArtículos = null;
        try{
             gbd = new GestorBD();
             codArtículos = gbd.getArticulos();
             int i =0;
             while(i<codArtículos.size()){
                 System.out.println(gbd.getArticulo(codArtículos.get(i)));
                 i++;
             }

        }catch(ExcepcionDeAplicacion eA){
            eA.printStackTrace();
        }

    }

    public void creaPedidoRealizacion(){
        //utilizar util.Calendario para verificar si es festivo o no.
        //si no funciona usar la que realizamos en la práctica 2 del otro día
    }
}
