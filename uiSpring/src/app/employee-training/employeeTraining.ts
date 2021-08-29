export interface iTraining {
    
    empId:number,
	courseCode : string;
	courseName: string;
	score:number;
	hourSpend:number;
	dateOfComplition:Date;
	status:string;


}

export class Training {
    

    constructor(public empId:number,
        public courseCode : string,
        public courseName: string,
        public score:number,
        public hourSpend:number,
        public dateOfComplition:Date,
        public status:string
        ){}
    
}