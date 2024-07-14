package MergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Meetings {
    int startTime;
    int endTime;

    public Meetings(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
}

public class MinimumMeetingRooms {

    public static void main(String[] args) {

        List<Meetings> meetingsList = new ArrayList<>();
        meetingsList.add(new Meetings(4, 5));
        meetingsList.add(new Meetings(2, 3));
        meetingsList.add(new Meetings(2, 4));
        meetingsList.add(new Meetings(3, 5));

        int minimumRoom = minimumRoomsNeeded(meetingsList);
        System.out.println(minimumRoom);
    }

    public static int minimumRoomsNeeded(List<Meetings> meetingsList) {
        int minRooms = 0;
        Collections.sort(meetingsList, (a, b) -> Integer.compare(a.startTime, b.startTime));
        PriorityQueue<Meetings> priorityQueue = new PriorityQueue<>(
                meetingsList.size(), (a,b)->Integer.compare(a.endTime, b.endTime)
        );
        for(Meetings meetings : meetingsList) {

            while (!priorityQueue.isEmpty() && meetings.startTime >= priorityQueue.peek().endTime){
                priorityQueue.poll();
            }
            priorityQueue.offer(meetings);
            minRooms = Math.max(minRooms, priorityQueue.size());
        }
        return minRooms;
    }
}
