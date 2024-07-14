package MergeIntervals;

import java.util.*;

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class MergeIntervals {



    public static void main(String[] args) {
        List<Interval> intervalList = new ArrayList<>();
        intervalList.add(new Interval(1, 4));
        intervalList.add(new Interval(1, 3));
        intervalList.add(new Interval(2, 10));
        intervalList.add(new Interval(3, 7));

//        output should 1 to 10

        List<Interval> merge = mergeInterval(intervalList);
        for(Interval inter: merge){
            System.out.println(inter.start + " " + inter.end);
        }

    }

    public static  List<Interval> mergeInterval(List<Interval> intervalList){

        Collections.sort(intervalList, (a, b) -> Integer.compare(a.start, b.start));

        List<Interval> mergedInterval = new LinkedList<>();
        Iterator<Interval> iterator = intervalList.iterator();
        Interval currentInterval = iterator.next();

        int start = currentInterval.start;
        int end = currentInterval.end;

        while (iterator.hasNext()){
            Interval interval = iterator.next();

            if(interval.start <= end){
                end = Math.max(end, interval.end);
            } else {
                mergedInterval.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        mergedInterval.add(new Interval(start, end));

        return mergedInterval;
    }
}