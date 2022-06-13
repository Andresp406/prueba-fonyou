import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { IStudent } from 'src/app/interfaces/student.interface';
import { StudentService } from 'src/app/services/student.service';

@Component({
  selector: 'app-create-exam',
  templateUrl: './create-exam.component.html',
})
export class CreateExamComponent implements OnInit {

  forma:FormGroup;
  students:IStudent[]=[];
  constructor(private studentServices:StudentService) { 
    this.forma = this.setValidationForm();
  }

  ngOnInit(): void {
    this.getStudent();
    
  }

  getStudent():void{
    this.studentServices.getStudent().subscribe((resp:IStudent[]) =>{ 
      this.students = resp;
      console.log(this.students);
    });
  }

  setValidationForm():FormGroup{
    return new FormGroup({
        title: new FormControl(null, [Validators.required, Validators.minLength(3), Validators.maxLength(15)]),
        option: new FormControl(null, [Validators.required, Validators.minLength(3), Validators.maxLength(15)]),
        isValid: new FormControl(null, [Validators.required]),
        point: new FormControl(null, [Validators.required, Validators.minLength(3), Validators.maxLength(15)]),
        grade: new FormControl(null, [Validators.required]),
      });
  }

  onSubmit(){}
}
