# 함수
# 함수의 정의 : def {함수명}() : 
def open_account(name):
    print(f"{name}님의 새로운 계좌가 생성되었습니다")
# 정의만 해둔 상태이며 , 호출하지 않는다면 실행되지 않는다
# 입금
def deposit(name,balance, money):
    print(f"{name}님 계좌에 {money} 입금 완료. 잔액 : {balance+money}원")
    return balance + money
# 출금
def withdraw(name,balance, money):
    if balance >= money:
        print(f"{name}님 계좌에서 {money}출금 완료, 현재 잔액 : {balance-money}원")
        return balance - money
    else:
        print(f"{name}님 계좌 잔액{balance}원으로 {money-balance}원 잔액부족으로 불가합니다")
        return balance 
# 수수료 부과 출금 함수
def withdraw_night(balance, money):
    commission = 100 # 수수료
    return commission, balance-money-commission

# 함수의 호출
open_account("김가율")
balance = 1000 # 계좌 잔액 
# balance = deposit("김가율", balance, 1000) # 입금  
# balance = withdraw("김가율", balance, 3000) # 출금 
commission, balance = withdraw_night(balance,500)
print(f"수수료 {commission}이며 , 잔액은 {balance}입니다. ")

