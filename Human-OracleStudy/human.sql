/*
CREATE OR REPLACE PROCEDURE reservation_info_proc(
    p_customerName Customer.customerName%TYPE,
    p_customerPhone Customer.customerPhone%TYPE,
    p_password Customer.password%TYPE,
    p_results OUT SYS_REFCURSOR
)AS
    -- 변수 선언 및 초기화 
    vs_bookingNumber NUMBER := 0;
    vs_cnt NUMBER := 0;
    vs_errorString VARCHAR2(50) := '';
BEGIN
    -- 입력받은 정보로 가입된 내용이 있는지 확인
    BEGIN
        SELECT COUNT(*), MAX(bookingNumber)
        INTO vs_cnt, vs_bookingNumber
        FROM Customer
        WHERE customerName = p_customerName
        AND password = p_password
        AND customerPhone = p_customerPhone
        GROUP BY bookingNumber;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            vs_errorString := '입력된 데이터가 없습니다';
    END;

    -- 만약 row가 0개라면
    IF vs_cnt = 0 THEN
        vs_errorString := '입력된 데이터가 없습니다';
    -- 0이 아니라면 
    ELSE 
        OPEN p_results FOR
        SELECT lg.lodgingName AS lodgingName, lg.lodgingTel AS lodgingTel
            , ri.lodgingAddr AS lodgingAddr, bl.bookingNumber AS bookingNumber, ri.roomName AS roomname
            , bl.priceTotal AS priceTotal, bl.checkIn AS checkIn, bl.checkOut AS checkOut
        FROM RoomInfo ri, BookingList bl, Lodging lg
        WHERE ri.roomNumber = bl.roomNumber
        AND lg.lodgingUniqueNumber = ri.lodgingUniqueNumber
        AND bl.bookingNumber = vs_bookingNumber
        ORDER BY bl.checkIn ASC;
    END IF;
END reservation_info_proc;
*/



DECLARE
    v_customerName Customer.customerName%TYPE := '가율';
    v_customerPhone Customer.customerPhone%TYPE := '01012341234';
    v_password Customer.password%TYPE := '1234!!';
    v_results SYS_REFCURSOR;
    v_lodgingName Lodging.lodgingName%TYPE;
    v_lodgingTel Lodging.lodgingTel%TYPE;
    v_lodgingAddr RoomInfo.lodgingAddr%TYPE;
    v_bookingNumber BookingList.bookingNumber%TYPE;
    v_roomname RoomInfo.roomName%TYPE;
    v_priceTotal BookingList.priceTotal%TYPE;
    v_checkIn BookingList.checkIn%TYPE;
    v_checkOut BookingList.checkOut%TYPE;
BEGIN
    -- 프로시저 호출
    reservation_info_proc(
        p_customerName => v_customerName,
        p_customerPhone => v_customerPhone,
        p_password => v_password,
        p_results => v_results
    );

    -- 결과 출력
    DBMS_OUTPUT.PUT_LINE('Results:');
    LOOP
        FETCH v_results INTO
            v_lodgingName, v_lodgingTel, v_lodgingAddr, v_bookingNumber, v_roomname, v_priceTotal, v_checkIn, v_checkOut;
        EXIT WHEN v_results%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(
            'Lodging Name: ' || v_lodgingName ||
            ', Lodging Tel: ' || v_lodgingTel ||
            ', Lodging Addr: ' || v_lodgingAddr ||
            ', Booking Number: ' || v_bookingNumber ||
            ', Room Name: ' || v_roomname ||
            ', Price Total: ' || v_priceTotal ||
            ', Check In: ' || v_checkIn ||
            ', Check Out: ' || v_checkOut
        );
    END LOOP;

    CLOSE v_results;
END;





