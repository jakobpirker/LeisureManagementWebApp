package backend_main.services;

import backend_main.entities.Staff;
import backend_main.entities.Task;
import backend_main.repositories.StaffRepository;
import backend_main.repositories.TaskRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
public class TaskService extends AbstractService<Task, String, TaskRepository> {

    @Autowired
    private StaffRepository staff_repository_;

    @Override
    public Task save(Task save_task) {

        if (save_task.getStaff() == null && save_task.getStaffId() != null) {
            save_task.setStaff(staff_repository_.findOne(save_task.getStaffId()));
        }

        return this.base_repository_.save(save_task);
    }

    public String getJsonStringWithForeignIds() {

        JsonNode task = object_mapper_.valueToTree(new Task());
        JsonNode task_ids = object_mapper_.createArrayNode();

        Iterable<Staff> persons = staff_repository_.findAll();

        for (Iterator<Staff> i = persons.iterator(); i.hasNext(); ) {
            ((ArrayNode) task_ids).add(object_mapper_.valueToTree(i.next().getId()));
        }

        ((ObjectNode) task).put("Mitarbeiter", task_ids);

        return task.toString();
    }
}
