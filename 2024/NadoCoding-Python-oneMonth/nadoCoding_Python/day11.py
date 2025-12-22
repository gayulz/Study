# 11일차
# 함수호출하기

# 기본 값이 정의되지 않은 함수  
# def profile(name, age, main_lang): 
#     print(f"이름 : {name}\t나이 : {age}\t주 사용 언어 : {main_lang}")
# profile("유재석", 20, "파이썬")
# profile("김태호", 25, "자바")

# 같은 학교 같은 학년 같은 반 같은 수업
# 함수의 기본 값 설정  
# def profile(name="입력값 없음", age=17, main_lang="파이썬"): 
#     print(f"이름 : {name}\t나이 : {age}\t주 사용 언어 : {main_lang}")

# profile()
# profile("유재석")
# profile("김태호")

# def profile(name, age, main_lang): 
#     print(f"이름 : {name}\t나이 : {age}\t주 사용 언어 : {main_lang}")

# profile(name="유재석", main_lang="파이썬",age=20)
# profile(age=25, main_lang="자바", name="김태호")

# 가변인자 사용하기 ( *로 활용 )
# def profile(name, age, lang1, lang2, lang3, lang4, lang5) : 
#     print("이름  : {0}\t나이 : {1}\t".format(name, age), end=" ")
#     print(lang1, lang2, lang3, lang4, lang5)
def profile(name, age, *language) : 
    print("이름  : {0}\t나이 : {1}\t".format(name, age), end=" ")
    for lang in language : 
        print(lang, end=" ")
    print()

profile("유재석", 20, "Python", "Java", "C", "C++", "C#")
profile("김태호", 25, "Python", "Swift")
profile("하하", 15, "Python")

# 지역변수와 전역변수

gun = 10
def checkpoint(soldiers) :  # 경계근무 
    global gun # 전역 공간에 있는 gun을 사용하겠다 라는 의미 
    gun -= soldiers
    print("[지역변수] 남은 총 : {0}\t".format(gun))
# 전역 변수로 사용하게 되면 코드가 지저분해 질 수 있다
# 보통은 파라미터로 전달 값으로 사용하고 반환하는 것으로 사용한다

def checkpoint_ret(gun, soldiers) : 
    gun -= soldiers
    print("[지역변수] 남은 총 : {0}".format(gun))
    return gun 

print("[전역변수] 전체 총 : {} ".format(gun))
# checkpoint(2)
gun = checkpoint_ret(gun, 2) 
# global 지정 없이 인자로 전달 받아 처리 후 리턴값으로 반환해 대입 하는 방식 
# 이렇게 할 경우 global 지정 없이도 함수 외부에 있는 변수에 적용 할 수 있다.
print("[전역변수] 전체 총 : {} ".format(gun))

print("--------------------------------------------------------------")
print("\t\t\t퀴즈")
# 퀴즈
# 표준 체중을 구하는 프로그램을 작성하시오
def std_weight(height, gender):
    if gender == "남자" :
        return std_kg(height, 22)
    else :
        return std_kg(height, 21)
# 평균 체중 계산 
def std_kg(height, number):
    return (height/100)*(height/100)*number   

height = 165
gender = "여자"
std = std_weight(height, gender)
print(f" 키 {height}cm {gender}의 표준 체중은 {std:.2f}kg 입니다")

height = 185
gender = "남자"
std = std_weight(height, gender)
print(f" 키 {height}cm {gender}의 표준 체중은 {std:.2f}kg 입니다")
print("--------------------------------------------------------------")
print("\t\t 셀프체크 - 미세먼지 체크")
# 미세먼지 수치 출력 함수 
def get_air_quality(air_levels) :
    if 0 <= air_levels <= 30 :
        return "좋음"
    elif 31 <= air_levels <= 80 : 
        return "보통"
    elif 81 <= air_levels <= 150 :
        return "나쁨"
    elif 151 <= air_levels :
        return "매우 나쁨"
    else : 
        return "확인 불가"
    
# 테스트코드 - 미세먼지 15 좋음
print(get_air_quality(15))

# 테스트코드 - 미세먼지 85 나쁨
print(get_air_quality(85))

