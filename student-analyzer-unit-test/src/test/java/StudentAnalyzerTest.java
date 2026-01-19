import org.junit.jupiter.api.Test;

import com.cmcu.StudentAnalyzer;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;

public class StudentAnalyzerTest {

    private final StudentAnalyzer analyzer = new StudentAnalyzer();

    // =========================================================
    // 1. Decision Table (DT) tests cho countExcellentStudents
    //
    // Giả lập bảng quyết định tổng quát:
    //
    // C1: scores == null?
    // C2: scores is empty?
    // C3: có ít nhất 1 điểm hợp lệ trong [0;10]?
    // C4: trong các điểm hợp lệ, có điểm >= 8.0?
    //
    // A1: trả về 0
    // A2: trả về số học sinh Giỏi (điểm hợp lệ >= 8.0)
    //
    // Quy tắc:
    // R1: C1 = T -> A1
    // R2: C1 = F, C2 = T -> A1
    // R3: C1 = F, C2 = F, C3 = F -> A1
    // R4: C1 = F, C2 = F, C3 = T, C4 = F -> A1
    // R5: C1 = F, C2 = F, C3 = T, C4 = T -> A2
    // =========================================================

    @Test
    public void testCountExcellentStudents_DT_R1_NullList() {
        // R1: scores == null -> 0
        assertEquals(
                0,
                analyzer.countExcellentStudents(null));
    }

    @Test
    public void testCountExcellentStudents_DT_R2_EmptyList() {
        // R2: scores is empty -> 0
        assertEquals(
                0,
                analyzer.countExcellentStudents(Collections.emptyList()));
    }

    @Test
    public void testCountExcellentStudents_DT_R3_AllInvalidOrNull() {
        // R3: không có điểm hợp lệ -> 0
        // Toàn invalid hoặc null
        assertEquals(
                0,
                analyzer.countExcellentStudents(Arrays.asList(-1.0, 11.0, null, 20.0)));
    }

    @Test
    public void testCountExcellentStudents_DT_R4_ValidButNoExcellent() {
        // R4: có điểm hợp lệ nhưng không ai đạt Giỏi (>= 8.0) -> 0
        assertEquals(
                0,
                analyzer.countExcellentStudents(Arrays.asList(0.0, 5.5, 7.99, 7.5)));
    }

