def solution(todo_list, finished):
    answer = []
    for checked in finished:
        todo = todo_list.pop(0)
        if not checked:
            answer.append(todo)
            
    return answer