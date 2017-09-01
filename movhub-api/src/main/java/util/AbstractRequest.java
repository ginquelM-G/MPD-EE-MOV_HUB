package util;

import java.io.InputStream;

/**
 * Created by Moreira on 01-09-2017.
 */
public abstract class AbstractRequest implements IRequest {

    @Override
    public Iterable<String> getContent(String path) {
        return () -> new IteratorFromReader(getStream(path));
    }

    protected abstract InputStream getStream(String path);
}
