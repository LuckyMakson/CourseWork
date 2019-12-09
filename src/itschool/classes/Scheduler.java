package itschool.classes;

import java.util.Collections;
import java.util.TimerTask;


public class Scheduler extends TimerTask {
    public static boolean isActive = false;
    static QueueCPU queueCPU;
    static Memory memory;
    static CPU cpu;
    public static Clock clock;

    public Scheduler(int memoryVolume, int coresNumber) {
        queueCPU = new QueueCPU();
        memory = new Memory(memoryVolume);
        cpu = new CPU(coresNumber);
        clock = new Clock();
        isActive = true;
        clock.run();
    }

    public static void tryToAddProcess() {
        if (Utils.getRandomInteger(11) <= 2) {
            System.out.println(queueCPU.add());
        }
    }

    public static void processQueue() {

        Collections.sort(queueCPU.queue, new QueueCPU.Bypriority());

        int freeCoreNumber = cpu.getFreeCoreNumber();
        if (freeCoreNumber >= 0) {
            for (Process process : queueCPU.queue) {
                if (process.state == State.Ready || process.state==State.Waiting) {
                    process.state = State.Running;
                    System.out.println("Currently running: " + process);
                    cpu.occupyCPU(freeCoreNumber, process.id);
                }
            }
        }

        for (Process process : queueCPU.queue) {
            if (process.state == State.Running && process.timeIn + process.burstTime == clock.getTime()) {
                process.state=State.Finished;
                memory.removeBlock(process.memoryBlock);
                cpu.setFreeCore(process.id);
                System.out.println("Currently finished" + process);
            }
        }
    }

    @Override
    public void run() {
        System.out.println("Scheduler started!");
    }

}
