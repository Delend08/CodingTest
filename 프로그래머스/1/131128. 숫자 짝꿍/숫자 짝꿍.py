def solution(X, Y):
    answer = ''
    L = []
    flag = True
    D = {"0":0, "1":0, "2":0, "3":0, "4":0, "5":0, "6":0, "7":0, "8":0, "9":0}
    for x in X:
        D[x] += 1
    for y in Y:
        if D[y] > 0:
            D[y] -= 1
            L.append(y)
            if y != '0':
                flag = False
    
    
    L.sort(reverse=True)
    for i in L:
        answer += i
    if answer == '':
        answer = '-1'
        flag = False
    if flag:
        return '0'
    return answer