package backend_main.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public abstract class AbstractService<T_obj, T_id extends Serializable, T_rep extends CrudRepository<T_obj, T_id>> implements AbstractServiceInterface<T_obj>{

    @Autowired
    protected T_rep base_repository_;

    protected ObjectMapper object_mapper_ = new ObjectMapper();

    public T_obj save(T_obj save_object){
        return this.base_repository_.save(save_object);
    }

    public Iterable<T_obj> getList(){
        return base_repository_.findAll();
    }
}
