//description: https://leetcode.com/problems/license-key-formatting/description/
public class Leetcode482 {
    public static void main(String args[]) {
        String result = licenseKeyFormatting("---", 2);
        System.out.println(result);
    }

    public static String licenseKeyFormatting(String S, int K) {
        int total = 0;
        for(int i=0; i<S.length(); i++) {
            if(S.charAt(i) == '-') {
                continue;
            }
            total++;
        }
        int r = total%K;
        StringBuilder result = new StringBuilder();
        int i = 0;
        for(;i<S.length(); i++) {
            if(S.charAt(i) == '-') continue;
            if(r>0) {
                if(S.charAt(i)>='a' && S.charAt(i)<='z') {
                    result.append(Character.toUpperCase(S.charAt(i)));
                } else {
                    result.append(S.charAt(i));
                }
                r--;
            } else {
                break;
            }
        }
        result.append('-');
        int temp = K;
        for(;i<S.length();) {
            if(S.charAt(i) == '-') {
                i++;
                continue;
            }
            if(temp>0) {
                if(S.charAt(i)>='a' && S.charAt(i)<='z') {
                    result.append(Character.toUpperCase(S.charAt(i)));
                } else {
                    result.append(S.charAt(i));
                }
                temp--;
                i++;
            } else {
                temp = K;
                result.append('-');
            }
        }
        if(result.charAt(0) == '-') {
            result.deleteCharAt(0);
        }
        if(result.length() > 0 && result.charAt(result.length()-1) == '-'){
            result.deleteCharAt(result.length()-1);
        }
        return result.toString();
    }

    /*    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        char[] a = S.toCharArray();
        int dashes = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == '-') {
                dashes++;
            }
            else {
                if (a[i] >= 'a' && a[i] <= 'z') {
                    a[i] = (char)('A' + (a[i] - 'a'));
                }
            }
        }

        int remain = (a.length - dashes) % K;
        int i = 0;      //index to where put '-'
        for (char c : a) {
            if (c == '-') {
                continue;
            }
            if (remain > 0) {
                sb.append(c);
                remain--;
            }
            else {
                if (i % K == 0 && sb.length() > 0) {
                    sb.append('-');
                }
                i++;
                sb.append(c);
            }
        }
        return sb.toString();
    }*/
}
