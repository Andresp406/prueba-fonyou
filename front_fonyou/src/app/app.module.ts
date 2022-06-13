import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ComponentsModule } from './components/components.module';
import { StudentComponent } from './student/student.component';
import { ModalModule } from './components/modal/modal.module';
import { HttpClientModule } from '@angular/common/http';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { ExamComponent } from './exam/exam.component';



@NgModule({
  declarations: [
    AppComponent,
    StudentComponent,
    ExamComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ComponentsModule,
    ModalModule,
    HttpClientModule,
    FontAwesomeModule,
  ],
  
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
