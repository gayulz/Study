$(document).ready(function() {
    // 주문하기 버튼 클릭 시 실행
    $("#orderButton").on("click", function() {
        $("#cart__list").show();
        $("#hidden").hide();
        addRowItems();
        editPrice();
    });

    // 전체 선택 체크박스 이벤트
    $("#allChk").on("change", function() {
        $(".checkbox-item").prop("checked", this.checked);
        editPrice();
    });

    // 수량 변경 시 총 금액 업데이트
    $(document).on("change", ".quantity-input", function() {
        let newQuantity = $(this).val();
        let itemPrice = parseFloat($(this).attr("name"));
        let totalPrice = newQuantity * itemPrice;
        $(this).closest("td").next().text(totalPrice.toFixed(2));
        editPrice();
    });

    // 장바구니 항목 삭제
    $("#deleteButton").on("click", function() {
        $(".checkbox-item:checked").closest("tr").remove();
        editPrice();
        showHiddens();
    });

    function addRowItems() {
        // 상품 정보 가져오기
        let itemInfoText = $("#goodsInfo").val();
        let itemCnt = $("#goodsCnt").val();
        let itemPrice = $("#goodsPrice").val();
        let itemDlv = $("#goodsDlv").val();

        // 테이블에 행 추가
        let newRow = $("<tr></tr>");
        newRow.append(`<td><input type="checkbox" class="checkbox-item" checked></td>`);
        newRow.append(`<td>${itemInfoText}</td>`);
        newRow.append(`<td><input type="number" class="quantity-input" min="1" value="${itemCnt}" name="${itemPrice}" style="width: 40px;">개</td>`);
        newRow.append(`<td>${(itemPrice * itemCnt).toFixed(2)}</td>`);
        newRow.append(`<td>${itemDlv}</td>`);

        $("#cart__list").append(newRow);
    }
        // 금액 변경
    function editPrice() {
        let total = 0;
        $(".checkbox-item:checked").each(function() {
            let price = $(this).closest("tr").find("td:eq(3)").text();
            total += parseFloat(price);
        });
        $(".cart__list tfoot tr").find("td:eq(3)").text(total.toFixed(2));
    }
        // 히든속성 컨트롤 
    function showHiddens() {
        if ($("#cart__list tr").length === 0) {
            $("#hidden").show();
        }
    }
});
