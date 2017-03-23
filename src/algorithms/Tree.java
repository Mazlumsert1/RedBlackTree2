package algorithms;

import java.util.Comparator;

/**
 * Created by mazlumsert on 23/03/2017.
 */
public class Tree<Key, Value> implements InterfaceMap<Key, Value> {

    private RedBlackBST<Key, Value> redBlackTree;

    public Tree() {
        redBlackTree = new RedBlackBST(Comparator.naturalOrder());
    }

    @Override
    public void put(Key key, Value value) {
        redBlackTree.insert(key, value);

    }

    @Override
    public Value get(Key k) {
        return redBlackTree.get(k);
    }

    @Override
    public int size() {
        return redBlackTree.getSize();
    }
}
