function solution(quiz) {
    let ans = [];
    
    quiz.forEach((item) => {
        let oneQuiz = item.split(" ");
        
        let X = Number(oneQuiz[0]);
        let Y = Number(oneQuiz[2]);
        
        let calc = 0;
        
        if(oneQuiz[1] === "+"){
            calc = X + Y;
        }
        
        if(oneQuiz[1] === "-"){
            calc = X - Y;
        }
        
        const result = Number(oneQuiz[4]);
        
        if(calc === result){
            ans.push("O");
        }
        
        if(calc !== result){
            ans.push("X");
        }
    })
    
    return ans;
}