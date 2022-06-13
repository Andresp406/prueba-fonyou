import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BaseModalComponent } from './base-modal/base-modal.component';

import { ButtonCloseComponent } from './button-close/button-close.component';
import { ReactiveFormsModule } from '@angular/forms';
import { ValidationsErrorsComponent } from './validations-errors/validations-errors.component';
import { CreateStudentComponent } from './create-student/create-student.component';
import { EditStudentComponent } from './edit-client/edit-student.component';



@NgModule({
  declarations: [
    BaseModalComponent,
    CreateStudentComponent,
    ButtonCloseComponent,
    ValidationsErrorsComponent,
    EditStudentComponent 
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,

  ],
  exports:[
    BaseModalComponent,
    ButtonCloseComponent,
    ValidationsErrorsComponent,
    CreateStudentComponent
  ]
})
export class ModalModule { }
