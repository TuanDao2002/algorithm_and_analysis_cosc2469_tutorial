public class TaskCollection {
    public static void main(String[] args) {
        Task t1 = new Task("GET DI", true);
        Task t2 = new Task("GET HD", false);
        TaskCollection taskCol = new TaskCollection();
        System.out.println(taskCol.calcLocation(t1));  // return 40
        System.out.println(taskCol.calcLocation(t2));  // return 39
        System.out.println(taskCol.calcLocation(new Task("GET D I", false)));  // return 40
        System.out.println(taskCol.addTask(t1));  // return 40
        System.out.println(taskCol.addTask(new Task("GET D I", false))); // return 41, due to collision at 40-th location
        System.out.println(taskCol.getTask("GET DI"));  // return Task t1
        System.out.println(taskCol.getTask("G E T D I")); // return null
        System.out.println(taskCol.getTask("GET HD"));  // return null
    }

    static int maxLen = 2027;
    Task[] tasks = new Task[maxLen];

    // calcLocation complexity = O(N)
    public int calcLocation(Task t) {
        String name = t.name;
        int value = 0;

        int nameLen = name.length();
        for (int i = 0; i < nameLen; i++) {
            if (name.charAt(i) == ' ') continue;
            value += name.charAt(i) - 'A';
        }

        return value;
    }

    // addTask complexity = O(1)
    public int addTask(Task t) {
        int value = calcLocation(t);

        if (value >= maxLen) {
            value %= maxLen;
        }

        int newIdx = value;
        while (tasks[newIdx] != null) {
            newIdx++;
        }

        tasks[newIdx] = t;
        return newIdx;
    }

    // getTask complexity = O(1)
    public Task getTask(String name) {
        int value = calcLocation(new Task(name, true));

        if (value >= maxLen) {
            value %= maxLen;
        }

        int idx = value;
        while (tasks[idx] != null) {
            if (tasks[idx].name.equals(name)) {
                return tasks[idx];
            }
            idx++;
        }

        return null;
    }

    public static class Task {
        String name;
        boolean status;

        public Task(String name, boolean status) {
            this.name = name;
            this.status = status;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "name='" + name + '\'' +
                    ", status=" + status +
                    '}';
        }
    }
}
