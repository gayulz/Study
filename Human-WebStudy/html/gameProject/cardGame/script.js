const cards = document.querySelectorAll(".card");

let hasFlippedCard = false;
let lockBoard = false;
let firstCard, secondCard;

function flipCard() {
  if (lockBoard) return;

  if (this === firstCard) return;

  this.classList.add("flip");
  if (!hasFlippedCard) {
    hasFlippedCard = true;
    firstCard = this;
    return;
  }

  hasFlippedCard = false;
  secondCard = this;
  checkForMatch();
}

function checkForMatch() {
  let isMatch = firstCard.dataset.name === secondCard.dataset.name;

  isMatch ? disableCards() : unflipCards();
}

function disableCards() {
  firstCard.removeEventListener("click", flipCard);
  secondCard.removeEventListener("click", flipCard);

  resetBoard();
}

function unflipCards() {
  lockBoard = true;
  setTimeout(() => {
    firstCard.classList.remove("flip");
    secondCard.classList.remove("flip");
    lockBoard = false;
  }, 1200);
}

function resetBoard() {
  [hasFlippedCard, lockBoard] = [false, false];
  [firstCard, secondCard] = [null, null];
}

function shuffleArray(arr) {
  arr.forEach((_, idx) => {
    const randomIdx = Math.floor(Math.random() * arr.length);
    [arr[randomIdx], arr[idx]] = [arr[idx], arr[randomIdx]];
  });
}

const orderList = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];

(function shuffle() {
  shuffleArray(orderList);
  cards.forEach((card, idx) => {
    card.style.order = orderList[idx];
  });
})();

cards.forEach((card) => card.addEventListener("click", flipCard));


// function startAnimation() {
//   const rows = 3; // 그리드의 행 수
//   const cols = 6; // 그리드의 열 수
//   let index = 0;

//   for (let row = 0; row < rows; row++) {
//     for (let col = 0; col < cols; col++) {
//       // 현재 카드를 찾습니다.
//       if (card) {
//         // 애니메이션을 적용합니다.
//         setTimeout(() => {
//           card.classList.add('flip');
//           setTimeout(() => {
//             card.classList.remove('flip');
//           }, 500); // 카드가 뒤집힌 상태로 있을 시간
//         }, 150 * index); // 각 카드 사이의 지연 시간
//       }
//       index++;
//     }
//   }
  
// }

// // 게임 시작 시 애니메이션 시작
// startAnimation();
document.addEventListener('DOMContentLoaded', () => {
  const cards = document.querySelectorAll('.card');
  // 카드가 뒤집히기 시작할 때까지의 간격 
  const interval = 150; 
  // 카드가 뒤집힌 상태로 있을 시간 
  const flipDuration = 500; 

  cards.forEach((card, index) => {
    // 각 카드에 대해 지연 시간을 설정합니다.
    const delay = index * interval;

    // 카드를 뒤집습니다.
    setTimeout(() => {
      card.classList.add('flip');
      // 카드를 다시 클로징 상태로 되돌립니다.
      setTimeout(() => {
        card.classList.remove('flip');
      }, flipDuration);
    }, delay);
  });
});


