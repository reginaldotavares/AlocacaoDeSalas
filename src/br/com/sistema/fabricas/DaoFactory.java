package br.com.sistema.fabricas;

public class DaoFactory {
    public static DaoFactoryIF creatFactory(){
        return new DaoFactoryBD();
    }
}
