import { Asset, iAsset } from "./Asset";



export interface Iemployee{

    empId: number,
	empName:string,
	empAddress:string,
    asset : iAsset
}

export class Employee{

    constructor(public empId:number,public empName:string,public empAddress:string,public asset:Asset){}

}