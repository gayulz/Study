# 반복문
# print("대기번호 : 1")
# print("대기번호 : 2")
# print("대기번호 : 3")
# print("대기번호 : 4")

# for numbers in range(1,6):
#     print("대기번호 : {0}".format(numbers))

# starbucks = ["아이언맨", "토르", "아이엠 그루트"]
# for customer in starbucks:
#     print("{0}, 커피가 준비되었습니다".format(customer))



# while
# 무한 루프 
# customer = "아이언맨"
# index = 1
# while True : 
#     print("{0}님 커피 준비되었습니다. 호출{1}회" .format(customer, index))
#     index += 1
#------------------------------------------------
# customer = "토르"
# person = "Unknown"

# # while person != customer : 
# #     print("{0}님 커피 준비되었습니다." .format(customer))
# #     person = input("이름이 어떻게 되세요?")
# index = 5
# while index >= 1:
#     print("{0}님 커피 준비되었습니다." .format(customer))
#     person = input("이름이 어떻게 되세요?")
#     if person == customer:
#         break; 
#     else: 
#         index -= 1
#         print("{}번 남았습니다".format(index))
#     if index == 0:
#         print("커피를 폐기합니다")
#------------------------------------------------
# continue && break
# absent = [2,5]
# no_book = [7] 
# for student in range(1, 11):
#     if student in absent:
#         continue
#     elif student in no_book:
#         print("오늘 수업은 여기까지 {0}번 학생은 교무실로 따라오세요".format(student))
#         break
#     print("{0}번 학생, 책을 읽어보세요" .format(student))
#------------------------------------------------
# [동작 for 변수 반복대상]
# students = [1,2,3,4,5,6,7]
# print(students)
# students = [i + 100 for i in students]
# print(students)
#------------------------------------------------
# Cocoa 택시 퀴즈
from random import * 
taxi = 0;
for i in range(1,51):
    customer = randrange(5, 51)
    if 5 <= customer <= 15:
        print(f"[O]{i}번째 손님 (소요시간 : {customer}분) ") 
        taxi+=1
    else:
        print(f"[ ]{i}번째 손님 (소요시간 : {customer}분) ")
 