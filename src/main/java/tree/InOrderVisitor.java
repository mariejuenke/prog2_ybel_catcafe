package tree;
import static java.util.Objects.requireNonNull;

public class InOrderVisitor<T extends Comparable<T>> implements TreeVisitor<T> {

    @Override
    public String visit(Empty<T> node) {
        requireNonNull(node);
        return node.data().toString();
    }

    @Override
    public String visit(Node<T> node) {
        requireNonNull(node);
        if(node.isEmpty()){
            return "";
        }
        String leftChild =node.leftChild().accept(this);
        String rightChild = node.rightChild().accept(this);

        return leftChild + node.data().toString() + rightChild;
    }
}
