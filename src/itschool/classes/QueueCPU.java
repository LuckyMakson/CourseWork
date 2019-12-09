package itschool.classes;

import java.util.ArrayList;
import java.util.Comparator;

import itschool.classes.Process;

public class QueueCPU {
    protected ArrayList<Process> queue;
    private int counter;

    public QueueCPU() {
        this.queue = new ArrayList<>();
        this.counter = 0;
    }

    public int getCounter() {
        return counter;
    }

    public Process add() {
        Process process = new Process(this.counter++, Clock.getTime());
        this.queue.add(process);
        return process;
    }

    @Override
    public String toString() {
        return counter + ": " + queue;
    }

    static class Bypriority implements Comparator<Process>
    {

        public int compare(Process a, Process b)
        {
            return a.priority - b.priority;
        }
    }


}
