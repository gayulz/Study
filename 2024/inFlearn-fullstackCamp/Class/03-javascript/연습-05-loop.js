

for(let i = 0; i < 3; i++){
    console.log("안녕")
}
let persons = [
    {name : "영희", age : 17},
    {name : "철수", age : 22}, 
    {name : "도우너", age : 5}, 
    {name : "도비", age : 65}, 
    {name : "그루투", age : 3}, 
]

for(let count = 0; count < persons.length; count++){
    if(persons[count].age >= 19){
        console.log(persons[count].name + "님은 성인이다")
    } else {
        console.log(persons[count].name + "님은 미성년자이다")
    }
}

const fruits = [
    { number: 1, title : "레드향"},
    { number: 2, title : "샤인머스켓"},
    { number: 3, title : "산청딸기"},
    { number: 4, title : "한라봉"},
    { number: 5, title : "사과"},
    { number: 6, title : "애플망고"},
    { number: 7, title : "딸기"},
    { number: 8, title : "천혜향"},
    { number: 9, title : "귤"},
    { number: 10, title : "과일종합선물세트"}
]


for (let index = 0; index < fruits.length; index++) {
    console.log(fruits[index].number +" "+ fruits[index].title)
}


for (let index = 0; index < fruits.length; index++) {
    console.log(`${fruits[index].number} ${ fruits[index].title}`)
}

for (let index = 0; index < fruits.length; index++) {
    console.log(`과일 차트 ${fruits[index].number}위는 ${ fruits[index].title}입니다`)
}

