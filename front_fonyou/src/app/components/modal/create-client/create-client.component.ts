import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Student } from 'src/app/interfaces/student.interface';
import { StudentService } from 'src/app/services/student.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-create-client',
  templateUrl: './create-client.component.html',
  styleUrls: ['./create-client.component.css']
})
export class CreateStudentComponent implements OnInit {
  forma: FormGroup;
  title: string = 'Formulario Estudiantes';
  @Output() cerrarModal = new EventEmitter<boolean>();

  constructor(private clienteService: StudentService) {
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
    const data: Student = {
      nombre: this.forma.get('nombre')?.value,
      apellido: this.forma?.get('apellido')?.value,
      edad: this.forma?.get('edad')?.value,
      ciudad: this.forma?.get('ciudad')?.value,
      zonaHoraria: this.forma?.get('zonaHoraria')?.value,
    };
    this.clienteService.createClient(data);
    Swal.fire({
        icon: 'success',
        title: 'el cliente ha sido guardado exitosamente',
        showConfirmButton: false,
        timer: 1500
      });
      this.cerrar(true);

  }

  cerrar(event: boolean): void {
    this.cerrarModal.emit(true);
  }
}
