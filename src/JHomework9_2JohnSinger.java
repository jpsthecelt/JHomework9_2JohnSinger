import java.util.Collections;

public class JHomework9_2JohnSinger {

//    @incept:      Created on Mon, Nov 5 17:55:14 2018
//
//    @file:        JHomework9_2JohnSinger.java
//
//    @author:      John Singer
//
//    @description:  Pretty-printing Asterisks in different patterns; building strings for output...
//
//                  Things to Notice:
//                  - Initially, I implemented this as a 'nested' group of for-loops, but it was repetitive.
//                  I intuitively knew there was 'a better way'. Since a key 'tenet' of modern-day programming is
//                  to create small routines that 'do one thing well', but that are reusable, I knew there was
//                  'a better solution'.
//
//                  for example, I knew we could put the "new-line" println in the increment-step of the for loops,
//                  and make the for-loop a little 'cleaner'.
//
//                  - Additionally, I knew that I could use Collections consisting of a combination of '*'s and
//                  spaces to create a 'block' of output that would be either 'right-justified' or 'left-justified';
//                  one set would add '*'s by 'counting down', the other by 'counting up'.
//                  -) The '*'s are are created using the java 'Collections' member-function called nCopies() which
//                  are 'concatenated' together along with the empty-string "".
//
//                  - my plan became to create a generalized utility-function called outputTriangle().
//                  One way of making a generalized routine is to 'pass in' a function as a parameter, so I did this
//                  by using what are called 'lambda' functions (each of which is 'coupled' with an 'interface' or
//                  'template' -- in this case, something called myComparator. I also attempted to create an increment/
//                  decrement function, but failed, so I simply created a function with an if..then..else.:w
//
//                  -) When I was originally attempting this program as a couple of for-loops, I noticed that there
//                  were 5 differences between printing the 4 types of triangles: 1) the staring value,
//                  2) the ending value, 3) the end-loop-test, 4) Whether the loop-index was increasing or decreasing,
//                  and 5) the printf 'format' statement.  These became the parameters to my utility-function,
//                  outputTriangle().
//
//                  By doing this, we make it possible to create a single generalized routine that can be called with 4 different
//                  sets of parameters.


    // The interface used with the lambda-function.
    public interface myComparator {
        public boolean test(int idx, int t);
    }

    // The enum which signals either an increasing or decreasing for-loop
    public enum incr { INCR, DECR};

    // my 'generalized' function that outputs any of 4 different types of triangles, 'counting up' or 'counting down'
    public static void outputTriangle(int start, myComparator is, int endVal, incr inc, String fmtStr) {
        if (inc == inc.INCR) {
            for (int i = start; is.test(i, endVal); i++, System.out.println()) {
                System.out.printf(fmtStr, "".join("", Collections.nCopies(i, "*")));
            }
        } else {
            for (int i = start; is.test(i, endVal); i--, System.out.println()) {
                System.out.printf(fmtStr, "".join("", Collections.nCopies(i, "*")));
            }
        }
    }

    public static void main(String[] args) {

        // my 'lambda' functions, used for 'passing in' the loop-completion test
        myComparator isLE = (idx, guardVal) -> (idx <= guardVal);
        myComparator isGE = (idx, guardVal) -> (idx >= guardVal);

        System.out.printf("Creating pretty pattern A%n");
        outputTriangle(1, isLE, 10, incr.INCR, "%-10s");

        System.out.printf("%nCreating pretty pattern B%n");
        outputTriangle(10, isGE, 0, incr.DECR, "%-10s");

        System.out.printf("%nCreating pretty pattern C%n");
        outputTriangle(10, isGE, 0, incr.DECR, "%10s");

        System.out.printf("Creating pretty pattern D%n");
        outputTriangle(1, isLE, 10, incr.INCR, "%10s");


        System.out.printf("%nGAME OVER.... Thanks for playing!%n%n");
    }
}
