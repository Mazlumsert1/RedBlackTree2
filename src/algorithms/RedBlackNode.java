package algorithms;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tobias
 */
public class RedBlackNode<K,V>
{
    private K data;
    private V value;
    private RedBlackNode<K,V> left;
    private RedBlackNode<K,V> right;
    private boolean isRed;

    public RedBlackNode(K data, V value)
    {
        this.data = data;
        this.left = null;
        this.right = null;
        this.isRed = true;
    }

    public K getData()
    {
        return data;
    }



    public void setData(K data)
    {
        this.data = data;
    }

    public void setValue(V value)
    {
        this.value = value;
    }

    public V getValue()
    {
        return value;
    }


    public RedBlackNode<K,V> getLeft()
    {
        return left;
    }

    public void setLeft(RedBlackNode left)
    {
        this.left = left;
    }

    public RedBlackNode<K,V> getRight()
    {
        return right;
    }

    public void setRight(RedBlackNode right)
    {
        this.right = right;
    }

    public boolean isRed()
    {
        return isRed;
    }

    public void setIsRed(boolean isRed)
    {
        this.isRed = isRed;
    }
    
    
    
    
}
