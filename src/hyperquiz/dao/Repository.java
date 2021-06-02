package hyperquiz.dao;



import hyperquiz.exceptions.EntityAlreadyExistsException;
import hyperquiz.exceptions.EntityDataInvalidException;
import hyperquiz.model.Identifiable;

import java.util.List;
import java.util.Optional;

public interface Repository<K, V extends Identifiable<K>> {
    List<V> findAll();
    Optional<V> findById(K id);
    V create(V entity) throws EntityAlreadyExistsException;
    V update(V entity) throws EntityDataInvalidException;
    V deleteById(K id) throws EntityDataInvalidException;
    long count();
}
