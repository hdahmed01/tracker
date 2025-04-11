import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Task } from 'src/app/Task';
import { faTimes } from '@fortawesome/free-solid-svg-icons';
import { TaskService } from 'src/app/services/task.service';


@Component({
  selector: 'app-task-item',
  templateUrl: './task-item.component.html',
  styleUrls: ['./task-item.component.css']
})
export class TaskItemComponent  {
@Input()  task?: Task;
faTimes = faTimes;

@Output() onDeleteTask :EventEmitter<Task>=new EventEmitter();
@Output() onToggelreminder :EventEmitter<Task>=new EventEmitter();


constructor(private taskService:TaskService){

}
onDelete(task: Task){
  this.onDeleteTask.emit(task)
}
onToggle(task: Task){
  this.onToggelreminder.emit(task)
}


}
