# # # 예외 처리하기
# try : 
#     print("나누기 전용 계산기 입니다.")
#     nums = []
#     nums.append(int(input("첫 번째 숫자를 입력하세요 : ")))
#     nums.append(int(input("두 번째 숫자를 입력하세요 : ")))
#     nums.append(int(nums[0]/nums[1]))
#     print(f"{nums[0]} / {nums[1]} = {nums[2]}")
# except ValueError :
#     print("에러입니다. 잘못된 값을 입력했습니다")
# except ZeroDivisionError as err : 
#     print(err)
# except Exception as err : 
#     print("알 수 없는 에러입니다")
#     print(err)


# # # 에러 발생 시키기    
# try : 
#     print("한자리 숫자 나누기 전용 계산기")
#     num1 = int(input("첫 번째 숫자를 입력하세요 : "))
#     num2 = int(input("첫 번째 숫자를 입력하세요 : "))
#     if num1 >= 10 or num2 >= 10 :
#         raise ValueError
#     print("{} / {} = {}".format(num1,num2, int(num1/num2)))
# except ValueError:
#     print("잘못된 값을 입력하였습니다. 한 자리 숫자만 입력하세요")


# # 사용자 정의 에러 및 메세지출력
# class BigNumberError(Exception):
#     def __init__(self, msg):
#         self.msg = msg
    
#     def __str__(self):
#         return self.msg
    
# try :
#     print("한자리 숫자 나누기 전용 계산기 입니다")
#     num1 = int(input("첫 번째 숫자를 입력하세요 : "))
#     num2 = int(input("첫 번째 숫자를 입력하세요 : "))
#     if num1 >= 10 or num2 >= 10 :
#         raise BigNumberError("입력값 : {} , {}".format(num1, num2))
#     print("{} / {} = {}".format(num1,num2, int(num1/num2)))
# except ValueError:
#     print("잘못된 값을 입력 했습니다. 한 자리 숫자만 입력하세요")
# except BigNumberError as err :
#     print("오류 발생 , 한자리 숫자만 입력하세요")
#     print(err)
# finally :
#     print("계산기를 이용해 주셔서 감사합니다")



# '''
# 실습 문제 : 치킨 주문
# '''    

# class SoldOutError(Exception):
#     def __init__(self, msg):
#         self.msg = msg
    
#     def __str__(self):
#         return self.msg
    
# class ErrorMsg(Exception):
#     def __init__(self, msg):
#         self.msg = msg
    
#     def __str__(self):
#         return self.msg
     
     
# chicken = 10 # 남은 치킨 수
# waiting = 1 # 대기번호 1부터 시작

# while True :
#     try :  
#         # 재료 소진
#         if chicken == 0 :
#             raise SoldOutError("재료가 소진돼 더이상 주문을 받지 않습니다")
        
#         print(f"[ 남은 치킨 : {chicken} ]")
#         order = int(input("치킨을 몇 마리 주문 하시겠습니까 ? "))

#         # 주문한 치킨 갯수가 1 미만 이거나 int type이 아닐 경우 
#         if order < 1 or type(order) != int : 
#             raise ValueError
#         # 최대 주문량은 10마리 제한
#         elif order > 10 :
#             print("개인당 주문 수량은 최대 10마리 까지 입니다")
#             continue

#         # 남은 수량 보다 주문 치킨 갯수가 많을 때
#         if order > chicken :
#             raise ErrorMsg(f"재료가 부족합니다")
#         else :
#             print(f"[ 대기번호 : {waiting} ] {order}마리 주문했습니다")
#             waiting+=1
#             chicken -= order
#     except ErrorMsg as err:
#         print(err)
#     except ValueError as err :
#         print("값을 잘못 입력하였습니다")        
#     except SoldOutError as err :
#         print(err)
#         break

'''
셀프 체크
배터리 잔량에 따라 스마트폰 배터리 관리하는 프로그램
'''

def save_battery(level):
    print(f"배터리 잔량 : {level}%")
    try :
        if level > 30 :
            print("일반 모드로 사용합니다.")
        elif level > 5 and level < 30 : 
            print("절전 모드로 사용합니다")
        else :
            raise Exception
    except Exception :
        print("배터리가 부족 하여 스마트 폰을 종료합니다")

save_battery(75)
save_battery(25)
save_battery(35)
save_battery(3)
