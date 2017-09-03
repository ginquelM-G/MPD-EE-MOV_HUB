package util;

import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.Dsl;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

import static java.util.stream.StreamSupport.stream;


/**
 * Created by User01 on 28/08/2017.
 */
public class HttpRequest  implements IRequest {

    private final AsyncHttpClient asyncHttpClient = Dsl.asyncHttpClient();

    @Override
    public CompletableFuture<Stream<String>> getContent(String path) {
        return asyncHttpClient
                .prepareGet(path)
                .execute()
                .toCompletableFuture()
                .thenApply(resp -> resp.getResponseBodyAsStream()) // igual a Stream::map
                .thenApply(in -> stream(new IteratorFromReader(in), false));
    }

    @Override
    public void close() {
        if(asyncHttpClient.isClosed()){
            try{
                asyncHttpClient.close();
            }catch (IOException e){
                throw new RuntimeException(e);
            }
        }
    }
}
