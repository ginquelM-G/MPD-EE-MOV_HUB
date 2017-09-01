package util;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.net.URL;

/**
 * Created by User01 on 28/08/2017.
 */
public class HttpRequest  extends AbstractRequest {

    @Override
    protected InputStream getStream(String path) {
        InputStream in;
        try{
            return in = new URL(path).openStream();
        }catch (IOException e){
            throw new UncheckedIOException(e);
        }
    }

}
