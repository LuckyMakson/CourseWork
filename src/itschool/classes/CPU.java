package itschool.classes;

public class CPU {
    Core[] cores;

    public CPU(final int coresNumber) {
        this.cores = new Core[coresNumber];
        for (int i = 0; i < coresNumber; i++) {
            cores[i] = new Core();
            cores[i].isFree = true;

        }
    }

    public int getFreeCoreNumber() {
        for (int n = 0; n < cores.length; n++) {
            if (cores[n].isFree)
                return n;
        }
        return -1;
    }

    public void occupyCPU(int freeCoreNumber, int pid) {
        this.cores[freeCoreNumber].isFree = false;
        this.cores[freeCoreNumber].pid = pid;
    }

    public void setFreeCore(int id) {
        for (Core core : this.cores) {
            if (core.pid == id) {
                core.isFree = true;
            }
        }
    }
}
