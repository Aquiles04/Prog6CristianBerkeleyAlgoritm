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
            System.out.println("Digite a hora formato hh");
            Date date = new Date();
            date.setHours(sc.nextInt());
            System.out.println("Digite a hora formato mm");
            date.setMinutes(sc.nextInt());
            
            Cliente cliente = new Cliente(sc.nextInt(),date);
            
            Socket t = new Socket("localhost", 12345);
            ObjectInputStream entrada = new ObjectInputStream(t.getInputStream());
            ObjectOutputStream saida = new ObjectOutputStream(t.getOutputStream());
            
            //saida.flush();
            saida.writeChars("Que horas sao?");

            Date data_TimeServer = (Date) entrada.readObject();
            
            Date data_T1 = new Date();
            
            Long resultado = (data_T1.getTime() - cliente.getTempoAgora().getTime() - data_TimeServer.getTime())/2;

            System.out.println("Hora correta " + Long.toString(resultado));
            //JOptionPane.showMessageDialog(null, "Data recebida do servidor:" + data_atual.toString());
            entrada.close();
            saida.close();
            System.out.println("Conexão encerrada");
            
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

}
