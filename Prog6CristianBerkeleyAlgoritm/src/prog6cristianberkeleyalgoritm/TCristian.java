/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog6cristianberkeleyalgoritm;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.lang.Thread.sleep;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JOptionPane;
import static java.lang.Thread.sleep;

/**
 *
 * @author alexandre.chaves
 */
public class TCristian {

    public static void main(String[] args) throws InterruptedException, IOException {

        try {
            ObjectInputStream entrada;
            ObjectOutputStream saida;
       	    Scanner sc = new Scanner(System.in); 

            System.out.println("Digite minha id");
            String id = sc.nextLine();
            System.out.println("Digite a hora formato hh");
            Date date = new Date();
            int hora = sc.nextInt();
            date.setHours(hora);
            System.out.println("Digite a hora formato mm");
            int minuto = sc.nextInt();
            date.setMinutes(minuto);
            
            Cliente cliente = new Cliente(id,date);
            String endereco = "localhost";
            int porta = 12345;        
            
            Socket t = new Socket(endereco, porta);
            System.out.println("Conectado ao servidor " + endereco + ", na porta: " + porta);
            
            entrada = new ObjectInputStream(t.getInputStream());
            
            saida = new ObjectOutputStream(t.getOutputStream());
            saida.flush();
            
            saida.writeObject("Que horas sao?");

            Long data_TimeServer = (Long)entrada.readObject();
            
            Date data_T1 = new Date(cliente.getTempoAgora().getTime() + data_TimeServer);
            
            System.out.println("Data servidor " + data_TimeServer);
            System.out.println("Data t0 " + cliente.getTempoAgora().getTime());
            System.out.println("Data t1 " + data_T1.getTime());

            Long resultado = (data_T1.getTime() - cliente.getTempoAgora().getTime() - data_TimeServer)/2;
            Date dataResultado = new Date(resultado);
            System.out.println("Hora correta " + dataResultado);
            //JOptionPane.showMessageDialog(null, "Data recebida do servidor:" + data_atual.toString());
            entrada.close();
            saida.close();
            System.out.println("Conexão encerrada");
            
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

}
