package bt2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class FileSizeandDelete {
    public static void main(String[] args) {
        // Sử dụng Scanner để nhập đường dẫn của tệp tin từ bàn phím
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập đường dẫn của thư mục hoặc tệp tin: ");
        String path = scanner.nextLine();
        

        // Tạo đối tượng File từ đường dẫn được nhập
        File file = new File(path);

        // Kiểm tra xem tệp tin hoặc thư mục có tồn tại không
        if (!file.exists()) {
            System.out.println("Tệp tin hoặc thư mục không tồn tại.");
            return;
        }

        // Kiểm tra xem đường dẫn trỏ đến một thư mục hay tệp tin
        if (file.isDirectory()) {
            System.out.println("Đây là một thư mục.");
            deleteDirectory(file);
        } else {
            System.out.println("Đây là một tệp tin.");
            System.out.println("Bạn có muốn xoá tệp tin không");
            int choice = scanner.nextInt();
            if(choice == 1) {
            	deleteFile(file);
            }else {
            	System.out.println("Không thực hiện việc xoá tệp tin");
            }
        }
    }

    private static void deleteDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    deleteDirectory(file);
                } else {
                    deleteFile(file);
                }
            }
        }
        if (directory.delete()) {
            System.out.println("Thư mục đã được xoá: " + directory.getAbsolutePath());
        } else {
            System.out.println("Không thể xoá thư mục: " + directory.getAbsolutePath());
        }
    }

    private static void deleteFile(File file) {
        if (file.delete()) {
            System.out.println("Tệp tin đã được xoá: " + file.getAbsolutePath());
        } else {
            System.out.println("Không thể xoá tệp tin: " + file.getAbsolutePath());
        }
    }
}
