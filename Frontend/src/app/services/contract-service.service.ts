import { HttpClient } from '@angular/common/http';
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
    return this.http.get(this.host_im + "/allImmobilier", { headers: { 'Authorization':  `Bearer ${localStorage.getItem('token')}` }});
  }
  ListImmobilier(address) {
    return this.http.get(this.host_im + `/listImmobilier/${address}`, { headers: { 'Authorization':  `Bearer ${localStorage.getItem('token')}` }});
  }
  ImmobilierForSale() {
    return this.http.get(this.host_im + `/listVisibleImmobilier`);
  }
  myImmobilier() {
    return this.http.get(this.host_im + `/myImmobiliers`, { headers: { 'Authorization':  `Bearer ${localStorage.getItem('token')}` }});
  }
  ChangeAnnouncement(id) {
    return this.http.get(this.host_im + `/changeAnnouncement/${id}`, { headers: { 'Authorization':  `Bearer ${localStorage.getItem('token')}` }});
  }
  ImmobilierTransaction(id){
    return this.http.get(this.host_im + `/transactions/${id}`, { headers: { 'Authorization':  `Bearer ${localStorage.getItem('token')}` }});
  }
  
  // Post methods for /Immobilier
  SaveImmobilier(data) {
    return this.http.post(this.host_im + `/saveImmobilier`, data, { headers: { 'Authorization':  `Bearer ${localStorage.getItem('token')}` }});
  }

  // Put methods for /Immobilier
  ChangeOwner(id, data) {
    return this.http.put(this.host_im + `/changeOwner/${id}`, data, { headers: { 'Authorization':  `Bearer ${localStorage.getItem('token')}` }});
  }
  SetPrice(id, data) {
    return this.http.put(this.host_im + `/setPrice/${id}`, data, { headers: { 'Authorization':  `Bearer ${localStorage.getItem('token')}` }});
  }

  // Delete methods for /Immobilier
  deleteImobilier(id) {
    return this.http.put(this.host_im + `/setPrice/${id}`, { headers: { 'Authorization':  `Bearer ${localStorage.getItem('token')}` }});
  }


  host_tr: string = "http://127.0.0.1:8088/transaction";

  
  // Get methods for /Immobilier
  AllTransactions() {
    return this.http.get(this.host_tr + "/allTransactions", { headers: { 'Authorization':  `Bearer ${localStorage.getItem('token')}` }});
  }

  // Post methods for /Immobilier
  AddTransaction(id, data) {
    return this.http.post(this.host_tr + `/addTransaction/${id}`, data, { headers: { 'Authorization':  `Bearer ${localStorage.getItem('token')}` }});
  }

}
