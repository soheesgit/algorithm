def solution(numbers, target):
    
    answer = 0
    arr = [0] # 만들어진 모든 계산 결과를 저장하는 리스트
    
    for num in numbers:
        # 새롭게 만들어지는 리스트 저장
        tmp = []
        
        for parent in arr:
            tmp.append(parent + num)
            tmp.append(parent - num)
        arr = tmp
        
    # 최종 리스트에서 결과랑 같은 갯수만 계산
    for leaf in arr:
        if leaf == target:
            answer += 1
    return answer