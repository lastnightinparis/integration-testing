package logarithmic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import function.logarithmic.Ln;
import function.logarithmic.Log2;
import function.logarithmic.Log3;
import function.logarithmic.Log5;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class LogarithmStubs {
    private static final Double EPS = 0.01;
    public static final Ln ln = mock(Ln.class);
    public static final Log2 log2 = mock(Log2.class);
    public static final Log3 log3 = mock(Log3.class);
    public static final Log5 log5 = mock(Log5.class);

    private static void fillLnMockFromCsv() throws IOException, CsvException {
        try (CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/logMocks/ln.csv"))) {
            List<String[]> records = csvReader.readAll();
            for (String[] record : records) {
                when(ln.apply(eq(Double.parseDouble(record[0])), any())).thenReturn(Double.parseDouble(record[1]));
            }
        }
    }

    private static void fillLog2MockFromCsv() throws IOException, CsvException {
        try (CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/logMocks/log2.csv"))) {
            List<String[]> records = csvReader.readAll();
            for (String[] record : records) {
                when(log2.apply(eq(Double.parseDouble(record[0])), any())).thenReturn(Double.parseDouble(record[1]));
            }
        }
    }

    private static void fillLog3MockFromCsv() throws IOException, CsvException {
        try (CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/logMocks/log3.csv"))) {
            List<String[]> records = csvReader.readAll();
            for (String[] record : records) {
                when(log3.apply(eq(Double.parseDouble(record[0])), any())).thenReturn(Double.parseDouble(record[1]));
            }
        }
    }

    private static void fillLog5MockFromCsv() throws IOException, CsvException {
        try (CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/logMocks/log5.csv"))) {
            List<String[]> records = csvReader.readAll();
            for (String[] record : records) {
                when(log5.apply(eq(Double.parseDouble(record[0])), any())).thenReturn(Double.parseDouble(record[1]));
            }
        }
    }

    @BeforeAll
    public static void setUp() throws IOException, CsvException {
        LogarithmStubs.fillLnMockFromCsv();
        LogarithmStubs.fillLog2MockFromCsv();
        LogarithmStubs.fillLog3MockFromCsv();
        LogarithmStubs.fillLog5MockFromCsv();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/logMocks/ln.csv")
    void testLnApply(Double x, Double expected) {
        Double result = ln.apply(x, EPS);
        assertEquals(expected, result, EPS);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/logMocks/log2.csv")
    void testLog2Apply(Double x, Double expected) {
        Double result = log2.apply(x, EPS);
        assertEquals(expected, result, EPS);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/logMocks/log3.csv")
    void testLog3Apply(Double x, Double expected) {
        Double result = log3.apply(x, EPS);
        assertEquals(expected, result, EPS);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/logMocks/log5.csv")
    void testLog5Apply(Double x, Double expected) {
        Double result = log5.apply(x, EPS);
        assertEquals(expected, result, EPS);
    }
}
