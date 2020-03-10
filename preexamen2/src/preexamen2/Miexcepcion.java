/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package preexamen2;

/**
 * 
 * @author alberto real
 */
public class Miexcepcion extends Exception {
    private String codigoError;
    
    public Miexcepcion(int cantidad){
        super();
        this.codigoError="el cajero no dispone"
                + "de los billetes necesarios para "
                + "ejecutar esta operacion ;";
    }

    public String getCodigoError() {
        return codigoError;
    }

    public void setCodigoError(String codigoError) {
        this.codigoError = codigoError;
    }
    
    public void añadirInforme(String codigoError){
        this.setCodigoError(this.getCodigoError()+codigoError);
    }
}
