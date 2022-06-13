import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { RouterModule } from '@angular/router';
import { NavBarComponent  } from './nav-bar/nav-bar.component';
import { ModalModule } from './modal/modal.module';
import { CreateQuestionComponent } from './create-question/create-question.component';
import { CreateAnswerComponent } from './create-answer/create-answer.component';
import { ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    HeaderComponent,
    FooterComponent,
    NavBarComponent,
    CreateQuestionComponent,
    CreateAnswerComponent,

  ],
  imports: [
    CommonModule,
    RouterModule,
    ModalModule,
    ReactiveFormsModule

  ],
  exports:[
    HeaderComponent,
    FooterComponent,
    NavBarComponent,
    CreateQuestionComponent,
    CreateAnswerComponent,
  ]
})
export class ComponentsModule { }
