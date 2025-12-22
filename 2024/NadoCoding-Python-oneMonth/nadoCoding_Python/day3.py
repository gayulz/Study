# 연산자
print(1+1)
print(3-2)
print(5*2)
print(6/3)

print(2**3) # 2^3 = 8 거듭제곱
print(10%3) # 나머지 구하기
print(10//3) # 몫 구하기

# 비교 연산자
print(10 > 3)
print(4 >= 7)
print(10 < 3)
print(5 <= 5)

print(3 == 3)
print(4 == 2)
print(3 + 4 == 7)
print(1 != 3)

# 논리 연산자
print(3 > 0 and 3 > 5)
print((3 > 0) or (3 > 5))
print(not(1 != 3))

# 연산자 우선 순위
print(2 + 3 * 4) # 14
print((2 + 3) * 4) # 20

# 간단한 수식
number = 2 + 3 * 4
print(number)
number = number + 2
print(number)
number += 2
print(number)
number *= 2
print(number)
number /= 2
print(number)
number -= 2
print(number)
number %= 5
print(number)

# 숫자 처리 함수
print(abs(-5))
print(pow(4, 2))
print(max(5, 12))
print(min(5, 12))
print(round(3.14))
print(round(4.678,2))

# math 라이브러리
from math import *

result = floor(4.99)
print(result)
result = ceil(3.14)
print(result)
result = sqrt(16)
print(result)

# 랜덤 함수
from random import *
print(random()) # 0.0 ~ 1.0 미만의 임의의 값 생성
print(random() * 10) # 0.0 ~ 10.0 미만의 임의의 값 생성
print(int(random() * 10)) # 0 ~ 10 미만의 임의의 값 생성
print(int(random() * 10) + 1) # 1 ~ 10 이하의 임의의 값 생성

print(randrange(1, 46)) # 1 ~ 46 미만의 임의의 값 생성
print(randint(1, 45)) # 1 ~ 45 이하의 임의의 값 생성



# Quiz) 당신은 최근에 코딩 스터디 모임을 새로 만들었습니다.
# 월 4회 스터디를 하는데 3번은 온라인으로 하고 1번은 오프라인으로 하기로 했습니다.
# 아래 조건에 맞는 오프라인 모임 날짜를 정해주는 프로그램을 작성하시오.
# 조건1: 랜덤으로 날짜를 뽑아야 함
# 조건2: 월별 날짜는 다름을 감안하여 최소 일수인 28 이내로 정함
# 조건3: 매월 1~3일은 스터디 준비를 해야 하므로 제외
# (출력문 예제)
# 오프라인 스터디 모임 날짜는 매월 x 일로 선정되었습니다.
# from random import * 
# day = randint(4,28)
print("오프라인 스터디 모임 날짜는 매월", randint(4,28), "일로 선정되었습니다.")


# 셀프체크
# 연산자를 이용한 온도단위 프로그램
# 섭씨온도를 저장하기 위한 변수 생성
# 화씨온도 = (섭씨 온도 * 9/5)+32
# 섭씨온도 30도일때
# 섭씨 온도 : 30
# 화씨온도 = 86.0
# 섭씨 온도가 10도일때
# 섭씨 온도 : 10
# 화씨 온도 : 50.0

#Celsius = 섭시 
#Fahrenheit = 화씨

celcius = 30
fahrenheit = (celcius*9/5)+32
print(celcius)
print(fahrenheit)
celcius = 10
fahrenheit = (celcius*9/5)+32
print(celcius)
print(fahrenheit)