package leetcode;

public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (s.isEmpty() || s.length() > 1000) {
            throw new RuntimeException("1 <= input str length <= 1000");
        }
        if (numRows < 0 || numRows > 1000) {
            throw new RuntimeException("1 <= numRows <= 1000");
        }

        String output = "";
        if (numRows == 1 || numRows >= s.length()) {
            output = s;
        } else {
            StringBuilder[] rows = new StringBuilder[numRows];
            for (int i = 0; i < numRows; i++) {
                rows[i] = new StringBuilder();
            }

            int curRow = 0;
            boolean goDown = false;
            for (char c : s.toCharArray()) {
                rows[curRow].append(c);
                if (curRow == numRows - 1 || curRow == 0) {
                    goDown = !goDown;
                }

                curRow += goDown ? 1 : -1;
            }

            StringBuilder result = new StringBuilder();
            for (StringBuilder row : rows) {
                result.append(row);
            }
            output = result.toString();
        }

        return output;
    }
}
