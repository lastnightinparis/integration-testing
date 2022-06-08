package function.utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CsvPrinter {

    private String filepath;

    public void print(double x, double y) throws FileNotFoundException {
        try (PrintStream printStream = new PrintStream(new FileOutputStream(filepath, true))) {
            printStream.printf("%s, %s %n", x, y);
        }
    }
}
