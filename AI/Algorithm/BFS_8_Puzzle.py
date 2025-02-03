from collections import deque

GOAL_STATE = GOAL_STATE = ((1, 2, 3), (4, 5, 6), (7, 8, 0))

def find_empty_path(state):
    for i in range(3):
        for j in range(3):
            if state[i][j]==0:
                return (i,j)
    return None

def generate_moves(state):
    moves = []
    empty_i, empty_j = find_empty_path(state)
    directions = [(-1,0),(1,0),(0,-1),(0,1)]
    for di, dj in directions:
        new_i,new_j = empty_i+di,empty_j+dj
        if 0<=new_i<3 and 0<=new_j<3:
            new_state = [list(row) for row in state]
            new_state[empty_i][empty_j], new_state[new_i][new_j] = new_state[new_i][new_j],new_state[empty_i][empty_j]
            moves.append(tuple(map(tuple,new_state)))
        return moves
    

def solve_8_puzzle(initial_state):
    queue = deque([(initial_state, [])])
    visited = set()
    visited.add(initial_state)

    while queue:
        current_state, path = queue.popleft()
        if current_state == GOAL_STATE :
            return path
        for next_state in generate_moves(current_state):
            if next_state not in visited:
                visited.add(next_state)
                queue.append((next_state,path+[next_state]))
    return None

initial_state = (
    (1, 2, 3),
    (4, 0, 6),
    (7, 5, 8)
)

solution_path = solve_8_puzzle(initial_state)

if solution_path:
    print("Solution found! Number of moves: ", len(solution_path))
    for step in solution_path:
        print(step)
else:
    print("No solution exists.")