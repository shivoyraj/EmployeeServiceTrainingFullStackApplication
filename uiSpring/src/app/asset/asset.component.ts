import { Component, OnInit } from '@angular/core';
import { Asset } from '../employee/Asset';
import { AssetService } from './asset.service';

@Component({
  selector: 'app-asset',
  templateUrl: './asset.component.html',
  styleUrls: ['./asset.component.css']
})
export class AssetComponent implements OnInit {

  
   assetId: string = "";

  f1: boolean = false
  f2: boolean = false
  f3: boolean = false
  f4: boolean = false

  flagGET: boolean = false;
  flagGETs: boolean = false;

  errorMessage: string | null = null;
  getsErrorMessage: string | null = null;


  postResponseMessage: any | null = null;
  postErrorMessage: string | null = null;

  putResponseMessage: any | null = null;
  putErrorMessage: string | null = null;

  deleteResponseMessage: any | null = null;
  deleteErrorMessage: string | null = null;

  public assets = [
    {
      "assetId": "",
      "assetName": "",
      "assetType": ""
    }];

  public asset = {
      "assetId": "",
      "assetName": "",
      "assetType": ""
  };

  ast: Asset = new Asset("", "", "");

  constructor(private assetService:AssetService) {

  }

  ngOnInit(): void {
  }

  getAssets() {
  
    this.assetService.getAssets()
      .subscribe(
        (data) =>{ this.assets = data
          this.flagGETs = true;
          this.getsErrorMessage = null
        },
        (error) => {
          this.getsErrorMessage = <any>error.error.errorMessage;
          this.flagGETs = false;
        }
      );

  }


  getAsset(assetId: string): void {

    this.assetId = assetId;
    this.flagGET = (!this.flagGET);
    this.assetService.getAsset(this.assetId)
      .subscribe(
        (data) => { this.asset = data; this.errorMessage = null },
        (error) => {
          this.errorMessage = <any>error.error.errorMessage;
        }
      );

  }

  addAsset(assetObj: any) {
    this.asset.assetId = assetObj.assetId;
    this.asset.assetName = assetObj.assetName;
    this.asset.assetType = assetObj.assetType;

    this.assetService.addAsset(this.asset)
      .subscribe(
        (msg) => {
          this.postErrorMessage=null;
          console.log(msg.successMessage);
          this.postResponseMessage=msg.successMessage;
      },
        (errorMessage) => {
          this.postResponseMessage = null;
          this.postErrorMessage = errorMessage.error.errorMessage;
          console.log(errorMessage);

        },
        
      );
  }

  updateAsset(assetObj: any) {
    this.asset.assetId = assetObj.assetId;
    this.asset.assetName = assetObj.assetName;
    this.asset.assetType = assetObj.assetType;

    this.assetService.updateAsset(this.asset)
      .subscribe(
        (msg) => {
          this.putErrorMessage=null;
          console.log(msg.successMessage);
          this.putResponseMessage=msg.successMessage;
      },
        (errorMessage) => {
          this.putResponseMessage = null;
          this.putErrorMessage = errorMessage.error.errorMessage;
          console.log(errorMessage);

        },
        
      );
  }

  deleteAsset(assetId:string):void{

    this.asset.assetId=assetId
    this.assetService.deleteAsset(this.asset.assetId)
      .subscribe(
        (msg) => {
          this.deleteErrorMessage=null;
          console.log(msg.successMessage);
          this.deleteResponseMessage=msg.successMessage;
      },
        (errorMessage) => {
          this.deleteResponseMessage = null;
          this.deleteErrorMessage = errorMessage.error.errorMessage;
          console.log(errorMessage);

        },
        
      );

  }

 


  getEnable1() {
    this.f1 = (!this.f1)
    this.f2 = false;
    this.f3 = false;
    this.f4 = false;
  }
  getEnable2() {
    this.f1 = false;
    this.f2 = (!this.f2);
    this.f3 = false;
    this.f4 = false;
  }
  getEnable3() {
    this.f1 = false;
    this.f2 = false;
    this.f3 = (!this.f3);
    this.f4 = false;
  }
  getEnable4() {
    this.f1 = false;
    this.f2 = false;
    this.f3 = false;
    this.f4 = (!this.f4);
  }

}
