/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preexamen2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @ author alberto real 
 */
public class Preexamen2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[][] cargaBilletes = {{500, 10}, {200, 0}, {100, 0}, {50, 27},
        {20, 0}, {10, 18}, {5, 25}};
        CajeroAutomatico p1 = new CajeroAutomatico();
        p1.setListaBilletes(cargaBilletes);
        //usuario 1 nif = 123456, PIN = 123
        TarjetaDebito mitarj1 = new TarjetaDebito(1000,123456,123, "Jorge", "Lorenzo" );
        p1.addtarjeta(mitarj1);
        //usuario 2 nif = 456, PIN = 456
        TarjetaCredito mitarj2 = new TarjetaCredito(34888999, 2222, 456, 456, "Rafa", "Nadal");
        p1.addtarjeta(mitarj2);
        p1.mostarBilletes();
        menu(p1);
    
    }
    
     public static ArrayList<Tarjeta> tarjetas = new ArrayList<Tarjeta>();
     
     public static void menu(CajeroAutomatico p1){
        Scanner entrada = new Scanner(System.in);
         System.out.println(" introduce \n1 para sacar dinero \n"
                 + "2 para salir");
        int opcion = entrada.nextInt();
        switch(opcion){
            case 1:{
                int usuario =validar(p1);
                       if (usuario>=0){
            p1.Tarjetas.get(usuario).mostrarDatos();
                           System.out.println("introduce el valor a retirar");
                           int retirada = entrada.nextInt();
            if(p1.Tarjetas.get(usuario).reintegro(retirada)&&p1.sacarDinero(retirada)){
                            p1.mostarBilletes();
                            p1.Tarjetas.get(usuario).mostrarDatos();
                        }else{
                            System.out.println("error");
                        }
                    }
                       menu(p1);
                       break;
                }case 2:{ 
                    break;
                }
                default:{
                    break;
                }
            }
        }
    public static int validar(CajeroAutomatico p1){
       int valido= -1;
       Scanner entrada = new Scanner (System.in);
        System.out.println("introduce el nif de usuario");
        int NIF = entrada.nextInt();
        System.out.println("introduce el pin");
        int PIN = entrada.nextInt();
        int salida = p1.busacarUsuario(NIF);
        if (salida>=0){
        p1.Tarjetas.get(salida).validacion(NIF, PIN);
        valido = salida;
    }else{
            System.out.println("usuario no encontrado");   
        }return valido;     
    }
}