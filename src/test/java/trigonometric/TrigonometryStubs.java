package trigonometric;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import function.trigonometric.Cos;
import function.trigonometric.Sin;
import function.trigonometric.Tan;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class TrigonometryStubs {
    private static final Double EPS = 0.01;
    public static final Cos cos = mock(Cos.class);
    public static final Sin sin = mock(Sin.class);
    public static final Tan tan = mock(Tan.class);

    private static void fillSinMockFromCsv() throws IOException, CsvException {
        try (CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/trigMocks/sin.csv"))) {
            List<String[]> records = csvReader.readAll();
            for (String[] record : records) {
                when(sin.apply(eq(Double.parseDouble(record[0])), any())).thenReturn(Double.parseDouble(record[1]));
            }
        }
    }

    private static void fillCosMockFromCsv() throws IOException, CsvException {
        try (CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/trigMocks/cos.csv"))) {
            List<String[]> records = csvReader.readAll();
            for (String[] record : records) {
                when(cos.apply(eq(Double.parseDouble(record[0])), any())).thenReturn(Double.parseDouble(record[1]));
            }
        }
    }

    private static void fillTanMockFromCsv() throws IOException, CsvException {
        try (CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/trigMocks/tan.csv"))) {
            List<String[]> records = csvReader.readAll();
            for (String[] record : records) {
                when(tan.apply(eq(Double.parseDouble(record[0])), any())).thenReturn(Double.parseDouble(record[1]));
            }
        }
    }

    @BeforeAll
    public static void setUp() throws IOException, CsvException {
        TrigonometryStubs.fillSinMockFromCsv();
        TrigonometryStubs.fillCosMockFromCsv();
        TrigonometryStubs.fillTanMockFromCsv();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/trigMocks/cos.csv")
    void testCosApply(Double x, Double expected) {
        Double result = cos.apply(x, EPS);
        assertEquals(expected, result, EPS);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/trigMocks/sin.csv")
    void testSinApply(Double x, Double expected) {
        Double result = sin.apply(x, EPS);
        assertEquals(expected, result, EPS);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/trigMocks/tan.csv")
    void testTanApply(Double x, Double expected) {
        Double result = tan.apply(x, EPS);
        assertEquals(expected, result, EPS);
    }
}
