# # CLASS

# # 마린 : 공격 유닛, 군인, 총을 쏠 수 있음
# name = "마린"
# hp = 40
# damage = 5

# print(f"{name}유닛이 생성되었습니다")
# print(f"체력 : {hp} , 공격력 : {damage}")

# # 탱크 : 공격 유닛, 탱크. 포를 쏠 수 있다. 일반모드와 시즈모드로 나뉜다
# tank_name = "탱크"
# tank_hp = 150
# tank_damage = 35

# print(f"{tank_name}유닛이 생성되었습니다")
# print(f"체력 : {tank_hp} , 공격력 : {tank_damage}")

# # 공격 함수
# def attack(name, location, damage) :
#     print(f"{name} : {location} 방향으로 적군을 공격 합니다. [공격력:{damage}]")

# attack(name, "1시", damage)
# attack(tank_name, "2시", tank_damage)

# # 여기에서 tank가 1개 더 생겼을 때?
# tank_name2 = "탱크2"
# tank_hp2 = 150
# tank_damage2 = 35
# attack(tank_name2, "2시", tank_damage2)

# # 매번 이렇게 생성해주는건 번거롭기 때문에 클래스가 생겼음, 하나의 틀이라 보면 됨


class Unit:
    def __init__(self, name, hp, damage):
        self.name = name
        self.hp = hp
        self.damage = damage
        print(f"{self.name} 유닛이 생성되었습니다.")
        print(f"체력 : {self.hp} , 공격력 : {damage}")


# marine1 = Unit("마린", 40, 5)
# marine2 = Unit("마린", 40, 5)
# tank1 = Unit("탱크", 150, 35)
# tank2 = Unit("탱크", 150, 35)
# tank3 = Unit("탱크", 150, 35)

# __init__ 이란?
# Python에서 사용하는 생성자

# 레이스 : 공중 유닛, 비행기, 클로킹 (상대에게 안보임)
# wraith1 = Unit("레이스", 80, 5)
# print(f"유닛이름 : {wraith1.name} , 공격력 : {wraith1.damage}")
# print("")
# # 마인드 컨트롤 : 상대방 유닛을 내 것으로 만드는 것
# wraith2 = Unit("빼앗은 레이스", 80, 5)
# wraith2.clocking = True
# print("")
# if wraith2.clocking == True :
#     print(f"{wraith2.name}는 현재 클로킹 상태입니다.")


# 메서드
class AttackUnit:
    def __init__(self, name, hp, damage):
        self.name = name
        self.hp = hp
        self.damage = damage
        print(f"{self.name} 유닛이 생성되었습니다.")
        print(f"체력 : {self.hp} , 공격력 : {damage}")

    def attack(self, location):
        print(f"{self.name} : {location} 방향으로 적군을 공격합니다 [공격력 {self.damage}]")

    def damaged(self, damage):
        print(f"{self.name} : {damage}를 입었습니다.")
        self.hp-=damage
        print(f"{self.name} : {self.hp}")
        if self.hp <= 0 :
            print(f"{self.name} : 파괴되엇습니다")

firebat1 = AttackUnit("파이어뱃", 50,60)
firebat1.attack("5시")

firebat1.damaged(25)
firebat1.damaged(25)

