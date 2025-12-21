let itemInfoText, itemCnt, itemPrice, itemDlv, cartList, allcheck, isChkBox;

// 주문하기 버튼 클릭시 히든속성 삭제 및 히든ID 삭제
function addRow() {
  cartTableBody = document.querySelector("#cart__list");
  getItems();
  cart__list.removeAttribute("hidden");
  if (document.querySelector("#hidden") != null) {
        hidden.setAttribute("hidden", "true");
  }
  addRowItems();
  editPrice();
}
// 전체선택 메서드 실행시 allChk1
function allChk1() {
  allcheck = document.querySelector("#allChk");
  isChkBox = document.querySelectorAll("#boxs");
  let changeValue = allcheck.checked ? true : false;
  for (let i = 0; i < isChkBox.length; i++) {
    isChkBox[i].checked = changeValue;
  }
  editPrice();
}

// 장바구니 추가시 토탈금액란 변경
function editPrice() {
  let totalPrice = document.querySelector(".cart__list tfoot tr");
  let innerTotal = chkBoxsTotalPrice();
  totalPrice.childNodes[7].innerText = `${innerTotal}`;
}

// 체크가 표시된 상품 가격만 계산하여 가격리턴
function chkBoxsTotalPrice() {
  // 체크박스를 모두 배열로 가져옴
  isChkBox = document.querySelectorAll("#boxs");
  // 변수선언
  let itemPay, itemDivPay;
  let itemBucketTotal = 0;
  // 해당 부모의 요소를 모두 긁어옴
  for (let i = 0; i < isChkBox.length; i++) {
    if (isChkBox[i].checked) {
      itemPay =
        isChkBox[i].parentNode.nextSibling.nextSibling.nextElementSibling.textContent;
      itemDivPay =
        isChkBox[i].parentNode.nextSibling.nextSibling.nextSibling.nextElementSibling.textContent;
      // 체크된 요소 더하기
      itemBucketTotal += parseFloat(itemPay) + parseFloat(itemDivPay);
    }
  }
  return itemBucketTotal;
}

// 장바구니에 데이터 추가
function addRowItems() {
  let newRow = cartTableBody.insertRow();
  let newCell0 = newRow.insertCell(0);
  let newCell1 = newRow.insertCell(1);
  let newCell2 = newRow.insertCell(2);
  let newCell3 = newRow.insertCell(3);
  let newCell4 = newRow.insertCell(4);
  newCell0.innerHTML = `<input type="checkbox" id="boxs" onchange="editPrice()" checked>`;
  newCell1.innerText = itemInfoText;
  newCell2.innerHTML = `<input type="number" class="quantity-input" min="1" value="${itemCnt}" name=${itemPrice}
                            oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" 
                            onClick="updateItemTotal()" style="width: 40px;">개`;
  newCell3.innerHTML = `${itemPrice * itemCnt}`;
  newCell4.innerHTML = `${itemDlv}`;
}

// 모든 요소 가져오기
function getItems() {
  itemInfoText = document.querySelector("#goodsInfo").value;
  itemCnt = document.querySelector("#goodsCnt").value;
  itemPrice = document.querySelector("#goodsPrice").value;
  itemDlv = document.querySelector("#goodsDlv").value;
}

// 각 행의 수량 변경을 감지하고 금액을 업데이트하는 함수
function updateItemTotal() {
  // 'quantity-input' 클래스를 가진 요소에 대한 참조를 가져옵니다.
  let quantityInputs = document.querySelectorAll(".quantity-input");
  quantityInputs.forEach((input) => {
    input.removeEventListener("change", quantityChangeHandler);
    input.addEventListener("change", quantityChangeHandler);
  });
}

function quantityChangeHandler(event) {
  let newQuantity = event.target.value;
  let itemPrice = parseFloat(event.target.getAttribute("name"));
  let totalPrice = newQuantity * itemPrice;
  // 해당 행의 3번째 열(총 금액을 표시할 열)을 찾아 업데이트합니다.
  let totalCell = event.target.parentElement.nextElementSibling;
  totalCell.innerHTML = totalPrice;
  editPrice()
}

function delRow(){
    isChkBox = document.querySelectorAll("#boxs");
    for (let i = 0; i < isChkBox.length; i++) {
        if (isChkBox[i].checked) {
            isChkBox[i].parentElement.parentElement.remove()
        }
    }
    editPrice()
    showHiddens()
}

function showHiddens(){
    cartTableBody = document.querySelector("#cart__list");
    if(cartTableBody.childElementCount <= 0){
        let showText = document.querySelector('#hidden')
        showText.removeAttribute('hidden')
    }

}
// 페이지 로드 시 함수를 호출하여 초기화합니다.
document.addEventListener("DOMContentLoaded", updateItemTotal);