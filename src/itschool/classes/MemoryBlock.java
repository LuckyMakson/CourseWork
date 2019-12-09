package itschool.classes;

import java.util.Comparator;

public class MemoryBlock {
    int start;
    int end;

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public MemoryBlock(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "[" + start + ", " + end + ']';
    }

    public static Comparator<MemoryBlock> ByEnd = (o1, o2) -> (o1.end < o2.end ? -1 : (o1.end > o2.end ? 1 : 0));
}
