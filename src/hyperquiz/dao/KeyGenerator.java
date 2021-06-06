package hyperquiz.dao;

import java.io.Serializable;

@FunctionalInterface // SAM
public interface KeyGenerator<K> {
    K getNextId();
}
