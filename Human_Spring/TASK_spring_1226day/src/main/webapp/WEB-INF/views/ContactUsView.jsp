<%--
  Created by IntelliJ IDEA.
  User: yuuri
  Date: 12/26/23
  Time: 2:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!-- jstl 문법을 사용한다 -->
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</head>
<body>
<article>
    <section>
        <div>
            <div>
                <div class="card text-center">
                    <div class="card-body">
                        <h1 class="card-title"> 등록된 문의글 </h1>
                    </div>
                </div>
            </div>
        </div>
        <div id="article_table">
            <table class="table">
                <thead class="table-dark">
                <tr style="text-align: center">
                    <th scope="col" width="10%" style="text-align: center">글번호</th>
                    <th scope="col" width="15%" style="text-align: center">작성자</th>
                    <th scope="col" width="40%" style="text-align: center">제목</th>
                    <th scope="col" width="20%" style="text-align: center">등록일</th>
                    <th scope="col" width="10%" style="text-align: center">수정</th>
                    <th scope="col" width="10%" style="text-align: center">삭제</th>
                </tr>
                </thead>
                <tbody>
                <!-- 컨트롤러에서 보낸 리스트를 반복하여 tr단위로 출력하면 된다 -->
                <c:forEach items="${list}" var="list">
                    <tr>
                        <th scope="row" style="text-align: center">${list.contactNum}</th>
                        <td style="text-align: center">${list.contactWriter}</td>
                        <td style="text-align: center">
                            <a href="/showPost?contactNum=${list.contactNum}">${list.contactTitle}</a>
                        </td>
                        <td style="text-align: center">${list.contactDate}</td>
                        <td style="text-align: center">
                            <form action="/selectPost" method="post">
                                <button type="submit" name="contactNum" value="${list.contactNum}"> 수정 </button>
                            </form>
                        </td>
                        <td style="text-align: center">
                            <form action="/deletePost" method="post">
                                <button type="submit" name="contactNum" value="${list.contactNum}"> 삭제 </button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <tr>
                <td colspan=4 align=center>
                    <c:if test="${pagevo.prev}">
                    <a href="ContactUS?page=${pagevo.startPage-1}"> [이전 페이지] </a>
                    </c:if>
                    <c:forEach begin="${pagevo.startPage}"
                    end="${pagevo.endPage}" var="idx">
                        <a href="ContactUs?page=${idx}">${idx}</a>
                    </c:forEach>
                    <c:if test="${pagevo.next}">
                        <a href="ContactUS?page=${pagevo.startPage-1}"> [다음 페이지] </a>
                    </c:if>
                </td>
            </tr>
            <div id="table_menu">
                <a href="addWrite"> 게시글 등록하기
                    <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor"
                         class="bi bi-file-plus" viewBox="0 0 16 16">
                        <path d="M8.5 6a.5.5 0 0 0-1 0v1.5H6a.5.5 0 0 0 0 1h1.5V10a.5.5 0 0 0 1 0V8.5H10a.5.5 0 0 0 0-1H8.5V6z"/>
                        <path d="M2 2a2 2 0 0 1 2-2h8a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V2zm10-1H4a1 1 0 0 0-1 1v12a1 1 0 0 0 1 1h8a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1z"/>
                    </svg>
                </a>
            </div>
        </div>
    </section>
</article>
</body>
</html>

