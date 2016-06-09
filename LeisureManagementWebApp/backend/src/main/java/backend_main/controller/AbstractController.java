package backend_main.controller;

import backend_main.services.AbstractServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.logging.Logger;


public abstract class AbstractController<T_obj extends Object, T_serv extends AbstractServiceInterface<T_obj>> {

    @Autowired
    protected T_serv service_;

    private final static Logger log = Logger.getLogger(AbstractController.class.getName());

    @RequestMapping(method = RequestMethod.GET)
    public String getRequest() {
        return service_.getJsonStringWithForeignIds();
    }

    @RequestMapping(method = RequestMethod.POST)
    public T_obj postRequest(@RequestBody T_obj new_obj) {
        return this.service_.save(new_obj);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteRequest(@RequestBody T_obj delete_obj) {
        this.service_.delete(delete_obj);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Iterable<T_obj> getList() {
        return service_.getList();
    }
}
