import java.util.Scanner;

public class MyListTest {
    MyList<Integer> listInteger;
    public MyListTest() {
        listInteger = new MyList<>();
        listInteger.add(1);
        listInteger.add(3);
        listInteger.add(5);
        listInteger.add(7);
        listInteger.add(9);
    }
    public static void main(String[] args) {
        MyListTest listIntegerTest = new MyListTest();
        listIntegerTest.display();

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n");
        System.out.print("Nhập vào vị trí cần xóa: ");
        int index = scanner.nextInt();
        listIntegerTest.listInteger.remove(index);
        listIntegerTest.display();;

        System.out.println("\n");
        System.out.println("Clone: ");
        listIntegerTest.display();

        System.out.println("\n");
        System.out.println(listIntegerTest.listInteger.indexOf("aaaa"));
    }
    public void display() {
        for (int i = 0; i < listInteger.getSize(); i++) {
            System.out.print(listInteger.get(i) + " ");
        }
    }
}