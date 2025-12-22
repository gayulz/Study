# 표준 입출력
# print("Python", "Java", sep=" vs ")
# print("Python", "Java", "JavaScript", sep=",", end = "?")
# print("무엇이 더 재밌을까요?")

# import sys
# print("Python", "Java", file=sys.stdout)
# print("Python", "Java", file=sys.stderr)

# 시험 성적
# scores = { "수학":0, "영어":59, "코딩":100 }
# for subject, score in scores.items() : 
#     print(subject.ljust(8), str(score).rjust(4), sep=":")

# 은행 대기 순번표
# for num in range(1, 21):
#
# 
# # 소수점을 특정 자리수 까지만 표시     print(.2"대기번호 : " + str(num).zfill(33))

# answer = input("아무 값이나 입력하세요 : ")
# print("입력하신 값은 : " + answer )

# 다양한 format 양식

# 빈 자리는 빈 공간으로 두고 오른쪽 정렬, 총 10자리 공간 확보 
print("{0:>10}".format(500))

# 양수 일 땐 + 로 표시, 음수일 땐 - 로 표시
print("{0:>+10}".format(500))
print("{0:>+10}".format(-500))

# 왼쪽 정렬 , 빈칸은 _로 채움
print("{0:_<10}".format(500))

# 3자리마다 콤마 찍기
print("{0:,}".format(100000000))

# 3자리마다 콤마찍기, + - 부호도 붙히기
print("{0:+,}".format(100000000))
print("{0:+,}".format(-100000000))

# 3자리마다 콤마찍기, + - 부호도 붙히고, 자리수도 확보
# 빈 자리는 ^ 표시로 채워주기
print("{0:^<+30,}".format(1000000000))

# 소수점 출력
print("{0:f}".format(5/3))

# 소수점을 특정 자리수 까지만 표시 = 반올림까지 함 
print("{0:.2f}".format(5/3))



