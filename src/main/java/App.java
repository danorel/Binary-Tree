import bt.ds.BinaryTree;

public class App {
    public static void main(String[] args) {
        Integer []Array = DataGenerator.generateIntegerRandomData(10);
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.asBT(Array);
    }
}
