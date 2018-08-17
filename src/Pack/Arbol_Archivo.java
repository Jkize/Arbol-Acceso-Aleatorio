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
public class Arbol_Archivo {

    private RandomAccessFile arbol;
    private RandomAccessFile archivo;

    public Arbol_Archivo(String archivo_dato) throws FileNotFoundException {
        arbol = new RandomAccessFile("arbol" + archivo_dato, "rw");
        archivo = new RandomAccessFile(archivo_dato, "rw");

    }

    private long obtener_pos_archivo() throws IOException {
        return archivo.length();
    }

    public boolean añadir(long id) throws IOException {
        arbol.seek(0);
        if (arbol.length() == 0) {
            arbol.writeLong(id);
            arbol.writeInt(-1);
            arbol.writeInt(-1);
            arbol.writeInt(0);
        } else {
            long pos_arbol = busqueda(id);
            if (pos_arbol == 0) {
                return false;
            }
            arbol.seek(pos_arbol);
            arbol.writeInt((int) arbol.length());
            arbol.seek(arbol.length());
            arbol.writeLong(id);
            arbol.writeInt(-1);
            arbol.writeInt(-1);
            arbol.writeInt((int) obtener_pos_archivo());
        }
        return true;
    }

    private long busqueda(long id) throws IOException {
        long t = arbol.readLong();
        if (id == t) {
            return 0;
        }

        if (id < t) {
            long pos = arbol.getFilePointer();
            int dat = arbol.readInt();
            if (dat == -1) {
                return pos;
            }else{
                arbol.seek(dat);
            } 
            return busqueda(id);
        } else {
            arbol.skipBytes(4);
            long pos = arbol.getFilePointer();
            int dat = arbol.readInt();

            if (dat == -1) {
                return pos;
            }else{
                arbol.seek(dat);
            } 
            return busqueda(id);

        }

    }

    public void imprimir() throws IOException {
        arbol.seek(0);
        while (true) {
            System.out.println(arbol.readLong() + " " + arbol.readInt() + " " + arbol.readInt() + " " + arbol.readInt());
            if (arbol.getFilePointer() == arbol.length()) {
                break;
            }
        }

    }

}
