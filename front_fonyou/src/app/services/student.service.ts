import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { IStudent } from '../interfaces/student.interface';
import { catchError, Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import Swal from 'sweetalert2';

@Injectable({
  providedIn: 'root'
})
export class StudentService {
  constructor(private _http:HttpClient) { }

  getStudent():Observable<IStudent[]>{
    return this._http.get<IStudent[]>(`${environment.url_base}student`);
  }

  createStudent(student:IStudent):Observable<any>{
    console.log(student);
    const headers = this._getHeaders();
    return this._http.post<any>(`${environment.url_base}create-student`, student, {headers});
  }

  findStudentById(id:number){

  }

  deleteStudent(id:number|any):Observable<any>{
    const headers = this._getHeaders();
    return this._http.delete<Observable<any>>(`${environment.url_base}student/${id}`, {headers});
  }

  updateStudent(student:IStudent|any):Observable<any>{
    const headers = this._getHeaders();
    return this._http.put<Observable<any>>(`${environment.url_base}student/${student.id}`,student , {headers});
  }


  private _getHeaders(): HttpHeaders {
      const headers = new HttpHeaders({
      Headers:environment.headers,
    })

    return headers;
  }
}
