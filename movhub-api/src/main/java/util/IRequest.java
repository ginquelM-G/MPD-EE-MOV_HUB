package util;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

/**
 * Created by User01 on 28/08/2017.
 */
public interface IRequest extends AutoCloseable{

    CompletableFuture<Stream<String>> getContent(String path);

    @Override
    public default void close(){}

}
