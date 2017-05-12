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

/**
 *
 * @author alexandre.chaves
 */
public class TimeServer {

    public static void main(String[] args) throws InterruptedException, IOException {

        try {
            // Instancia o ServerSocket ouvindo a porta 12345
            ServerSocket servidorSocket = new ServerSocket(12345);
            System.out.println("Servidor ouvindo a porta 12345");

            Date date = new Date();
            Cliente serverObj = new Cliente(0, date);
            int count = 0;
            while (true) {

                //Date date = new Date();
                //server.setTempoAgora(date);
                // o método accept() bloqueia a execução até que
                // o servidor receba um pedido de conexão
                Socket cliente = servidorSocket.accept();

                System.out.println("Cliente conectado: " + cliente.getInetAddress().getHostAddress());
                
                ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
                ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
                saida.flush();
                
                Cliente dataT0 = (Cliente) entrada.readObject();  
                Long resultado = serverObj.getTempoAgora().getTime() - dataT0.getTempoAgora().getTime();
                
                Date dateFinal = new Date(resultado);
                        
                JOptionPane.showMessageDialog(null, "Data recebida do servidor:" + data_atual.toString());
                entrada.close();
                saida.writeObject(new Date());
                saida.close();
                cliente.close();

                count = count + 1;
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

}
