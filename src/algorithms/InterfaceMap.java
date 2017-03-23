package algorithms;

/**
 * Created by mazlumsert on 23/03/2017.
 */
public interface InterfaceMap<Key, Value> {

    void put(Key key, Value value);

    Value get(Key key);

    int size();


}
