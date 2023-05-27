package org.codewarrior;

import java.util.*;

/*
This is a 3kyu Kata from Codewars.
"Get all the people to the floors they want to go to while obeying the Lift rules and the People rules.
Return a list of all floors that the Lift stopped at (in the order visited!)"
Link: https://www.codewars.com/kata/58905bfa1decb981da00009e
 */

public class Lift {

    public final int NO_MORE_PASSENGER = -1;

    public int[] theLift(final int[][] queues, final int capacity) {
        // initialize list and start at floor 0
        List<Integer> floors = new ArrayList<>();
        floors.add(0);
        // loop until all floors are empty
        while (!allFloorsEmpty(queues)) {
            int peopleInLift = 0;
            List<Integer> floorsToStopAt = new ArrayList<>();
            // drive up
            for (int i = 0; i < queues.length; i++) {
                // let people out
                if (floorsToStopAt.contains(i)) {
                    int peopleExitingLift = letPeopleOut(floors, floorsToStopAt, i);
                    peopleInLift -= peopleExitingLift;
                }
                // let people in
                if (queues[i].length != 0) {
                    for (int passengerDest : queues[i]) {
                        if (inTravelDirection(floors, i, passengerDest, "up")) break;
                    }
                    peopleInLift = letPeopleIn(queues, capacity, peopleInLift, floorsToStopAt, i, "up");
                }
            }
            // drive down
            for (int i = queues.length-1; i >= 0; i--) {
                // let people out
                if (floorsToStopAt.contains(i)) {
                    int peopleExitingLift = letPeopleOut(floors, floorsToStopAt, i);
                    peopleInLift -= peopleExitingLift;
                }
                // let people in
                if (queues[i].length != 0) {
                    for (int passengerDest : queues[i]) {
                        if (inTravelDirection(floors, i, passengerDest, "down")) break;
                    }
                    peopleInLift = letPeopleIn(queues, capacity, peopleInLift, floorsToStopAt, i, "down");
                }
            }
        }
        // stop again at the bottom floor
        if (floors.get(floors.size()-1) != 0) {
            floors.add(0);
        }
        return floors.stream().mapToInt(Integer::intValue).toArray();
    }

    private int letPeopleIn(int[][] queues, int capacity, int peopleInLift, List<Integer> floorsToStopAt, int i, String direction) {
        // let people into lift, if enough capacity and right travel direction for passenger destination
        if (Objects.equals(direction, "up")) {
            for (int j = 0; j < queues[i].length; j++) {
                if (peopleInLift < capacity && queues[i][j] > i && queues[i][j] != NO_MORE_PASSENGER) {
                    peopleInLift++;
                    floorsToStopAt.add(queues[i][j]);
                    queues[i][j] = NO_MORE_PASSENGER;
                }
            }
        } else {
            for (int j = 0; j < queues[i].length; j++) {
                if (peopleInLift < capacity && queues[i][j] < i && queues[i][j] != NO_MORE_PASSENGER) {
                    peopleInLift++;
                    floorsToStopAt.add(queues[i][j]);
                    queues[i][j] = NO_MORE_PASSENGER;
                }
            }
        }
        return peopleInLift;
    }

    private boolean inTravelDirection(List<Integer> floors, int i, int passengerDest, String direction) {
        // add floor to result list, if correct direction for passenger
        if (Objects.equals(direction, "up") && passengerDest > i && passengerDest != NO_MORE_PASSENGER
                && floors.get(floors.size()-1) != i) {
            floors.add(i);
            return true;
        }
        if (Objects.equals(direction, "down") && passengerDest < i && passengerDest != -1
                && floors.get(floors.size()-1) != i) {
            floors.add(i);
            return true;
        }
        return false;
    }

    private int letPeopleOut(List<Integer> floors, List<Integer> floorsToStopAt, int i) {
        // check how many people exit on a floor
        if (floors.get(floors.size()-1) != i) {
            floors.add(i);
        }
        int peopleExitingLift = 0;
        Iterator<Integer> iterator = floorsToStopAt.iterator();
        while (iterator.hasNext()) {
            Integer floor = iterator.next();
            if (floor.equals(i)) {
                iterator.remove();
                peopleExitingLift++;
            }
        }
        return peopleExitingLift;
    }

    private boolean allFloorsEmpty(int[][] queues) {
        for (int[] floor : queues) {
            for (int passenger : floor) {
                if (passenger != NO_MORE_PASSENGER) {
                    return false;
                }
            }
        }
        return true;
    }
}
