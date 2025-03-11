/*
You are given a list of worker shifts, where each shift is
represented as a list [name, start, end]. The name is a string
representing the worker's name, start is an integer representing the
start time of the shift, and end is an integer representing the end
time of the shift. The goal is to generate a schedule that shows the
intervals of time and the workers present during each interval.

Example:
Given the input:
[["Abby", 10, 100], ["Ben", 50, 70], ["Carla", 60, 70], 
["David", 120, 300]]

The output should be:
[[10, 50, ["Abby"]], [50, 60, ["Abby", "Ben"]], 
[60, 70, ["Abby", "Ben", "Carla"]], [70, 100, ["Abby"]], 
[120, 300, ["David"]]]
*/

import java.util.*;

public class WorkerShifts {
    public static List<List<Object>> getActiveEmp(List<List<Object>> shifts) {
        // Create timeline of events
        List<Event> timeline = new ArrayList<>();
        for (List<Object> shift : shifts) {
            String name = (String) shift.get(0);
            int start = (Integer) shift.get(1);
            int end = (Integer) shift.get(2);
            
            timeline.add(new Event(start, 1, name)); // 1 represents start event
            timeline.add(new Event(end, -1, name));  // -1 represents end event
        }
        
        // Sort timeline by time
        Collections.sort(timeline, (a, b) -> {
            if (a.time != b.time) {
                return Integer.compare(a.time, b.time);
            }
            return Integer.compare(a.eventType, b.eventType);
        });
        
        // Process events
        Set<String> activeEmp = new TreeSet<>(); // Using TreeSet for sorted names
        List<List<Object>> result = new ArrayList<>();
        int lastTime = -1;
        
        for (Event event : timeline) {
            // Add interval if we have active employees
            if (lastTime != -1 && event.time != lastTime && !activeEmp.isEmpty()) {
                List<Object> interval = new ArrayList<>();
                interval.add(lastTime);
                interval.add(event.time);
                interval.add(new ArrayList<>(activeEmp)); // Convert set to list
                result.add(interval);
            }
            
            // Update active employees
            if (event.eventType == 1) {
                activeEmp.add(event.name);
            } else {
                activeEmp.remove(event.name);
            }
            
            lastTime = event.time;
        }
        
        return result;
    }
    
    // Helper class to represent an event
    static class Event {
        int time;
        int eventType; // 1 for start, -1 for end
        String name;
        
        public Event(int time, int eventType, String name) {
            this.time = time;
            this.eventType = eventType;
            this.name = name;
        }
    }
    
    public static void main(String[] args) {
        // Example input
        List<List<Object>> shifts = new ArrayList<>();
        
        List<Object> shift1 = new ArrayList<>();
        shift1.add("Abby");
        shift1.add(10);
        shift1.add(100);
        shifts.add(shift1);
        
        List<Object> shift2 = new ArrayList<>();
        shift2.add("Ben");
        shift2.add(50);
        shift2.add(70);
        shifts.add(shift2);
        
        List<Object> shift3 = new ArrayList<>();
        shift3.add("Carla");
        shift3.add(60);
        shift3.add(70);
        shifts.add(shift3);
        
        List<Object> shift4 = new ArrayList<>();
        shift4.add("David");
        shift4.add(120);
        shift4.add(300);
        shifts.add(shift4);
        
        // Generate schedule
        List<List<Object>> schedule = getActiveEmp(shifts);
        
        // Print the schedule
        System.out.println("Schedule:");
        for (List<Object> interval : schedule) {
            System.out.println(interval);
        }
    }
}