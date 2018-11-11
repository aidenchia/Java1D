package com.example.aidenchia.java1dapp;

public class TimeChecker {

    public static boolean timeCheck (String startTime, String endTime)
    {
        String[] startExtract = TimeChecker.timeExtractor(startTime);
        String startPeriod = startExtract[1];
        int startTiming = Integer.parseInt(startExtract[0]);

        String[] endExtract =  TimeChecker.timeExtractor(endTime);
        String endPeriod = endExtract[1];
        int endTiming = Integer.parseInt(endExtract[0]);
        System.out.println("endperiod " + endPeriod);
        System.out.println("startperiod " + startPeriod);

        if (endPeriod.equals("am") && startPeriod.equals("pm"))
        {
            return false;
        }

        else if (endPeriod.equals("pm") && startPeriod.equals("pm"))
        {
            if (endTiming <= startTiming)
            {
                return false;
            }

            else
                return true;
        }


        else if (endPeriod.equals("pm") && startPeriod.equals("am"))
        {
            return true;
        }

        else // endPeriod.equals("am") && startPeriod.equals("am")
        {
            if (endTiming <= startTiming)
            {
                return false;
            }

            else
                return true;
        }

    }

    public static String[] timeExtractor(String time)
    {
        if (time.length() == 3)
        {
            String period = time.substring(1,3);
            String timing = time.substring(0,1);
            String[] extract = new String[]{timing, period};
            return extract;
        }

        else
        {
            String period = time.substring(2,4);
            String timing = time.substring(0,2);
            String[] extract = new String[]{timing, period};
            return extract;
        }
    }
}
