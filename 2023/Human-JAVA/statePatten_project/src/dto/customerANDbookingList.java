package dto;

public class customerANDbookingList {
    private String lodgingName;
    private String lodgingTel;
    private String lodgingAddr;
    private String roomName;
    private int priceTotal;
    private int bookingNumber;
    private String checkIn;
    private String checkOut;
    private int reservationDay;

    // 싱글톤
    private customerANDbookingList(){}
    private static class holderInstacne{
        public static final customerANDbookingList INSTANCE = new customerANDbookingList();
    }
    public static customerANDbookingList getInstance(){return holderInstacne.INSTANCE;}


    // getter & setter
    public int getReservationDay() {return reservationDay;}

    public void setReservationDay(int reservationDay) {
        this.reservationDay = reservationDay;
    }

    public String getLodgingName() {
        return lodgingName;
    }

    public void setLodgingName(String lodgingName) {
        this.lodgingName = lodgingName;
    }

    public String getLodgingTel() {
        return lodgingTel;
    }

    public void setLodgingTel(String lodgingTel) {
        this.lodgingTel = lodgingTel;
    }

    public String getLodgingAddr() {
        return lodgingAddr;
    }

    public void setLodgingAddr(String lodgingAddr) {
        this.lodgingAddr = lodgingAddr;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(int priceTotal) {
        this.priceTotal = priceTotal;
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

    public int getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(int bookingNumber) {
        this.bookingNumber = bookingNumber;
    }
}
