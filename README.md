# KiemThuPhanMem
Repository lưu bài tập thực hành môn Kiểm thử phần mềm

**Sinh viên:** Đỗ Lâm Trang 

**MSSV:** BIT230471

**Lớp:** 23SOFT5

---

## 1. Giới thiệu
Repository này được tạo để lưu trữ các bài tập thực hành môn **Kiểm thử phần mềm**.  

1.1. Nội dung hiện tại là bài thực hành tuần 1: trải nghiệm và đánh giá chất lượng giao diện phần mềm.

1.2. Student Analyzer

## Mô tả bài toán

Chương trình **Student Analyzer** là một công cụ phân tích điểm số học sinh, giúp xác định số lượng học sinh đạt loại **Giỏi** và tính **điểm trung bình hợp lệ** từ danh sách điểm của học sinh. Chương trình cung cấp hai chức năng chính:

1. **Phân tích số lượng học sinh đạt loại Giỏi**:
   - Chương trình sẽ kiểm tra điểm số của từng học sinh và đếm số học sinh có điểm >= 8.0 (được xem là loại Giỏi).
   - Bỏ qua các điểm không hợp lệ (điểm nhỏ hơn 0 hoặc lớn hơn 10).
   - Nếu danh sách điểm rỗng, trả về kết quả là 0.

2. **Tính điểm trung bình hợp lệ**:
   - Chương trình tính điểm trung bình chỉ từ các điểm hợp lệ (điểm nằm trong khoảng từ 0 đến 10).
   - Nếu không có điểm hợp lệ trong danh sách, kết quả trả về sẽ là 0.

## Các yêu cầu

### 1. **Phương thức `countExcellentStudents()`**
   - Nhận vào một danh sách điểm số của học sinh.
   - Đếm số học sinh có điểm >= 8.0 (được coi là loại Giỏi).
   - Bỏ qua các điểm không hợp lệ (điểm nhỏ hơn 0 hoặc lớn hơn 10).
   - Nếu danh sách trống, trả về 0.

### 2. **Phương thức `calculateValidAverage()`**
   - Nhận vào một danh sách điểm số của học sinh.
   - Tính điểm trung bình từ các điểm hợp lệ (nằm trong khoảng từ 0 đến 10).
   - Nếu không có điểm hợp lệ, trả về 0.

## Cách chạy chương trình

1. **Biên dịch mã nguồn Java**:
   Để biên dịch chương trình, bạn cần sử dụng lệnh `javac`:
   ```bash
   javac src/StudentAnalyzer.java
Chạy chương trình:
Sau khi biên dịch xong, bạn có thể chạy chương trình của mình (cách chạy có thể thay đổi tùy vào cách triển khai của bạn).

Kiểm thử đơn vị:
Chương trình đi kèm với các bài kiểm thử đơn vị sử dụng JUnit 5 để kiểm tra các phương thức:

Phương thức countExcellentStudents().

Phương thức calculateValidAverage().