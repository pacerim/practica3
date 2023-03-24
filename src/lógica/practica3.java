package lógica;

import model.*;
import sol.GestorBD;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
            creaPedidoRealizacion();
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

    public static void creaPedidoRealizacion(){
        //utilizar util.Calendario para verificar si es festivo o no.
        //si no funciona usar la que realizamos en la práctica 2 del otro día


        GestorBD gbd = new GestorBD();
        GregorianCalendar fecha = new GregorianCalendar();

        try{
            while(!util.Calendario.isFestivo(fecha)){
                fecha.add(GregorianCalendar.DAY_OF_MONTH,1);
            }
            Cliente cl1 = gbd.getCliente("200006/01");
            PedidoEnRealizacion pedido =  new PedidoEnRealizacion( "Mie/003LD",cl1,fecha);

            Articulo a1 = gbd.getArticulo("Fag/267FO");
            LineaEnRealizacion linea1 = new LineaEnRealizacion("lin1", pedido, a1,22, fecha);

            Articulo a2 = gbd.getArticulo("aaaaaa");
            LineaEnRealizacion linea2 = new LineaEnRealizacion("lin2", pedido, a2,1, fecha);
            pedido.addLinea(linea1);
            pedido.addLinea(linea2);

            System.out.println(pedido);
            Pedido ped = new Pedido(pedido);
            System.out.println(ped);

        }catch(ExcepcionDeAplicacion eA){
            eA.printStackTrace();
            eA.printStackTrace();
        }

    }
}
