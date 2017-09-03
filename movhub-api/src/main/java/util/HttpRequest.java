package util;

import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.Dsl;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.net.URL;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

/**
 * Created by User01 on 28/08/2017.
 */
public class HttpRequest  implements IRequest {

    private final AsyncHttpClient asyncHttpClient = Dsl.asyncHttpClient();

    @Override
    public CompletableFuture<Stream<String>> getContent(String path) {

        return null;
    }

    public static InputStream getStream(String path) {
        InputStream in;
        try{
            return in = new URL(path).openStream();
        }catch (IOException e){
            throw new UncheckedIOException(e);
        }
    }


}
