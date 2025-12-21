let selectContainer1 = document.querySelector("#selectContainer1");
let selectContainer2 = document.querySelector("#selectContainer2");
let overlay1 = document.querySelector("#overlay1");
let overlay2 = document.querySelector("#overlay2");

// 마우스 오버 되었을때 
selectContainer1.addEventListener('mousemove', function(e){
    let x = e.offsetX
    let y = e.offsetY
    let rotateY = -1/5 * x + 20
    let rotateX = 4/30 * y - 20
    overlay1.style=`background-position : ${x/5 + y/5}%`
    selectContainer1.style = `transform : perspective(350px) rotateX(${rotateX}deg)rotateY(${rotateY}deg)` 
});  
// 마우스 아웃 되었을때 
selectContainer1.addEventListener('mouseout', function(e){
    overlay1.style = 'filter : opacity(0%)'
    selectContainer1.style = 'transform : perspective(350px) rotateX(0deg)rotateY(0deg)'
});
// 클릭 되었을 때
function startCardGame(){
    location.href = "./cardGame/cardGame.html";
}

// 마우스 오버 되었을때 
selectContainer2.addEventListener('mousemove', function(e){
    let x = e.offsetX
    let y = e.offsetY
    let rotateY = -1/5 * x + 20
    let rotateX = 4/30 * y - 20
    overlay2.style=`background-position : ${x/5 + y/5}%`
    selectContainer2.style = `transform : perspective(350px) rotateX(${rotateX}deg)rotateY(${rotateY}deg)` 
});  
// 마우스 아웃 되었을때 
selectContainer2.addEventListener('mouseout', function(e){
    overlay2.style = 'filter : opacity(0%)'
    selectContainer2.style = 'transform : perspective(350px) rotateX(0deg)rotateY(0deg)'
});
// 클릭 되었을때
function startDefenseGame(){
    location.href = "./yejongGame/mainPlay.html";
}