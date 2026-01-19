import org.junit.jupiter.api.Test;

import com.cmcu.StudentAnalyzer;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;

public class StudentAnalyzerTest {

    private final StudentAnalyzer analyzer = new StudentAnalyzer();

    // =========================================================
    // Tests cho countExcellentStudents (Giỏi >= 8.0)
    // =========================================================

    @Test
    public void testCountExcellentStudents_NormalWithInvalidValues() {
        // Danh sách gồm cả điểm hợp lệ và không hợp lệ
        // Điểm hợp lệ: 9.0, 8.5, 7.0
        // Học sinh Giỏi (>=8.0): 9.0, 8.5 => 2
        assertEquals(
                2,
                analyzer.countExcellentStudents(Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0)));
    }

    @Test
    public void testCountExcellentStudents_EmptyList() {
        // Trường hợp biên: danh sách rỗng
        assertEquals(
                0,
                analyzer.countExcellentStudents(Collections.emptyList()));
    }

    @Test
    public void testCountExcellentStudents_NullList() {
        // Trường hợp biên: danh sách null
        assertEquals(
                0,
                analyzer.countExcellentStudents(null));
    }

    @Test
    public void testCountExcellentStudents_AllInvalidScores() {
        // Chỉ có điểm không hợp lệ -> 0
        assertEquals(
                0,
                analyzer.countExcellentStudents(Arrays.asList(-1.0, 11.0, 20.0)));
    }

    @Test
    public void testCountExcellentStudents_NoExcellentStudent() {
        // Có điểm hợp lệ nhưng không có ai đạt Giỏi (>= 8.0)
        assertEquals(
                0,
                analyzer.countExcellentStudents(Arrays.asList(0.0, 5.5, 7.99, 7.5)));
    }

    @Test
    public void testCountExcellentStudents_MultipleExcellentStudentsAndBoundary() {
        // Kiểm tra biên: 8.0, 9.0, 10.0 đều là Giỏi
        assertEquals(
                3,
                analyzer.countExcellentStudents(Arrays.asList(8.0, 9.0, 10.0, 7.0, -2.0, 11.0)));
    }

    @Test
    public void testCountExcellentStudents_WithNullElements() {
        // Có phần tử null trong danh sách
        // Học sinh Giỏi: 8.0 và 9.0 => 2
        assertEquals(
                2,
                analyzer.countExcellentStudents(Arrays.asList(8.0, null, 9.0, -1.0, 11.0)));
    }

    // =========================================================
    // Tests cho calculateValidAverage
    // =========================================================

    @Test
    public void testCalculateValidAverage_NormalWithInvalidValues() {
        // Điểm hợp lệ: 9.0, 8.5, 7.0 => (9 + 8.5 + 7) / 3 = 8.166... ~ 8.17
        assertEquals(
                8.17,
                analyzer.calculateValidAverage(Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0)),
                0.01);
    }

    @Test
    public void testCalculateValidAverage_EmptyList() {
        assertEquals(
                0.0,
                analyzer.calculateValidAverage(Collections.emptyList()),
                0.01);
    }

    @Test
    public void testCalculateValidAverage_NullList() {
        assertEquals(
                0.0,
                analyzer.calculateValidAverage(null),
                0.01);
    }

    @Test
    public void testCalculateValidAverage_AllInvalidScores() {
        // Không có điểm hợp lệ -> 0.0
        assertEquals(
                0.0,
                analyzer.calculateValidAverage(Arrays.asList(-5.0, 11.0, 100.0)),
                0.01);
    }

    @Test
    public void testCalculateValidAverage_OnlyValidBoundaryScores() {
        // Chỉ có 0.0 và 10.0 => (0 + 10) / 2 = 5.0
        assertEquals(
                5.0,
                analyzer.calculateValidAverage(Arrays.asList(0.0, 10.0)),
                0.01);
    }

    @Test
    public void testCalculateValidAverage_SingleValidScore() {
        // Chỉ một điểm hợp lệ: 7.5
        assertEquals(
                7.5,
                analyzer.calculateValidAverage(Arrays.asList(7.5, -1.0, 11.0)),
                0.01);
    }

    @Test
    public void testCalculateValidAverage_WithNullElements() {
        // Có null xen giữa: điểm hợp lệ 8.0 và 9.0 => (8 + 9) / 2 = 8.5
        assertEquals(
                8.5,
                analyzer.calculateValidAverage(Arrays.asList(8.0, null, 9.0, -1.0, 11.0)),
                0.01);
    }
}
