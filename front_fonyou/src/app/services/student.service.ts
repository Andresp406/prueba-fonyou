import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Student } from '../interfaces/student.interface';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StudentService {
  private urlEndPoint:string = 'http://localhost:9000/api/clients'
  constructor(private _http:HttpClient) { }

  getClient():Observable<Student[]>{
    return this._http.get<Student[]>(this.urlEndPoint);
  }

  createClient(cliente:Student){
    
  }

  findClientById(id:number){

  }

  deleteClient(id:number){

  }

  updateClient(cliente:Student){

  }
}
