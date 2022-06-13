import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BaseModalComponent } from './base-modal/base-modal.component';
import { MatDatepickerModule } from '@angular/material/datepicker';

import { ReactiveFormsModule } from '@angular/forms';
import { ValidationsErrorsComponent } from './validations-errors/validations-errors.component';
import { CreateStudentComponent } from './create-student/create-student.component';
import { EditStudentComponent } from './edit-student/edit-student.component';

import { ShowDetailsStudentComponent } from './show-details-student/show-details-student.component';
import { ButtonCloseComponent } from './button-close/button-close.component';



@NgModule({
  declarations: [
    BaseModalComponent,
    CreateStudentComponent,
    ButtonCloseComponent,
    ValidationsErrorsComponent,
    EditStudentComponent,

    ShowDetailsStudentComponent 
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    MatDatepickerModule,

  ],
  exports:[
    BaseModalComponent,
    ButtonCloseComponent,
    ValidationsErrorsComponent,
    CreateStudentComponent
  ]
})
export class ModalModule { }
