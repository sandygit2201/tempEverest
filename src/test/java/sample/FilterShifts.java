package sample;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FilterShifts {

    public static void main(String[] args) {
//        List<String> shiftsInfo = new ArrayList<>();
//
//        shiftsInfo.add("Sunday 6 January 2019");
//        shiftsInfo.add("5:30am – 6:30am");
//        shiftsInfo.add("Back Office at Waiter");
//        shiftsInfo.add("7:30am – 8:30am");
//        shiftsInfo.add("Back Office at Waiter");
//        shiftsInfo.add("Monday 7 January 2019");
//        shiftsInfo.add("5:30am – 6:30am");
//        shiftsInfo.add("Back Office at Waiter");
//        shiftsInfo.add("Tuesday 8 January 2019");
//        shiftsInfo.add("5:30am – 6:30am");
//        shiftsInfo.add("Back Office at Waiter");
//        shiftsInfo.add("5:30am – 6:30am");
//        shiftsInfo.add("Back Office at Waiter");
//        shiftsInfo.add("Wednesday 9 January 2019");
//        shiftsInfo.add("5:30am – 6:30am");
//        shiftsInfo.add("Back Office at Waiter");
//        shiftsInfo.add("Thursday 10 January 2019");
//        shiftsInfo.add("6:30am – 7:30am");
//        shiftsInfo.add("Back Office at Waiter");
//        shiftsInfo.add("7:30am – 8:30am");
//        shiftsInfo.add("Back Office at Waiter");
//        shiftsInfo.add("Friday 11 January 2019");
//        shiftsInfo.add("5:30am – 6:30am");
//        shiftsInfo.add("Back Office at Waiter");
//        shiftsInfo.add("5:30am – 6:30am");
//        shiftsInfo.add("Back Office at Waiter");
//        shiftsInfo.add("Wednesday 9 January 2019");
//        shiftsInfo.add("5:30am – 6:30am");
//        shiftsInfo.add("Back Office at Waiter");
//        shiftsInfo.add("Thursday 10 January 2019");
//        shiftsInfo.add("6:30am – 7:30am");
//        shiftsInfo.add("Back Office at Waiter");
//        shiftsInfo.add("7:30am – 8:30am");
//        shiftsInfo.add("Back Office at Waiter");
//        shiftsInfo.add("Friday 11 January 2019");
//        shiftsInfo.add("5:30am – 6:30am");
//        shiftsInfo.add("Back Office at Waiter");
//
//
//        String location;
//        String shiftData;
//        String time;
//        String shiftDay="";
//        HashSet setShiftInfo = new HashSet();
//        for (int i = 0; i < shiftsInfo.size(); i++) {
//            shiftData = shiftsInfo.get(i);
//            if (shiftData.matches("^(Sun|Mon|Tue|Wed|Thu|Fri|Sat).*$")) {
//                shiftDay = shiftData;
//                i++;
//            }
//            time = shiftsInfo.get(i);
//            i++;
//            location=shiftsInfo.get(i);
//
//            setShiftInfo.add(shiftDay +" " + time + " "+location);
//
//        }
//
//        Iterator itr = setShiftInfo.iterator();
//
//        while (itr.hasNext())
//            System.out.println(itr.next());
//

        List<String> temp = new ArrayList<>();


        temp.add("Sunday 6 January 2019 7:30am – 8:30am Back Office at Waiter");
        temp.add("Sunday 6 January 2019 5:30am – 6:30am Back Office at Waiter");
        temp.add("Wednesday 9 January 2019 5:30am – 6:30am Back Office at Waiter");
        temp.add("Thursday 10 January 2019 7:30am – 8:30am Back Office at Waiter");
        temp.add("Friday 11 January 2019 5:30am – 6:30am Back Office at Waiter");
        temp.add("Tuesday 8 January 2019 5:30am – 6:30am Back Office at Waiter");
        temp.add("Monday 7 January 2019 5:30am – 6:30am Back Office at Waiter");
        temp.add("Thursday 10 January 2019 6:30am – 7:30am Back Office at Waiter");

        String pattern = "([A-Za-z0-9\\:\\s\\–])";


        for (String str:temp) {


            if(str.matches(pattern)){
                System.out.println(str);
            }

        }
    }



}
