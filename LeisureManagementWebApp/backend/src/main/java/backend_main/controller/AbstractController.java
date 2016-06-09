package backend_main.controller;

import backend_main.services.AbstractServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


public abstract class AbstractController<T_obj extends Object, T_serv extends AbstractServiceInterface<T_obj>> {

    @Autowired
    protected T_serv service_;

    @RequestMapping(method = RequestMethod.GET)
    public String getRequest() { return service_.getJsonStringObjectWithForeignIds(); }

    @RequestMapping(method = RequestMethod.POST)
    public T_obj postRequest(@RequestBody T_obj new_address) {
        return this.service_.save(new_address);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Iterable<T_obj> getList() {
        return service_.getList();
    }
}
