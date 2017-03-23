package algorithms;

import java.util.Comparator;



/**
 *
 * @author Tobias
 */
public class RedBlackBST<K,V>
{
    private RedBlackNode<K,V> rootNode;
    private Comparator<K> comparator;

    int length = 0;

    public RedBlackBST(Comparator<K> comp)
    {
        this.rootNode = null;
        this.comparator = comp;
    }

    public int getSize() {
        return length;
    }

    public void insert(K data, V value)
    {
        if(data == null) throw new NullPointerException("NULL");
        this.rootNode = insert(data, value, rootNode);
        this.rootNode.setIsRed(false);
    }

    public V get(K key) {
        RedBlackNode<K,V> x = rootNode;
        while (x != null) {
            int cmp = comparator.compare(key, x.getData());
            if (cmp < 0) {
                x = x.getLeft();
            } else if (cmp > 0) {
                x = x.getRight();
            } else {
                return x.getValue();
            }
        }
        return null;
    }

    private RedBlackNode<K,V> insert(K data, V value, RedBlackNode<K,V> h)
    {
        if(h == null) {
            length++;
            return new RedBlackNode<>(data,value);
        }
        int c = comparator.compare(data, h.getData());
        if(c < 0)
        {
            h.setLeft(insert(data, value, h.getLeft()));
        }
        else if(c > 0)
        {
            h.setRight(insert(data, value, h.getRight()));
        }
        else
        {
            h.setData(data);
            h.setValue(value);
            length++;
        }

        if(isRed(h.getRight()) && !isRed(h.getLeft()))
        {
            h = rotateLeft(h);
        }

        if(isRed(h.getLeft()) && isRed(h.getLeft().getLeft()))
        {
            h = rotateRight(h);
        }

        if(isRed(h.getLeft()) && isRed(h.getRight()))
        {
            flipColors(h);
        }
        return h;
    }

    private boolean isRed(RedBlackNode<K,V> node)
    {
        if(node == null) return false;
        return node.isRed();
    }

    private RedBlackNode<K,V> rotateLeft(RedBlackNode<K,V> h)
    {
        RedBlackNode<K,V> tmp = h.getRight();
        h.setRight(tmp.getLeft());
        tmp.setLeft(h);
        tmp.setIsRed(h.isRed());
        h.setIsRed(true);
        return tmp;
    }

    private RedBlackNode<K,V> rotateRight(RedBlackNode<K,V> h)
    {
        RedBlackNode<K,V> tmp = h.getLeft();
        h.setLeft(tmp.getRight());
        tmp.setRight(h);
        tmp.setIsRed(h.isRed());
        h.setIsRed(true);
        return tmp;
    }

    private void flipColors(RedBlackNode<K,V> h)
    {
        h.getLeft().setIsRed(false);
        h.getRight().setIsRed(false);
        h.setIsRed(true);
    }
}