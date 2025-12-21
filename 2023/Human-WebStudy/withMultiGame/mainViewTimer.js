    let limitTime = 10;
    let dateCnt = 1;

    function timerButton(){
        let timerInterval = setInterval(function() {
            limitTime--;
            document.getElementById('currentTime').textContent = limitTime;
            if(limitTime === -1){
            clearInterval(timerInterval)
            alert('end timer')
            limitTime = 10;
            document.getElementById('currentTime').textContent = limitTime;
            dateCnt++;
            document.getElementById('gameDate').textContent = dateCnt;
            }
        } , 1000);
    } 