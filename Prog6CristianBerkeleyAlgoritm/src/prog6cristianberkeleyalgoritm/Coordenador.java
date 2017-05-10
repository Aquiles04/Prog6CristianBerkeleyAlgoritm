/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog6cristianberkeleyalgoritm;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Random;

/**
 *
 * @author alexandre.chaves
 */
public class Coordenador {
    
     private DatagramSocket socket;
    private InetAddress endereco;
    private int porta;
    private String mensagem;
    private String tempoAgora;
    private int hora;
    private int minuto;

    public Coordenador(InetAddress endereco, int porta) throws IOException {
        
        this.endereco = endereco;
        this.socket = new DatagramSocket (porta);
        this.porta = porta;
        
        Random rand = new Random();
        //this.hora = rand.nextInt(23);
        //this.minuto = rand.nextInt(59);
        //this.tempoAgora = "" + hora + ":"+ minuto;
        this.tempoAgora = "15:00";
    }

    public Coordenador(int porta) throws IOException {
        
        this.socket = new DatagramSocket (porta);
    }

    Coordenador() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public DatagramSocket getSocket() {
        return socket;
    }

    public void setSocket(DatagramSocket socket) {
        this.socket = socket;
    }

    
    public int getPorta() {
        return porta;
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String gettempoAgora() {
        return tempoAgora;
    }

    public void settempoAgora(String tempoAgora) {
        this.tempoAgora = tempoAgora;
    }

    public InetAddress getEndereco() {
        return endereco;
    }

    public void setEndereco(InetAddress endereco) {
        this.endereco = endereco;
    }
   

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }
	
    //    public static void main(String [] args) throws IOException{
//            
//            
//		MulticastSocket remSocket = new MulticastSocket();
//		byte[] send;
//                
//		String message = "hello group";
//		send = message.getBytes();
//                
//		String group = "224.0.0.1";
//                
//                int porta = 3333;
//		DatagramPacket pacote = new DatagramPacket(send, send.length,InetAddress.getByName(group) , porta);
//		
//                remSocket.send(pacote);
//				
//	}
}
