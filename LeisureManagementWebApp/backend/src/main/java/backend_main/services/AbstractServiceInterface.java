package backend_main.services;

public interface AbstractServiceInterface<T_obj> {
    public String getJsonStringWithForeignIds();
    public T_obj save(T_obj new_obj);
    public Iterable<T_obj> getList();
    public void delete(T_obj delete_obj);

}
