import axios from 'axios'

function fetchAsync(){
    const result = axios.get("https://koreanjson.conm/posts/1")
    console.log(`비동기식 방식 : ${result}`) // Promise {<pending>}
}

fetchAsync()
/* 함수 중복 선언 문제를 피해야한다 , 화살표로 변경한다 
async function fetchSync(){
    let rs = await axios.get("https://koreanjson.conm/posts/1")
    console.log("동기 방식 : ", rs) // 재대로된 결과가 나온다 { title : "...", content : ... }
    console.log("제목 : ", rs.data.title ) //
}
*/

// 함수의 시작 부분에 async를 작성한다 
const fetchSync = async () => {
    let rs = await axios.get("https://koreanjson.conm/posts/1")
    console.log("동기 방식 : ", rs) // 재대로된 결과가 나온다 { title : "...", content : ... }
    console.log("제목 : ", rs.data.title ) //
}
fetchSync()