package util;

import java.io.InputStream;
import java.util.function.Function;

/**
 * Created by Moreira on 01-09-2017.
 */
public abstract class Request implements IRequest {

    final Function<String, InputStream> getStream;

    public Request(Function<String, InputStream> getStream){
        this.getStream = getStream;
    }
    @Override
    public Iterable<String> getContent(String path) {
        return () -> new IteratorFromReader(getStream.apply(path));
    }


}
