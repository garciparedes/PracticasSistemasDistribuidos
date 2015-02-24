package clienteservidor;

import java.net.*;
import java.io.*;

public class Sirviente implements Runnable{

	public static final int PUERTO = 2000;
	private Socket sock;
	
	public Sirviente(Socket sock){
		this.sock = sock;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		/********************************************
         * Zona de servicio.
         */
		try{
        InputStream in = sock.getInputStream(); /* entrada socket */
        
        Reader r1 = new InputStreamReader(in);
        PrintStream outred;
        try (BufferedReader inred = new BufferedReader(r1)) {
            OutputStream out = sock.getOutputStream(); /* salida socket */
            outred = new PrintStream(out);
            String linea;
            /* bucle de ECHO */
            
            linea = inred.readLine();
                
                System.out.println("Echoing: "+linea); /* echo por la pantalla */
                outred.println(linea); /* echo al cliente */
                
          
        } /* salida socket */
        outred.close();
        outred.close();
        /********************************************
         * Fin de la zona de servicio
         */
		}catch (IOException e) {
            e.printStackTrace(System.err);
        }
	}
}
