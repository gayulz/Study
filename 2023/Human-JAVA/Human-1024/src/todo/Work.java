package todo;

public class Work {
    String day = "";
    String text = null;
    int iptWork = 0;

    public void todoPrt(){
        StringBuilder star = new StringBuilder();

        for (int i = 0; i < iptWork; i++) {
            star.append("⛤ ");
        }
        System.out.println();
        System.out.println(" ︵‿︵‿︵‿︵‿︵ My To do List ︵‿︵‿︵‿︵‿︵ ");
        System.out.println(" ⓵ 중요도     : " + star);
        System.out.println(" ⓶ DAY      : " + day.substring(0,4) + "년 " + day.substring(4,6) + "월 " + day.substring(6) + "일 ");
        System.out.println(" ⓷ Contents : " + text);
        System.out.println(" ︵‿︵‿︵‿︵‿︵︵‿︵‿︵‿︵‿︵︵‿︵‿︵‿︵‿︵︵‿ ");
    }
}
