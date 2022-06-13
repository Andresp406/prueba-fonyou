import { IExam } from "./exam.interface";

export interface IStudent{
    id?:number;
    name:string;
    lastName:string;
    age:number;
    city:string;
    timeZone:string;
    exam?: IExam;
    
}