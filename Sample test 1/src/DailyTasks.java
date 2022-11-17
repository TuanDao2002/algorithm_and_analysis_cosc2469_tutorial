public class DailyTasks {
    static class Task {
        String description;
        int startTime;
        int duration;

        public Task(String description, int startTime, int duration) {
            this.description = description;
            this.startTime = startTime;
            this.duration = duration;
        }
    }

    private int size;
    private static int MAX_SIZE = 100;
    private Task[] tasks;

    public DailyTasks() {
        size = 0;
        tasks = new Task[MAX_SIZE];
    }

    // validateTask complexity = O(1)
    boolean validateTask(Task task) {
        if (task.startTime < 0 || task.startTime > 23) return false;
        if (task.duration < 1 || task.duration > 24) return false;
        return task.duration + task.startTime <= 24;
    }

    // addTask complexity = O(n)
    boolean addTask(Task task) {
        if (!validateTask(task)) return false;
        if (size != 0) {
            for (int i = 0; i < size; i++) {
                if (tasks[i].startTime + tasks[i].duration > task.startTime && tasks[i].startTime < task.startTime
                        || tasks[i].startTime < task.startTime + task.duration && tasks[i].startTime + tasks[i].duration > task.startTime + task.duration) {
                    System.out.println("f");
                    return false;
                }
            }
        }

        tasks[size] = task;
        size++;
        return true;
    }

    // nextTask complexity = O(n)
    String nextTask(int time) {
        if (size == 0) return "";
        Task earliestTask = null;
        for (int i = 0; i < size; i++) {
            if (tasks[i].startTime >= time) {
                if (earliestTask == null) {
                    earliestTask = tasks[i];
                } else if (earliestTask.startTime > tasks[i].startTime) {
                    earliestTask = tasks[i];
                }
            }
        }

        if (earliestTask == null) return "";
        return earliestTask.description;
    }

    public static void main(String[] args) {
        DailyTasks dailyTasks = new DailyTasks();
        dailyTasks.addTask(new Task("Studying DSA", 10, 2));
        dailyTasks.addTask(new Task("Programming", 8, 2));
        dailyTasks.addTask(new Task("Ethical hacking", 20, 2));

        for (int i = 0; i < dailyTasks.size; i++) {
            System.out.println(dailyTasks.tasks[i].description);
        }

        System.out.println();
        System.out.println(dailyTasks.nextTask(5));
        System.out.println(dailyTasks.nextTask(8));
        System.out.println(dailyTasks.nextTask(9));
        System.out.println(dailyTasks.nextTask(18));
        System.out.println(dailyTasks.nextTask(21));
    }
}
