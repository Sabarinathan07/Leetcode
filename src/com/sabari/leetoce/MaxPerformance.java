package com.sabari.leetoce;

import java.util.*;

public class MaxPerformance {

    class Team implements Comparable<Team> {
        int performance,speed,efficiency;

        public Team(int performance, int speed, int efficiency) {
            this.performance = performance;
            this.speed = speed;
            this.efficiency = efficiency;
        }


        public int getPerformance() {
            return performance;
        }

        public void setPerformance(int performance) {
            this.performance = performance;
        }

        public int getSpeed() {
            return speed;
        }

        public void setSpeed(int speed) {
            this.speed = speed;
        }

        public int getEfficiency() {
            return efficiency;
        }

        public void setEfficiency(int efficiency) {
            this.efficiency = efficiency;
        }


        @Override
        public int compareTo(Team o) {
            return o.performance - this.performance;
        }
    }


    public int maxPerformance1(int n, int[] speed, int[] efficiency, int k) {

        ArrayList<Team> arrayList = new ArrayList<Team>();

        for(int i = 0;i<speed.length;i++) {
            Team t = new Team(speed[i] * efficiency[i], speed[i], efficiency[i]);
            arrayList.add(t);
        }
        Collections.sort(arrayList);
        int min=Integer.MAX_VALUE;
        int sum=0;
        for(int i=0;i<k;i++){
            Team t = arrayList.get(i);
            sum += t.getSpeed();
            min = Math.min(min,t.getEfficiency());
        }
        return sum*min;
    }

    public static void main(String[] args) {
        MaxPerformance obj = new MaxPerformance();
        int x = obj.maxPerformance1(6, new int[]{2, 10, 3, 1, 5, 8}, new int[]{5, 4, 3, 9, 7, 2},3);
        System.out.println(x);
    }


}
