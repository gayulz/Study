<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
    <link rel="stylesheet" href="helpdesk.css">
    <style>
        ul {
            display: flex;
            flex-direction: row;
            justify-content: space-around;
        }

        section {
            margin: 10px 10px 10px 10px;
            width: 99%;
            display: flex;
            flex-direction: column;
            justify-items: center;
            align-items: center;
        }


    </style>
</head>
<body>
<%@ include file="/WEB-INF/views/include/header.jsp" %>
<section>
    <div style="margin:0; padding:0; width: 100%; height: 800px; display: flex; flex-direction: column; align-items: center;">
        <div style="width:100%; height: 50px;"></div>
        <div class="text-center">
            <p class="fs-3"> 병원 접수 내역 </p>
        </div>
        <div style="width: 70%;">
            <table class="table">
                <thead class="table-light">
                <tr style="text-align: center">
                    <th scope="col"> 접수 날짜</th>
                    <th scope="col"> 접수번호</th>
                    <th scope="col"> KTAS level</th>
                    <th scope="col"> 추정 원인</th>
                    <th scope="col"> 접수 병원</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${list}" var="list">
                    <tr style="text-align: center;">
                        <td style="text-align: center"><a href="chartdetail?ptntNumber=${list.ptntNumber}" class="text-decoration-none"/>${list.ptntDate}</td>
                        <td style="text-align: center"><a href="chartdetail?ptntNumber=${list.ptntNumber}" class="text-decoration-none"/>${list.ptntNumber}</td>
                        <td style="text-align: center"><a href="chartdetail?ptntNumber=${list.ptntNumber}" class="text-decoration-none"/>${list.KTASlevel}</td>
                        <td style="text-align: center"><a href="chartdetail?ptntNumber=${list.ptntNumber}" class="text-decoration-none"/>${list.ptntCause}</td>
                        <td style="text-align: center"><a href="chartdetail?ptntNumber=${list.ptntNumber}" class="text-decoration-none"/>${list.hpid}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <nav aria-label="Page navigation example">
                <ul class="pagination" style="width: 30%">
                    <li class="page-item">
                        <a class="link-success" href="#" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <li class="page-item"><a class="link-success" href="#">1</a></li>
                    <li class="page-item"><a class="link-success" href="#">2</a></li>
                    <li class="page-item"><a class="link-success" href="#">3</a></li>
                    <li class="page-item">
                        <a class="link-success" href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</section>
<%@ include file="/WEB-INF/views/include/footer.jsp" %>
</body>
</html>
