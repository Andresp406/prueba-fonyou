import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { IExam } from 'src/app/interfaces/exam.interface';
import { IStudent } from 'src/app/interfaces/student.interface';

@Component({
  selector: 'app-show-details-student',
  templateUrl: './show-details-student.component.html'
})
export class ShowDetailsStudentComponent implements OnInit {
  @Input() student!:IStudent;
  @Input() exam!:IExam;
  @Output() cerrarModal = new EventEmitter<boolean>();
  title:string='Informacion del Estudiante';
  resp:any[] = [];
  question:string[]=[];
  constructor() { }

  ngOnInit(): void {
      this.student?.exam?.question?.forEach(q =>{
        this.question.push(q.title);
        q.answer?.forEach(a => {

          if (a.isValid){
            this.resp.push({valido:a.isValid, opcion:a.option});
          }
        })
      })
      console.log(this.resp)
    }

  closeModal(){
    this.cerrarModal.emit(true);
  }

}
