package MergeIntervals;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//class Interval {
//    int start;
//    int end;
//
//    public Interval(int start, int end) {
//        this.start = start;
//        this.end = end;
//    }
//}
public class InsertIntervals {
    public static void main(String[] args) {

        List<Interval> intervalList = new ArrayList<>();
        intervalList.add(new Interval(2, 3));
        intervalList.add(new Interval(5, 7));
//        intervalList.add(new Interval());

        Interval interval = new Interval(1, 4);

        List<Interval> insertInterval = insertInterval(intervalList, interval);
        for(Interval interval1: insertInterval){
            System.out.println(interval1.start + " " + interval1.end);
        }

    }

    public static List<Interval> insertInterval(List<Interval> intervalList, Interval interval){

        List<Interval> insertInterval = new ArrayList<>();

        if(intervalList.isEmpty() || intervalList == null){
            return Arrays.asList(interval);
        }

        int index = 0;

        while (index < intervalList.size() && intervalList.get(index).end < interval.start){
            insertInterval.add(intervalList.get(index++));
        }

        while (index < intervalList.size() && intervalList.get(index).start < interval.end){
            interval.start = Math.min(intervalList.get(index).start, interval.start);
            interval.end = Math.max(intervalList.get(index).end, interval.end);
            index++;
        }
        insertInterval.add(interval);

        while (index < intervalList.size()){
            insertInterval.add(intervalList.get(index++));
        }

        return insertInterval;

    }
}
