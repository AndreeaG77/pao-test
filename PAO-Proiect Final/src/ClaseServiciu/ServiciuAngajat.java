package ClaseServiciu;

import Clase.Angajat;
import Clase.Bibliotecar;
import Clase.Bodyguard;
import Interfete.InterfataAngajat;
import java.sql.*;
import java.util.Scanner;



public class ServiciuAngajat implements InterfataAngajat{
    public void vizualizareAngajati() throws SQLException{
        Connection con = ConexiuneBD.getConexiuneBazaDate();
        try {
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM bibliotecar";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String s = rs.getString("nume") + " " + rs.getString("prenume");
                s = s + "\n" + "Salariu: " + rs.getString("salariu") + "\n";
                s = s + "Bibliotcar\n";
                s = s + "Grad: " + rs.getString("grad");
                System.out.println(s);
                System.out.println();
            }
        }catch (SQLException se){
            se.printStackTrace();
        }
        try {
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM bodyguard";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String s = rs.getString("nume") + " " + rs.getString("prenume");
                s = s + "\n" + "Salariu: " + rs.getString("salariu") + "\n";
                s = s + "Bodyguard\n";
                s = s + "Firma securitate: " + rs.getString("firmaSecuritate");
                System.out.println(s);
                System.out.println();
            }
        }catch (SQLException se){
            se.printStackTrace();
        }
    }

    public void citireDateAngajatNou(Scanner scanner) throws SQLException {
        System.out.println("Adauga informatiile despre noul angajat");
        System.out.println("Nume: ");
        String nume = scanner.next();
        System.out.println("Prenume: ");
        String prenume = scanner.next();
        System.out.println("Apasa 1 pentru BIBLIOTECAR / 2 pentru BODYGUARD: ");
        int i = scanner.nextInt();
        Connection con = ConexiuneBD.getConexiuneBazaDate();
        int nmax=0;
        try {
            String caracteristica;
            Angajat angNou;
            String insereazaAng;
            if (i == 1) {
                System.out.println("Grad: ");
                caracteristica = scanner.next();
                angNou = new Bibliotecar(nume, prenume, caracteristica);
                insereazaAng = "INSERT INTO bibliotecar(cod_angajat,nume,prenume,salariu,grad) VALUES(?,?,?,?,?)";
                Statement stmt1 = con.createStatement();
                String sql = "SELECT max(cod_angajat) FROM bibliotecar";
                ResultSet rs = stmt1.executeQuery(sql);
                rs.next();
                nmax = rs.getInt("max(cod_angajat)");
            } else {
                System.out.println("Firma securitate: ");
                caracteristica = scanner.next();
                angNou = new Bodyguard(nume, prenume, caracteristica);
                insereazaAng = "INSERT INTO bodyuard(cod_angajat,nume,prenume,salariu,firmaSecuritate) VALUES(?,?,?,?,?)";
                Statement stmt2 = con.createStatement();
                String sql = "SELECT max(cod_angajat) FROM bodyguard";
                ResultSet rs = stmt2.executeQuery(sql);
                rs.next();
                nmax = rs.getInt("max(cod_angajat)");
            }

            PreparedStatement preparedStatement = con.prepareStatement(insereazaAng);
            preparedStatement.setInt(1, (nmax+1));
            preparedStatement.setString(2, nume);
            preparedStatement.setString(3, prenume);
            preparedStatement.setInt(4, angNou.getSalariu());
            preparedStatement.setString(5, caracteristica);
            preparedStatement.executeUpdate();
        }catch (SQLException se){
            se.printStackTrace();
        }
    }

    public void eliminaAngajat(Scanner scanner) throws SQLException{
        Connection con = ConexiuneBD.getConexiuneBazaDate();
        System.out.println("Apasa 1 pentru BIBLIOTECAR / 2 pentru BODYGUARD: ");
        int i = scanner.nextInt();
        if(i==1){
            try{
                Statement stmt1 = con.createStatement();
                String sql = "SELECT max(cod_angajat) FROM bibliotecar";
                ResultSet rs = stmt1.executeQuery(sql);
                rs.next();
                int nmax = rs.getInt("max(cod_angajat)");
                System.out.println("Alege un numar intre 1 si " + nmax);
                int n = scanner.nextInt();
                String stergeAngajat = "DELETE FROM bibliotecar WHERE cod_angajat=" + n;
                Statement stmt2 = con.createStatement();
                stmt2.executeUpdate(stergeAngajat);
            }catch (SQLException se){
                se.printStackTrace();
            }
        }
        else{
            try{
                Statement stmt1 = con.createStatement();
                String sql = "SELECT max(cod_angajat) FROM bodyguard";
                ResultSet rs = stmt1.executeQuery(sql);
                rs.next();
                int nmax = rs.getInt("max(cod_angajat)");
                System.out.println("Alege un numar intre 1 si " + nmax);
                int n = scanner.nextInt();
                String stergeAngajat = "DELETE FROM bodyguard WHERE cod_angajat=" + n;
                Statement stmt2 = con.createStatement();
                stmt2.executeUpdate(stergeAngajat);
            }catch (SQLException se){
                se.printStackTrace();
            }
        }
    }
}
