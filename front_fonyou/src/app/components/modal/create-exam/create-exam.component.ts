import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { IExam } from 'src/app/interfaces/exam.interface';

@Component({
  selector: 'app-create-exam',
  templateUrl: './create-exam.component.html',
})
export class CreateExamComponent implements OnInit {

  @Input() exam!:IExam;
  @Output() cerrarModal = new EventEmitter<boolean>();
  forma:FormGroup;
  title:string='Formulario de Creacion de Examen';

  constructor() { 
    this.forma = this.setValidationForm();
  }

  ngOnInit(): void {
  }

  setValidationForm(): FormGroup {
      return new FormGroup({        
        title: new FormControl(null, [Validators.required, Validators.minLength(3), Validators.maxLength(15)]),
      });
    }

    cerrar(event: boolean): void {
      this.cerrarModal.emit(true);
    }
  
    onSubmit(){
    
    }
}
