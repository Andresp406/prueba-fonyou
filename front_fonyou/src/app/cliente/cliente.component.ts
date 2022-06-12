import { Component, OnInit } from '@angular/core';
import { Student as Student } from '../interfaces/student.interface';
import { StudentService } from '../services/student.service';
import { faEdit, faEye, faTrash, IconDefinition } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-cliente',
  templateUrl: './cliente.component.html',
})
export class StudentComponent implements OnInit {
  students:Student[] = [];
  icons:IconDefinition[] = [faEdit, faEye, faTrash];

  constructor(private clienteService:StudentService) {}

  ngOnInit(): void {
    this.getClients()
  }

  public getClients(){
    this.clienteService.getClient().subscribe(client => this.students = client);
  }

  public deleteStudent(id:number|any):void{

  }
 
}
