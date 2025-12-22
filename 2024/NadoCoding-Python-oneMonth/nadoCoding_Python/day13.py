# 파일 입 출력
# score_file = open("score.txt", "w", encoding="utf-8")
# print("수학 : 0", file=score_file)
# print("영어 : 50", file=score_file)
# score_file.close()

# score_file = open("score.txt", "a", encoding="utf-8")
# score_file.write("과학 : 90\n")
# score_file.write("코딩 : 90")
# score_file.close()

# score_file = open("score.txt", "r", encoding="utf-8")
# 내용을 모두 한꺼번에 가져오는 것 : score_file.read()
# print(score_file.read())
# score_file.close()

# 내용을 한줄 한줄 가져와서 처리하고 싶다 : score_file.readline() 1라인씩만 가져옴
# score_file = open("score.txt", "r", encoding="utf-8")
# print(score_file.readline(), end="")
# print(score_file.readline(), end="")
# print(score_file.readline(), end="")
# print(score_file.readline(), end="")
# score_file.close()

# 다른 사람의 파일일 경우 몇 라인일지 모른다, 그럴 경우 처리하는 방법
# score_file = open("score.txt", "r", encoding="utf-8")
# while True :
#     line = score_file.readline()
#     if not line :
#         break
#     print(line, end=" ")
# score_file.close()

# List에 값을 모두 넣어서 처리하기
# score_file = open("score.txt", "r", encoding="utf-8")
# lines = score_file.readlines() # 리스트 형태로 저장한다
# for line in lines :
#     print(line, end="")
# score_file.close()

# w : 쓰기 r : 읽기 a : 추가하기
# 피클을 쓰기 위해서는 바이너리파일을 꼭 설정해줘야 한다 , w가 아닌 wb(바이너리의미)
# pickle 모듈
import pickle

# profile_file = open("profile.pickle", "wb")
# profile = { "이름" : "박명수" , "나이": 30, "취미" : ["축구","골프","코딩"]}
# print(profile)
# pickle.dump(profile, profile_file)

# profile_file.close()
# profile_file = open("profile.pickle", "rb")
# profile = pickle.load(profile_file)
# print(profile)
# profile_file.close()

# pickle은 프로그램에서 사용하는 데이터를 파일 형태로 저장하거나 불러오게할 수 있는 모듈이고
# 바이너리 형식으로 저장된다 .

# with문
# close()를 별도로 쓰지 않아도 열었던 파일을 닫게해줌

# with open("profile.pickle", "rb") as profile_file:
#     print(pickle.load(profile_file))

# with open("study.txt", "w", encoding="utf-8") as study_file:
#     study_file.write("파이썬 공부중")

# with open("study.txt", "r", encoding="utf-8") as study_file:
#     print(study_file.read())

# 주차별 보고서 파일 만들기
# week = 1
for i in range(1, 51):
    memo = f" - {i}주차 주간보고 - \n부서 :\n이름 :\n업무요약 :"
    with open(f"{i}주차.txt", "w", encoding="utf-8") as files:
        files.write(memo)

# 셀프 체크
# 파일 생성
with open("class.txt", "w", encoding="utf-8") as files:
    files.write("초록반 5세 20명 파랑반 6세 18명 노랑반 7세 22명")

# 파일 읽어오기
with open("class.txt", "r", encoding="utf-8") as files:
    kinder = files.read()

kinder = kinder.split(" ")  # 빈칸을 기준으로 split
temp = ""
for k in kinder:
    if k.endswith("명"):
        # 합친 글자를 출력
        print(temp + k)
        temp = ""
    else:
        # 명으로 끝나지 않는 단어일 경우 단어를 합쳐야 한다
        temp += k + " "
