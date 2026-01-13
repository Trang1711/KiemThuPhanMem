import org.junit.jupiter.api.Test;

import com.cmcu.StudentAnalyzer;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Collections;

public class StudentAnalyzerTest {

    @Test
    public void testCountExcellentStudents() {
        StudentAnalyzer analyzer = new StudentAnalyzer();

        // Trường hợp bình thường
        assertEquals(1, analyzer.countExcellentStudents(Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0)));

        // Trường hợp biên: danh sách trống
        assertEquals(0, analyzer.countExcellentStudents(Collections.emptyList()));
    }

    @Test
    public void testCalculateValidAverage() {
        StudentAnalyzer analyzer = new StudentAnalyzer();

        // Trường hợp bình thường
        assertEquals(8.17, analyzer.calculateValidAverage(Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0)), 0.01);

        // Trường hợp biên: danh sách trống
        assertEquals(0.0, analyzer.calculateValidAverage(Collections.emptyList()), 0.01);

        // Trường hợp ngoại lệ: chỉ có giá trị 0 và 10
        assertEquals(5.0, analyzer.calculateValidAverage(Arrays.asList(0.0, 10.0)), 0.01);
    }
}