    @Test
    public void testCountExcellentStudents_DT_R5_HasExcellentStudents() {
        // R5: có điểm hợp lệ và có ít nhất một điểm >= 8.0 -> đếm số Giỏi
        // Hợp lệ: 9.0, 8.5, 7.0
        // Giỏi: 9.0, 8.5 => 2
        assertEquals(
                2,
                analyzer.countExcellentStudents(Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0)));
    }

    // =========================================================
    // 2. Boundary Value Analysis (BVA) tests cho countExcellentStudents
    //
    // Biên cần kiểm tra:
    // - Điểm ngay dưới 8.0 (7.99)
    // - Điểm đúng bằng 8.0 (biên Giỏi)
    // - Điểm trên 8.0 (8.5, 9.0)
    // - Biên dưới hợp lệ (0.0)
    // - Biên trên hợp lệ (10.0)
    // - Dưới 0 và trên 10 (-1.0, 11.0)
    // - Phần tử null trong list
    // =========================================================

    @Test
    public void testCountExcellentStudents_BVA_SingleScoreBelowBoundary() {
        // Một điểm ngay dưới ngưỡng Giỏi: 7.99 => 0
        assertEquals(
                0,
                analyzer.countExcellentStudents(Arrays.asList(7.99)));
    }

    @Test
    public void testCountExcellentStudents_BVA_SingleScoreAtBoundary() {
        // Một điểm đúng tại ngưỡng Giỏi: 8.0 => 1
        assertEquals(
                1,
                analyzer.countExcellentStudents(Arrays.asList(8.0)));
    }

    @Test
    public void testCountExcellentStudents_BVA_SingleScoreAboveBoundary() {
        // Một điểm trên ngưỡng Giỏi: 9.0 => 1
        assertEquals(
                1,
                analyzer.countExcellentStudents(Arrays.asList(9.0)));
    }

    @Test
    public void testCountExcellentStudents_BVA_LowerAndUpperValidBoundaries() {
        // Biên hợp lệ 0.0 và 10.0
        // 0.0: không Giỏi, 10.0: Giỏi -> 1
        assertEquals(
                1,
                analyzer.countExcellentStudents(Arrays.asList(0.0, 10.0)));
    }

    @Test
    public void testCountExcellentStudents_BVA_MixedValidInvalidAndNull() {
        // Kết hợp:
        // - 8.0 (Giỏi, biên)
        // - null
        // - 9.0 (Giỏi)
        // - -1.0, 11.0 (invalid)
        // => 2 học sinh Giỏi
        assertEquals(
                2,
                analyzer.countExcellentStudents(Arrays.asList(8.0, null, 9.0, -1.0, 11.0)));
    }

    // =========================================================
    // 3. Decision Table (DT) tests cho calculateValidAverage
    //
    // Giả lập bảng quyết định:
    //
    // C1: scores == null?
    // C2: scores is empty?
    // C3: có ít nhất một điểm hợp lệ trong [0;10]?
    //
    // A1: trả về 0.0
    // A2: trả về trung bình các điểm hợp lệ
    //
    // R1: C1 = T -> A1
    // R2: C1 = F, C2 = T -> A1
    // R3: C1 = F, C2 = F, C3 = F -> A1
    // R4: C1 = F, C2 = F, C3 = T -> A2
    // =========================================================

    @Test
    public void testCalculateValidAverage_DT_R1_NullList() {
        // R1: scores == null -> 0.0
        assertEquals(
                0.0,
                analyzer.calculateValidAverage(null),
                0.0001);
    }

    @Test
    public void testCalculateValidAverage_DT_R2_EmptyList() {
        // R2: scores is empty -> 0.0
        assertEquals(
                0.0,
                analyzer.calculateValidAverage(Collections.emptyList()),
                0.0001);
    }

    @Test
    public void testCalculateValidAverage_DT_R3_AllInvalidOrNull() {
        // R3: không có điểm hợp lệ -> 0.0
        assertEquals(
                0.0,
                analyzer.calculateValidAverage(Arrays.asList(-5.0, 11.0, 100.0, null)),
                0.0001);
    }

    @Test
    public void testCalculateValidAverage_DT_R4_OnlyValidScores() {
        // R4: chỉ có điểm hợp lệ -> tính trung bình bình thường
        // (9 + 8 + 7) / 3 = 8.0
        assertEquals(
                8.0,
                analyzer.calculateValidAverage(Arrays.asList(9.0, 8.0, 7.0)),
                0.0001);
    }

    @Test
    public void testCalculateValidAverage_DT_R4_MixedValidInvalidAndNull() {
        // R4 (biến thể): trộn hợp lệ + invalid + null
        // Hợp lệ: 9.0, 8.5, 7.0 => (9 + 8.5 + 7) / 3 = 8.166... ~ 8.17
        assertEquals(
                8.17,
                analyzer.calculateValidAverage(Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0, null)),
                0.01);
    }

    // =========================================================
    // 4. Boundary Value Analysis (BVA) tests cho calculateValidAverage
    //
    // Biên:
    // - 0.0 (biên dưới hợp lệ)
    // - 10.0 (biên trên hợp lệ)
    // - giá trị hợp lệ chung trong (0;10)
    // - invalid < 0 và > 10
    // - phần tử null
    // =========================================================

    @Test
    public void testCalculateValidAverage_BVA_SingleLowerBoundary() {
        // Chỉ một điểm hợp lệ ở biên dưới: 0.0
        assertEquals(
                0.0,
                analyzer.calculateValidAverage(Arrays.asList(0.0)),
                0.0001);
    }

    @Test
    public void testCalculateValidAverage_BVA_SingleUpperBoundary() {
        // Chỉ một điểm hợp lệ ở biên trên: 10.0
        assertEquals(
                10.0,
                analyzer.calculateValidAverage(Arrays.asList(10.0)),
                0.0001);
    }

    @Test
    public void testCalculateValidAverage_BVA_LowerAndUpperBoundaries() {
        // Biên 0.0 và 10.0 => (0 + 10) / 2 = 5.0
        assertEquals(
                5.0,
                analyzer.calculateValidAverage(Arrays.asList(0.0, 10.0)),
                0.0001);
    }

    @Test
    public void testCalculateValidAverage_BVA_SingleValidScoreWithInvalidAround() {
        // Chỉ một điểm hợp lệ giữa các điểm invalid:
        // Hợp lệ: 7.5 -> trung bình = 7.5
        assertEquals(
                7.5,
                analyzer.calculateValidAverage(Arrays.asList(-1.0, 7.5, 11.0)),
                0.0001);
    }

    @Test
    public void testCalculateValidAverage_BVA_WithNullElements() {
        // Có null và invalid xen giữa:
        // Hợp lệ: 8.0 và 9.0 => (8 + 9) / 2 = 8.5
        assertEquals(
                8.5,
                analyzer.calculateValidAverage(Arrays.asList(8.0, null, 9.0, -1.0, 11.0)),
                0.0001);
    }
}
