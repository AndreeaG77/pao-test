package ClaseServiciu;

import Clase.Carte;
import Clase.Client;
import Interfete.InterfataClient;

import java.sql.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.concurrent.Callable;

public class ServiciuClient implements InterfataClient {
    public void creareTabelClientImprumut() throws SQLException {
        String creeazaTabel = "CREATE TABLE IF NOT EXISTS client_imprumut" +
                "(cod_client int PRIMARY KEY AUTO_INCREMENT, nume character(30), prenume character(30), cnp character(20), numeCarte character(30), data character(30))";
        Connection con = ConexiuneBD.getConexiuneBazaDate();
        try {
            Statement stmt = con.createStatement();
            stmt.execute(creeazaTabel);
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
    public void creareTabelClientRetur() throws SQLException {
        String creeazaTabel= "CREATE TABLE IF NOT EXISTS client_retur" +
                "(cod_client int PRIMARY KEY AUTO_INCREMENT, nume character(30), prenume character(30), cnp character(20), numeCarte character(30), data character(30))";
        Connection con = ConexiuneBD.getConexiuneBazaDate();
        try {
            Statement stmt = con.createStatement();
            stmt.execute(creeazaTabel);
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
    public  Client citireDateClientImprumut(Scanner scanner, ArrayList<Carte> c) throws SQLException{
        System.out.println("Introduceti datele personale: ");
        System.out.println("Nume: ");
        String nume = scanner.next();
        System.out.println("Prenume: ");
        String prenume = scanner.next();
        System.out.println("CNP: ");
        String cnp = scanner.next();
        LocalDate dataImprumutarii = LocalDate.now();
        System.out.println("Numele cartii: ");
        String numeCarte= scanner.nextLine();
        numeCarte+=scanner.nextLine();
        boolean verificareNume = verificaNume(numeCarte);
        Client cl = new Client();
        if(verificareNume) {
            boolean disponibila = verificaDisponibilitate(numeCarte);
            if (disponibila) {
                Carte carteImprumutata = gasesteCarte(numeCarte, c);
                cl = new Client(nume, prenume, cnp, carteImprumutata);
                int nr = carteImprumutata.getNrExemplare();
                nr--;
                carteImprumutata.setNrExemplare(nr);
                creareTabelClientImprumut();
                Connection con = ConexiuneBD.getConexiuneBazaDate();
                String insereazaClient = "INSERT INTO client_imprumut(nume,prenume,cnp, numeCarte, data) VALUES(?,?,?,?,?)";
                try {
                    PreparedStatement preparedStatement = con.prepareStatement(insereazaClient);
                    preparedStatement.setString(1, cl.getNume());
                    preparedStatement.setString(2, cl.getPrenume());
                    preparedStatement.setString(3, cl.getCnp());
                    preparedStatement.setString(4, cl.getCarteImprumutataReturnata().getNume());
                    preparedStatement.setString(5, cl.getDataImprumutariiReturului().toString());
                    preparedStatement.executeUpdate();
                    updateCarte(numeCarte);
                } catch (SQLException se){
                    se.printStackTrace();
                }
            } else System.out.println("Carte indisponibila");
        }
        else System.out.println("Nume invalid");
        return cl;
    }

    public Client citireDateClientRetur(Scanner scanner, ArrayList<Carte> c) throws SQLException{
        System.out.println("Introduceti datele personale: ");
        System.out.println("Nume: ");
        String nume = scanner.next();
        System.out.println("Prenume: ");
        String prenume = scanner.next();
        System.out.println("CNP: ");
        String cnp = scanner.next();
        System.out.println("Numele cartii: ");
        String numeCarte= scanner.nextLine();
        numeCarte+=scanner.nextLine();
        boolean verificareNume = verificaNume(numeCarte);
        Client cl = new Client();
        if(verificareNume) {
            boolean verificareDate = verificaDate(cnp, numeCarte);
            if(verificareDate) {
                Carte carteReturnata = gasesteCarte(numeCarte, c);
                cl = new Client(nume, prenume, cnp, carteReturnata);
                int nr = carteReturnata.getNrExemplare();
                nr++;
                carteReturnata.setNrExemplare(nr);
                creareTabelClientRetur();
                Connection con = ConexiuneBD.getConexiuneBazaDate();
                String insereazaClient = "INSERT INTO client_retur(nume,prenume,cnp, numeCarte, data) VALUES(?,?,?,?,?)";
                try {
                    PreparedStatement preparedStatement = con.prepareStatement(insereazaClient);
                    preparedStatement.setString(1, cl.getNume());
                    preparedStatement.setString(2, cl.getPrenume());
                    preparedStatement.setString(3, cl.getCnp());
                    preparedStatement.setString(4, cl.getCarteImprumutataReturnata().getNume());
                    preparedStatement.setString(5, cl.getDataImprumutariiReturului().toString());
                    preparedStatement.executeUpdate();
                } catch (SQLException se){
                    se.printStackTrace();
                }
            }
            else System.out.println("Nu exista in istoric imprumutarea cartii " + numeCarte + " facuta de catre clientul cu cnp-ul: " + cnp);
        }
        else System.out.println("Nume invalid");
        return cl;
    }

    public boolean verificaNume(String numeCarte){
        Connection con = ConexiuneBD.getConexiuneBazaDate();
        try {
            Statement stmt = con.createStatement();
            String sql = "SELECT nume FROM carte";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                if(numeCarte.equals(rs.getString("nume")))
                    return true;
            }
            return false;
        } catch (SQLException se){
            se.printStackTrace();
        }
        return false;
    }

    public boolean verificaDisponibilitate(String numeCarte) throws SQLException{
        Connection con = ConexiuneBD.getConexiuneBazaDate();
        try {
            Statement stmt = con.createStatement();
            String sql = "SELECT nume, nr_exemplare FROM carte";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                if(rs.getString("nume").equals(numeCarte) && rs.getInt("nr_exemplare")>0)
                    return true;
            }
            return false;
        } catch (SQLException se){
            se.printStackTrace();
        }
        return false;
    }

    public  Carte gasesteCarte(String numeCarte,ArrayList<Carte> c){
        for(int i=0; i<c.size(); i++){
            if(numeCarte.equals(c.get(i).getNume())){
                Carte cAux = c.get(i);
                return cAux;
            }
        }
        Carte cAux2 = c.get(0);
        return c.get(0);
    }
    public boolean  verificaDate(String cnp, String numeCarte){
        Connection con = ConexiuneBD.getConexiuneBazaDate();
        try {
            String cautaClient = "SELECT cnp, numeCarte FROM client_imprumut WHERE cnp=? AND numeCarte=?";
            PreparedStatement preparedStatement = con.prepareStatement(cautaClient);
            preparedStatement.setString(1, cnp);
            preparedStatement.setString(2, numeCarte);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()) return true;
            else return false;
        } catch (SQLException se){
            se.printStackTrace();
        }
        return false;
    }

    public void updateCarte(String numeCarte) throws SQLException{
        Connection con = ConexiuneBD.getConexiuneBazaDate();
        try {
            String updateNr = "UPDATE carte SET nr_exemplare = nr_exemplare - 1 WHERE nume=?";
            PreparedStatement preparedStatement = con.prepareStatement(updateNr);
            preparedStatement.setString(1, numeCarte);
            preparedStatement.executeUpdate();
        } catch (SQLException se){
            se.printStackTrace();
        }
    }
    public void vizualizareListe() throws SQLException{
        Connection con = ConexiuneBD.getConexiuneBazaDate();
        try {
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM client_imprumut";
            ResultSet rs = null;
            try{
                rs = stmt.executeQuery(sql);
            } catch (SQLException se){
                System.out.println("Tabela client_imprumut nu a fost creata inca");
                System.out.println();
            }
            int contor1 = -1;
            if (rs != null) {
                contor1 = 0;
                while (rs.next()) {
                    String s = rs.getString("nume") + " " + rs.getString("prenume");
                    s = s + " CNP: " + rs.getString("cnp");
                    s = s + " - Carte imprumutata: " + rs.getString("numeCarte");
                    s = s + " - Data imprumutarii: " + rs.getString("data");
                    System.out.println(s);
                    System.out.println();
                    contor1++;
                }
            }
            else if(contor1==0){
                System.out.println("Niciun client gasit in tabela client_imprumut");
                System.out.println();
            }
        }catch(SQLException se){
            se.printStackTrace();
        }
        try {
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM client_retur";
            ResultSet rs = null;
            try{
                rs = stmt.executeQuery(sql);
            } catch (SQLException se){
                System.out.println("Tabela client_retur nu a fost creata inca");
                System.out.println();
            }
            int contor2 = -1;
            if(rs!=null) {
                contor2 = 0;
                while (rs.next()) {
                    String s = rs.getString("nume") + " " + rs.getString("prenume");
                    s = s + " CNP: " + rs.getString("cnp");
                    s = s + " - Carte returnata: " + rs.getString("numeCarte");
                    s = s + " - Data returnarii: " + rs.getString("data");
                    System.out.println(s);
                    System.out.println();
                    contor2++;
                }
            }
            else if(contor2==0){
                System.out.println("Niciun client gasit in tabela client_retur");
                System.out.println();
            }
        }catch (SQLException se){
            se.printStackTrace();
        }
    }
}
