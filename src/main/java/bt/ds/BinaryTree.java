package bt.ds;

import java.util.Comparator;

public class BinaryTree<T> {
    private Leaf root;

    public BinaryTree(){
        this((T) null);
    }

    public BinaryTree(T key){
        root = new Leaf<>(key);
    }

    public BinaryTree(T []Array){
        if(Array.length > 0 && Array[0] instanceof Number){
            asBT(Array);
        } else {
            System.exit(-1);
        }
    }

    public void asBT(T []Array){
        asBT(Array, null);
    }

    public void asBT(T []Array, Comparator comparator){
        if(Array.length > 0 && comparator != null){
            root = new Leaf(Array[0]);
            buildBT_WithC(root, 1, Array, comparator);
        } else if(Array.length > 0 && comparator == null){
            root = new Leaf(Array[0]);
            buildBT_WithoutC(root, 1, Array);
        }
    }

    private void buildBT_WithC(Leaf leaf, int index, T []Array, Comparator comparator){
        if(leaf != null){
            if(comparator.compare(Array[index], leaf.key) > 0){
                buildBT_WithC(leaf.leftPtr, ++index, Array, comparator);
            } else {
                buildBT_WithC(leaf.rightPtr, ++index, Array, comparator);
            }
        }
    }

    private void buildBT_WithoutC(Leaf leaf, int index, T []Array){
        if(leaf != null){
            if(leaf.key > Array[index]){
                if(leaf.leftPtr == null){
                    leaf.leftPtr = new Leaf(Array[index]);
                } else {
                    buildBT_WithoutC(leaf.leftPtr);
                }
            } else {

            }
        }
    }

    public T[] asArray(){
        return null;
    }


    private class Leaf<E>{
        private E key;
        private Leaf leftPtr;
        private Leaf rightPtr;

        public Leaf(E key){
            this.key = key;
        }
    }
}
