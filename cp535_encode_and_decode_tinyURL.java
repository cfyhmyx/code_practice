//TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and
//it returns a short URL such as http://tinyurl.com/4e9iAk. Design the encode and decode methods for the TinyURL service.
//There is no restriction on how your encode/decode algorithm should work. You just need to ensure that a URL can
//be encoded to a tiny URL and the tiny URL can be decoded to the original URL.

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Leetcode535 {
    public static void main(String args[]) {

    }

    public class Codec {

        private Map<Integer, String> map = new HashMap<>();
        private Random r=new Random();

        public String encode(String longUrl) {

            int key=r.nextInt(10000);
            while(map.containsKey(key))
                key= r.nextInt(10000);
            map.put(key,longUrl);
            return "http://tinyurl.com/"+key;
        }

        public String decode(String shortUrl) {
            return map.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
        }
    }

}
