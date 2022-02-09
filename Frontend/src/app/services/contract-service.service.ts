import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ContractServiceService {
  // host2: string = "http://127.0.0.1:9999/CONTRACT-SERVICE";
  host_im: string = "http://127.0.0.1:8088/immobilier";

  constructor(private http: HttpClient) { }

  // Get methods for /Immobilier
  AllImmobiliers() {
    return this.http.get(this.host_im + "/allImmobilier", { headers: { 'Authorization': `Bearer ${localStorage.getItem('token')}` } });
  }
  myImmobilier(address) {
    return this.http.get(this.host_im + `/listImmobilier/${address}`);
  }
  ImmobilierForSale() {
    return this.http.get(this.host_im + `/listVisibleImmobilier`);
  }
  ChangeAnnouncement(id) {
    return this.http.get(this.host_im + `/changeAnnouncement/${id}`, { headers: { 'Authorization': `Bearer ${localStorage.getItem('token')}` } });
  }
  ImmobilierTransaction(id) {
    return this.http.get(this.host_im + `/transactions/${id}`, { headers: { 'Authorization': `Bearer ${localStorage.getItem('token')}` } });
  }
  ImmobilierDetails(id) {
    return this.http.get(this.host_im + `/immobilierDetails${id}`, { headers: { 'Authorization': `Bearer ${localStorage.getItem('token')}` } });
  }
  // Post methods for /Immobilier
  SaveImmobilier(data) {
    return this.http.post(this.host_im + `/saveImmobilier`, data);
  }

  // Put methods for /Immobilier
  ChangeOwner(id, data) {
    return this.http.put(this.host_im + `/changeOwner/${id}`, data, { headers: { 'Authorization': `Bearer ${localStorage.getItem('token')}` } });
  }
  SetPrice(id, data) {
    return this.http.put(this.host_im + `/setPrice/${id}`, data, { headers: { 'Authorization': `Bearer ${localStorage.getItem('token')}` } });
  }

  ModifyImm(id, data) {
    return this.http.put(this.host_im + `/modifyImombilier/${id}`, data, { headers: { 'Authorization': `Bearer ${localStorage.getItem('token')}` } });
  }

  // Delete methods for /Immobilier
  deleteImobilier(id) {
    return this.http.put(this.host_im + `/deleteImobilier/${id}`, { headers: { 'Authorization': `Bearer ${localStorage.getItem('token')}` } });
  }


  host_tr: string = "http://127.0.0.1:8088/transaction";


  // Get methods for /Transaction
  AllTransactions() {
    return this.http.get(this.host_tr + "/allTransactions");
  }

  // Post methods for /Transaction
  AddTransaction(id, data) {
    return this.http.post(this.host_tr + `/addTransaction/${id}`, data, { headers: { 'Authorization': `Bearer ${localStorage.getItem('token')}` } });
  }

  host_con: string = "http://127.0.0.1:8089/api";


  TransferImmobilier(Data: any) {
    const httpOptions = {
      headers: new HttpHeaders({ 
        'Access-Control-Allow-Origin':'*'

      })
    };

    return this.http.post(this.host_con+"/transferImmobilier",Data, httpOptions);
  }
  addImmobilier(Data: any) {
    return this.http.post(this.host_con + "/addImmobilier", Data, { headers: { 'Authorization': `Bearer ${localStorage.getItem('token')}` } });
  }
}
