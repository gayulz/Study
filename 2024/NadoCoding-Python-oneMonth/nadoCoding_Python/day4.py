#문자열
sentence = '나는 소년입니다'
print(sentence)
sentence2 = "파이썬은 쉬워요"
print(sentence2)
sentence3 = """
나는 소년이고,
파이썬은 쉬워요
"""
print(sentence3)

type(sentence)


temp = "990229-1234567"
print("역방향 확인:" , temp[-7:])
# 출력 : 1234567

python = "Python is Amazing python"
print("모두 소문자 : " , python.lower())
print("모두 대문자 : " , python.upper())
print("첫 글자는 대문자니? : " , python[0].isupper())
print("python의 글자 길이 수 : " , len(python))
print("Python글자를 JAVA로 바꿔줘 : " , python.replace("Python", "JAVA"))

print("현재 python 단어 :", python)
index = python.index("n")
print("첫번째 n의 위치번호 : ", index)
print("두번째 n의 위치번호 : ", python.index("n", index+1))

# 단어 찾기
print(python.find("n"))
# 단어 횟수
print(python.count("n"))

