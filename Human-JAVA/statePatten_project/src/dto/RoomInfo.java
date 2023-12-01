package dto;

public class RoomInfo {
    private int roomNumber;
    private String lodgingUniqueNumber;
    private String roomName;
    private int roomPrice;
    private String lodgingType;
    private String lodgingAddr;
    private String lodgingName;

    // 싱글톤
    private RoomInfo(){}
    private static class holderInstance{
        public static final RoomInfo INSTANCE = new RoomInfo();
    }
    public static RoomInfo getInstance(){
        return holderInstance.INSTANCE;
    }



    // getter & setter
    public String getLodgingName() {return lodgingName;}

    public void setLodgingName(String lodgingName) {this.lodgingName = lodgingName;}

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getLodgingUniqueNumber() {
        return lodgingUniqueNumber;
    }

    public void setLodgingUniqueNumber(String lodgingUniqueNumber) {
        this.lodgingUniqueNumber = lodgingUniqueNumber;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(int roomPrice) {
        this.roomPrice = roomPrice;
    }

    public String getLodgingType() {
        return lodgingType;
    }

    public void setLodgingType(String lodgingType) {
        this.lodgingType = lodgingType;
    }

    public String getLodgingAddr() {
        return lodgingAddr;
    }

    public void setLodgingAddr(String lodgingAddr) {
        this.lodgingAddr = lodgingAddr;
    }
}
