def solution(enroll, referral, seller, amount):
    n = len(enroll)

    # 1) 이름 ↔︎ 인덱스
    idx = {name: i for i, name in enumerate(enroll)}

    # 2) 부모 테이블 (센터 = -1)
    parent = [-1] * n
    for i, r in enumerate(referral):
        if r != '-':
            parent[i] = idx[r]

    # 3) 이익 배열
    profit = [0] * n

    # 4) 판매 처리
    for s, a in zip(seller, amount):
        cur = idx[s]
        money = a * 100              # 원 단위
        while cur != -1 and money > 0:
            commission = money // 10         # 부모 몫(내림)
            profit[cur] += money - commission # 본인 몫
            money = commission                # 위로 전파
            cur = parent[cur]                 # 한 단계 위로

    return profit