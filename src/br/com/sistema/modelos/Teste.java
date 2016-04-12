/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.modelos;

import br.com.sistema.controller.ConverterData;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Reginaldo
 */
public class Teste {
    ConverterData converter = new ConverterData();
    public static void main(String args[]) throws ParseException {
        Evento evento = new Evento();
        Timestamp d  =  new Timestamp(2011, 1, 20, 8, 45, 0, 0);
        
        Timestamp d2 = new Timestamp(2011, 1, 21, 11, 25, 0, 0);
        
//        long t = d.getTime();
//        String s = formatarTimestamp(t);
        
//        String r = subTimeStamps(d2, d2);
        
        evento.setNome("Teste");
        evento.setParticipantes(30);
        evento.setInicio(d);
        evento.setFim(d2);
        
        System.out.println(evento.toString());
    }
    
    public static String subTimeStamps(Timestamp inicio, Timestamp fim) {
        //Calcula o tempo transcorrido em milissegundos, entre dois horários
        long tempo = fim.getTime() - inicio.getTime();
        tempo = tempo / 60000;      //Converte o tempo para minutos
        long minutos = (tempo % 60);   //Retira os minutos da hora
        tempo = tempo / 60;         //Deixa em tempo apenas as horas
        return String.format("%02d:%02d", tempo, minutos);
    }
    
    public static String formatarTimestamp(long time) {  
        StringBuffer resultado = new StringBuffer();  
      
        // verifica quantidade de dias.  
        long dias = time/(1000*60*60*24);  
        time = time % (1000*60*60*24);  
      
        if  ( dias > 0 ) {  
            resultado.append(dias);  
//            resultado.append(" DD "<img src="http://javafree.uol.com.br/forum/images/smiles/icon_wink.gif">;  
        }  
      
        // verifica quantidade de horas.  
        long horas =  time / (1000*60*60);  
        time = time % (1000*60*60);  
                      
//        if  ( horas < 10 ) {  
//            resultado.append("0"<img src="http://javafree.uol.com.br/forum/images/smiles/icon_wink.gif">;  
//        }  
        resultado.append(horas);  
//        resultado.append(":"<img src="http://javafree.uol.com.br/forum/images/smiles/icon_wink.gif">;  
//      
        // verifica quantidade de minutos.  
        long minutos = time/(1000*60);  
        time = time % (1000*60);  
              
//        if  ( minutos < 10 ) {             
//            resultado.append("0"<img src="http://javafree.uol.com.br/forum/images/smiles/icon_wink.gif">;  
//        }  
        resultado.append(minutos);  
//        resultado.append(":"<img src="http://javafree.uol.com.br/forum/images/smiles/icon_wink.gif">;  
      
        // verifica quantidade de segundos.  
        long segundos = time/1000;  
        time = time % 1000;  
              
//        if  ( segundos < 10 ) {  
//            resultado.append("0"<img src="http://javafree.uol.com.br/forum/images/smiles/icon_wink.gif">;           
//        }  
        resultado.append(segundos);  
                   
        return resultado.toString();  
    }  
}
