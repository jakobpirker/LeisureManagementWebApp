package backend_main.services;

public interface AbstractServiceInterface<T_obj> {
    public String getJsonStringObjectWithForeignIds();
    public T_obj save(T_obj new_obj);
    public Iterable<T_obj> getList();

}
