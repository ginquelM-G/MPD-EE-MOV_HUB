package util;

/**
 * Created by User01 on 28/08/2017.
 */
public interface IRequest {

    Iterable<String> getContent(String path);
}
