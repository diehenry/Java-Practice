package leetcode;

public class ReverseInteger {
    public int reverse(int x) {
        int rev = 0;

        boolean isMinus = x < 0;
        String str = String.valueOf(Math.abs(x));
        StringBuilder sb = new StringBuilder(str).reverse();

//        if (x == 0) {
//            return x;
//        } else if (x < 0) {
//            x *= -1;
//            isMinus = true;
//        }

//        while (x > 0) {
//            sb.append(x % 10);
//            x = x / 10;
//        }

        try {
            rev = Integer.parseInt(sb.toString());
//            if (isMinus) {
//                rev *= -1;
//            }
        } catch (NumberFormatException e) {
            return 0;
        }

        return isMinus ? -rev : rev;
    }
}
