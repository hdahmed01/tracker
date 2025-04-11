package hd.ahmed.runnerz.tasks;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
@CrossOrigin(origins = "http://localhost:58702")
public class TasksController {

    TaskRepository repo;
    public TasksController(TaskRepository repo) {
        this.repo = repo;
    }


    @GetMapping("")
    public List<Task> getTasks() {
        return repo.findAllTasks();
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void addTask(@RequestBody Task task) {
        repo.addTask(task);
    }
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id){
        repo.deletTask(id) ;

    }


}
