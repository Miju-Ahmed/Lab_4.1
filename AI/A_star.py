import heapq

class PuzzleNode:
    def __init__(self, state, parent=None, move=None, cost=0, heuristic=0):
        self.state = state
        self.parent = parent
        self.move = move
        self.cost = cost  # g(n) -> Steps taken
        self.heuristic = heuristic  # h(n) -> Heuristic estimate
    
    def __lt__(self, other):
        return (self.cost + self.heuristic) < (other.cost + other.heuristic)

def manhattan_distance(state, goal):
    distance = 0
    for i in range(3):
        for j in range(3):
            if state[i][j] != 0:  # Ignore empty space
                x, y = divmod(goal.index(state[i][j]), 3)
                distance += abs(x - i) + abs(y - j)
    return distance

def get_neighbors(state):
    neighbors = []
    x, y = next((i, j) for i in range(3) for j in range(3) if state[i][j] == 0)  # Find empty tile
    
    moves = [("Up", (x - 1, y)), ("Down", (x + 1, y)), ("Left", (x, y - 1)), ("Right", (x, y + 1))]
    
    for move, (nx, ny) in moves:
        if 0 <= nx < 3 and 0 <= ny < 3:
            new_state = [row[:] for row in state]
            new_state[x][y], new_state[nx][ny] = new_state[nx][ny], new_state[x][y]  # Swap tiles
            neighbors.append((move, new_state))
    
    return neighbors

def a_star(initial, goal):
    goal_flat = sum(goal, [])  # Flatten goal state for easy indexing
    open_list = []
    closed_set = set()
    
    start_node = PuzzleNode(initial, heuristic=manhattan_distance(initial, goal_flat))
    heapq.heappush(open_list, start_node)
    
    while open_list:
        node = heapq.heappop(open_list)
        
        if node.state == goal:
            path = []
            while node.parent:
                path.append(node.move)
                node = node.parent
            return path[::-1]  # Reverse the path
        
        closed_set.add(tuple(map(tuple, node.state)))
        
        for move, new_state in get_neighbors(node.state):
            if tuple(map(tuple, new_state)) in closed_set:
                continue
            
            new_cost = node.cost + 1
            new_heuristic = manhattan_distance(new_state, goal_flat)
            neighbor_node = PuzzleNode(new_state, node, move, new_cost, new_heuristic)
            heapq.heappush(open_list, neighbor_node)
    
    return None  # No solution found

# Example Usage
initial_state = [
    [1, 2, 4],
    [3, 0, 6],
    [7, 5, 8]
]

goal_state = [
    [1, 2, 3],
    [4, 5, 6],
    [7, 0, 8]
]

solution = a_star(initial_state, goal_state)
print("Solution Path:", solution)
