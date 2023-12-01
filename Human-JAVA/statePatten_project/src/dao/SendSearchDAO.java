package dao;

import dto.RoomInfo;
import dto.UserNeedsRoomSearch;
import oracle.jdbc.internal.OracleTypes;
import resource.Connection;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SendSearchDAO extends Connection {

    // 싱글톤
    private SendSearchDAO(){}
    private static class holderInstance{
        public static final SendSearchDAO INSTANCE = new SendSearchDAO();
    }
    public static SendSearchDAO getInstance(){
        return holderInstance.INSTANCE;
    }

    // 멤버변수
    // 검색받는란
    // 업체 종류 , 지역 , 날짜 선택받아 쿼리문전송
    private UserNeedsRoomSearch roomSearchDTO;
    private List<RoomInfo> resultRoomList = new ArrayList<>();


    public List<RoomInfo> searchRoom(UserNeedsRoomSearch searchDTO){
        this.roomSearchDTO = searchDTO;
        if(isConnect()){
            try{
                csmt = connection.prepareCall("{call Search_room_proc(?, ?, ?, ?, ?)}");
                csmt.setString(1, roomSearchDTO.getLodgingType());
                csmt.setString(2, roomSearchDTO.getLodgingAddr());
                csmt.setDate(3, Date.valueOf(roomSearchDTO.getCheckIn()));
                csmt.setDate (4, Date.valueOf(roomSearchDTO.getCheckOut()));

                // 커서 설정
                csmt.registerOutParameter(5, OracleTypes.CURSOR);

                // 프로시저 실행
                csmt.executeQuery();

                // 결과를 ResultSet으로 받아오기
                resultSet = (ResultSet) csmt.getObject(5);

                // ResultSet을 이용하여 결과 처리
                while (resultSet.next()) {
                    RoomInfo resultRoomDTO = RoomInfo.getInstance();
                    resultRoomDTO.setLodgingName(resultSet.getString("LodgingName"));
                    resultRoomDTO.setRoomNumber(resultSet.getInt("roomNumber"));
                    resultRoomDTO.setLodgingUniqueNumber(resultSet.getString("lodgingUniqueNumber"));
                    resultRoomDTO.setRoomName(resultSet.getString("roomName"));
                    resultRoomDTO.setRoomPrice(resultSet.getInt("roomPrice"));
                    resultRoomDTO.setLodgingType(resultSet.getString("lodgingType"));
                    resultRoomDTO.setLodgingAddr(resultSet.getString("lodgingAddr"));
                    resultRoomList.add(resultRoomDTO);
                }
                // select result List  -> Object transfer
                return resultRoomList;
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                resourceClose();
            }
        }
        return null;
    }

}
