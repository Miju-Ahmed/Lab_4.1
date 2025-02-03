from collections import deque

def bfs_maze(maze,start,goal):
    rows,cols = len(maze),len(maze[0])

    queue = deque([(start,[start])])
    visited = set()
    visited.add(start)

    while queue:
        (current, path) = queue.popleft()
        if current == goal:
            return path
        
        for direction in [(-1,0),(1,0),(0,-1),(0,1)]:
            neighbor = (current[0] + direction[0], current[1]+direction[1])
            if(0<=neighbor[0]<rows and 0<=neighbor[1]<cols and maze[neighbor[0]][neighbor[1]]!='#' and neighbor not in visited):
                visited.add(neighbor)
                queue.append((neighbor, path+[neighbor]))
    return None

maze = [
    ['S', '.', '.', '#', '.'],
    ['#', '.', '#', '.', '.'],
    ['#', '.', '.', '.', '#'],
    ['#', '#', '#', '.', 'G']
]
start = (0,0)
goal = (3,4)

path = bfs_maze(maze,start,goal)
print("Path: ", path)