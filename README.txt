- Phương pháp phát triển phần mềm: Mô hình "Waterfall".
  1. Lên kế hoạch:
	- Xác định mục tiêu làm nội dung cho trang web: Web bán snack online.
	- Xem kĩ các yêu cầu đề bài cho.
  2. Thiết kế giao diện
  3. Lập trình
  4. Kiểm tra
  5. Triển khai
- Giải thích về cấu trúc:
  + Trong thư mục Java có các mục:
     * controller: bao gồm một lớp Spring Controller với các phương thức xử lý các yêu cầu HTTP như 
	trang chủ, trang sản phẩm, giỏ hàng và thanh toán. Mã sử dụng các bean đã được đăng ký trong 
	ApplicationContext để thực hiện các nhiệm vụ cụ thể. Các phương thức được đánh dấu bởi các 
	chú thích @GetMapping hoặc @PostMapping để định nghĩa các yêu cầu HTTP mà phương thức được xử lý.
     * database: chứa 1 file sql script để lấy các dữ liệu.
     * model: bao gồm các class đại diện cho đối tượng và truyền dữ liệu từ controller đến các phương thức
	trong services.
     * repository: chứa các class repository giúp cho việc truy cập cơ sở dữ liệu trở nên dễ dàng hơn, 
	giảm thiểu các thủ tục phức tạp như kết nối cơ sở dữ liệu, tạo và xử lý các câu lệnh truy vấn
     * services: chứ file main để chạy chương trình.
  + Trong thư mục resources:
     * css: chứa các file css hỗ trợ cho giao diện người dùng.
     * templates: chứa các file html sử dụng để xây dựng và định dạng trang web. 
- Tất cả các bước để chạy ứng dụng:
  + Tải xuống và cài đặt Java Development Kit (JDK) và Apache Maven.
  + Tải xuống mã nguồn của ứng dụng và giải nén tệp ZIP.
  + Mở IDE và mở thư mục mã nguồn.
  + Sử dụng Docker để kết nối server.
  + Sử dụng DBeaver để kết nối tới database.
  + Mở file data.sql trong đường dẫn src\main\java\com\qa1602\midterm\database\data.sql
  + Copy nội dung và dán vào SQL script, sau đó Execute SQL script.
  + Chạy IDE sau đó mở trang web với đường dẫn http://localhost:8080/
 