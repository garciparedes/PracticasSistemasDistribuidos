/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hilosjava;


public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ColaStrings cola = new ColaStrings() ;
        Runnable genera = new Productor(cola) ;
        Runnable come = new Consumidor(cola, "UNO") ;
        Runnable come2 = new Consumidor(cola, "DOS") ;


        new Thread(genera).start();
        new Thread(come).start();
        new Thread(come2).start();


    }

}
