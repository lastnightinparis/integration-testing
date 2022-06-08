package function.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Setter
public class CsvPrinter {

    private String filepath;

    public void print(double x, double y) throws IOException {
        //File file = new File("src/test/resources/out", filepath);
        //file.createNewFile();
        try (PrintStream printStream = new PrintStream(new FileOutputStream(filepath, true))) {
            printStream.printf("%s, %s %n", x, y);
        }
    }
}
