/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package preexamen2;

/**
 * 
 * @ author alberto real 
 */
public class TarjetaCredito extends Tarjeta {
    private int saldoDisponible;
    private int creditoDisponible;

    public TarjetaCredito() {
    }


    public TarjetaCredito(int saldoDisponible, int creditoDisponible, int nifCliente, int pin, String nombre, String apellido) {
        super(nifCliente, pin, nombre, apellido);
        this.setSaldoDisponible(saldoDisponible);
        this.setCreditoDisponible(creditoDisponible);
    }
    
    public TarjetaCredito(TarjetaCredito t1){
        super((Tarjeta) t1);
        this.setSaldoDisponible(t1.getSaldoDisponible());
        this.setCreditoDisponible(t1.getCreditoDisponible());
    }
    
    
    public int getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(int saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }

    public int getCreditoDisponible() {
        return creditoDisponible;
    }

    public void setCreditoDisponible(int creditoDisponible) {
        this.creditoDisponible = creditoDisponible;
    }
  
    public void mostrarDatos(){
        super.mostrarDatos();
        System.out.println("saldo" +this.getSaldoDisponible());
        System.out.println("credito" +this.getCreditoDisponible());
    }
    public boolean reintegro(int reintegro){
        boolean operacionRealizada = false;
        if (reintegro<this.getSaldoDisponible()+this.getCreditoDisponible()){
            int sobrante =reintegro-this.getSaldoDisponible();
            this.setSaldoDisponible(saldoDisponible-reintegro);
            System.out.println("operacin aceptada saldo restante"+this.getSaldoDisponible());
            this.setCreditoDisponible(creditoDisponible-sobrante);
            System.out.println("creditorestante"+this.getCreditoDisponible());
            operacionRealizada=true;
        }else{
            System.out.println("saldo insuficiente");
        }return operacionRealizada;
    }
}
