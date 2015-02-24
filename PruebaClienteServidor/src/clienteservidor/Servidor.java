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
            try {
                System.out.println("----Servidor aceptando conexiones----");
                try (Socket sock = servidor.accept()) {
                    new Thread(new Sirviente(sock)).run();
                  
                    System.out.println("Creado Hilo");

                }
            } catch (IOException e) {
                e.printStackTrace(System.err);
            }
        }
    }
}
