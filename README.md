# Lập trình ứng dụng mạng
# Nhóm 13 đề tài 12

# Thành viên
- Hồ Hữu Đại       3122410066
- Huỳnh Tấn Dương  3122410061

# Mô tả ứng dụng
ĐỀ TÀI 12: ỨNG DỤNG TRA CỨU THÔNG TIN ĐỊA LÝ

Mô tả chức năng ứng dụng (phải có GUI):
▪ Client gửi thông tin là tên một vị trí địa lý (thành phố hoặc quốc gia).
▪ Server trả lại các thông tin liên quan đến vị trí địa lý đó
✓ Nếu vị trí đó là 1 thành phố:
▪ Trả về các thông tin như tọa độ, quốc gia, dân số, thời tiết hiện tại, và một số thông
tin/bài báo liên quan, ....
▪ Đề xuất thông tin một số khách sạn ở thành phố đó, các thông tin tối thiểu: địa chỉ,
giá phòng, review (dữ liệu lấy theo thời gian thực, từ booking.com, agoda.com
hoặc hệ thống do nhóm SV chọn).

✓ Nếu vị trí đó là 1 quốc gia:
▪ Ngoài các thông tin như của thành phố, server cần trả về thêm một số thông tin
khác như: đơn vị tiền tệ, ngôn ngữ, quốc kỳ, các quốc gia liền kề (nếu có)....
▪ Đề xuất thông tin các địa điểm du lịch nổi bật/hoặc khách sạn ở quốc gia đó.

Yêu cầu về chức năng phía server (không cần GUI):
▪ Mã hóa nội dung tin nhắn giữa client – server. Phải sử dụng key khác nhau cho các client
▪ Các client hoạt động trên các máy tính khác nhau.
