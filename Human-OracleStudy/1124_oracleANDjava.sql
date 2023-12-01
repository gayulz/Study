EXEC SearchAvailableRooms('호텔', '제주', TO_DATE('2023-12-01', 'YYYY-MM-DD'), TO_DATE('2023-12-02', 'YYYY-MM-DD'));	
commit;
desc SearchAvailableRooms;

DROP PROCEDURE SearchAvailableRooms;

SET SERVEROUTPUT ON;


CREATE OR REPLACE PROCEDURE SearchAvailableRooms (
    p_lodging_type VARCHAR2,
    p_lodging_addr_keyword VARCHAR2,
    p_check_in DATE,
    p_check_out DATE
) AS
    CURSOR room_cursor IS
        SELECT ri.*
        FROM RoomInfo ri
        WHERE ri.lodgingType = p_lodging_type
          AND ri.lodgingAddr LIKE '%' || p_lodging_addr_keyword || '%'
          AND NOT EXISTS (
              SELECT 1
              FROM BookingList bl
              WHERE bl.roomNumber = ri.roomNumber
                AND (p_check_in BETWEEN bl.checkIN AND bl.checkOut
                     OR p_check_out BETWEEN bl.checkIN AND bl.checkOut)
          );

BEGIN
    FOR room_rec IN room_cursor LOOP
        DBMS_OUTPUT.PUT_LINE('Room Number: ' || room_rec.roomNumber);
        DBMS_OUTPUT.PUT_LINE('Lodging Unique Number: ' || room_rec.lodgingUniqueNumber);
        DBMS_OUTPUT.PUT_LINE('Room Name: ' || room_rec.roomName);
        DBMS_OUTPUT.PUT_LINE('Room Price: ' || room_rec.roomPrice);
        DBMS_OUTPUT.PUT_LINE('Lodging Type: ' || room_rec.lodgingType);
        DBMS_OUTPUT.PUT_LINE('Lodging Address: ' || room_rec.lodgingAddr);
        DBMS_OUTPUT.PUT_LINE('----------------------');
    END LOOP;
END SearchAvailableRooms;


