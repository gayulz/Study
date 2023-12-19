let itemInfoText, itemCnt, itemPrice, itemDlv, cartList, allcheck, isChkBox;

// 주문하기 버튼 클릭시 히든속성 삭제 및 히든ID 삭제
function addRow() {
  cartTableBody = document.querySelector("#cart__list");
  getItems();
  cart__list.removeAttribute("hidden");
  if (document.querySelector("#hidden") != null) {
    hidden.remove();
  }
  console.log(`${itemInfoText} ${itemCnt} ${itemPrice} ${itemDlv}`);
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
        isChkBox[i].parentNode.nextSibling.nextSibling.nextElementSibling
          .textContent;
      itemDivPay =
        isChkBox[i].parentNode.nextSibling.nextSibling.nextSibling
          .nextElementSibling.textContent;
      // 체크된 요소 더하기
      itemBucketTotal += parseFloat(itemPay) + parseFloat(itemDivPay);
      console.log(itemBucketTotal);
    }
  }
  return itemBucketTotal;
}

// 장바구니에 데이터 추가
function addRowItems() {
  const newRow = cartTableBody.insertRow();
//   let price = String()
  newRow.setAttribute('name', `${itemPrice}`)
  const newCell0 = newRow.insertCell(0);
  const newCell1 = newRow.insertCell(1);
  const newCell2 = newRow.insertCell(2);
  const newCell3 = newRow.insertCell(3);
  const newCell4 = newRow.insertCell(4);
  newCell0.innerHTML =
    '<input type="checkbox" id="boxs" onchange="editPrice()" checked>';
  newCell1.innerText = itemInfoText;
  // oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"
  newCell2.innerHTML = `<input type="number" id="goodsCnt" min="1" value="${itemCnt}" 
                            oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" 
                            onkeypress="changeCnt()" style="width: 40px;">개`;
  newCell3.innerHTML = `${itemPrice * itemCnt}`;
  newCell4.innerHTML = `${itemDlv}`;
}

// 추가된 장바구니 목록 중 수량 변경이 발생시 진행 
function changeCnt(){
    
}

// 모든 요소 가져오기
function getItems() {
  itemInfoText = document.querySelector("#goodsInfo").value;
  itemCnt = document.querySelector("#goodsCnt").value;
  itemPrice = document.querySelector("#goodsPrice").value;
  itemDlv = document.querySelector("#goodsDlv").value;
}
