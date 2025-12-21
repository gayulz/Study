# 1. 운영체제 및 프로그램 설치하기
# 경로 : https://hub.docker.com/ 에 저장된 이미지를 가져온다 
# FROM ubuntu:23.04
# # 필요한 라이브러리 설치
# RUN sudo apt install nodejs 
# RUN sudo npm install -g yarn


# 귀찮다면 docker hub에서 다운받자
# docker node 라는 도구를 설치하면 ubuntu에 nodejs, yarn이 설치된 이미지를 올려놓음

# 1. 운영체제 및 프로그램 설치(linux , node, npm, yarn)까지 모두 깔려있는 이미지 다운로드 방식 
FROM node:14 

# 1-1 : 도커 이미지 안에 폴더 생성 
RUN mkdir myfolder 


# 2. 내 컴퓨터에 있는 폴더나 파일을 도커 이미지 안으로 복사하기 
# COPY ./index.js /index.js
COPY . /myfolder/
WORKDIR /myfolder/
RUN yarn install 


# 3. 도커 안에서 Index.js 실행시키기 
CMD yarn start:dev



# 도커를 만든 후 build 하게 되면 모두 진행 후 최적화를 한 다음 하나의 이미지로 만들어 진다 
# 실행시키는 명령어는 RUN , CMD 가 있다
# 이미지로 저장 될 때 CMD는 실제 저장이 되지 않고 RUN으로 되는것들은 모두 실행 후 이미지로 저장된다 
# CMD는 이미지 저장완료 후 저장된 컴퓨터를 실행 시킬때 CMD를 사용한다 
# CMD는 파일1개당 1번만 사용할 수 있다 : 마지막에 1번만 실행하는 것 


