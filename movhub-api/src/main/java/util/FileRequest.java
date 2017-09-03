package util;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by User01 on 28/08/2017.
 */
public class FileRequest implements IRequest {


    @Override
    public CompletableFuture<Stream<String>> getContent(String path) {
        return CompletableFuture.supplyAsync(() -> {
            return getStream(path);
        });
    }

    protected static Stream<String> getStream(String path) {
        String [] parts = path.split("/");
        path = parts[parts.length-1].substring(0, 5);
        path = "search-"+path+".txt";
        System.out.println("PATH:" + path);
        ArrayList<String> res = new ArrayList<>();
        try{
            InputStream in = ClassLoader.getSystemResource(path).openStream();
            return StreamSupport.stream(new IteratorFromReader(in), false);
        }catch (IOException e){
            throw new UncheckedIOException(e);
        }
    }


    @Override
    public void close() {

    }
}
