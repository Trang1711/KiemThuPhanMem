import java.util.List;

public class StudentAnalyzer {

    /**
     * Phân tích điểm số và trả về số lượng học sinh đạt loại Giỏi.
     * 
     * @param scores danh sách điểm số từ 0 đến 10
     * @return số học sinh đạt loại Giỏi (>= 8.0)
     */
    public int countExcellentStudents(List<Double> scores) {
        int count = 0;
        // Duyệt qua danh sách điểm
        for (double score : scores) {
            // Kiểm tra điểm hợp lệ và nếu điểm >= 8.0 thì tăng biến đếm
            if (score >= 8.0 && score <= 10.0) {
                count++;
            }
        }
        return count;
    }
}
