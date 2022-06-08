package logarithmic;

import static org.junit.jupiter.api.Assertions.assertEquals;

import function.logarithmic.Ln;
import function.logarithmic.Log2;
import function.logarithmic.Log3;
import function.logarithmic.Log5;
import function.utils.CsvPrinter;
import java.io.IOException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class LogarithmWriteCsvTest {
    private final Double EPS = 0.01;
    private final Ln ln = new Ln();
    private final Log2 log2 = new Log2(ln);
    private final Log3 log3 = new Log3(ln);
    private final Log5 log5 = new Log5(ln);
    private final CsvPrinter csvPrinter = new CsvPrinter();

    @ParameterizedTest
    @CsvFileSource(resources = "/logMocks/ln.csv")
    public void testLnApply(Double x, Double expected) throws IOException {
        Double result = ln.apply(x, EPS);
        csvPrinter.setFilepath("src/test/resources/out/ln.csv");
        csvPrinter.print(x, result);
        assertEquals(expected, result, EPS);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/logMocks/log2.csv")
    public void testLog2Apply(Double x, Double expected) throws IOException {
        Double result = log2.apply(x, EPS);
        csvPrinter.setFilepath("src/test/resources/out/log2.csv");
        csvPrinter.print(x, result);
        assertEquals(expected, result, EPS);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/logMocks/log3.csv")
    public void testLog3Apply(Double x, Double expected) throws IOException {
        Double result = log3.apply(x, EPS);
        csvPrinter.setFilepath("src/test/resources/out/log3.csv");
        csvPrinter.print(x, result);
        assertEquals(expected, result, EPS);
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/logMocks/log5.csv")
    public void testLog5Apply(Double x, Double expected) throws IOException {
        Double result = log5.apply(x, EPS);
        csvPrinter.setFilepath("src/test/resources/out/log5.csv");
        csvPrinter.print(x, result);
        assertEquals(expected, result, EPS);
    }

}
