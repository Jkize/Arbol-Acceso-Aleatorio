/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pack;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 *
 * @author LabingXEON
 */
public class persona {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        RandomAccessFile archivo = new RandomAccessFile("persona", "rw");
        Arbol_Archivo cc = new Arbol_Archivo("persona");
        Scanner in = new Scanner(System.in);
        while (true) {

            int cas = in.nextInt();
            switch (cas) {

                case 1:
                    long id = in.nextLong();
                    String name = in.next();
                    añadir(id, name, cc, archivo);
                    break;
                case 2:
                    imprimir(cc);
                    break;
                            

            }
        }
    }

    public static void añadir(long id, String name, Arbol_Archivo cc, RandomAccessFile archivo) throws IOException {
        if (cc.añadir(id)) {
            archivo.writeLong(id);
            archivo.writeUTF(name);
        }else{
            System.out.println("ya esta");
        }
    }

    public static void imprimir(Arbol_Archivo cc) throws IOException {
        cc.imprimir();
    }

}
