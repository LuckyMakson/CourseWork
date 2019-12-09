package itschool.classes;

public class Clock extends Thread {
    private static int time = 0;

    public static int getTime() {
        return time;
    }

    public static void incTime() {
        time++;
    }

    @Override
    public void run() {
        while (Scheduler.isActive) {
            incTime();
            System.out.println(getTime());
            Scheduler.tryToAddProcess();
            System.out.println("Processes: " + Scheduler.queueCPU.getCounter());
            Scheduler.processQueue();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
