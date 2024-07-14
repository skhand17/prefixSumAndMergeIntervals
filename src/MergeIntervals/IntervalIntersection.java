package MergeIntervals;

import java.util.ArrayList;
import java.util.List;

public class IntervalIntersection {

    public static void main(String[] args) {

        Interval[] input = new Interval[]{
                new Interval(1, 3), new Interval(5, 6), new Interval(7, 9)
        };

        Interval[] input2 = new Interval[]{
                new Interval(2, 3), new Interval(5, 7)
        };

        List<Interval> mergedIntervals = intervalIntersection(input, input2);
        for(Interval interval : mergedIntervals){
            System.out.println(interval.start + " " + interval.end);
        }



    }

    public static List<Interval> intervalIntersection(Interval[] input1, Interval[] input2) {

        List<Interval> mergedInterval = new ArrayList<>();

        int i=0;
        int j=0;

        while (i < input1.length && j < input2.length) {

            if((input1[i].start >= input2[j].start
                    && input1[i].start <= input2[j].end) ||
                    (input2[j].start >= input1[i].start && input2[j].start <= input1[i].end)){

                mergedInterval.add(new Interval(Math.max(input1[i].start, input2[j].start) ,
                        Math.min(input1[i].end, input2[j].end)));

            }

            if(input1[i].end < input2[j].end){
                i++;
            } else {
                j++;
            }

        }
        return mergedInterval;

    }
}
