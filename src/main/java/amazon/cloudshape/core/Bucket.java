package amazon.cloudshape.core;

import java.util.Objects;

/**
 * A bucket maintains a arbitrary set of blobs and acts like a namespace.
 * Each bucket is identified by a unique name.
 */
public class Bucket {

    private final String name;

    public Bucket(String name) {
        Objects.requireNonNull(name);

        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bucket bucket = (Bucket) o;
        return Objects.equals(name, bucket.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
