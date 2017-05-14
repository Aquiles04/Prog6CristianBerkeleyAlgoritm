/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog6cristianberkeleyalgoritm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 *
 * @author Usuario
 */
public class T {

    public static void main(String[] args) throws InterruptedException, IOException {

        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

        MulticastSocket mSocket = new MulticastSocket(3333);
        String group = "224.0.0.1";

        mSocket.joinGroup(InetAddress.getByName(group));

        mSocket.receive(receivePacket);

        String mensagemCoordenador = new String(receivePacket.getData());
        String tempoCoor[] = mensagemCoordenador.split(":");
        int horaCoordenador = Integer.parseInt(tempoCoor[0]);
        int minutoCoordenador = Integer.parseInt(tempoCoor[1]);

        String tempoEscravo[] = this.tempoAgora.split(":");
        int horaEscravo = Integer.parseInt(tempoEscravo[0]);
        int minutoEscravo = Integer.parseInt(tempoEscravo[1]);

        int horaRes = 0;
        int minRes = 0;

        System.out.println(
                new String(receivePacket.getData(), receivePacket.getOffset(),
                        receivePacket.getLength()));

        if (horaCoordenador <= horaEscravo) {
            horaRes = horaEscravo - horaCoordenador;
        }

        if (minutoCoordenador <= minutoEscravo) {
            minRes = minutoEscravo - minutoCoordenador;
        }

        if (horaCoordenador >= horaEscravo) {
            horaRes = horaCoordenador - horaEscravo;
        }

        if (minutoCoordenador >= minutoEscravo) {
            minRes = minutoCoordenador - minutoEscravo;
        }

        String tempoRes = "" + horaRes + ":" + minRes;

        sendData = tempoRes.getBytes();

        //DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 7777);

        //clientSocket.send(sendPacket);
        //System.out.println("FROM SERVER:" + modifiedSentence);

//        byte[] sendData = new byte[1024];
//        byte[] receiveData = new byte[1024];
//        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
//        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
//        MulticastSocket mSocket = new MulticastSocket(3333);
//        String group = "224.0.0.1";		
//        mSocket.joinGroup(InetAddress.getByName(group));
//
//		
//        mSocket.receive(receivePacket);
//        System.out.println(new String(receivePacket.getData(), receivePacket.getOffset(),    
//        receivePacket.getLength()));
//		
    }
}
