package sol;

import bd.AbstractDBManager;
import model.*;

import java.sql.*;

public class GestorBD extends AbstractDBManager {

    static{
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }

    }


    public Articulo getArticulo(String codigo) throws ExcepcionDeAplicacion {
        Articulo articulo = null;
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.56.101:1521:pbd",
                    "prbd", "prbdprbd");
            Statement stm = con.createStatement();
            String sql = "SELECT nombre, PVP FROM Articulo WHERE codigo = '" + codigo + "'";

            ResultSet res = stm.executeQuery(sql);
            if (res.next()) {
                articulo = new Articulo(codigo, res.getString(1), res.getDouble(2));
            }
            res.close();
            stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExcepcionDeAplicacion(e);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return articulo;
    }
    public Cliente getCliente(java.lang.String codigo) throws ExcepcionDeAplicacion{
        Cliente cl = null;
        return cl;
    }

}
