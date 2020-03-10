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
public class TarjetaDebito extends Tarjeta {
    private int saldo;

    public TarjetaDebito() {
    }

    public TarjetaDebito(int saldo, int nifCliente, int pin, String nombre, String apellido) {
        super(nifCliente, pin, nombre, apellido);
        this.setSaldo(saldo);
    }
    
    public TarjetaDebito(TarjetaDebito t1){
        super((Tarjeta)t1);
        this.setSaldo(t1.getSaldo());
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    @Override
    public void mostrarDatos(){
        super.mostrarDatos();
        System.out.println("saldo" +this.getSaldo());
    }
    @Override
    public boolean reintegro(int reintegro){
        boolean operacionRealizada = false;
        if (reintegro<this.getSaldo()){
            this.setSaldo(saldo-reintegro);
            System.out.println("operacin aceptada saldo restante"+this.getSaldo());
            operacionRealizada=true;
        }else{
            System.out.println("saldo insuficiente");
        }return operacionRealizada;
    }
//    
}
