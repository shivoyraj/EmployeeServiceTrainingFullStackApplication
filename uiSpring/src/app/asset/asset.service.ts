import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Asset, iAsset } from '../employee/Asset';

@Injectable({
  providedIn: 'root'
})
export class AssetService {
 
  constructor(private http:HttpClient) { }

  getAssets(): Observable<iAsset[]> {

    const getsUrl = "http://localhost:8081/InfyAsset/assets";
    return this.http.get<iAsset[]>(getsUrl);

  }

  getAsset(assetId: string): Observable<iAsset> {
 
    const getUrl = "http://localhost:8081/InfyAsset/asset/" + assetId;
    return this.http.get<iAsset>(getUrl);

  }

  addAsset(asset: Asset): Observable<any> {
    const baseURL = "http://localhost:8081/InfyAsset/asset";
    const headers = { 'content-type': 'application/json' };
    const body = JSON.stringify(asset);
    return this.http.post<any>(baseURL, body, { headers })
  }

  updateAsset(asset: Asset): Observable<any> {
    const baseURL = "http://localhost:8081/InfyAsset/asset/" + asset.assetId;
    const headers = { 'content-type': 'application/json' };
    const body = JSON.stringify(asset);
    return this.http.put<any>(baseURL, body, { headers })
  }

  deleteAsset(assetId: string): Observable<any> {

    const u ="http://localhost:8081/InfyAsset/asset/" + assetId;
    return this.http.delete<any>(u);

  }

}
