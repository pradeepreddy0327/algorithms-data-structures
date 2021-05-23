package array;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class CreditPayments2 {

    public static void main(String[] args) {

        CreditPayments2 obj = new CreditPayments2();
        System.out.println(Arrays
                .toString(obj.creditPayments(10000, 1000, "01/2019", "08/2019",
                        new String[] { "$1000 payment received on 01/16/2019",
                                "$2400 payment received on 03/20/2019",
                                "$4000 payment received on 04/25/2019",
                                "$3300 payment received on 05/06/2019",
                                "$1500 payment received on 08/15/2019" })));
        System.out.println(Arrays
                .toString(obj.creditPayments(3550, 250, "01/2000", "01/2001",
                        new String[] { "$500 payment received on 01/01/2000",
                                "$500 payment received on 02/02/2000",
                                "$500 payment received on 03/03/2000",
                                "$500 payment received on 04/04/2000",
                                "$500 payment received on 05/05/2000",
                                "$500 payment received on 06/06/2000",
                                "$500 payment received on 07/07/2000",
                                "$500 payment received on 09/09/2000" })));
        System.out.println(250 - 3550 * 0.01);
        System.out.println(Math.floor(250 - 3550 * 0.01));
    }

    String[] creditPayments(int a, int b, String startDate, String endDate,
            String[] history) {
        Map<String, Payment> paymentMap = new HashMap<>();
        for (String s : history) {
            String[] parsedHistory = s.split(" ");
            Date d = getDate(parsedHistory[4], "MM/dd/yyyy");
            paymentMap.put(getKey(d),
                    new Payment(parsedHistory[0].substring(1), d.getDate(), d));
        }

        Date fromDate = getDate("01/" + startDate, "dd/MM/yyyy");
        Date currentDate = getDate("01/" + startDate, "dd/MM/yyyy");
        Date toDate = getDate("01/" + endDate, "dd/MM/yyyy");
        List<String> suggestions = new ArrayList<>();

        while (!currentDate.after(toDate)) {
            Payment currentPayment = paymentMap.get(getKey(currentDate));
            Payment LastPayment = paymentMap
                    .get(getKey(roleMonth(currentDate, -1)));
            Payment LastLastPayment = paymentMap
                    .get(getKey(roleMonth(currentDate, -2)));
            if (currentDate.equals(fromDate)) {
                suggestions.add(getLeaveItSuggestion(b));
            } else if (roleMonth(currentDate, -1).equals(fromDate)) {
                if (!isPaidLastTwoMonths(paymentMap, currentDate)) {
                    b = (int) Math.round(b + a * 0.01);
                    suggestions.add(getAddYearSuggestion(b));
                } else {
                    suggestions.add(getLeaveItSuggestion(b));
                }
            } else {
                int sumOfLast3Payments = getPayment(currentPayment)
                        + getPayment(LastPayment) + getPayment(LastLastPayment);
                boolean isLate3Months = isLate(currentPayment)
                        && isLate(LastPayment) && isLate(LastLastPayment);
                int paidMoreTimes = 0;
                if (getPayment(currentPayment) > b)
                    paidMoreTimes++;
                if (getPayment(LastPayment) > b)
                    paidMoreTimes++;
                if (getPayment(LastLastPayment) > b)
                    paidMoreTimes++;
                if (sumOfLast3Payments < 3 * b || isLate3Months
                        || (currentPayment == null && LastPayment == null)) {
                    b = (int) Math.round(b + a * 0.01);
                    suggestions.add(getAddYearSuggestion(b));
                } else if (currentPayment != null && LastPayment != null
                        && LastLastPayment != null && paidMoreTimes >= 2) {
                    b = (int) Math.floor(b - a * 0.01);
                    suggestions.add(getRemoveYearSuggestion(b));
                } else {
                    suggestions.add(getLeaveItSuggestion(b));
                }

            }
            currentDate = roleMonth(currentDate, 1);
        }
        System.out.println(paymentMap);
        return toArray(suggestions);
    }

    private Date getDate(String s, String format) {
        DateFormat df = new SimpleDateFormat(format, Locale.ENGLISH);
        try {
            return df.parse(s);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    private Date roleMonth(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, n);
        return cal.getTime();
    }

    private String[] toArray(List<String> list) {
        String[] arr = new String[list.size()];
        int i = 0;
        for (String s : list) {
            arr[i++] = s;
        }
        return arr;
    }

    private int getPayment(Payment p) {
        return p == null ? 0 : p.amount;
    }

    private boolean isLate(Payment p) {
        return p == null ? true : p.isLate();
    }

    private String getLeaveItSuggestion(int b) {
        return "Leave as it is, " + b + ".";
    }

    private String getAddYearSuggestion(int b) {
        return "Add one year, " + b + ".";
    }

    private String getRemoveYearSuggestion(int b) {
        return "Remove one year, " + b + ".";
    }

    private boolean isPaidLastTwoMonths(Map<String, Payment> paymentMap,
            Date currentDate) {
        Date lastMonthDate = roleMonth(currentDate, -1);
        if (paymentMap.get(getKey(currentDate)) == null
                && paymentMap.get(getKey(lastMonthDate)) == null) {
            return false;
        }
        return true;
    }

    private String getKey(Date date) {
        return date.getMonth() + "_" + date.getYear();
    }

    class Payment {
        int amount;
        int dayOfMonth;
        Date date;

        boolean isLate() {
            return dayOfMonth > 15;
        }

        Payment(String amount, int dayOfMonth, Date d) {
            this.amount = Integer.valueOf(amount);
            this.dayOfMonth = dayOfMonth;
            this.date = d;
        }
    }

}
