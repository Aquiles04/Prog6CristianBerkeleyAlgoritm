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
import java.util.Random;
import static java.lang.Thread.sleep;

/**
 *
 * @author alexandre.chaves
 */
public class TimeServerCristian {

    public static void main(String[] args) throws InterruptedException, IOException {
        
        ObjectInputStream entrada;
        ObjectOutputStream saida;

        try {
            // Instancia o ServerSocket ouvindo a porta 12345
            ServerSocket servidorSocket = new ServerSocket(12345);
            System.out.println("Servidor ouvindo a porta 12345");

            
            int count = 0;
                            

            while (true) {

                //Date date = new Date();
                //server.setTempoAgora(date);
                // o método accept() bloqueia a execução até que
                // o servidor receba um pedido de conexão
                System.out.println("Esperando Conexao");
                
                Socket cliente = servidorSocket.accept();
                
                Date dateInicial = new Date();
                
                //Cliente serverObj = new Cliente(count, date);
                System.out.println("Cliente conectado: " + cliente.getInetAddress().getHostAddress());

                
                
                saida = new ObjectOutputStream(cliente.getOutputStream());
                saida.flush();
                
                entrada = new ObjectInputStream(cliente.getInputStream());
                
                //saida.writeObject("Conexao estabelecida com sucesso...\n");
                //saida.flush();
                
                
                System.out.println(entrada.readObject());
                
                Random rand = new Random();
                //this.hora = rand.nextInt(23);
                //this.minuto = rand.nextInt(59);
                int espera = rand.nextInt((30 - 5 + 1)+5);
                System.out.println("Tempo de espera " + espera);
                //servidorSocket.setSoTimeout(espera);

                sleep(espera * 1000);
                
                Date dateFinal = new Date();
                System.out.println("Data inicial " + dateInicial.getTime());
                System.out.println("Data final " + dateFinal.getTime());

                Long resposta = dateFinal.getTime() - dateInicial.getTime();
                
                saida.writeObject(resposta);
                saida.flush();
    
                //Cliente dataT0 = (Cliente) entrada.readObject();  
                //Long resultado = serverObj.getTempoAgora().getTime() - dataT0.getTempoAgora().getTime();
                
                //Date dateFinal = new Date(resultado);
                        
                //JOptionPane.showMessageDialog(null, "Data recebida do servidor:" + data_atual.toString());
//                saida.writeObject(new Date());

                entrada.close();
                saida.close();
                cliente.close();

                count = count + 1;
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

}
