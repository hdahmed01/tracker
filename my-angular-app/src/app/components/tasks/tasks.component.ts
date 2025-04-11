import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { Task } from 'src/app/Task';
import { TaskService } from 'src/app/services/task.service';
import { TASKS } from 'src/app/mock-tasks';




@Component({
  selector: 'app-tasks',
  templateUrl: './tasks.component.html',
  styleUrls: ['./tasks.component.css']
})
export class TasksComponent implements OnInit {
  tasks :Task[]=[];
  
  constructor(private taskService:TaskService,){

  }
  ngOnInit(): void {
    // this.tasks=TASKS;
    this.taskService.getTasks().subscribe((tasks)=>this.tasks=tasks)
    console.log(this.tasks);
    
  }
  deletTask(task: Task){
   
    this.taskService.deleteTask(task).subscribe(()=>(this.tasks=this.tasks.filter(t=>t.id !==   task.id)))
  }
  toggoleReminder(task: Task){
    task.reminder=!task.reminder;
    this.taskService.updateTaskReminder(task).subscribe();
  }
  onAddTask(task:Task){
    this.tasks.push(task)
    this.taskService.addTask(task).subscribe();


  }
}
