/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog6cristianberkeleyalgoritm;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 *
 * @author alexandre.chaves
 */
public class Prog6CristianBerkeleyAlgoritm {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException, IOException {
        // TODO code application logic here
        
        
          
        //Scanner sc = new Scanner(System.in);

        InetAddress endereco = InetAddress.getByName("localhost");
        int portaCoordenador = 7777;
        
        Coordenador coordenador = new Coordenador(endereco, portaCoordenador);
        coordenador.getSocket().setSoTimeout(10000);

        //System.out.println("Informe mensagem que será enviada para grupo");
        //coordenador.setMensagem(sc.nextLine());
        //coordenador.setMensagem(coordenador.getMensagem() + Integer.toString(coordenador.getPorta()));

        String tempoCoordenador = coordenador.gettempoAgora();
        coordenador.setMensagem(tempoCoordenador);
        
        //System.out.println("Mensagem sera: "+ coordenador.getMensagem() );
        
        
        MulticastSocket remSocket = new MulticastSocket();
        byte[] send1;
        byte[] send2;

        send1 = coordenador.getMensagem().getBytes();
        send2 = Integer.toString(coordenador.getPorta()).getBytes();

        String group = "224.0.0.1";
        int portaGrupo = 3333;
        
        DatagramPacket pacote1 = new DatagramPacket(send1, send1.length, InetAddress.getByName(group), portaGrupo);
        //DatagramPacket pacote2 = new DatagramPacket(send2, send2.length, InetAddress.getByName(group), portaGrupo);


       

        Escravo escravo1 = new Escravo();
        Escravo escravo2 = new Escravo();
        Escravo escravo3 = new Escravo();
        Escravo escravo4 = new Escravo();
        Escravo escravo5 = new Escravo();

        escravo1.start();
        escravo2.start();
        escravo3.start();
        escravo4.start();
        escravo5.start();

        
        remSocket.send(pacote1);
        //remSocket.send(pacote2);

        int count = 0;
        
        byte[] receiveData = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        
        while (true) {
            
            Thread.sleep(5000);
            coordenador.getSocket().receive(receivePacket);
            
            String msg = new String(receivePacket.getData(), receivePacket.getOffset(),
                                    receivePacket.getLength());

           
            System.out.println("Recebida: " + msg);

            //socket.close();
            
            count ++;
            if (count == 10){
            
                break;
        
            }
            
        }
        remSocket.close();

    }
        
    
}
