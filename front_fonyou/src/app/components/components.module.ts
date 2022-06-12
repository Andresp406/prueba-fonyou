import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './home/home.component';
import { RouterModule } from '@angular/router';
import { NavBarComponent  } from './nav-bar/nav-bar.component';


@NgModule({
  declarations: [
    HeaderComponent,
    FooterComponent,
    HomeComponent,   
    NavBarComponent,

  ],
  imports: [
    CommonModule,
    RouterModule,

  ],
  exports:[
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    NavBarComponent,
  ]
})
export class ComponentsModule { }
