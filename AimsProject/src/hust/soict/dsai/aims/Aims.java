package src.hust.soict.dsai.aims;
import src.hust.soict.dsai.aims.disc.DigitalVideoDisc;
import src.hust.soict.dsai.aims.cart.Cart;

public class Aims {
    public static void main(String[] args) {
        // Tạo một giỏ hàng mới
        Cart an0der = new Cart();

        // Tạo các DVD mới và thêm chúng vào giỏ hàng
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        System.out.println("DVD 1 ID: " + dvd1.getId()); // In ID của DVD
        an0der.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        System.out.println("DVD 2 ID: " + dvd2.getId()); // In ID của DVD
        an0der.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 24.95f);
        System.out.println("DVD 3 ID: " + dvd3.getId()); // In ID của DVD
        an0der.addDigitalVideoDisc(dvd3);

        // In tổng chi phí của các DVD trong giỏ hàng
        System.out.println("Total cost is: ");
        System.out.println(an0der.totalCost());

        // In thông tin giỏ hàng theo định dạng yêu cầu
        an0der.printCart();

        // Xóa DVD khỏi giỏ hàng
        an0der.removeDigitalVideoDisc(dvd2);
        System.out.println("Total cost is: ");
        System.out.println(an0der.totalCost());

        // In lại giỏ hàng sau khi xóa DVD
        an0der.printCart();

        // Thêm lại DVD vào giỏ hàng
        an0der.addDigitalVideoDisc(dvd1);
        System.out.println("Total cost is: ");
        System.out.println(an0der.totalCost());

        // In lại giỏ hàng sau khi thêm lại DVD
        an0der.printCart();

        // Tìm DVD theo ID
        an0der.findDVDById(dvd1.getId());

        // Tìm DVD theo tiêu đề
        an0der.findDVDByTitle("Aladin");
        an0der.findDVDByTitle("Titanic");  // Tiêu đề không có trong giỏ hàng


    }
}
