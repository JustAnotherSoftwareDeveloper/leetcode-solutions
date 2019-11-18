import java.util.*;

public class FreqStack {


    private Map<Integer,Integer> numsToFreq;
    private Map<Integer, Stack<Integer>> groups;
    int maxFrequency;
    public FreqStack() {
        groups = new HashMap<>();
        numsToFreq = new HashMap<>();
        maxFrequency = 0;
    }

    public void push(int x) {
       int frequency = numsToFreq.getOrDefault(x,0)+1;
       numsToFreq.put(x,frequency);
       if (frequency > maxFrequency) {
           maxFrequency = frequency;
       }
       groups.computeIfAbsent(frequency, s -> new Stack<>()).push(x);
    }


    public int pop() {
        int toPop = groups.get(maxFrequency).pop();
        numsToFreq.put(toPop,numsToFreq.get(toPop) -1);
        if (groups.get(maxFrequency).size() == 0) {
            maxFrequency--;
        }
        return toPop;
    }
}
