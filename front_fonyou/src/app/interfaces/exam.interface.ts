export interface IExam{
    id:number;
    grade:string;
    question?:IQuestion[];
}

export interface IQuestion{
    title:string;
    point?:number;
    answer?:IAnswer[];
}

export interface IAnswer{
    id?:number;
    option:string;
    isValid:boolean;
}