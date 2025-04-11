package hd.ahmed.runnerz.tasks;


import jakarta.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepository {


    List<Task> tasks=new ArrayList<>();

    List<Task> findAllTasks(){
        return tasks;
    }
    public void  addTask(Task task) {
        tasks.add(task);
    }
    public void deletTask(Integer id) {
        tasks.removeIf((task -> task.id().equals(id))) ;
    }
    @PostConstruct
    public void init(){
        tasks.add(new Task(
                1,
                "Doctors appointement",
                "may 5th at 2:30",
                true)
        ) ;
        tasks.add(new Task(
                        2,
                        "exercises",
                        "may 5th at 2:30",
                        true)
        ) ;
    }

}
