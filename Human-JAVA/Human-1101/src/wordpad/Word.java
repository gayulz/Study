package wordpad;
import java.util.ArrayList;

// 단어의 정의
public class Word {

    private int point;
    private ArrayList<String> korWordList= new ArrayList<>();
    public Word(){}


    public ArrayList<String> getKorWordList() {
        return korWordList;
    }
    public void setKorWordList(String text) {
        this.korWordList.add(text);
    }
    public int getPoint() {
        return point;
    }
    public void setPoint(int point) {
        this.point = point;
    }
}
