-- select * from customer;
----------------
desc BookingList;


            SELECT lg.lodgingName, lg.lodgingTel, ri.lodgingAddr, bl.bookingNumber , ri.roomName, bl.priceTotal, bl.reservationDay, bl.checkIn, bl.checkOut
            FROM RoomInfo ri, BookingList bl, Lodging lg
            WHERE ri.roomNumber = bl.roomNumber
            AND lg.lodgingUniqueNumber = ri.lodgingUniqueNumber
            AND bl.bookingNumber = (SELECT bookingNumber
                                     FROM Customer
                                    WHERE customerName = '최봉석'
                                    AND password =  '1234!'
                                    AND customerPhone = '010-1212-1212')
            ORDER BY bl.checkIn ASC; 
            
            
             
    SELECT count(*)
    FROM Customer
    WHERE customerName = '최봉석'
    AND password =  '1234!'
    AND customerPhone = '010-1212-1212';