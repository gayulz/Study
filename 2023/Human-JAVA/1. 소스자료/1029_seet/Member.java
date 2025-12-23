
public class Member {
	// 생성자를 작성하지 않으면 자바는 자동으로 생성자를 생성해 준다.
	/**
	 *   //아래 생성자는 생략이 가능하다.
	 *   Member() {
	 *   }
	 */

	String name=null;
	String addr=null;
	int age=0;
	BookingInfo[] mybookingList = new BookingInfo[3];

	public void prt() {
		System.out.println(" Name "+name);
		System.out.println(" ADDR "+addr);
		System.out.println(" A GE "+age);
	}
	public void bookingInfo(){
		for (int i = 0; i < mybookingList.length; i++) {
			if (mybookingList[i] != null ){
				System.out.println("예약 " + (i+1) + " : " + mybookingList[i].userName );
				System.out.println("예약좌석 : " + mybookingList[i].row + "행 | " + mybookingList[i].col + " 열");
			}
		}
	}
	public void inputBooking(BookingInfo bookingInfo){
		for (int i = 0; i < mybookingList.length; i++) {
			if (mybookingList[i] == null ){
				mybookingList[i] = bookingInfo;
				break;
			}
		}
	}

}
