package util;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Created by Moreira on 02-09-2017.
 */
public class Cache {

    public static <T,R> Function<T, R> memoize(Function<T,R> src){
        final Map<T,R> data = new HashMap<>();
        return key ->{
            R res = data.get(key);
            if(data == null){
                res = src.apply(key);
                data.put(key, res);
            }
            return res;
        };
    }
}

