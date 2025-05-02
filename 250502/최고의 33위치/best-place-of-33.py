n = int(input())
grid = [list(map(int, input().split())) for _ in range(n)]

maxCnt = 0
for i in range(n-2):
    for j in range(n-2):
        tmp = 0;
        for k in range(3):
            for l in range(3):
                tmp+=grid[i+k][j+l]
        
        if maxCnt < tmp:
            maxCnt = tmp

print(maxCnt)