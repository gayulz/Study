package programs;
import resource.*;
import main_menu.First_Menu;
public class Start {
    public static void main(String[] args) {
        //todo : 도서관리 프로그램 제작 . 혼자서 하는 프로젝트
        Oracle_Driver driverLoad = Oracle_Driver.DRIVER_LOAD;
        new First_Menu();
    }
}
