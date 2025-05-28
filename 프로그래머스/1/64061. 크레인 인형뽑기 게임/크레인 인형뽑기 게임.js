function solution(b, m) {
            let answer = 0;
            let stack = [0];
            let n = 0;
            for (let i of m) {
                n = 0;
                while (n < b.length) {
                    if (b[n][i-1] > 0) {
                        stack.push(b[n][i-1]);
                        b[n][i-1] = 0;
                        if (stack[stack.length-1] === stack[stack.length-2]) {
                            stack.pop();
                            stack.pop();
                            answer += 2;
                        } //if
                        break;
                    } //if
                    n++;
                }
            } //for


            return answer;
        } //solution