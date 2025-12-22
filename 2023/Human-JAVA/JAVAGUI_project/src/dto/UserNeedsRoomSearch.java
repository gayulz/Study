package dto;

public class UserNeedsRoomSearch {
    /*
    객실조회 DTO (검색조건)
     1. 업체종류
     2. 지역
     3. 날짜
    */

    private String lodgingType;
    private String lodgingAddr;
    private String checkIn;
    private String checkOut;

    // 싱글톤
    private UserNeedsRoomSearch(){}
    private static class holderInstance{
        public static final UserNeedsRoomSearch INSTANCE = new UserNeedsRoomSearch();
    }
    public static UserNeedsRoomSearch getInstance(){
        return holderInstance.INSTANCE;
    }



    // getter & setter
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
