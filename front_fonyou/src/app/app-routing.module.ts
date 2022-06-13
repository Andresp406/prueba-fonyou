import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StudentComponent } from './student/student.component';
import { HomeComponent } from './components/home/home.component';
import { ExamComponent } from './exam/exam.component';

const routes: Routes = [
  {path:'', component: HomeComponent},
  {path:'student', component: StudentComponent},
  {path:'exam', component: ExamComponent},
  {path:'**', redirectTo:'/'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
