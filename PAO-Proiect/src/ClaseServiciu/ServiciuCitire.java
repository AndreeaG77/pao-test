package ClaseServiciu;

import Clase.*;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class ServiciuCitire {
    private static ServiciuCitire sc;
    private ServiciuCitire() {}
    public static ServiciuCitire getSeriviciuCitire() {
        if (sc == null)
            sc = new ServiciuCitire();
        return sc;
    }

    public ArrayList<Autor> citireAutori() throws SQLException{
        Connection con = ConexiuneBD.getConexiuneBazaDate();
        ArrayList<Autor> aut = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM autor";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Autor a = new Autor(rs.getString("nume"), rs.getString("prenume"), rs.getString("data_nasterii"), rs.getString("data_decesului"));
                aut.add(a);
            }
            return aut;
        } catch (SQLException se) {
            System.out.print("Eroare la citire Autor");
        }
        return aut;
    }

    public ArrayList<Carte> citireCarti() throws SQLException{
        Connection con = ConexiuneBD.getConexiuneBazaDate();
        ArrayList<Carte> c = new ArrayList<>();
        try {
            Statement stmt1 = con.createStatement();
            String sql1 = "SELECT * FROM carte";
            ResultSet rs1 = stmt1.executeQuery(sql1);

            while (rs1.next()) {
                Statement stmt2 = con.createStatement();
                String n = rs1.getString("cod_autor");
                String sql2 = "SELECT * FROM autor WHERE cod_autor=" + n;
                ResultSet rs2 = stmt2.executeQuery(sql2);
                rs2.next();
                String numeCarte = rs1.getString("nume");
                Autor a = new Autor(rs2.getString("nume"), rs2.getString("prenume"), rs2.getString("data_nasterii"), rs2.getString("data_decesului"));
                Carte crt = new Carte(numeCarte, a);
                c.add(crt);
            }
            return c;
        } catch (SQLException se) {
            System.out.print("Eroare la citire Carte");
        }
        return c;
    }

    public ArrayList<Sectiune> citireSectiune(ArrayList<Carte> c) throws IOException{
        ArrayList<Sectiune> s = new ArrayList<>();
        try {
            String path = System.getProperty("user.dir") + "\\src\\FisiereCSV\\Sectiune.txt";
            Scanner scaner = new Scanner(new File(path));
            scaner.useDelimiter(",");

            ArrayList<Carte> carti1 = new ArrayList<>();
            carti1.add(c.get(4));
            carti1.add(c.get(5));
            carti1.add(c.get(8));
            Sectiune s1 = new Sectiune(scaner.next(), carti1);
            s.add(s1);

            ArrayList<Carte> carti2 = new ArrayList<>();
            carti2.add(c.get(6));
            carti2.add(c.get(9));
            carti2.add(c.get(10));
            Sectiune s2 = new Sectiune(scaner.next(), carti2);
            s.add(s2);

            ArrayList<Carte> carti3 = new ArrayList<>();
            carti3.add(c.get(7));
            carti3.add(c.get(11));
            Sectiune s3 = new Sectiune(scaner.next(), carti3);
            s.add(s3);

            ArrayList<Carte> carti4 = new ArrayList<>();
            carti4.add(c.get(3));
            carti4.add(c.get(0));
            carti4.add(c.get(2));
            carti4.add(c.get(3));
            Sectiune s4 = new Sectiune(scaner.next(), carti4);
            s.add(s4);

            return s;
        } catch (IOException e) {
            System.out.print("Eroare la citire Sectiune");
        }
        return s;
    }
}
