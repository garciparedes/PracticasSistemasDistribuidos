/**
 * 
 */
package clienteservidor;

import java.net.*;
import java.io.*;

public class Servidor {
    public static final int PUERTO = 2000;

    public static void main(String[] args) throws IOException {
        ServerSocket servidor = new ServerSocket(PUERTO); /* creación del socket */

        for (;;) {
            System.out.println("----Servidor aceptando conexiones----");
        		new Thread(new Sirviente(servidor.accept())).start();
        }
    }
}
