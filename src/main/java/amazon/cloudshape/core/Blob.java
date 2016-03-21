package amazon.cloudshape.core;

import java.util.Objects;

/**
 * A blob is key-value tuple.
 */
public class Blob {

    private final String key;
    private final String value;

    public Blob(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Blob blob = (Blob) o;
        return Objects.equals(key, blob.key) &&
                Objects.equals(value, blob.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
}
