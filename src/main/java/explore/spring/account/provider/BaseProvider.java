package explore.spring.account.provider;

import java.util.function.Function;

public abstract class BaseProvider<T> {
    private T entity;

    protected  <V> T findEntity(Function<V, T> findFunction, V value) {
        if (entity == null) {
            entity = findFunction.apply(value);
        }
        return entity;
    }
}
