/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.controller;

import br.com.sistema.gerenciadores.GerenciadorDeFeriado;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Reginaldo
 */
public class LerCsv {

    public void readCsvFile(String path) throws IOException, SQLException, ParseException {

//A estrutura try-catch é usada pois o objeto BufferedWriter exige que as
//excessões sejam tratadas
        try {

//Criação de um buffer para a ler de uma stream
            BufferedReader StrR = new BufferedReader(new FileReader(path));

            String Str;
            String[] TableLine;
            String Str2;

//Essa estrutura do looping while é clássica para ler cada linha
//do arquivo
            while ((Str = StrR.readLine()) != null) {
//Aqui usamos o método split que divide a linha lida em um array de String
//passando como parametro o divisor ";".

                TableLine = Str.split(";");
//O foreach é usado para imprimir cada célula do array de String.
                List lista = new ArrayList();
                for (String cell : TableLine) {
                    lista.add(cell);
                }
                for (int i = 0; i < lista.size(); i++) {
                    String[] line = Str.split(",");
                    String nome = line[0];
                    String date = line[1];
                    GerenciadorDeFeriado feriado = new GerenciadorDeFeriado();
                    ConverterData data = new ConverterData();
                    Date d = data.stringParaDate(date);
                    if (feriado.adicionarFeriado(nome, d)) {
                        JOptionPane.showMessageDialog(null, "Importado com Sucesso");
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro na Importação");

                    }
                }

                System.out.println("\n");
            }

//Fechamos o buffer
            StrR.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
