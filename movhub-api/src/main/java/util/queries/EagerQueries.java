package util.queries;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by Moreira on 01-09-2017.
 */
public class EagerQueries {

    public static <T> Iterable<T> filter(Iterable<T>  data, Predicate<T> p){
        List<T> res = new ArrayList<>();
        for(T item: data){
            if(p.test(item)){
                res.add(item);
            }
        }
        return res;
    }


    public static <T,R> Iterable<R> map(Iterable<T>  data, Function<T, R> mapper){
        List<R> res = new ArrayList<>();
        for(T item: data){
            res.add(mapper.apply(item));
        }
        return res;
    }


    public static <T> int count(Iterable<T>  data){
        int size =0;
        for(T item: data){
           size++;
        }
        return size;
    }
}
