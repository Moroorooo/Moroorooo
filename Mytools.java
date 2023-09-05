/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trietnm.util;

/* Công cụ thông dụng trong các chương trình */
import java.util.Date;
// Lớp mô tả ngày tháng
import java.text.SimpleDateFormat;
// Lớp giúp định dạng ngày tháng
import java.text.DateFormat;
// Lớp giúp định dạng ngày tháng
import java.text.ParseException;
// Lớp mô tả lỗi khi phân tích String
import java.util.Calendar;
// Lớp mô tả cho lịch nói chung
import java.util.GregorianCalendar; // Lớp mô tả cho dương lịch ngày nay
import java.util.Scanner;
// Lớp nhập dữ liệu

/**
 *
 * @author shinr
 */
public class Mytools {

    public static final Scanner sc = new Scanner(System.in);

    /**
     * Parsing the input string to get a boolean data (true/false)
     *
     * @param input: input string
     * @return true if the first character in input is 'T' or '1' or 'Y'
     */
    public static boolean parseBoolean(String input) {
        input = input.trim().toUpperCase();// chuẩn hoá chuỗi nhập 
        char c = input.charAt(0);// Lấy ký tự đầu của chuỗi nhập
        return c == 'T' || c == '1' || c == 'Y';// trả trị true nếu ký tự này là T, 1, Y
    }

    /**
     * Normalizing a date string: Using - to separate date parts only
     *
     * @param dateStr: input date string
     * @return new string
     */
    //" 7... 2 //---// 2023 "--> "7-2-2013"
    public static String normalizeDateStr(String dateStr) {
            // Loại bỏ tất cả các khoảng trống trong chuỗi nhập. Dùng replaceAll() với
            // regex phủ hợp " 7 ... --- 2 |||| 2023 "--> "7...---2////2023"
        String result = dateStr.replaceAll("[\\s]+", ""); // Thay thế tất cả các nhóm ký tự . / - bằng '-'. Dùng replaceAll() với regex
        // phù hợp "7...---2||||2023" --> "7-2-2023" rồi trả kết quả sau khi đã xử lý
        result = result.replaceAll("[./-]+", "-");
        return result;
    }

    /**
     * Parsing the input string to date data
     *
     * @param inputStr: date string input.
     * @param date Format: chosen date format.
     * @return Date object if successful and null if failed
     */
    public static Date parseDate(String inputStr, String dateFormat) {
        inputStr = normalizeDateStr(inputStr);// chuẩn hóa chuỗi ngày tháng 
        DateFormat formatter = new SimpleDateFormat(dateFormat);// Tạo Date Format formatter
        try { // Dùng formatter parse chuỗi nhập rồi trả kết quả
            return formatter.parse(inputStr);
        } catch (ParseException e) {
            System.err.println(e);
        }
        return null; // không phân tích thành công thì trả về null
    }

    /**
     * Convert a Date object to string using a given date format
     *
     * @param date: Date object
     * @param date Format: chosen date format
     * @return date string in the given format
     */
    public static String toString(Date date, String dateFormat) {
        if (date == null) {
            return "";
        }
        // Tạo DateFormat object làm việc với định dạng trong tham số thứ hai
        DateFormat formatter = new SimpleDateFormat(dateFormat);
        // rồi trả kết quả sau khi đã chuyển dạng
        return formatter.format(date);
    }

    /**
     * Getting year of date data
     *
     * @param d: Date data
     * @param calendarPart: date part is declared in the class Calendar
     * @return year in date data.
     */
    public static int getPart(Date d, int calendarPart) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(d);
        return cal.get(calendarPart);
    }
    //--- METHODS FOR READING DATA FROM KEYBOARD

    /**
     * Reading a boolean data
     */
    public static boolean readBoolean(String prompt) {
        System.out.print(prompt + ": ");
        return parseBoolean(sc.nextLine());
    }

    /**
     * Reading a string using a pre-define pattern * @param prompt: prompt will
     * be printed befor inputting.
     *
     * @param pattern: pre-defined pattern of input
     * @return an input string which matches the pattern.
     */
    public static String readStr(String prompt, String pattern) {
        String input;
        boolean valid = false;
        do {
            System.out.print(prompt + ": ");
            input = sc.nextLine().trim();
            valid = input.matches(pattern);
        } while (valid == false);
        return input;
    }

    /**
     * Reading a date data using a pre-define date format dd-MM-XXXX/MM-dd-XXXX
     * XXXX-MM-dd
     *
     * @param prompt: prompt will be printed befor inputting
     * @param pattern: pre-defined pattern of input
     * @return an input string which matches the pattern.
     */
    public static Date readDate(String prompt, String dateFormat) {
        String input;
        Date d;
        do {
            System.out.print(prompt + ": ");
            input = sc.nextLine().trim();
            d = parseDate(input, dateFormat);
            if (d == null) {
                System.out.println("Date data is not valid!");
            }
        } while (d == null);
        return d;
    }
    // Nhập ngáy tháng sau một ngày cho trước

    public static Date readDateAfter(String prompt, String dateFormat, Date markerDate) {
        String input;
        Date d;
        boolean ok = false;
        do {
            System.out.print(prompt + ": ");
            input = sc.nextLine().trim();
            d = parseDate(input, dateFormat);
            ok = (d != null && d.after(markerDate));
            if (d == null) {
                System.out.println("Date data is not valid!");
            }
        } while (!ok);
        return d;
    }
