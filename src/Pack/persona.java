/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pack;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author LabingXEON
 */
public class persona {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        RandomAccessFile archivo = new RandomAccessFile("persona", "rw");
        Arbol_Archivo cc = new Arbol_Archivo("persona");

       /*  if(cc.añadir(1234)){
            archivo.writeLong(1234);
            archivo.writeUTF("name hola");
        }
        
        if(cc.añadir(1024)){            
            archivo.writeLong(1024);
            archivo.writeUTF("Jorge el curioso");
        }*/
      
        /*if (cc.añadir(1235)) {
            archivo.writeLong(1235);
            archivo.writeUTF("matalo");
        }*/

        cc.imprimir();
        //archivo.seek(19);
        //System.out.println(archivo.readLong() + " " + archivo.readUTF());

    }

}
