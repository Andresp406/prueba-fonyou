import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateExamComponent } from './create-exam/create-exam.component';
import { ExamComponent } from './exam/exam.component';
import { HomeComponent } from './home/home.component';
import { StudentComponent } from './student/student.component';

const routes:Routes =[
  {
    path:'',
    children:[
      {
        path:'create-exam',
        component:CreateExamComponent
      },
      {
        path:'exam',
        component:ExamComponent
      },
      {
        path:'home',
        component:HomeComponent
      },
      {
        path:'student',
        component:StudentComponent
      }
    ]
  }
]


  @NgModule({
    imports: [
      RouterModule.forChild(routes),
    ],
    exports:[
      RouterModule
    ]
  })
  export class PagesRoutingModule { }
