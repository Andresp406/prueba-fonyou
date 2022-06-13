import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-create-answer',
  templateUrl: './create-answer.component.html',

})
export class CreateAnswerComponent implements OnInit {
  forma!:FormGroup;
  constructor() { }

  ngOnInit(): void {
  }

  onSubmit(){
    
  }
}
