/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.controller;

import java.io.IOException;

/**
 *
 * @author Reginaldo
 */
public class teste {
    public static void main(String args[]) throws IOException {
        CriarCVS cvs = new CriarCVS();
        cvs.createCsvFile();
        
//        LerCVS cvs = new LerCVS();
//        cvs.readCsvFile();
        
    }
}
 