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

        form, #emailSendCheckLine {
            width: 100%;
            display: inline-block;
            font-size: 20px;
            justify-content: center;
            padding: 0;
            margin: 0;
        }

        .inputs {
            width: 400px;
            margin-left: 30px;
        }

        button, #checkBtn {
            width: 150px;
            font-weight: bold;
        }

        .phoneNumber {
            width: 20%;
        }

        #hospital {
            width: 50%;
        }
    </style>
</head>
<body>
<%@ include file="/WEB-INF/views/include/header.jsp" %>
<section>
    <div class="shadow p-3 mb-5 bg-body-tertiary rounded" style="width: 40%; height: 750px;">
        <p class="fs-1"> 회원가입 </p>
        <div class="mb-3">
            <label class="form-label">이름</label>
            <div>
                <input type="text" class="form-control" placeholder="성함 입력" name="staffName" id="staffName">
            </div>
            <label class="form-label">Email</label>
            <form id="emailSend" action="javascript:void(0);" method="post" style="display:flex; width: 100%; ">
                <input type="email" class="form-control" id="staffEmail" style=" width: 60%;"
                       placeholder="name@example.com" name="staffEmail">
                <button type="submit" class="btn btn-secondary" style="width: 30%; margin-left: 5px;">
                    인증번호 발송
                </button>
            </form>
            <div style="display:flex; width: 100%; padding: 0; margin-top: 5px;" id="emailSendCheckLine">
                <input type="text" class="form-control" placeholder="인증번호 입력" style="width:60%;" id="inputNumber">
                <button type="button" class="btn btn-secondary" style=" width: 30%; margin-left: 5px;"
                        onclick="isEmailSendNumber()" id="checkBtn">
                    인증 확인
                </button>
            </div>
            <label class="form-label">Password</label>
            <form id="userSend" action="javascript:void(0);" method="post">
                <div>
                    <input type="password" class="form-control" aria-describedby="passwordHelpBlock"
                           placeholder="영문5자리이상 / ` , & , $ , % 사용불가" id="staffPass">
                </div>
                <label class="form-label">연락처</label>
                <div>
                    <input type="text" class="phoneNumber" id="phoneNumber1" style="width: 10%;"/> - <input type="text"
                                                                                                            class="phoneNumber"
                                                                                                            id="phoneNumber2"
                                                                                                            style="width: 20%;"/>
                    - <input type="text" id="phoneNumber3" style="width: 20%;">
                </div>
                <hr>
                <div>
                    <c:if test="${type==1}">
                        <label class="form-label">소속 단체명</label>
                        <!-- select box로 DB에 저장된 소속단체 가져오기 -->
                        <select id="prmName">
                            <c:forEach items="${prmList}" var="list">
                                <option value="${list.prmNumber}"> ${list.prmName}</option>
                            </c:forEach>
                        </select>
                        <input type="hidden" id="userType" value="${type}"/>
                    </c:if>
                </div>
                <div>
                    <c:if test="${type==2}">
                        <div>
                            <label class="form-label">근무 지역</label>
                            <select id="city">
                                <option> 지역 선택</option>
                                <option value="서울특별시">서울특별시</option>
                                <option value="인천광역시">인천광역시</option>
                                <option value="고양시">고양시</option>
                                <option value="광명시">광명시</option>
                                <option value="광주시">광주시</option>
                                <option value="구리시">구리시</option>
                                <option value="군포시">군포시</option>
                                <option value="김포시">김포시</option>
                                <option value="남양주시">남양주시</option>
                                <option value="동두천시">동두천시</option>
                                <option value="부천시">부천시</option>
                                <option value="성남시">성남시</option>
                                <option value="수원시">수원시</option>
                                <option value="시흥시">시흥시</option>
                                <option value="안산시">안산시</option>
                                <option value="안성시">안성시</option>
                                <option value="안양시">안양시</option>
                                <option value="오산시">오산시</option>
                                <option value="용인시">용인시</option>
                                <option value="의왕시">의왕시</option>
                                <option value="의정부시">의정부시</option>
                                <option value="이천시">이천시</option>
                                <option value="파주시">파주시</option>
                                <option value="평택시">평택시</option>
                                <option value="포천시">포천시</option>
                                <option value="하남시">하남시</option>
                                <option value="화성시">화성시</option>
                            </select>
                        </div>
                        <div>
                            <label class="form-label">근무 병원</label>
                            <select id="dutyNameList">
                                <option value=""> 병원 선택</option>
                            </select>
                        </div>
                        <input type="hidden" id="userType" value="${type}"/>
                        <div id="hpidHidden" style="display: none"> </div>
                    </c:if>
                </div>
                <button type="submit" class="btn btn-info" style="width: 70%;">회원가입</button>
            </form>
        </div>
    </div>
</section>
<%@ include file="/WEB-INF/views/include/footer.jsp" %>
<script>
    function goToInfo() {
        location.href = "<%=request.getContextPath()%>/"
    }
</script>
<script src="<%=request.getContextPath()%>/resources/javascript/hospitalDataAPI.js"></script>
<script src="<%=request.getContextPath()%>/resources/javascript/emailCheckProcess.js"></script>
<script src="<%=request.getContextPath()%>/resources/javascript/singup.js"></script>
</body>
</html>