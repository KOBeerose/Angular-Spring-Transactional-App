import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { JwtHelperService } from '@auth0/angular-jwt';

@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {

  // host2: string = "http://127.0.0.1:9999/AUTH-SERVICE";
  host2: string = "http://127.0.0.1:8086";
  jwt:string;
  username:string
  roles:Array<string>

  constructor(private http: HttpClient) { }
  login(data) {

    return this.http.post(this.host2 + "/loggin", data, { observe: 'response' });
  }

  register(data) {
    return this.http.post(this.host2 + "/register", data);
  }

    saveToken(jwt: string) {
    localStorage.setItem('token',jwt);
    this.jwt=jwt;
    this.parseJWT()

    }
  
  activateAccount(data) {
    return this.http.post(this.host2 + "/actived", data);
  }

  private parseJWT() {
    let jwtHelper = new JwtHelperService();
    let objJWT = jwtHelper.decodeToken(this.jwt);
    this.username=objJWT.obj;
    this.roles = objJWT.roles;
    localStorage.setItem("Role", `${this.roles.indexOf("ADMIN")}`);
  }
  isAdmin(){
    return this.roles.indexOf("ADMIN")>=0;
  }

  loadToken() {
    this.jwt= localStorage.getItem('token');
    this.parseJWT();
  }
  logout(){
    localStorage.clear();
    this.initParams();
  }

  private initParams() {
    this.jwt="";
    this.username="";
    this.roles=null;
  }
  getAccountStatus(data) {
    return this.http.post(this.host2 + "/active", data);
  }
}
