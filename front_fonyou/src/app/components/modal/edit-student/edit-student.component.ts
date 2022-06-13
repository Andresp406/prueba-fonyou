import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { IStudent } from 'src/app/interfaces/student.interface';
import { StudentService } from 'src/app/services/student.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-edit-student',
  templateUrl: './edit-student.component.html',
})
export class EditStudentComponent implements OnInit {
  forma: FormGroup;
  title: string = 'Formulario de modificacion Estudiante';
  @Input() student!:IStudent;
  @Output() cerrarModal = new EventEmitter<boolean>();
  @Output() studentUpdate = new EventEmitter<IStudent>();

  constructor(private studentService: StudentService) {
    this.forma = this.setValidationForm();
  }

  ngOnInit(): void {
    const data:IStudent = {
      name:this.student.name,
      lastName:this.student.lastName,
      age:this.student.age,
      city:this.student.city,
      timeZone:this.student.timeZone
    }
    this.forma.setValue(data);
  }


  setValidationForm(): FormGroup {
    return new FormGroup({
      name: new FormControl(null, [Validators.required, Validators.minLength(3), Validators.maxLength(15)]),
      lastName: new FormControl(null, [Validators.required, Validators.minLength(3), Validators.maxLength(15)]),
      age: new FormControl(null, [Validators.required]),
      city: new FormControl(null, [Validators.required]),
      timeZone: new FormControl(null, [Validators.required]),
    });
  }

  onSubmit(): void {
    const data: IStudent = {
      id: this.student.id,
      name: this.forma.get('name')?.value,
      lastName: this.forma?.get('lastName')?.value,
      age: this.forma?.get('age')?.value,
      city: this.forma?.get('city')?.value,
      timeZone: this.forma?.get('timeZone')?.value,
    };
    Swal.fire({
      title: 'Desea guardar los cambios?',
      showDenyButton: true,
      showCancelButton: true,
      confirmButtonText: 'Guardar',
      denyButtonText: `No guardar`,
    }).then((result) => {
      if (result.isConfirmed) {
        this.studentService.updateStudent(data).subscribe(resp => {
          Swal.fire('Editado!', '', 'success');
          this.studentUpdate.emit(data);
          this.cerrar(true);
        });
        this.studentUpdate.emit(data);
      } else if (result.isDenied) {
        Swal.fire('Cambios no guardados', '', 'info');
        this.cerrar(true);
      }
    })
  }

  cerrar(event: boolean): void {
    this.cerrarModal.emit(true);
  }
}
