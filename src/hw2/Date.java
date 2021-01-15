package hw2;

/**
 * Created by qiuying on 2020/12/19.
 */
/* Date.java */

class Date {

  /* Put your private data fiel  ds here. */
    public int month;
    public int day;
    public int year;
    public static int max_day;
    /** Constructs a date with the given month, day and year.   If the date is
     *  not valid, the entire program will halt with an error message.
     *  @param month is a month, numbered in the range 1...12.
     *  @param day is between 1 and the number of days in the given month.
     *  @param year is the year in question, with no digits omitted.
     */
    public Date(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
        if (this.month <=0 || this.month >12 || this.year <=0 || this.day <=0 || this.day >32) {
            System.out.println("wrong year/month/day format");
        }
    }

    /** Constructs a Date object corresponding to the given string.
     *  @param s should be a string of the form "month/day/year" where month must
     *  be one or two digits, day must be one or two digits, and year must be
     *  between 1 and 4 digits.  If s does not match these requirements or is not
     *  a valid date, the program halts with an error message.
     */
    public Date(String s) {
        // use the library .split("/")
        // then construct a string to store the results
        String[] date = s.split("/");
        month = Integer.parseInt(date[0]);
        day = Integer.parseInt(date[1]);
        year = Integer.parseInt(date[2]);

    }

    /** Checks whether the given year is a leap year.
     *  @return true if and only if the input year is a leap year.
     */
    public boolean isLeapYear(int year) {
        if (year % 400 == 0 || (year %4 == 0 && year %100 != 0)){
            return true;
        } else{
            return false;
        }
                                // replace this line with your solution
    }

