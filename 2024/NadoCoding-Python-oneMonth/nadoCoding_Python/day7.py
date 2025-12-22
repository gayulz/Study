#튜플

menu = ( "돈가스" , "치즈돈가스" )
print(menu[0])
print(menu[1])

name = "피글렛"
age = 20
hobby = "코딩"
print(name, age, hobby)

( name, age, hobby) = ( "피글렛", 30, "코딩" )
print(name, age, hobby)

(departure, arrival) = ("김포", "제주")
print(departure, ">", arrival)
(departure, arrival) = (arrival, departure)
print(departure, ">", arrival)

# 집합(Set)

java = { "유재석", "김태호", "양세형" }
python = set(["유재석", "박명수"])

# 교집합 ( java와 python을 모두 할 수 있는 개발자 )
print(java & python)
print(java.intersection(python))

#합집합 ( java 할 수 있거나 python 할 수 있는 개발자 )
print(java | python)
print(java.union(python))

#차집합 ( java는 할 수 있지만 python은 할 줄 모르는 개발자 )
print(java - python)
print(java.difference(python))

# python을 할 줄 아는 사람이 늘어남
python.add("김태호")
print(python)

# java를 까먹음
java.remove("김태호")
print(java)

# 자료구조의 변경
# 커피숍 
menu = { "커피", "우유", "주스" }
print(menu, type(menu))
menu = list(menu)
print(menu, type(menu))
menu = tuple(menu)
print(menu, type(menu))
menu = set(menu)
print(menu, type(menu))

print("\n---------------------[ # 퀴즈 ]---------------------[\n")
# 퀴즈 당첨자 뽑기
from random import *
numbers = range(1, 21)
numbers = list(numbers)
shuffle(numbers)
users = sample(numbers, 4)
print(f"--당첨자 발표--\n치킨 당첨자 : {users[0]}\n커피 당첨자 : {users[1:]} \n -- 축하합니다! -- ")
print("\n---------------------[ # 셀프체크 ]---------------------\n")

applicationSubjects = ["자료구조", "알고리즘", "자료구조", "운영체제"]
applicationSubjects = set(applicationSubjects)
print(f"신청 과목 : {applicationSubjects}")