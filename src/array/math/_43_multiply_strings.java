package array.math;

/**
 * Trick:
 *  1. 高低位对应清楚
 *
 *  123
 *  String 的最高位 其实是 最小值
 *
 *  所以之后取出的 低位数组，其实是string的高位，一直往下append就行
 *
 *  取余得低位， 取商相加，得高位
 *
 *  2. 一个special case
 *
 *  if(!(sb.length() == 0 && val ==0)) sb.append(val)
 *
 *  T:O(M*N) S:O(M+N)
 *
 *  3. return 依旧 考虑 "0"
 *  return sb.length() == 0? "0" :sb.toString();
 *
 *
 *  6/15/20.
 */
public class _43_multiply_strings {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        int m = num1.length();
        int n = num2.length();

        int[] pos = new int[m+n];
        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                int val = (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
                // 原来是有值的
                //System.out.println(val);
                int sum = val+pos[i+j+1];

                pos[i+j] += sum/10;
                pos[i+j+1] = sum%10;
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int digit: pos){
            if(!(sb.length()==0 && digit==0)){
                sb.append(digit);
            }
        }
        return sb.length() == 0? "0" :sb.toString();
    }

    public static void main(String[] args){
        _43_multiply_strings solution = new _43_multiply_strings();

        String res = solution.multiply( "123", "456");
        System.out.println(res);
    }
}