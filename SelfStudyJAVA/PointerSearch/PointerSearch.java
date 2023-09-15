import java.awt.*;

public class PointerSearch {

    public static void main(String[] args) {
        PointerInfo pt = MouseInfo.getPointerInfo();
        while (true) {
            pt = MouseInfo.getPointerInfo();

            System.out.println(pt.getLocation()); // x , y 좌표 출력
        }
    }
}

