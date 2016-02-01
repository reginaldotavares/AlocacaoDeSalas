/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.controller;

/**
 *
 * @author Reginaldo
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class CriarCVS {


public void createCsvFile(){
//A estrutura try-catch é usada pois o objeto BufferedWriter exige que as
//excessões sejam tratadas
    

try{

//Criação de um buffer para a escrita em uma stream
BufferedWriter StrW = new BufferedWriter(new FileWriter("D:\\feriados.csv"));

//Escrita dos dados da tabela
//StrW.write("Nome;Data\n");
StrW.write("Natal;25/12/2015\n");
StrW.write("Dia Mundial da Paz;01/01/2016\n");
StrW.write("Aniversário do Professor Diogo;02/02/2016");

//Fechamos o buffer
StrW.close();
}catch (FileNotFoundException ex)
{
JOptionPane.showMessageDialog(null, ex);
}catch (IOException e)
{
e.printStackTrace(); }
}
}
