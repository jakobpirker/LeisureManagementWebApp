package backend_main.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface AbstractRepository<T_obj, T_id extends Serializable> extends CrudRepository<T_obj, T_id> {
    Iterable<T_obj> findAllByOrderByIdAsc();
}
