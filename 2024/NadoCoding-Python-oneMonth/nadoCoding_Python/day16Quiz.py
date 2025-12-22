"""
부동산 프로그램 퀴즈

[코드]
class House:
    # 매물 초기화
    def __init__(self, location, house_type, deal_type, price, completion_year):
        pass

    # 매물 정보 표시
    def show_detail(self):
        pass

조건1 : 생성자로 인스턴스 변수를 정의한다 , 매물 정보를 표시하는 show_detail()메서드에서는 
        인스턴스 변수를 순서대로 출력한다
조건 2 : 실행결과에 나온 3가지 매물을 객체로 만들고 총 매물 수를 출력한 뒤 show_detail()메서드를
        호출해 각 매물 정보를 표시한다

[실행결과]
총 3대의 매물이 있습니다
강남 아파트 매매 10억 2010년
마포 오피스텔 전세 5억 2007년
송파 빌라 월세 500/50 2000년
"""


class House:
    # 매물 초기화
    def __init__(self, location, house_type, deal_type, price, completion_year):
        self.location = location
        self.house_type = house_type
        self.deal_type = deal_type
        self.price = price
        self.completion_year = completion_year

    # 매물 정보 표시
    def show_detail(self):
        print(f"{self.location} {self.house_type} {self.deal_type} {self.price} {self.completion_year}")

houses = []
houses.append(House("강남", "아파트", "매매", "10억", "2010년"))
houses.append(House("마포", "오피스텔", "전세", "5억", "2007년"))
houses.append(House("송파", "빌라", "월세", "500/50", "2000년"))
tot = len(houses)
print(f"총 {tot}대의 매물이 있습니다 ")
for h in houses:
    House.show_detail(h)

print("===================================================================")
"""
셀프체크
주차 차량 등록 관리 프로그램
"""

class ParkingManager:
    count = 0
    # 주차 정보 초기화 : 총 주차 가능 대수
    def __init__(self, capacity):
        self.capacity = capacity
        print(f"총 {capacity}대를 등록할 수 있습니다")

    # 신규 차량 등록
    def register(self):
        self.count += 1
        if self.count <= self.capacity: 
            print(f"차량 신규 등록 ({self.count}/{self.capacity})")
        else : 
            print("더 이상 등록할 수 없습니다.")
# 테스트코드
manager = ParkingManager(5)
for i in range(6):
    manager.register()


