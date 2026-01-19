package com.cmcu;

import java.util.List;

public class StudentAnalyzer {

    /**
     * Phân tích điểm số và trả về số lượng học sinh đạt loại Giỏi.
     *
     * Quy ước:
     * - Điểm hợp lệ nằm trong khoảng [0; 10].
     * - Học sinh Giỏi nếu điểm >= 8.0 và <= 10.0.
     * - Bỏ qua:
     * + điểm âm,
     * + điểm lớn hơn 10,
     * + phần tử null trong danh sách.
     * - Nếu danh sách null hoặc rỗng, trả về 0.
     *
     * @param scores danh sách điểm số
     * @return số học sinh đạt loại Giỏi
     */
    public int countExcellentStudents(List<Double> scores) {
        if (scores == null || scores.isEmpty()) {
            return 0;
        }

        int excellentCount = 0;
        for (Double score : scores) {
            if (score == null) {
                continue; // bỏ qua phần tử null
            }
            // Kiểm tra điểm hợp lệ và đếm học sinh đạt Giỏi (>= 8.0)
            if (score >= 8.0 && score <= 10.0) {
                excellentCount++;
            }
        }
        return excellentCount;
    }

    /**
     * Tính điểm trung bình của các điểm hợp lệ.
     *
     * Quy ước:
     * - Điểm hợp lệ: 0 <= điểm <= 10.
     * - Bỏ qua:
     * + điểm âm,
     * + điểm lớn hơn 10,
     * + phần tử null trong danh sách.
     * - Nếu danh sách null, rỗng hoặc không có điểm hợp lệ, trả về 0.0.
     *
     * @param scores danh sách điểm
     * @return điểm trung bình của các điểm hợp lệ, hoặc 0.0 nếu không có điểm hợp
     *         lệ
     */
    public double calculateValidAverage(List<Double> scores) {
        if (scores == null || scores.isEmpty()) {
            return 0.0;
        }

        double sum = 0.0;
        int validCount = 0;

        for (Double score : scores) {
            if (score == null) {
                continue; // bỏ qua phần tử null
            }
            if (score >= 0.0 && score <= 10.0) {
                sum += score;
                validCount++;
            }
        }

        if (validCount == 0) {
            return 0.0;
        }
        return sum / validCount;
    }
}
