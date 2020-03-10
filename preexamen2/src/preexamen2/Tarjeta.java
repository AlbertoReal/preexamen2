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
public abstract class Tarjeta {
    private int nifCliente;
    private int pin;
    private String nombre;
    private String apellido;

    public Tarjeta() {
    }

    public Tarjeta(int nifCliente, int pin, String nombre, String apellido) {
        this.setNifCliente(nifCliente);
        this.setPin(pin);
        this.setNombre(nombre);
       this.setApellido(apellido);
    }
    public Tarjeta(Tarjeta t1) {
        this.setNifCliente(t1.getNifCliente());
        this.setPin(t1.getPin());
        this.setNombre(t1.getNombre());
        this.setApellido(t1.getApellido());  
    }


    public int getNifCliente() {
        return nifCliente;
    }

    public void setNifCliente(int nifCliente) {
        this.nifCliente = nifCliente;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public void mostrarDatos(){
        System.out.println("nif" +this.getNifCliente());
        System.out.println("pin" +this.getPin());
        System.out.println("nombre" +this.getNombre());
        System.out.println("apellidos"+this.getApellido());
    }
   public boolean validacion(int nif, int pin){
       boolean correcto = false;
       if (this.getNifCliente()==nif){
          if (this.getPin()==pin){
             correcto=true;  
          }else{
              System.out.println("pin incorrecto");
          }
       }else{
           System.out.println("nif incorrecto");
       }if (correcto==true){
           System.out.println("usuario reconocido");
       }
       return correcto;
       
   }
   public abstract boolean reintegro(int saldo);   
}
