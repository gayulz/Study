<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
<%@ include file="./include/top.jsp" %>
    <article>
        <section>
            <div>
              <div class="card text-center">
                <img src="<%=request.getContextPath()%>/resources/img/indexmain.PNG" class="img-fluid" alt="...">
                <div class="card-body">

                  <h5 class="card-title">Java Study 맴버 모집</h5>
                 
                    <ul>
                      <li> java 기본 문법을 이해한 사람</li>
                      <li> 팀별 활동을 적극적으로 참여할 사람</li>
                    </ul>  
                  
                 <a href="#" class="btn btn-primary">참여하기</a>
                </div>
              </div>
            </div>

        </section>
        
    </article>
    
    <footer>
        <div>
            <hr>
            <p>개발자 : 김티처.. 10분 쉴께요</p>
        </div>
    </footer>
</body>
</html>