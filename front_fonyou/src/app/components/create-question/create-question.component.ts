import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { IExam } from 'src/app/interfaces/exam.interface';

@Component({
  selector: 'app-create-question',
  templateUrl: './create-question.component.html',
})
export class CreateQuestionComponent implements OnInit {

  @Input() exam!:IExam;
  @Output() cerrarModal = new EventEmitter<boolean>();
  @Input() forma!:FormGroup;
  title:string='Formulario de Creacion de Examen';

  constructor() { 
    this.forma = this.setValidationForm();
  }

  ngOnInit(): void {
  }

  setValidationForm(): FormGroup {
      return new FormGroup({        
        point: new FormControl(null, [Validators.required, Validators.minLength(3), Validators.maxLength(15)]),
        title: new FormControl(null, [Validators.required, Validators.minLength(3), Validators.maxLength(15)]),
      });
    }

  onSubmit(){

  }
}
