package network.tcp.autocloseable;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 6.
 * @fileName : ResourceCloseMainV1
 */
public class ResourceCloseMainV1 {
    public static void main(String[] args) {
        try {
            logic();
        } catch (CallException e) {
            System.out.println("Call Exception 예외 처리");
            throw new RuntimeException(e);
        } catch (CloseException e) {
            System.out.println("Close Exception 예외 처리");
            throw new RuntimeException(e);
        }
    }

    private static void logic() throws CallException, CloseException {
        ResourceV1 resource1 = new ResourceV1("resource1");
        ResourceV1 resource2 = new ResourceV1("resource2");

        resource1.call();
        resource2.callEx();

        System.out.println("자원 정리"); // 예외 발생으로 자원 정리 불가
        resource2.closeEx();
        resource1.closeEx();
    }
}
