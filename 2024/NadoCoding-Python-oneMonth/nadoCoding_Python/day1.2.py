# 숫자 자료 형
print(5)
print(-10)
print(3.14)
print(1000)

print(5+3)
print(2*8)
print(6/3)
print(3 * (3+1))

# 문자 자료형
print('풍선')
print("나비")
print('abcdefg')
print("10")
print("파이썬" * 3) # 문자열 곱하기 가능
print("파이썬" + "무료") # 문자열 더하기 가능
print('작은따옴표') # 작은 따옴표로 감싸도 문자열로 인식 , ' " 는 불가
print("큰따옴표") # 큰 따옴표로 감싸도 문자열로 인식 , ' " 는 불가

# 불 자료형
print(5 > 10)
print(5 < 10)
print(True)
print(False)
print(not True)
print(not False)
not (5 > 10)
not (5 < 10)

# 변수
print("반려동물을 소개해 주세요")
print("우리 집 반려동물은 개인데, 이름은 연탄이에요")
print("연탄이는 4살이며, 산책을 아주 좋아해요")
print("연탄이는 수컷인가요?")
print("네")

name = "연탄이"
age = 4
hobby = "산책"
is_male = True
animal = "개"

print("우리 집 반려동물은 " + animal + "인데, 이름은 " + name + "에요")
print(name + "는 " + str(age) + "살이며, " + hobby + "을 아주 좋아해요")

hobby = "공놀이"
print(name + "는 " + str(age) + "살이며, " + hobby + "을 아주 좋아해요")


# 형변환 하기
print(int("3"))
# print(int("3") + "입니다") # 문자열과 숫자열은 더하기 불가
print(int(3.5))
# print(int("삼")) # 숫자가 아닌 문자열은 형변환 불가
print(float("3.5")) # 문자열을 실수로 형변환
# print(float("오.삼")) # 문자열을 실수로 형변환 불가
print(str(3)+"입니다") # 숫자를 문자열로 형변환
print(str(3.0)+"입니다") # 숫자를 문자열로 형변환
print(str(3.5)+"입니다") # 숫자를 문자열로 형변환


# 주석 문제
print("파이썬은")
# print("처음에는")
print("쉬워요")

'''
예상되는 답안

파이썬은
쉬워요
'''


#역이름 출력하기
station = "사당"
print(station + "행 열차가 들어오고 있습니다.")
station = "신도림"
print(station + "행 열차가 들어오고 있습니다.")
station = "인천공항"
print(station + "행 열차가 들어오고 있습니다.")


# 셀프 체크
status = "상품준비"
print("주문 상태 : " + status)
status = "배송중"
print("주문 상태 : " + status)
statxxxus = "배송완료"
print("주문 상태 : " + status)
