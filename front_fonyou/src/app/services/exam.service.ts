import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { IExam } from '../interfaces/exam.interface';


@Injectable({
  providedIn: 'root'
})
export class ExamService {
  constructor(private _http:HttpClient) { }

  getExam():Observable<IExam[]>{
    return this._http.get<IExam[]>(`${environment.url_base}exam`);
  }

  
  reateExam(exam:IExam):Observable<any>{

    const headers = this._getHeaders();
    return this._http.post<any>(`${environment.url_base}create-exam`, exam, {headers})
    ;
  }

  findExamById(id:number){

  }

  deleteExam(id:number|any):Observable<any>{
    const headers = this._getHeaders();
    return this._http.delete<Observable<any>>(`${environment.url_base}exam/${id}`, {headers});
  }

  updateExam(exam:IExam|any):Observable<any>{
    const headers = this._getHeaders();
    return this._http.put<Observable<any>>(`${environment.url_base}exam/${exam.id}`
    ,exam ,
     {headers}
    );
  }


  private _getHeaders(): HttpHeaders {
      const headers = new HttpHeaders({
      Headers:environment.headers,
    })

    return headers;
  }
}
