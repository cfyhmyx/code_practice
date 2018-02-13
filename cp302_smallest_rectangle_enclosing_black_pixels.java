//An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel.
//The black pixels are connected, i.e., there is only one black region.
//Pixels are connected horizontally and vertically. Given the location (x, y) of one of the black pixels,
//return the area of the smallest (axis-aligned) rectangle that encloses all black pixels.

public class Leetcode302 {
    public static void main(String args[]) {
        char[][] image = {{'0','0','1','0'}, {'0','1','1','0'},{'0','1','0','0'}};
        int result = minArea(image, 0, 2);
        System.out.println(result);
    }

    //O(n^2)
    private static int left, right, top, bottom;

    public static int minArea(char[][] image, int x, int y) {
        left = image[0].length; top = image.length; right = 0; bottom=0;
        helper(image, x, y);
        return (right-left+1)*(bottom-top+1);
    }

    private static void helper(char[][] image, int row, int col) {
        if(row<0 || row>=image.length || col<0 || col>=image[0].length || image[row][col] =='0') return;
        image[row][col] = '0';
        left = Math.min(left, col);
        right = Math.max(right, col);
        top = Math.min(top, row);
        bottom = Math.max(bottom, row);
        helper(image, row+1, col);
        helper(image, row-1, col);
        helper(image, row, col+1);
        helper(image, row, col-1);
    }

    //O(mlogn + nlogm)
    /*public int minArea(char[][] image, int x, int y) {
        int left = leftmost(image, 0, y, true);
        int right = rightmost(image, y, image[0].length - 1, true);
        int top = leftmost(image, 0, x, false);
        int bottom = rightmost(image, x, image.length - 1, false);
        return (right - left + 1) * (bottom - top + 1);
    }

    int leftmost(char[][] image, int min, int max, boolean horizontal) {
        int l = min, r = max;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (!hasBlack(image, mid, horizontal)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    int rightmost(char[][] image, int min, int max, boolean horizontal) {
        int l = min, r = max;
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (!hasBlack(image, mid, horizontal)) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return r;
    }

    boolean hasBlack(char[][] image, int mid, boolean horizontal) {
        if (horizontal) {
            for (int i = 0; i < image.length; i++) {
                if (image[i][mid] == '1') {
                    return true;
                }
            }
        } else {
            for (int j = 0; j < image[0].length; j++) {
                if (image[mid][j] == '1') {
                    return true;
                }
            }
        }
        return false;
    }*/

}
