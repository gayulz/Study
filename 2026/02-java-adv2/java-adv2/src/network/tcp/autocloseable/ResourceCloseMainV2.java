package network.tcp.autocloseable;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 6.
 * @fileName : ResourceCloseMainV1
 */
public class ResourceCloseMainV2 {
    public static void main(String[] args) {
        try {
            logic();
        } catch (CallException e) {
            System.out.println("Call Exception 예외 처리");
            e.printStackTrace();
        } catch (CloseException e) {
            System.out.println("Close Exception 예외 처리");
            e.printStackTrace();
        }
    }

    private static void logic() throws CallException, CloseException {
        ResourceV1 resource1 = null;
        ResourceV1 resource2 = null;

        try{
            resource1 = new ResourceV1("resource1");
            resource2 = new ResourceV1("resource2");

            resource1.call();
            resource2.callEx();
        } catch(CallException e){
            System.out.println("ex : " + e);
            throw e;
        } finally {
            if (resource2 != null) {
                resource2.closeEx();
            }

            if (resource1 != null) {
                resource1.closeEx();
            }


            System.out.println("자원 정리");
        }


    }
}
