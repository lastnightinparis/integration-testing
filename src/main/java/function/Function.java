package function;

public interface Function<K, V> {
    V apply(K a, K b);
}
