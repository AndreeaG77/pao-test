package ClaseServiciu;

import java.sql.*;

public class ConexiuneBD {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/agbd";
    private static final String UTILIZATOR = "root";
    private static final String PAROLA = "java2022!7";

    private static Connection conexiuneBazaDate;

    private ConexiuneBD() { }

    public static Connection getConexiuneBazaDate() {

        try {
            if (conexiuneBazaDate == null || conexiuneBazaDate.isClosed()) {
                conexiuneBazaDate = DriverManager.getConnection(DB_URL, UTILIZATOR, PAROLA);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }

        return conexiuneBazaDate;
    }

    public static void inchidereConexiuneBD() {
        try {
            if (conexiuneBazaDate != null && !conexiuneBazaDate.isClosed()) {
                conexiuneBazaDate.close();
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
}
