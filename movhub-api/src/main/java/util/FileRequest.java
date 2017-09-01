package util;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.util.ArrayList;

/**
 * Created by User01 on 28/08/2017.
 */
public class FileRequest extends Request {


    public FileRequest() {
        super(FileRequest::getStream);
    }

    protected static InputStream getStream(String path) {
        String [] parts = path.split("/");
        path = parts[parts.length-1].substring(0, 5);
        path = "search-"+path+".txt";
        System.out.println("PATH:" + path);
        ArrayList<String> res = new ArrayList<>();
        InputStream in;
        try{
            return in = ClassLoader.getSystemResource(path).openStream();
        }catch (IOException e){
            throw new UncheckedIOException(e);
        }
    }
}
