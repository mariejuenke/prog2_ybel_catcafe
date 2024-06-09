package catcafe;

import static java.util.Objects.requireNonNull;

import tree.Empty;
import tree.Tree;
import tree.TreeVisitor;

import java.util.Optional;

public class CatCafe {
    private Tree<FelineOverLord> clowder = new Empty<>();

    public void addCat(FelineOverLord cat) {
        clowder = clowder.addData(requireNonNull(cat));
    }

    public long getCatCount() {
        return clowder.size();
    }

    public Optional<FelineOverLord> getCatByName(String name) {
        requireNonNull(name);

        for (FelineOverLord c : clowder) {
            if (c.name().equals(name)) return Optional.ofNullable(c);
        }

        return Optional.empty();
    }

    public Optional<FelineOverLord> getCatByWeight(int minWeight, int maxWeight) {
        if (minWeight < 0) return null;
        if (maxWeight < minWeight) return null;

        for (FelineOverLord c : clowder) {
            if (c.weight() >= minWeight && c.weight() < maxWeight) return Optional.ofNullable(c);
        }

        return Optional.empty();
    }

    String accept(TreeVisitor<FelineOverLord> visitor) {
        return clowder.accept(visitor);
    }
}
