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
    
}
