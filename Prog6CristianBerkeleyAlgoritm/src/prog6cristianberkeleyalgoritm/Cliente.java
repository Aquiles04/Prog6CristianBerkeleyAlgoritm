/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog6cristianberkeleyalgoritm;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author alexandre.chaves
 */
public class Cliente {
    
    
     private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
     private String id;
     private Date tempoAgora;

    public Cliente(String id, Date tempoAgora) {
        this.id = id;
        this.tempoAgora = tempoAgora;
    }

    public Cliente(Date tempoAgora) {
        this.tempoAgora = tempoAgora;
    }

    Cliente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getTempoAgora() {
        return tempoAgora;
    }

    public void setTempoAgora(Date tempoAgora) {
        this.tempoAgora = tempoAgora;
    }
     
     
     
}
