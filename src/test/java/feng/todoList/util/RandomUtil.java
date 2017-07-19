package feng.todoList.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * Created by 10503313 on 2017/7/19.
 */
public class RandomUtil {

    public static Random random = new Random();

    public static String randomString() {
        return UUID.randomUUID().toString();
    }

    public static int randomPositiveInt(int limit) {
        return Math.abs(random.nextInt(limit));
    }

    /*
     * @Return YYYYMMDDHHMMSS
     */
    public static String randDateTime() {
        Random  rnd = new Random();
        long ms = -946771200000L + (Math.abs(rnd.nextLong()) % (70L * 365 * 24 * 60 * 60 * 1000));
        Date date = new Date(ms);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(date);
    }

    public static boolean randomBoolean() {
        return Math.random() < 0.5;
    }
}
