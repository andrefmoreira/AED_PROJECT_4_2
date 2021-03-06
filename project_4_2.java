import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class project_4_2
{

    public static class Global
    {   
        public static int array[];
        public static int n;

        public static void cria_array(int x , int y){
            n = x*y;
            array = new int[n];
        }
    } 


    static void bubble_sort(){

        int trocas = 1;
        int temp;
        int ultimo_indice = Global.array.length - 1;

        while(trocas > 0)
        {
            trocas = 0;

            for(int i = 0 ; i < ultimo_indice ; i++){

                if(Global.array[i] > Global.array[i+1]){

                    trocas++;
                    temp = Global.array[i+1];
                    Global.array[i+1] = Global.array[i];
                    Global.array[i] = temp;

                }

            }

            ultimo_indice--;
        }


    }
    static String le_parametros(Scanner sc)
    {
        String str;  
            
        try{
                
        str = sc.nextLine();

        }
        //Se o valor for um valor causar um erro, ira ser avisado ao usuario que o valor nao e valido.
        catch (java.util.InputMismatchException e){
            System.out.printf("Valor Introduzido nao e valido.");
            return null;
        }
        
        return str;
    }

    //permite receber o input do usuario e verificar qual a opcao inserida.
    static void opcoes(Scanner sc){
    
    int fim = 0;

    while(fim == 0)
    {

        String[] parametros;
        parametros = le_parametros(sc).split(" ");


        if(parametros[0].equals("RASTER")){
            
            int n,m;
            int indice = 0;

            n = Integer.parseInt(parametros[1]);
            m = Integer.parseInt(parametros[2]);

            Global.cria_array(n, m);

            for(int i = 0 ; i < n ; i++){

                parametros = le_parametros(sc).split(" ");

                for(int x = 0 ; x < m ; x++){
                    
                    Global.array[indice] = Integer.parseInt(parametros[x]);
                    indice++;

                }
            }

            bubble_sort();

            System.out.println("RASTER GUARDADO");
        }
        
        if(parametros[0].equals("AMPLITUDE"))
            System.out.println(Global.array[Global.array.length - 1] - Global.array[0]);

    

        if(parametros[0].equals("PERCENTIL")){ 

            int valor = Integer.parseInt(parametros[1]);
            parametros = le_parametros(sc).split(" ");

            for(int c = 0 ; c < valor ; c++){

                int numero_limite = Integer.parseInt(parametros[c]);

                double contador = 0;
                int indice = -1;

                for(int x = 0 ; x < Global.n ; x++){

                    if(Global.array[x] >= numero_limite){
                        indice = x;
                        break;
                    }

                }
                
                if(indice == -1){
                    indice = Global.array.length;
                }
                contador = indice;
                
                int percentil;
                percentil = (int) Math.floor((contador / Global.array.length) * 100);

                if(c == valor -1)
                    System.out.println(percentil);
                else
                System.out.print(percentil + " ");
            }
        }

        if(parametros[0].equals("MEDIANA")){

            int mediana = 0;

            if(Global.array.length % 2 == 0){
                mediana = (Global.array[Global.array.length / 2] + Global.array[(Global.array.length / 2) - 1]) / 2;
            }
            else
                mediana = Global.array[(Global.array.length / 2)] ;
                
            System.out.println(mediana);
        }

        if(parametros[0].equals("TCHAU")){
                
            fim++;
            sc.close();

        }

        }
    }


    public static void main(String[] args) 
    {   
        Scanner sc = new Scanner(System.in);

        opcoes(sc);
        sc.close();
    }
}