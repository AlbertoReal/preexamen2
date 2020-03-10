/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package preexamen2;

import java.util.ArrayList;

/**
 * 
 * @ author alberto real 
 */


public class CajeroAutomatico {
    private static int numeroIdCajeroUltimo;
    private int numeroIdcajero;
    private int[][] listaBilletes;
    public  ArrayList<Tarjeta> Tarjetas = new ArrayList<Tarjeta>();

    public CajeroAutomatico() {
        this.setNumeroIdCajeroUltimo(numeroIdCajeroUltimo++);
    }

    public CajeroAutomatico(int numeroIdCajeroUltimo, int numeroIdcajero, int[][] listaBilletes) {
        this.setNumeroIdCajeroUltimo(numeroIdCajeroUltimo++);
        this.setListaBilletes(listaBilletes);
        this.setNumeroIdcajero(numeroIdcajero);
    }

    public int getNumeroIdCajeroUltimo() {
        return numeroIdCajeroUltimo;
    }

    public void setNumeroIdCajeroUltimo(int numeroIdCajeroUltimo) {
        this.numeroIdCajeroUltimo = numeroIdCajeroUltimo;
    }

    public int getNumeroIdcajero() {
        return numeroIdcajero;
    }

    public void setNumeroIdcajero(int numeroIdcajero) {
        this.numeroIdcajero = numeroIdcajero;
    }

    public int[][] getListaBilletes() {
        return listaBilletes;
    }

    public void setListaBilletes(int[][] listaBilletes) {
        this.listaBilletes = listaBilletes;
    }

    public ArrayList<Tarjeta> getTarjetas() {
        return Tarjetas;
    }

    public void setTarjetas(ArrayList<Tarjeta> Tarjetas) {
        this.Tarjetas = Tarjetas;
    }
    
    public void mostarBilletes(){
        for (int i = 0;i<listaBilletes.length; i++){
            System.out.println(this.getListaBilletes()[i][1]+ " billetes de " +this.getListaBilletes()[i][0]);
        }
    }
    
    public int totalCajero(){
        int total =0;
        for(int i = 0; i<listaBilletes.length; i++){
            total+=listaBilletes[i][0]*listaBilletes[i][1];
        }
        return total;
    }
    public boolean sacarDinero(int cantidad){
        boolean operacionRealizada=false;
        int b500 =0; 
        int b200 =0;
        int b100 =0;
        int b50 =0;
        int b20 =0;
        int b10 =0;
        int b5 =0;
        int tope=totalCajero();
        if (cantidad<tope){
        if (listaBilletes[0][1]>0){
        b500=cantidad/500;
        if (b500<listaBilletes[0][1]){
           cantidad = cantidad-(b500*500);
        }else{
            int salida = b500-listaBilletes[0][1];
            cantidad = cantidad-(salida*500);
        }
        } if (listaBilletes[1][1]>0){
        b200=cantidad/200;
        if (b200<listaBilletes[1][1]){
           cantidad = cantidad-(b200*200);
        }else{
            int salida = b200-listaBilletes[1][1];
            cantidad = cantidad-(salida*200);
        }
        }
        if (listaBilletes[2][1]>0){
         b100=cantidad/500;
        if (b100<listaBilletes[2][1]){
           cantidad = cantidad-(b100*100);
        }else{
            int salida = b100-listaBilletes[2][1];
            cantidad = cantidad-(salida*100);
        }
        }
        if (listaBilletes[3][1]>0){
        b50=cantidad/50;
        if (b50<listaBilletes[3][1]){
            cantidad = cantidad-(b50*50);
        }else{
        cantidad = cantidad-(b50*50);
        int salida2 = b50-listaBilletes[3][1];
        cantidad = cantidad-(salida2*50);
        }
        }
        if (listaBilletes[4][1]>0){
        b20 = cantidad/20;
        if (b20<listaBilletes[4][1]){
           cantidad = cantidad-(b20*20); 
        }else{
            int salida3 = b20-listaBilletes[4][1];
            cantidad = cantidad-(salida3*20);
        }
        }
        if(listaBilletes[5][1]>0){
        b10 = cantidad/10;
        if (b10<listaBilletes[5][1]){
           cantidad = cantidad-(b10*10); 
        }else{
            int salida4 = b10-listaBilletes[4][1];
            cantidad = cantidad-(salida4*10);
        }
        }
        if(listaBilletes[6][1]>0){
        b5 = cantidad/5;
        if (b5<listaBilletes[6][1]){
             cantidad = cantidad-(b5*5);
        }else{
            int salida5 = b5 -listaBilletes[5][1];
            cantidad = cantidad -(salida5*5);
        }
        }

        if(cantidad>0){
           // throw new Miexcepcion(cantidad);
            System.out.println("el cajero no dispone de los billetes necesarios");
        }else{
            listaBilletes[0][1]-=b500;
            listaBilletes[1][1]-=b200;
            listaBilletes[2][1]-=b100;
            listaBilletes[3][1]-=b50;
            listaBilletes[4][1]-=b20;
            listaBilletes[5][1]-=b10;
            listaBilletes[6][1]-=b5;
            operacionRealizada = true;
            }
        }
        return operacionRealizada;
    }
    public void addtarjeta (Tarjeta miTarjeta){
        Tarjetas.add(miTarjeta);
    }
    
    public int busacarUsuario(int NIF){
        int encontrado = -1;
        int i =0;
        while (Tarjetas.size()!=i){
            if (Tarjetas.get(i).getNifCliente()==NIF){
                encontrado=i;
            }i++;
        }
        return encontrado;
    }
}