// Nhập ngày tháng trước một ngày chỗ trước

    public static Date readDateBefore(String prompt, String dateFormat, Date markerDate) {
        String input;
        Date d;
        boolean ok = false;
        do {
            System.out.print(prompt + ": ");
            input = sc.nextLine().trim();
            d = parseDate(input, dateFormat);
            ok = (d != null && d.before(markerDate));
            if (d == null) {
                System.out.println("Date data is not valid!");
            }
        } while (!ok);
        return d;
    }
    // Automatically generating an increasing code
    // Thí dụ sinh ra mã: F0000123 -> prefix: F, length=7, curNumber= 123

    public static String generateCode(String prefix, int length, int curNumber) {
        String formatStr = "%0" + length + "d"; // -> #07d 
        return prefix + String.format(formatStr, curNumber);
    }
    // TESTS

    public static void main(String[] args) {
        System.out.println("Test boolean string: "); // Test boolean string
        System.out.println(parseBoolean(" TRUE"));
        System.out.println(parseBoolean(" FALSE "));
        System.out.println(parseBoolean(" 1234"));
        System.out.println(parseBoolean(" 01 23 "));
        System.out.println(parseBoolean(" total "));
        System.out.println(parseBoolean(" cosine "));
        System.out.println("Test normalizeDateStr(String):");
        String S = " 7... --- 2 / 2023  ";
        System.err.println(S + " --> " + normalizeDateStr(S));
        S = "7 ... 2 //// 2023  ";
        System.err.println(S + " --> " + normalizeDateStr(S));
        //Tests date <--> String
        System.out.println("\nTest Date <--> String: ");
        String[] formats = {"yyyy-MM-dd", "MM-dd-yyyy", "dd-MM-yyyy"};
        String[] dStrs = {" 2023-02-21 ", " 12.-- 25 - 2023 ", " 7..2// 2023"};
        Date d = null;
        for (int i = 0; i < 3; i++) {
            System.out.println(dStrs[i] + "(" + formats[i] + ")");
            d = parseDate(dStrs[i], formats[i]);
            if (d != null) {
                System.out.println("Year: " + getPart(d, Calendar.YEAR));
                System.out.println("----> Result: " + d);
                System.out.println("----> In the format " + formats[i] + ": "+ toString(d, formats[i]));

            } else {
                System.out.println("Parsing error!");
            }
            // Test reading a boolean
            System.out.println("Test reading a boolean data");
            boolean b = readBoolean("Input a boolean data (T/F, 1/0, Y/N)");
            System.out.println(b + " inputted");
            //Test input a date data
            System.out.println("Test input a date data");
            d = readDate("Input a data data (dd-mm-yyyy)", "dd-MM-yyyy");
            System.out.println("Inputted date:");
            System.out.println("In format dd-MM-yyyy: " + toString(d, "dd - MM - yyyy"));
            System.out.println("In format MM-dd-yyyy: " + toString(d, "MM - dd - yyyy"));
            System.out.println("In format yyyy-MM-dd: " + toString(d, "yyyy - MM - dd"));
            // Test inputting a phone number including 9..11 digits
            String phoneNo = readStr("Phone number (9..11 digits)", "[\\d]{9,11}");
            System.out.println("Inputted phone no. :" + phoneNo);
            //Testing for generating an automatic code
            System.out.println("Testing for generating an automatic code");
            String prefix = "P";
            int curNumber = 25;
            int len = 7;
            String code = generateCode(prefix, len, curNumber);
            curNumber++;
            System.out.println("Generated code: " + code);
            code = generateCode(prefix, len, curNumber);
            System.out.println("Generated code: " + code);
            //Test reading date data before and after today
            System.out.println("Testing reading date data before and after today");
            Date today = new Date();
            System.out.println("Today: "+ Mytools.toString (d, "dd - MM - yyyy"));
            Date dBefore = Mytools.readDateBefore("Date before today", "dd-MM-yyyy", today);
            System.out.println(Mytools.toString(dBefore, "dd-MM-yyyy"));
            Date dAfter = Mytools.readDateAfter("Date after today", "dd-MM-yyyy", today);
            System.out.println(Mytools.toString(dAfter, "dd-MM-yyyy"));
            
        } 

    // main()
    
    }// class MyTools
}
