package backend_main.controller;

import backend_main.entities.Task;
import backend_main.services.TaskService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class TaskController  extends AbstractController<Task, TaskService>{
}
