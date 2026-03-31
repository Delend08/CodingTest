function solution(video_len, pos, op_start, op_end, commands) {
    var answer = '';
    let video_len_second = Number(video_len.slice(0,2)) * 60
    +Number(video_len.slice(3,5));
    let pos_second = Number(pos.slice(0,2)) * 60
    +Number(pos.slice(3,5));
    let op_start_second = Number(op_start.slice(0,2)) * 60
    +Number(op_start.slice(3,5));
    let op_end_second = Number(op_end.slice(0,2)) * 60
    +Number(op_end.slice(3,5));
    
    const autoEnding = () => {
        if (pos_second >= op_start_second && pos_second <= op_end_second)  {
            pos_second = op_end_second;
        }
    }
    
    
    autoEnding()
    commands.forEach(command => {
        
        if(command === "next") {
            pos_second += 10
            if(pos_second > video_len_second) pos_second = video_len_second
            
        } else if (command === "prev") {
            pos_second -= 10
            if(pos_second < 0) pos_second = 0
        }
        autoEnding()
        
    })
    
    answer += String(parseInt(pos_second / 60)).padStart(2,"0")+":"
    +String(pos_second%60).padStart(2,"0");
    
    return answer;
}