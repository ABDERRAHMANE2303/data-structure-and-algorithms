class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rows_config = {_ : set() for _ in range(len(board))}
        columns_config = {_ : set() for _ in range(len(board))}
        subboxes_config = {_ : set() for _ in range(len(board))}

        for row in range(len(board)) :
            for column in range(len(board[0])):

                subboxe_index = (row//3) * 3 + (column//3)

                if board[row][column] == "." :
                    continue
                
                if board[row][column] in rows_config[row] :
                    return False
                
                if board[row][column] in columns_config[column] :
                    return False

                if board[row][column] in subboxes_config[subboxe_index]:
                    return False
                
                rows_config[row].add(board[row][column])
                columns_config[column].add(board[row][column])
                subboxes_config[subboxe_index].add(board[row][column])
    
        return True