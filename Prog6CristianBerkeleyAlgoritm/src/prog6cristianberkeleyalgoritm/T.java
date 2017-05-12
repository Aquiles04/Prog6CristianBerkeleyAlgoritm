/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog6cristianberkeleyalgoritm;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author alexandre.chaves
 */
public class T {

    public static void main(String[] args) throws InterruptedException, IOException {

        try {
       	    Scanner sc = new Scanner(System.in); 

            System.out.println("Digite minha id");
            String id = sc.nextLine();
            //System.out.println("Digite minha id");
            Date date = new Date();
            Cliente cliente = new Cliente(sc.nextInt(),date);
            
            Socket t = new Socket("paulo", 12345);
            ObjectInputStream entrada = new ObjectInputStream(t.getInputStream());
            Date data_atual = (Date) entrada.readObject();
            JOptionPane.showMessageDialog(null, "Data recebida do servidor:" + data_atual.toString());
            entrada.close();
            System.out.println("Conexão encerrada");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

}
