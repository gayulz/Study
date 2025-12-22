<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--<%@ page session="false" %>--%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <style>
        section {
            margin: 10px 10px 10px 10px;
            width: 99%;
            display: flex;
            flex-direction: column;
            justify-items: center;
            align-items: center;
        }

        button {
            width: 150px;
            border: none;
            font-weight: bold;
        }

    </style>
</head>
<body>
<%@ include file="/WEB-INF/views/include/header.jsp" %>
<section>
        <div style="margin:0; padding:0; width: 100%; height: 800px; display: flex; flex-direction: column; align-items: center;">
            <div style="width:100%; height: 50px;"></div>
            <div class="shadow p-3 mb-5 bg-body-tertiary rounded" style="width: 50%; height: 750px;">
                <p class="fs-1">⚙️ 내 정보 수정 </p>
                <div class="mb-3">
                    <c:set var="vo" value="${vo}" scope="request"/>
                    <form action="/editStaffInfo" method="POST" id="editStaffForm">
                    <fieldset disabled>
                        <label class="form-label">이름</label>
                        <div>
                            <input type="text" class="form-control" placeholder="${vo.staffName}" readonly>
                        </div>
                        <label class="form-label">Email</label>
                        <div>
                            <input type="email" class="form-control" value="${vo.staffEmail}" id="staffEmail" placeholder="${vo.staffEmail}" readonly>
                        </div>
                    </fieldset>
                    <label for="inputPassword5" class="form-label">Password</label>
                    <div>
                        <input type="password" id="inputPassword5" class="form-control" name="staffPass"
                               aria-describedby="passwordHelpBlock" placeholder="영문5자리이상 / ` , & , $ , % 사용불가">
                    </div>
                    <label for="inputPassword5" class="form-label">연락처</label>
                    <div>
                        <input type="text" id="phoneNumber1" style="width: 10%;"/> - <input
                            type="text"  id="phoneNumber2" style="width: 20%;"/> - <input
                            type="text" id="phoneNumber3" style="width: 20%;">
                    </div>
                        <button type="submit" class="btn btn-primary"  style="width: 100%; margin-top: 10px"> 수정 완료</button>
                    </form>
                </div>
            </div>
        </div>
</section>
<%@ include file="/WEB-INF/views/include/footer.jsp" %>
<script>
    function goToInfo() {
        location.href = "<%=request.getContextPath()%>/navMenu1Page"
    }
</script>
<script src="<%=request.getContextPath()%>/resources/javascript/hospitalDataAPI.js"></script>
<script src="<%=request.getContextPath()%>/resources/javascript/emailCheckProcess.js"></script>
<script src="<%=request.getContextPath()%>/resources/javascript/singup.js"></script>
<script src="<%=request.getContextPath()%>/resources/javascript/editStaff.js"></script>
</body>
</html>