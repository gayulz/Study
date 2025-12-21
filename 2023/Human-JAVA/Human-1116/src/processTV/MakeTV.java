package processTV;

import internet.SKnet;
import makeTv.BasicTV;
import makeTv.SmartTV;

import java.util.Scanner;

public class MakeTV {
    private Scanner in = new Scanner(System.in);
    public MakeTV(){
        System.out.println("1. SmartTV making");
        System.out.println("2. SmartTV making");
        int selectNum = in.nextInt();
        in.nextLine();
        if ( selectNum == 1 ) makeSmartTV();
        else if ( selectNum == 2) makeBasicTv();
    }

    private void makeSmartTV() {
        SmartTV smartTV = new SmartTV();
        // 샘플 . 고객이 인터넷을 선택한다
        smartTV.setting("20231116", "humanEC",new SKnet());
        smartTV.testing();
    }

    private void makeBasicTv() {
        BasicTV basicTV = new BasicTV();
        basicTV.setting("20231116", "humanEC");
        basicTV.testing();
    }
}
