export interface iAsset {
    assetId:string,
    assetName:string,
    assetType:string
}

export class Asset {
    

    constructor(public assetId:string,public assetName:string,public assetType:string){}
    
}