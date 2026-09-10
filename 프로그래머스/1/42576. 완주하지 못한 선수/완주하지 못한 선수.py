def solution(participant, completion):
    participant.sort()
    completion.sort()
    
    for i in range (len(completion)):
        if participant[i] != completion[i]:
            return participant[i]
        
    return participant[-1]
# 그러면 어떻게하지? 음... 하나가 있으면 제거는 안되잖아. 전부 sort한다음에 for문으로 돌면서 같지않은거면 출력?

# def solution(participant, completion):
#    for human in completion:
#        participant.remove(human)
#    
#    return participant[0]