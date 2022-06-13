import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { IExam } from 'src/app/interfaces/exam.interface';

@Component({
  selector: 'app-create-answer',
  templateUrl: './create-answer.component.html',

})
export class CreateAnswerComponent implements OnInit {
  forma!:FormGroup;
  @Input() exam!:IExam;
  @Output() cerrarModal = new EventEmitter<boolean>();

  title:string='Formulario de Creacion de Examen';

  constructor() { 
    this.forma = this.setValidationForm();
  }

  ngOnInit(): void {
  }

  setValidationForm(): FormGroup {
      return new FormGroup({        
        option: new FormControl(null, [Validators.required, Validators.minLength(3), Validators.maxLength(15)]),
        isValid: new FormControl(null, [Validators.required, Validators.minLength(3), Validators.maxLength(15)]),

      });
    }
  onSubmit(){
    
  }
}
