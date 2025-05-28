def solution(babbling):
    answer = 0
    p = ["aya", "ye", "woo", "ma"]
    for talk in babbling:
        length = 0
        for i in range(len(p)):
            if not talk.find(p[i]) == -1:
                length += len(p[i])
        if len(talk) == length and length != 0:
            answer += 1
            
    return answer