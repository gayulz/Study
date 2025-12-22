# 문자열 포멧
print("a"+"b")
print("a","b")
print("나는 %d살 입니다." %20)
print("나는 %s을 좋아해요" %"파이썬")
print("Apple 은 %c로 시작해요." %"A")
# %s 로 사용할 경우 정수,문자건 상관 없이 각 출력을 할 수 있어서 간편하다
# 여러개 사용할 때
print("나는 %s색과 %s색을 좋아해요" %("파란", "노란"))

#방법2
print("나는 {}살 입니다." .format(20))
print("나는 {1}색과 {0}색을 좋아해요" .format("파란", "빨간"))

#방법3
print("나는 {age}살이며, {color}색을 좋아해요." .format(age=20, color="빨간"))

#방법4 (v3.6 파이썬 이상 ~ )
age = 20
color = "빨간"
print(f"나는 {age}살이며, {color}색을 좋아해요.")

#탈출문자 \n
print("백문이 불여일견 백견이 불여일타")
print("백문이 불여일견\n백견이 불여일타")
print("저는 \"김가율\" 입니다.")

# \\ : 문장 내에서 하나의 \ 로 인식한다
# \r : 리턴 
print("Red Apple\rPine")
# PineApple : \r을 만나면서 커서가 맨 앞으로 이동해 Red를 덮어씌우면서 Pine이 작성됨
# \b : 백스페이스 
print("Redd\bApple")
# RedApple : \b을 만나면서 두번적힌 d의 글자가 백스페이스되어 삭제되고 Apple이 작성됨
# \t : 탭 칸띄우기

# 퀴즈 비밀번호만들기
print("퀴즈 : 비밀번호 만들기")
site = "http://naver.com"
temp = site[site.index("//")+2:site.index(".")] 
# http가 될수도 있고 https 가 될 수 있어서 // 가 있는 공통점을 index로 찾아 위치를 +2시킴
# 도메인만 추출할 수 있도록 함
password = temp[:3]+str(len(temp))+str(temp.count('e'))+"!"
print(f"비밀번호 생성 :{password}")

#셀프체크
#첫번째 글자는 대문자, 나머지 글자 소문자 변환 프로그램

#문장1 
#the early bird catches the worm
title = "the early bird catches the worm"
print(title[0].upper()+title[1:].lower())

#문장2
#Actions Speak Louder Than Words
title = "Actions Speak Louder Than Words"
print(title[0].upper()+title[1:].lower())

#문장3
# PRACTICE MAKES PERFECT.
title = "PRACTICE MAKES PERFECT."
print(title[0].upper()+title[1:].lower())