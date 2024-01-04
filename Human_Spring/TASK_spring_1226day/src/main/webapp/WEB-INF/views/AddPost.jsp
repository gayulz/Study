<%--
  Created by IntelliJ IDEA.
  User: yuuri
  Date: 12/26/23
  Time: 5:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
    <style>
        body,
        button {
            display: block;
            width: 600px;
            text-align: center;
            margin: 10px;
        }

        input {
            width: 80%;
            height: 50px;
            font-size: 20px;
            text-align: center;
            margin: 10px;
        }

        button {
            height: 50px;
        }

        div {
            display: block;
        }

        textarea{
            width: 90%;
        }
    </style>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
            integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.min.js"
            integrity="sha384-Rx+T1VzGupg4BHQYs2gCW9It+akI2MM/mndMCy36UVfodzcJcF0GGLxZIzObiEfa"
            crossorigin="anonymous"></script>

    <script>
        function validateForm() {
            var writer = document.querySelector('#isName').value;
            var title = document.querySelector('#isTitle').value;
            var comment = document.querySelector('#isComment').value;

            if (writer === "" || title === "" || comment === "") {
                alert("모든 필드를 채워주세요.");
                return false;
            }
            return true;
        }
    </script>
</head>

<body>
<h1> 문의글 남기기 </h1>
<form class="addComm" action="addCommit" method="post">
    <div>
        작성자
        <input type="text" name="contactWriter" id="isName" placeholder="작성자 이름을 적어주세요">
    </div>
    <div>
        제목&nbsp;&nbsp;&nbsp;
        <input type="text" name="contactTitle" id="isTitle" placeholder="제목을 입력하세요">
    </div>
    <div>
        <div class="mb-3">
            <label for="exampleFormControlTextarea1" class="form-label"></label>
            <textarea class="form-control" id="isComment" name="contactComment" id="exampleFormControlTextarea1"
                      rows="10" placeholder="내용을 적어주세요"></textarea>
        </div>
        <button onsubmit="return validateForm()"> 저장 </button>
    </div>
</form>
</body>

</html>


