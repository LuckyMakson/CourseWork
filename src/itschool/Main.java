package itschool;

import itschool.classes.*;
import itschool.classes.Process;

import itschool.classes.QueueCPU;


public class Main {

    public static void main(String[] args) {

        Scheduler scheduler = new Scheduler(2048, 4);
        scheduler.run();
    }
}
