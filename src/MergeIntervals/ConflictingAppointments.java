package MergeIntervals;

import java.util.*;

public class ConflictingAppointments {

    public static void main(String[] args) {

        Interval[] intervals = new Interval[]{
                new Interval(6, 7), new Interval(2, 4), new Interval(13, 14),
                new Interval(8, 12), new Interval(45, 47)
        };

        boolean canAttend = canAttendAll(intervals);
        System.out.println(canAttend);

    }

    public static boolean canAttendAll(Interval[] intervals) {
        List<Interval> intervalList = new ArrayList<>(Arrays.asList(intervals));

        Collections.sort(intervalList, (a, b)-> Integer.compare(a.start, b.start));

        Iterator<Interval> iterator = intervalList.iterator();
        Interval interval = iterator.next();
        int start = interval.start;
        int end = interval.end;

        while(iterator.hasNext()){
            Interval currentInterval = iterator.next();
            if(currentInterval.start < end){
                return false;
            } else {
                start = currentInterval.start;
                end = currentInterval.end;;
            }
        }

        return true;

    }
}
