package hw1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by qiuying on 2020/12/14.
 */

public class nuke2 {
    public static void main(String[] arg) throws Exception {

        BufferedReader keyboard;
        String inputLine;

        keyboard = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Please enter the name of a string (without spaces): ");
        System.out.flush();        /* Make sure the line is printed immediately. */
        inputLine = keyboard.readLine();
        StringBuilder results  = new StringBuilder(inputLine);
        String nuke2 = results.deleteCharAt(1).toString();
        System.out.println(nuke2);

    }
}