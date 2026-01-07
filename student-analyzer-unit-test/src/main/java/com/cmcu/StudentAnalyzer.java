package com.cmcu;

import java.util.List;

public class StudentAnalyzer {
    /**
     * Phân tích điểm số và trả về số lượng học sinh đạt loại Giỏi.
     * 
     * @param scores danh sách điểm số từ 0 đến 10
     * @return số học sinh đạt loại Giỏi (>= 8.0)
     *         - Bỏ qua điểm âm hoặc lớn hơn 10 (coi là dữ liệu sai)
     *         - Nếu danh sách rỗng, trả về 0
     */
    public int countExcellentStudents(List<Double> scores) {
        if (scores == null || scores.isEmpty())
            return 0;

        int excellentCount = 0;
        for (Double score : scores) {
            // Kiểm tra điểm hợp lệ từ 0 đến 10 và đếm học sinh đạt Giỏi (>= 8)
            if (score >= 8.0 && score <= 10.0) {
                excellentCount++;
            }
        }
        return excellentCount;
    }

    /**
     * Tính điểm trung bình hợp lệ (từ 0 đến 10)
     * 
     * @param scores danh sách điểm
     * @return điểm trung bình của các điểm hợp lệ
     */
    public double calculateValidAverage(List<Double> scores) {
        if (scores == null || scores.isEmpty())
            return 0.0;

        double sum = 0;
        int validCount = 0;

        // Tính tổng điểm hợp lệ (từ 0 đến 10) và đếm số điểm hợp lệ
        for (Double score : scores) {
            if (score >= 0 && score <= 10) {
                sum += score;
                validCount++;
            }
        }

        // Trả về điểm trung bình hoặc 0 nếu không có điểm hợp lệ
        return validCount == 0 ? 0.0 : sum / validCount;
    }
}
