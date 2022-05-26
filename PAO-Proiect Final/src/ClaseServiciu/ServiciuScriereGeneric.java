package ClaseServiciu;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ServiciuScriereGeneric {
    private static ServiciuScriereGeneric ssg;
    private ServiciuScriereGeneric() {}
    public static ServiciuScriereGeneric getServiciuScriereGeneric() {
        if (ssg == null)
            ssg = new ServiciuScriereGeneric();
        return ssg;
    }
    public <T, S> void scriereGenerica(T t, S s) {
        String path = "";
        String text = "";

        // Scriere in fisier date clienti
        if(t.getClass().getName().equals("Clase.Client")){
            path = System.getProperty("user.dir") + "\\src\\FisiereCSV\\" + s;
            text = t.toString() + "\n";
        }

        // Serviciu audit - numele actiuni, data si timpul apelarii
        else {
            path = System.getProperty("user.dir") + "\\src\\FisiereCSV\\Audit.txt";
            LocalDateTime dt = LocalDateTime.now();
            DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String dtFormatted = dt.format(myFormat);
            text = t + " - " + dtFormatted + "\n";
        }

        try {
            FileWriter fw = new FileWriter(path, true);
            fw.write(text);
            fw.close();
        } catch (IOException e) {
        }
    }
}
