

drop PROCEDURE reservation_info_proc;

CREATE OR REPLACE PROCEDURE reservation_info_proc(
    p_customerName VARCHAR2,
    p_customerPhone VARCHAR2,
    p_password VARCHAR2,
    p_results OUT SYS_REFCURSOR
)AS
    -- 변수 선언 및 초기화 
    vs_bookingNumber NUMBER := 0;
    vn_count NUMBER := 0;
    
BEGIN
    OPEN p_results FOR
    SELECT lg.lodgingName, lg.lodgingTel, ri.lodgingAddr, bl.bookingNumber , ri.roomName, bl.priceTotal, bl.reservationDay, bl.checkIn, bl.checkOut
    FROM RoomInfo ri, BookingList bl, Lodging lg
    WHERE ri.roomNumber = bl.roomNumber
    AND lg.lodgingUniqueNumber = ri.lodgingUniqueNumber
    AND bl.bookingNumber = (SELECT bookingNumber
                            FROM Customer
                            WHERE customerName = p_customerName
                            AND password =  p_password
                            AND customerPhone = p_customerPhone)
    ORDER BY bl.checkIn ASC; 

END reservation_info_proc;

commit;


-------------------------------
/*
    SELECT bookingNumber
    INTO vs_bookingNumber
    FROM Customer
    WHERE customerName = p_customerName
    AND password =  p_password
    AND customerPhone = p_customerPhone
    GROUP BY bookingNumber;
    
    
    OPEN p_results
    FOR
    SELECT lg.lodgingName AS lodgingName, lg.lodgingTel AS lodgingTel
            , ri.lodgingAddr AS lodgingAddr, bl.bookingNumber AS bookingNumber, ri.roomName AS roomname
            , bl.priceTotal AS priceTotal, bl.checkIn AS checkIn, bl.checkOut AS checkOut
    FROM RoomInfo ri, BookingList bl, Lodging lg
    WHERE ri.roomNumber = bl.roomNumber
    AND lg.lodgingUniqueNumber = ri.lodgingUniqueNumber
    AND bl.bookingNumber = vs_bookingNumber
    ORDER BY bl.checkIn ASC;
*/