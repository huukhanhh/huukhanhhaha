package bt1;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Filesize {
    public static void main(String[] args) {
        // Sử dụng Scanner để nhập đường dẫn của tệp tin từ bàn phím
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập đường dẫn của tệp tin: ");
        String filePath = scanner.nextLine();
        scanner.close();

        // Tạo đối tượng File từ đường dẫn được nhập
        File file = new File(filePath);

        // Kiểm tra xem tệp tin có tồn tại không
        if (!file.exists()) {
            System.out.println("Tệp tin không tồn tại.");
            return;
        }

        // Kiểm tra xem đường dẫn trỏ đến một tệp tin hay thư mục
        if (file.isDirectory()) {
            System.out.println("Đường dẫn trỏ đến một thư mục, không phải tệp tin.");
            return;
        }

        // Lấy kích thước của tệp tin
        long fileSize = getFileSize(file);

        // In ra màn hình kích thước của tệp tin
        System.out.println("Độ lớn của tệp tin là: " + fileSize + " bytes.");
    }

    private static long getFileSize(File file) {
        long size = 0;
        try {
            // Tạo một đối tượng InputStream để đọc từ tệp tin
            InputStream inputStream = new FileInputStream(file);

            // Đọc kích thước của tệp tin
            size = inputStream.available();

            // Đóng InputStream sau khi đã sử dụng xong
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return size;
    }
}
