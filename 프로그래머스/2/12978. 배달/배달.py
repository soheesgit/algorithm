# DP 처럼 전부 걸리는 거리를 계산해놓아야한다.

def solution(N, road, K):
    answer = 0

    dp = [float('inf')] * (N + 1)
    dp[1] = 0
    
    for _ in range(N - 1):
        for nodeA, nodeB, length in road:
            dp[nodeB] = min(dp[nodeB], dp[nodeA]+length)
            dp[nodeA] = min(dp[nodeA], dp[nodeB]+length)
    
    for i in range(1, N + 1):
        if dp[i] <= K:
            answer+=1
    return answer