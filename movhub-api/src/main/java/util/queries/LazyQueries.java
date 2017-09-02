package util.queries;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by Moreira on 01-09-2017.
 */
public class LazyQueries {

    public static <T> Iterable<T> filter(Iterable<T>  data, Predicate<T> p){
        return () -> new IteratorFilter(data.iterator(), p);

    }


    public static <T,R> Iterable<R> map(Iterable<T>  data, Function<T, R> mapper){
        return null;
    }


    public static <T> int count(Iterable<T>  data){
        int size =0;
        for(T item: data){
            size++;
        }
        return size;
    }

    public static <T> String join(Iterable<T> src) {
        String res = "";
        for (T item: src) {
            res += item.toString();
        }
        return res;
    }
}
