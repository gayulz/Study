package dto;

public class CustomerDTO {
    private int roomNumber;
    private String customerName;
    private String customerPhone;
    private String password;
    private String paymentInfo;
    private String checkIn;
    private String checkOut;


    // 싱글톤 구간
    private CustomerDTO(){}
    private static class holderInstance{
        public static final CustomerDTO INSTANCE = new CustomerDTO();
    }
    public static CustomerDTO getInstance(){return holderInstance.INSTANCE;}


    // getter & setter
    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {

        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        // 휴대폰 번호 입력시 숫자로만 입력하더라도 000-0000-0000 포멧을 유지하고
        // -가 있거나 부족하더라도 해당 포멧을 유지하며 데이터에 저장되어야한다
        // 정규화식 사용하여 숫자만 우선 추출하고 서브스트링 후 입력

        // 숫자만 추출
        String tempNum = customerPhone.replaceAll("[^0-9]","");
        if (tempNum.length() == 11) {
            for (int i = 0; i < 3; i++) {
                String subTemp = tempNum.substring(0,3);
                this.customerPhone += subTemp + "-";
            }
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        // 비밀번호 유효성
        // 비밀번호는 특수문자 2자리 이상 필수로 가져야 하고
        // 길이는 5자리 이상 해야한다
        this.password = password;
    }

    public String getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(String paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }
}
