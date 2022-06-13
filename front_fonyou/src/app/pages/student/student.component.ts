import { Component, OnInit } from '@angular/core';
import { IStudent as IStudent } from '../../interfaces/student.interface';
import { StudentService } from '../../services/student.service';
import { faEdit, faEye, faTrash, IconDefinition } from '@fortawesome/free-solid-svg-icons';
import Swal from 'sweetalert2';
import { NgxSpinnerService } from "ngx-spinner";


@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
})
export class StudentComponent implements OnInit {
  students:IStudent[] = [];
  icons:IconDefinition[] = [faEdit, faEye, faTrash];

  constructor(private studentService:StudentService,  private spinner: NgxSpinnerService,) {}

  ngOnInit(): void {
    this.getStudents()
  }

  public getStudents():void{
    this.spinner.show();
    this.studentService.getStudent().subscribe(student => {
      this.students = student
      this.spinner.hide();
    });
  }

  public deleteStudent(student:IStudent):void{  
    Swal.fire({
      title: 'Esta seguro?',
      text: `Desea eliminar al estudiante ${student.name} ${student.lastName}`,
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Si, eliminar!'
    }).then((result) => {
      if (result.isConfirmed) {
        this.studentService.deleteStudent(student.id).subscribe((resp)=>{
          this.students = this.students.filter(cli => cli !== student); 
          Swal.fire(
            'Eliminado!',
            'El estudiante ha sido eliminado con exito.',
            'success'
          );  
        });
      }
    });
   
  }

  studentUpdate():void{
   this.getStudents();
  }
 
  
}
