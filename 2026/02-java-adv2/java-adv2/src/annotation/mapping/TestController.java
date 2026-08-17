package annotation.mapping;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 17.
 * @fileName : TestController
 */
public class TestController {

    @SimpleMapping(value="/")
    public void home(){
        System.out.println("TestController.home");
    }

    @SimpleMapping(value="/site1")
    public void page1(){
        System.out.println("TestController.page1");
    }
}
