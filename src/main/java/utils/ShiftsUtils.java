package utils;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class ShiftsUtils {

    public void printShiftDetails(List<String> shiftsInfo){
        String location;
        String shiftData;
        String time;
        String shiftDay="";
        String shiftDetails;
        HashSet setShiftInfo = new HashSet();
        for (int i = 0; i < shiftsInfo.size(); i++) {
            shiftData = shiftsInfo.get(i);
            if (shiftData.matches("^(Sun|Mon|Tue|Wed|Thu|Fri|Sat).*$")) {
                shiftDay = shiftData;
                i++;
            }
            time = shiftsInfo.get(i);
            i++;
            location=shiftsInfo.get(i);

            shiftDetails=shiftDay +" " + time + " "+location;

            if(shiftDetails.matches("/([A-Za-z0-9\\:\\s\\–])/g"))
            setShiftInfo.add(shiftDetails);

        }

        Iterator itr = setShiftInfo.iterator();

        while (itr.hasNext())
            System.out.println(itr.next());

    }
}
