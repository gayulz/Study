package changeFrame;

import dto.RoomInfo;

import java.util.List;

public class Funtions {
    // 싱글톤 구간
    private Funtions(){}
    private static class holderInstance{ public static final Funtions INSTANCE = new Funtions();}
    public static Funtions getInstance(){return holderInstance.INSTANCE;}

    protected StringBuilder printLodgingInfo(List<RoomInfo> userNeedsRooms){
        int findRoomNumber = RoomViewFrame.getInstance().getFindRoomNumber();
        StringBuilder returnText = new StringBuilder("--------------------------------------\n\n");
        for (RoomInfo roomInfo : userNeedsRooms) {
            if (roomInfo.getRoomNumber() == findRoomNumber) {
                RoomViewFrame.getInstance().setChoiceRoomInfo(roomInfo);
                returnText.append(" 숙소 업종 : ").append(roomInfo.getLodgingType()).append("\n");
                returnText.append(" 숙소 이름 : ").append(roomInfo.getLodgingName()).append("\n");
                returnText.append(" 숙소 주소 : ").append(roomInfo.getLodgingAddr()).append("\n");
                returnText.append(" 객실 번호 : ").append(roomInfo.getRoomNumber()).append("\n");
                returnText.append(" 객실 이름 : ").append(roomInfo.getRoomName()).append("\n");
                returnText.append(" 객실 요금 : ").append(roomInfo.getRoomPrice()).append(" 원 \n\n");
                returnText.append("--------------------------------------\n\n");
                returnText.append(" ✔ 입실 : 13시    ✔ 퇴실 : 12시\n");
                returnText.append(" 1. 반려 동물들의 배변패드는 직접 준비하셔야 합니다 \n");
                returnText.append(" 2. 반려견이 대형견 일 경우 미리 프론트에 알려주세요 \n");
                returnText.append(" 3. 리드줄 필수아님 / 대형견 경우 권장합니다\n\n");
                returnText.append("--------------------------------------");
                break;
            }
        }
        return returnText;
    }
}
