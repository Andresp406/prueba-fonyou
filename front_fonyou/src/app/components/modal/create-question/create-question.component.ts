import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-create-question',
  templateUrl: './create-question.component.html',
})
export class CreateQuestionComponent implements OnInit {

  forma!:FormGroup;
  constructor() { }

  ngOnInit(): void {
  }

  onSubmit(){

  }
}
