from random import *
# 상속
# 일반 유닛 (부모 클래스)
class Unit:
    def __init__(self, name, hp, speed):
        self.name = name
        self.hp = hp
        self.speed = speed
        print(f"{name} 유닛이 생성되었습니다.")

    def move(self, location):
        print(" [지상 유닛 이동] ")
        print(f"{self.name} : {location}시 방향으로 이동합니다.[ 속도 : {self.speed} ] ")

    def damaged(self, damage):
        print(f"{self.name} : {damage}를 입었습니다.")
        self.hp -= damage
        print(f"{self.name} : {self.hp}")
        if self.hp <= 0:
            print(f"{self.name} : 파괴되엇습니다")

# 날수 있는 클래스
class Flyable:
    def __init__(self, flying_speed):
        self.flying_speed = flying_speed

    def fly(self, name, location):
        print(f"{name} : {location}시 방향으로 날아갑니다 [속도 : {self.flying_speed}]")



# 자식 클래스
# 공격 유닛 
class AttackUnit(Unit):
    def __init__(self, name, hp, speed, damage):
        Unit.__init__(self, name, hp, speed)
        self.damage = damage

    def attack(self, location):
        print(f"{self.name} : {location} 방향으로 적군을 공격합니다 [공격력 {self.damage}]")

# 공중 공격 유닛 클래스 (다중 상속)
class FlyableAttackUnit(AttackUnit, Flyable):
    def __init__(self, name, hp, damage, flying_speed):
        AttackUnit.__init__(self, name, hp, 0, damage)  # 지상 스피드는 0
        Flyable.__init__(self, flying_speed)

    def move(self, location):
        print(" [공중 유닛 이동] ")
        self.fly(self.name, location)

#---------------------------------------------------------------------------------#
        
# 마린
class Marine(AttackUnit):
    def __init__(self):
        super().__init__("마린", 40, 1, 5)

    # 스팀팩 : 일정 시간 동안 이동 및 공격 속도를 증가, 체력 10 감소
    def stimpack(self):
        if self.hp > 10:
            self.hp -= 10
            print(f"{self.name} : 스팀팩을 사용합니다 (HP 10 감소)")
        else:
            print(f"{self.name} : 체력이 부족하여 스팀팩을 사용하지 않았습니다")


# 탱크
class Tank(AttackUnit):
    # 시즈모드 : 탱크를 지상에 고정시켜 더 높은 파워러 공격 가능, 이동 불가
    seize_developed = False  # 시즈모드 개발여부

    def __init__(self):
        AttackUnit.__init__(self, "탱크", 150, 1, 35)
        self.seize_mode = False

    def set_seize_mode(self):
        if Tank.seize_developed == False:
            return

        # 현재 시즈모드가 아닐 때 : 시즈모드
        if self.seize_mode == False:
            print(f"{self.name} : 시즈모드로 전환합니다.")
            self.damage *= 2
            self.seize_developed = True
        # 현재 시즈모드가 일 때 : 시즈모드 실행
        else:
            print(f"{self.name} : 시즈모드로 해제합니다.")
            self.damage /= 2
            self.seize_developed = False


            
# 드랍쉽 : 공중유닛,수송기. 마린 / 파이어뱃 /탱크 등을 수송한다. 공격기능 없음


# 레이스
class Wraith(FlyableAttackUnit):
    def __init__(self):
        FlyableAttackUnit.__init__(self,"레이스", 80,20,5)
        self.clocked = False # 클로킹 모드(해제상태)

    def clocking(self):
        if self.clocked == True: # 클로킹 모드 -> 해제 
            print(f"{self.name} : 클로킹 모드 해제합니다.")
            self.clocked = False
        else: # 클로킹 해제 -> 모드 설정
            print(f"{self.name} : 클로킹 모드 설정합니다.")
            self.clocked = True


def game_start():
    print(" ** 알림 ** 새로운 게임을 시작합니다. ")
def game_over():
    print(" Player : gg")
    print("[Player] 님이 게임에서 퇴장하셨습니다.")

# 발키리 : 공중 공격 유닛 , 한번에 14발 미사일 발사
# valkyrie = FlyableAttackUnit("발키리", 200, 6, 5)
# valkyrie.fly(valkyrie.name, 3)

# 연산자 오버로딩
# 부모 클래스에서 정의한 메서드가 아닌 자식 클래스에서 정의한 메서드를 사용하고 싶을 때 하는 것을 오버로딩이라 함

# # 벌쳐 : 지상 유닛, 기동성이 좋음
# valture = AttackUnit("벌쳐", 80, 10, 20)

# # 배틀크루저 : 공중 유닛, 체력도 좋음, 공격력도 좋음
# battlecuiser = FlyableAttackUnit("배틀크루저",500,25,3)

# valture.move(11)
# # battlecuiser.fly(battlecuiser.name,9)
# battlecuiser.move(9)


# PASS
# 건물 짓기
class BuildingUnit(Unit):
    def __init__(self, name, hp, location):
        # Unit.__init__(self, name, hp, 0)
        super().__init__(name, hp, 0)
        # super를 사용할 때엔 self를 작성하지 않고 사용한다
        # 하지만 다중 상속 할 때엔 super 키워드는 문제가 된다
        # 다중 상속일 경우 처음 만나는 부모 클래스만 super로 인식되고 그 이후에 상속해야 하는 부모 클래스는 인식이안된다
        # 다중 상속일 경우엔 super대신 기존처럼 (부모클래스명).__init__ 으로 처리해야함
        self.location = location