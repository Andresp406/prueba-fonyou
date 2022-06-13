import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CreateExamComponent } from './create-exam/create-exam.component';
import { ExamComponent } from './exam/exam.component';
import { StudentComponent } from './student/student.component';
import { HomeComponent } from './home/home.component';
import { ModalModule } from '../components/modal/modal.module';
import { ComponentsModule } from '../components/components.module';
import { NgxSpinnerModule } from "ngx-spinner";
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { RouterModule } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    CreateExamComponent,
    ExamComponent,
    StudentComponent,
    HomeComponent,
  ],
  imports: [
    CommonModule,
    ModalModule,
    ComponentsModule,
    NgxSpinnerModule,
    FontAwesomeModule,
    RouterModule,
    ReactiveFormsModule
  ],
  exports:[
    CreateExamComponent,
    ExamComponent,
    StudentComponent,
    HomeComponent,
  ]
})
export class PagesModule { }
