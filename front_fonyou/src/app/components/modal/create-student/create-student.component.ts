import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { IStudent } from 'src/app/interfaces/student.interface';
import { StudentService } from 'src/app/services/student.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-create-student',
  templateUrl: './create-student.component.html',
})
export class CreateStudentComponent implements OnInit {
  forma: FormGroup;
  title: string = 'Formulario Estudiantes';
  @Output() cerrarModal = new EventEmitter<boolean>();
  @Output() studentUpdate = new EventEmitter<any>();

  constructor(private studentService: StudentService) {
    this.forma = this.setValidationForm();
  }

  ngOnInit(): void {
  }


  setValidationForm(): FormGroup {
    return new FormGroup({
      
      nombre: new FormControl(null, [Validators.required, Validators.minLength(3), Validators.maxLength(15)]),
      apellido: new FormControl(null, [Validators.required, Validators.minLength(3), Validators.maxLength(15)]),
      edad: new FormControl(null, [Validators.required, Validators.minLength(3), Validators.maxLength(15)]),
      ciudad: new FormControl(null, [Validators.required, Validators.minLength(3), Validators.maxLength(15)]),
      zonaHoraria: new FormControl(null, [Validators.required, Validators.minLength(3), Validators.maxLength(15)]),
    });
  }

  onSubmit(): void {
    const data: IStudent = {
      name: this.forma.get('name')?.value,
      lastName: this.forma?.get('lastName')?.value,
      age: this.forma?.get('age')?.value,
      city: this.forma?.get('city')?.value,
      timeZone: this.forma?.get('timeZone')?.value,
    };
    this.studentService.createStudent(data).subscribe((resp)=>{
      Swal.fire({
        icon: 'success',
        title: `el estudiante ${data.name} ${data.lastName} fue ${resp.message}`,
        showConfirmButton: false,
        timer: 1500
      });
      this.studentUpdate.emit(data);
      this.cerrar(true);
    });
  }

  cerrar(event: boolean): void {
    this.cerrarModal.emit(true);
  }


}
