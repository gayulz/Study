# 리스트
# 순서를 가지는 객체의 집합이다

subway = ["유재석", "조세호", "박명수"]
print("조세호씨는 {}번째 자리에 있습니다".format(subway.index("조세호")))

subway.append("하하")
print(subway) # 하하탑승

# 정형돈씨를 유재석/조세호 사이에 추가
subway.insert(1,"정형돈")
print(subway)

# 지하철에 있는 사람을 한명씩 뒤에서 꺼냄
print(subway.pop())
print(subway)
print(subway.pop())
print(subway)
print(subway.pop())
print(subway, len(subway))
subway.append("유재석")
print(subway)
print(subway.count("유재석"))




# 정렬
num_list = [ 5,2,4,3,1 ]
num_list.sort()
print(num_list)

# 뒤집기도 가능
num_list.reverse()
print(num_list)

# 모두 지우기
num_list.clear()
print(num_list)



# 리스트는 자료형에 구애받지 않고 다양하게 대입 가능하다
# 리스트끼리 확장도 가능하다
num_list.extend(subway)
print(num_list)


# 딕셔너리
# 사전형은 키와 밸류로 구성되어있다, {} 형식으로 선언
# 딕셔너리에 값을 가져오려고 할 때엔 2가지 방법이 있음

cabinet = { 3:"유재석", 100:"김태호"}
print(cabinet[3])
print(cabinet[100])
print(cabinet.get(3))
# print(cabinet.get(5))

# 5번 key는 없는 키 이다.
# get을 사용하지않고 [5]로 명시하여 꺼내오게 되면 오류가 발생되며 프로그램이 종료된다
# get을 사용하여 꺼내오게 되면 프로그램은 종료되지 않고 None을 보여주고 유지된다
# None이라는 값을 표기하고 싶지 않고 사용자가 별도 표기하고 싶다면 
print(cabinet.get(5, "사용가능"))

# key가 있는지 확인
print(3 in cabinet)
print(5 in cabinet)
print("곰" in "돌이")

#값 변경/추가/삭제
cabinet.clear()
cabinet = { "A-3" : "푸" , "B-100" : "피글렛"}
print(cabinet)
cabinet["A-3"] = "티거"
cabinet["C-20"] = "이요르"
print(cabinet)
del cabinet["A-3"]
print(cabinet)

# key만 출력
print(cabinet.keys())

# values만 출력
print(cabinet.values())

# 모두출력
print(cabinet.items())