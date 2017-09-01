package util;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by User01 on 28/08/2017.
 */
public class FileRequest implements IRequest {
    @Override
    public Iterable<String> getContent(String path) {
        String [] parts = path.split("/");
        path = parts[parts.length-1].substring(0, 5);
        path = "search-"+path+".txt";
        System.out.println("PATH:" + path);
        ArrayList<String> res = new ArrayList<>();
        try(InputStream in = ClassLoader.getSystemResource(path).openStream()){
             /*
             * Consumir o Inputstream e adicionar dados ao res
             */
            Iterator<String> iter = new IteratorFromReader(in);
            return () -> iter;
//            try(BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
//                String line;
//                while ((line = reader.readLine()) != null) {
//                    res.add(line);
//                }
//            }
        }catch (IOException e){
            throw new UncheckedIOException(e);
        }
    }
}
