package hackerrank;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class CountElementsGreaterThanPreAvg {


    /*
     * Complete the 'countResponseTimeRegressions' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY responseTimes as parameter.
     */

    public int countResponseTimeRegressions(List<Integer> responseTimes) {
        // Write your code here
        int days = responseTimes.size();
        if (days <= 1 || days > 1000) {
            return 0;
        }

        int count = 0;
        // 用 long 防止相加溢位
        long totalResponseTime = responseTimes.get(0);
        for (int i = 1; i < days; i++) {
            long currentResponseTime = responseTimes.get(i);

            // 除法改成乘法, 避開浮點數
            if (currentResponseTime * i > totalResponseTime) {
                count++;
            }

            totalResponseTime += currentResponseTime;
        }
        return count;

    }

    public void doing(List<Integer> responseTimes) {
        int result = countResponseTimeRegressions(responseTimes);
        System.out.println("count:" + result);
    }
}

