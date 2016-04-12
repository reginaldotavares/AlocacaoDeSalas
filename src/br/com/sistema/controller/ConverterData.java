/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.controller;

import static java.lang.String.format;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.text.ParseException;
import java.sql.Timestamp;

/**
 *
 * @author NandaPC
 */
public class ConverterData {
    public Date stringParaDate(String date) throws ParseException{
//        Date data = null;
        
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//            data = (Date)formatter.parse(date);
            java.sql.Date dat = new java.sql.Date(formatter.parse(date).getTime());
        
        return dat;
    }
    
    
    public boolean verificaData(Date data1, Date data2){
	boolean data;
	if (data1.before(data2)){
		data = true;
	}
	else if (data1.after(data2))
		data = false;
	else
		data = true;
	return data;
    }
    
    public String subTimeStamps(Timestamp inicio, Timestamp fim) {
        //Calcula o tempo transcorrido em milissegundos, entre dois horários
        long f=fim.getTime();
        long i=inicio.getTime();
        long tempo = f-i;
        tempo = tempo / 60000;      //Converte o tempo para minutos
        int minutos = (int) (tempo % 60);   //Retira os minutos da hora
        tempo = tempo / 60;         //Deixa em tempo apenas as horas
        return String.format("%02dh%02dm00s", tempo, minutos);
    }
    
    public static long somaTimestamp(Timestamp inicio, Timestamp fim) {  
        return inicio.getTime() + fim.getTime();  
    } 
    
    public static long subtraiTimestamp(Timestamp inicio, Timestamp fim) {  
        return fim.getTime() - inicio.getTime();  
    } 

    
}
