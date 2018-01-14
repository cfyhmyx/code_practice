//The API: int read4(char *buf) reads 4 characters at a time from a file.
//The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
//By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
//The read function may be called multiple times.

public class Leetcode158 {
    public static void main(String args[]) {
    }

/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

    public class Solution {
        /**
         * @param buf Destination buffer
         * @param n   Maximum number of characters to read
         * @return The number of characters read
         */
        char[] prevBuf = new char[4];
        int prevSize = 0;
        int prevIndex = 0;

        public int read(char[] buf, int n) {
            int counter = 0;

            while (counter < n) {
                if (prevIndex < prevSize) {
                    buf[counter++] = prevBuf[prevIndex++];
                } else {
                    prevSize = read4(prevBuf);
                    prevIndex = 0;
                    if (prevSize == 0) {
                        // no more data to consume from stream
                        break;
                    }
                }
            }
            return counter;
        }

        //faked function
        private int read4(char[] buff) {
            return 0;
        }
    }
}

