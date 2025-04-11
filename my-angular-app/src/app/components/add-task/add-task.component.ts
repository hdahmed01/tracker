import { Component,Output,EventEmitter } from '@angular/core';
import { Task } from 'src/app/Task';
import { UiService } from 'src/app/services/ui.service';
import { Subscription } from 'rxjs';


@Component({
  selector: 'app-add-task',
  templateUrl: './add-task.component.html',
  styleUrls: ['./add-task.component.css']
})
export class AddTaskComponent {
@Output()  onAddtask :EventEmitter<Task>=new EventEmitter();
  
  text!:string ;
  day !:string;
  reminder:boolean=false;
  showAddtask :boolean =false;
  subscription! :Subscription;
  constructor(private uiService:UiService){
    this.subscription=this.uiService.onToggle().subscribe((value)=>(this.showAddtask=value))
  }

  onSubmit(){
    if(!this.text){
      alert('Please add a task')
    }
    const newTask:Task ={
      id :100,
      text :this.text,
      day :this.day,
      reminder:this.reminder
    }
    this.onAddtask.emit(newTask);
    this.text="";
    this.day="";
    this.reminder=false;
  }
}
