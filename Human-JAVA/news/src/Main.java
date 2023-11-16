public class Main {
    public static void main(String[] args) {

        String name1 = "nana";
        String name2 = "nana";
        String name3 = new String(name1);
        String name4 = new String("nana");
        boolean isSame1 = (name1 == name2)  ;
        boolean isSame2 = (name1 == name3)  ;
        boolean isSame3 = (name1 == name4)  ;
        boolean isSame4 = (name1 == "nana")  ;

       System.identityHashCode(isSame1);
       System.identityHashCode(isSame2);
       System.identityHashCode(isSame3);
       System.identityHashCode(isSame4);



    }
}