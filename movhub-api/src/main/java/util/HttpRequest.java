package util;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by User01 on 28/08/2017.
 */
public class HttpRequest  implements IRequest {

    @Override
    public Iterable<String> getContent(String path) {
        List<String> res = new ArrayList<>();
        try(InputStream in = new URL(path).openStream()){
            // Consumir o Inputstream e adicionar ao res
            Iterator<String> iter = new IteratorFromReader(in);
            return () -> iter;
//            try (BufferedReader reader = new BufferedReader(new InputStreamReader(in))){
//                String line;
//                while((line = reader.readLine()) != null){
//                    res.add(line);
//                }
//
//            }

        }catch (IOException e){
            throw new UncheckedIOException(e);
        }
    }
}
