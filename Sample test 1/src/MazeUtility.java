public class MazeUtility {
    public static class ArrayQueue<T> {
        private int size;
        private static int MAX_SIZE = 100;
        private T[] items;

        public ArrayQueue() {
            size = 0;
            items = (T[])new Object[MAX_SIZE];
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean enQueue(T item) {
            // make sure the queue still have empty slot
            if (size < MAX_SIZE) {
                items[size] = item;
                size++;
                return true;
            }
            return false;
        }

        public boolean deQueue() {
            // make sure the queue is not empty
            if (isEmpty()) {
                return false;
            }
            // shifting left
            for (int i = 0; i < size - 1; i++) {
                items[i] = items[i + 1];
            }
            size--;
            return true;
        }

        public T peekFront() {
            // make sure the queue is not empty
            if (isEmpty()) {
                return null;
            }
            return items[0];
        }
    }

    public static void main(String[] args) {
        char[][] maze = new char[][]{
                {'S', '.', '.', '*'},
                {'.', '*', '*', '*'},
                {'.','.', '.', 'E'}
        };

        displayMaze(maze);
        System.out.println("Number of end: " + countEnd(maze));
        System.out.println(solvable(maze));
    }

    static void displayMaze(char[][] maze) {
        for (char[] row : maze) {
            for (char cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }

    static int countEnd(char[][] maze) {
        int count = 0;
        for (char[] row : maze) {
            for (char cell : row) {
                if (cell == 'E') count++;
            }
        }

        return count;
    }

    static class Position {
        int row;
        int col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static boolean solvable(char[][] maze) {
        int rowLen = maze.length;
        int colLen = maze[0].length;
        boolean[][] visited = new boolean[rowLen][colLen];

        ArrayQueue<Position> queue = new ArrayQueue<>();
        queue.enQueue(new Position(0, 0));

        while (!queue.isEmpty()) {
            Position currPos = queue.peekFront();

            int currRow = currPos.row;
            int currCol = currPos.col;

            if (visited[currRow][currCol]) {
                queue.deQueue();
                continue;
            } else {
                visited[currRow][currCol] = true;
            }

            if (maze[currRow][currCol] == 'E') {
                return true;
            }

            if (currRow > 0 && maze[currRow - 1][currCol] != '*') {
                queue.enQueue(new Position(currRow - 1, currCol));
            }

            if (currRow < rowLen - 1 && maze[currRow + 1][currCol] != '*') {
                queue.enQueue(new Position(currRow + 1, currCol));
            }

            if (currCol > 0 && maze[currRow][currCol - 1] != '*') {
                queue.enQueue(new Position(currRow, currCol - 1));
            }

            if (currCol < colLen - 1 && maze[currRow][currCol + 1] != '*') {
                queue.enQueue(new Position(currRow, currCol + 1));
            }

            queue.deQueue();
        }

        return false;
    }
}
