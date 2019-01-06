package utils;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ShiftsUtils {

    public void printShiftDetails(List<String> shiftsInfo) {
        String location;
        String shiftData;
        String time;
        String shiftDay = "";
        Set setShiftInfo = new HashSet();
        for (int i = 0; i < shiftsInfo.size(); i++) {
            try {
                shiftData = shiftsInfo.get(i);
                if (shiftData.matches("^(Sun|Mon|Tue|Wed|Thu|Fri|Sat).*$")) {
                    shiftDay = shiftData;
                    i++;
                }
                time = shiftsInfo.get(i);
                i++;
                location = shiftsInfo.get(i);
                setShiftInfo.add(shiftDay + " " + time + " " + location);

            } catch (Exception e) {

            }
        }

        Iterator itr = setShiftInfo.iterator();

        while (itr.hasNext())
            System.out.println(itr.next());

        System.out.println("Total ShiftsReq for user:"+setShiftInfo.size());

    }

}
