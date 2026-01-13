# Kiểm Thử Phần mềm

Repository lưu bài tập thực hành môn **Kiểm thử phần mềm**.

**Sinh viên:** Đỗ Lâm Trang  
**MSSV:** BIT230471  
**Lớp:** 23SOFT5

---

## 1. Giới Thiệu

Repository này được tạo để lưu trữ các bài tập thực hành môn **Kiểm thử phần mềm**.

---

## 2. Bài Tập

### 2.1. Cantunsee

**Cantunsee** là bài tập trong môn Kiểm thử phần mềm, giúp sinh viên trải nghiệm và đánh giá chất lượng giao diện phần mềm. Mục tiêu của bài tập là:

- **Trải nghiệm giao diện người dùng:** Kiểm tra tính dễ sử dụng và sự hợp lý của các yếu tố giao diện.
- **Phát hiện lỗi UI:** Nhận diện các vấn đề giao diện như bố cục không hợp lý, màu sắc khó nhìn, hoặc các nút bấm không hoạt động.

Bài tập này giúp sinh viên hiểu rõ hơn về việc kiểm thử giao diện và cải thiện trải nghiệm người dùng trong phần mềm.

Dưới đây là hình ảnh minh chứng đã chơi cantunse
![Ảnh minh họa](./cantunsee.png)

### 2.2. StudentAnalyzer

**StudentAnalyzer** là một bài tập về kiểm thử đơn vị và xử lý dữ liệu trong Java. Chương trình phân tích danh sách điểm của học sinh và thực hiện các thao tác sau:

1. **Phân tích số học sinh đạt loại Giỏi** (>= 8.0).
2. **Tính điểm trung bình hợp lệ** từ các điểm trong danh sách (0 đến 10).

#### Hướng Dẫn Chạy Chương Trình

1. **Cài đặt JUnit:** Đảm bảo bạn có JUnit trong dự án của mình.
2. **Chạy chương trình:** Bạn có thể chạy chương trình qua IDE hoặc qua dòng lệnh.

#### Hướng Dẫn Kiểm Thử

Để chạy các bài kiểm thử, sử dụng **JUnit** để kiểm tra các phương thức `countExcellentStudents()` và `calculateValidAverage()`.

##### Các ca kiểm thử:

- Kiểm thử với danh sách có điểm hợp lệ và không hợp lệ.
- Kiểm thử với danh sách trống.
- Kiểm thử với giá trị biên (0 và 10).

#### Các Bước Thực Hiện:

1. Tạo repository.
2. Thêm mã nguồn.
3. Viết kiểm thử đơn vị.
4. Viết tài liệu README.

---
## 2.3. Kiểm Thử Tự Động với Cypress

**Cypress** là công cụ kiểm thử tự động end-to-end giúp kiểm tra các ứng dụng web.

### Mục Tiêu

Thực hành kiểm thử tự động với Cypress trên trang web mẫu.

### Yêu Cầu

- Cài đặt Node.js (v14+), Visual Studio Code.
- Truy cập trang web: [https://www.saucedemo.com](https://www.saucedemo.com).
- Cài đặt Cypress.

### Hướng Dẫn Cài Đặt

1. **Tạo thư mục và khởi tạo npm:**
   ```bash
   mkdir cypress-exercise
   cd cypress-exercise
   npm init -y
2. **Cài đặt Cypress:**
 npm install cypress --save-dev
3. **Mở Cypress:**
 npx cypress open

### Các Kịch Bản Kiểm Thử

#### Kịch bản 1: Đăng nhập thành công

**Mô tả:** Thực hiện đăng nhập với thông tin hợp lệ và xác nhận việc đăng nhập thành công bằng cách kiểm tra sự xuất hiện của các yếu tố giao diện.

#### Kịch bản 2: Đăng nhập thất bại

**Mô tả:** Thực hiện đăng nhập với thông tin không hợp lệ và xác nhận rằng thông báo lỗi hiển thị đúng.

#### Kịch bản 3: Thêm sản phẩm vào giỏ hàng

**Mô tả:** Chọn sản phẩm từ trang sản phẩm và thêm vào giỏ hàng, sau đó xác minh rằng giỏ hàng đã được cập nhật đúng.

#### Kịch bản 4: Tìm kiếm sản phẩm

**Mô tả:** Thực hiện tìm kiếm sản phẩm bằng tên và xác nhận rằng kết quả tìm kiếm đúng với yêu cầu.

### Bài Tập Yêu Cầu

#### Xóa sản phẩm khỏi giỏ hàng

**Mô tả:** Thêm một sản phẩm vào giỏ hàng, sau đó nhấn vào nút "Remove" và xác minh rằng giỏ hàng trở thành rỗng.

#### Quy trình thanh toán

**Mô tả:** Đăng nhập với tài khoản hợp lệ, thêm sản phẩm vào giỏ hàng, tiến hành thanh toán và xác nhận việc chuyển đến trang xác nhận.