    /** Returns the number of days in a given month.
     *  @param month is a month, numbered in the range 1...12.
     *  @param year is the year in question, with no digits omitted.
     *  @return the number of days in the given month.
     */
    public int daysInMonth(int month, int year) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                max_day=31;
                break;
            case 2:
                if(isLeapYear(year))
                    max_day=29;
                else
                    max_day=28;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                max_day=30;
                break;
        }

        return max_day;
    }

    /** Checks whether the given date is valid.
     *  @return true if and only if month/day/year constitute a valid date.
     *
     *  Years prior to A.D. 1 are NOT valid.
     */
    public boolean isValidDate(int month, int day, int year) {
        if (month <=0 || month > 12 || year <= 0 || year >9999 || day <= 0 || day >= 32) {
                return false;
            }
        if (day == 29 && isLeapYear(year) == false){
            return false;
        }
        else{
            return true;
        }

    }

    /** Returns a string representation of this date in the form month/day/year.
     *  The month, day, and year are printed in full as integers; for example,
     *  12/7/2006 or 3/21/407.
     *  @return a String representation of this date.
     */
    public String toString() {
        return this.month + "/" + this.day + "/" + this.year;                  // replace this line with your solution
    }

    /** Determines whether this Date is before the Date d.
     *  @return true if and only if this Date is before d.
     */
    public boolean isBefore(Date d) {
        boolean result = true;
        if (this.year < d.year) {
            result = true;
        } else if (this.year > d.year) {
            result = false;
        } else{
            if(this.month < d.month) {
                result = true;
            } else if (this.month > d.month) {
                result = true;
            } else{
                if(this.day < d.day){
                    result = true;
                } else if (this.day > d.day) {
                    result = false;
                } else{
                    result = false;
                }
            }
        }

        return result;

    }
                           // replace this line with your solution


    /** Determines whether this Date is after the Date d.
     *  @return true if and only if this Date is after d.
     */
    public boolean isAfter(Date d) {
        boolean result = true;
        if(this.year == d.year && this.month == d.month && this.day == d.day){
            result = false;
        } else {
            result = !(isBefore(d));
        }
        return result;
    }

    /** Returns the number of this Date in the year.
     *  @return a number n in the range 1...366, inclusive, such that this Date
     *  is the nth day of its year.  (366 is only used for December 31 in a leap
     *  year.)
     */
    public int dayInYear() {
       int sum_day = 0;
       for (int i = month -1 ; i > 0; i--) {
           sum_day = sum_day + daysInMonth(i, year);
       }
       sum_day = sum_day + day;
       return sum_day;
    }

    /** Determines the difference in days between d and this Date.  For example,
     *  if this Date is 12/15/1997 and d is 12/14/1997, the difference is 1.
     *  If this Date occurs before d, the result is negative.
     *  @return the difference in days between d and this date.
     */
    public int difference(Date d) {
        if (this.year == d.year) {
         return this.dayInYear() - d.dayInYear();
        }

        else if (this.year > d.year) {
            int daysYear = 0;
            int year1 = this.year;
            int year2 = d.year;
            while (year1 != year2) {
                if (isLeapYear(year2)) {
                    daysYear += 366;
                } else {
                    daysYear += 365;
                }
                year2++;
            }
         daysYear = daysYear + this.dayInYear() - d.dayInYear();
         return daysYear;
        }

        else  {
            int daysYear = 0;
            int year1 = this.year;
            int year2 = d.year;
            while (year1 != year2) {
                if (isLeapYear(year1)) {
                    daysYear += 366;
                } else {
                    daysYear += 365;
                }
                year1++;
            }
            daysYear = -daysYear + (this.dayInYear()-d.dayInYear());
            return daysYear;
        }
    }


    public static void main(String[] argv) {
        System.out.println("\nTesting constructors.");
        Date d1 = new Date(1, 1, 1);
        System.out.println("Date should be 1/1/1: " + d1);
        d1 = new Date("2/4/2");
        System.out.println("Date should be 2/4/2: " + d1);
        d1 = new Date("2/29/2000");
        System.out.println("Date should be 2/29/2000: " + d1);
        d1 = new Date("2/29/1904");
        System.out.println("Date should be 2/29/1904: " + d1);

        d1 = new Date(12, 31, 1975);
        System.out.println("Date should be 12/31/1975: " + d1);
        Date d2 = new Date("1/1/1976");
        System.out.println("Date should be 1/1/1976: " + d2);
        Date d3 = new Date("1/2/1976");
        System.out.println("Date should be 1/2/1976: " + d3);

        Date d4 = new Date("2/27/1977");
        Date d5 = new Date("8/31/2110");

    /* I recommend you write code to test the isLeapYear function! */

        System.out.println("\nTesting before and after.");
        System.out.println(d2 + " after " + d1 + " should be true: " +
                d2.isAfter(d1));
        System.out.println(d3 + " after " + d2 + " should be true: " +
                d3.isAfter(d2));
        System.out.println(d1 + " after " + d1 + " should be false: " +
                d1.isAfter(d1));
        System.out.println(d1 + " after " + d2 + " should be false: " +
                d1.isAfter(d2));
        System.out.println(d2 + " after " + d3 + " should be false: " +
                d2.isAfter(d3));

        System.out.println(d1 + " before " + d2 + " should be true: " +
                d1.isBefore(d2));
        System.out.println(d2 + " before " + d3 + " should be true: " +
                d2.isBefore(d3));
        System.out.println(d1 + " before " + d1 + " should be false: " +
                d1.isBefore(d1));
        System.out.println(d2 + " before " + d1 + " should be false: " +
                d2.isBefore(d1));
        System.out.println(d3 + " before " + d2 + " should be false: " +
                d3.isBefore(d2));

        System.out.println("\ntest day in year");
        System.out.println(d1+":"+d1.dayInYear());
        System.out.println(d2+":"+d2.dayInYear());
        System.out.println(d3+":"+d3.dayInYear());
        System.out.println(d4+":"+d4.dayInYear());
        System.out.println(d5+":"+d5.dayInYear());

        System.out.println("\ntest day in year");
        System.out.println(d1+":"+d1.dayInYear());
        System.out.println(d2+":"+d2.dayInYear());
        System.out.println(d3+":"+d3.dayInYear());
        System.out.println(d4+":"+d4.dayInYear());
        System.out.println(d5+":"+d5.dayInYear());

        System.out.println("\nTesting difference.");
        System.out.println(d1 + " - " + d1  + " should be 0: " +
                d1.difference(d1));
        System.out.println(d2 + " - " + d1  + " should be 1: " +
                d2.difference(d1));
        System.out.println(d3 + " - " + d1  + " should be 2: " +
                d3.difference(d1));
        System.out.println(d3 + " - " + d4  + " should be -422: " +
                d3.difference(d4));
        System.out.println(d5 + " - " + d4  + " should be 48762: " +
                d5.difference(d4));

        System.out.println("\ntest day in year");
        System.out.println(d1+":"+d1.daysInMonth(d1.month, d1.year));
        System.out.println(d2+":"+d2.daysInMonth(d2.month, d2.year));
        System.out.println(d3+":"+d3.daysInMonth(d3.month, d3.year));
        System.out.println(d4+":"+d4.daysInMonth(d4.month, d4.year));
        System.out.println(d5+":"+d5.daysInMonth(d5.month,d5.year));

        System.out.println("\ntest deap year function");
        System.out.println(d5+":"+d5.isLeapYear(d5.year));
        System.out.println(d1+":"+d5.isLeapYear(d1.year));
        System.out.println(d2+":"+d5.isLeapYear(d2.year));
        System.out.println(d3+":"+d5.isLeapYear(d3.year));
        System.out.println(d4+":"+d5.isLeapYear(d4.year));

    }

}