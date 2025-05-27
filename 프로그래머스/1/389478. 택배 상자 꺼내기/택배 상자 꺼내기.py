def solution(n, w, num):
    answer = 1
    Line = 1
    Max_Line = n // w
    if n % w > 0:
        Max_Line += 1
    Location = num;
    while Location - w > 0:
        Location -= w
        Line += 1
    if Line % 2 == 0:
        Location = w - Location + 1
    while Line < Max_Line:
        if Line % 2 == 0:
            num += Location*2-1
            if num <= n:
                answer += 1
        else:
            num += (w-Location)*2+1
            if num <= n:
                answer += 1
        Line += 1
    return answer