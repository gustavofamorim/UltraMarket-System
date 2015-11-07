/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Gerenciador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Gustavo Freitas
 */
public class ConfigLoader {
    
    public static String URL = null;
    public static String USER = null;
    public static String PASSWORD = null;
    public static String CONTROLLER = null;
    
    static void load() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("config.txt"));

        ConfigLoader.CONTROLLER = br.readLine();
        ConfigLoader.URL = br.readLine();
        ConfigLoader.USER = br.readLine();
        ConfigLoader.PASSWORD = br.readLine();
        System.out.println(URL);
        br.close();
    }
    
}
