import { Router } from '@angular/router';

import { Component, OnInit } from '@angular/core';
import { AuthServiceService } from 'src/app/services/auth-service.service';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  focus: any;
  focus1;
  form: FormGroup;
  constructor(private authService: AuthServiceService, private Formbuilder: FormBuilder, private router: Router) { }


  ngOnInit() {
    this.form = this.Formbuilder.group({
      username: '',
      password: ''
    });
  }
  onLogin() {
    const data = {
      username: this.form.getRawValue().username,
      password: this.form.getRawValue().password,
      useraddress: "adresse"
    }
    let status;
    let roles;
    let roleName;
    localStorage.setItem("username", data.username);
    localStorage.setItem("password", data.password);

    this.authService.getAccountStatus(data).subscribe((response: any) => {

      status = response.actived;

      localStorage.setItem("useraddress", response.address);
      console.log("this is your account Status : " + status);
      if (status == true) {
        this.authService.login(data).subscribe(res => {

          roles = res.body["roles"][0];
          roleName = roles["roleName"];


          // console.log(res.headers.get('Authorization'))
          let jwt = res.headers.get('Authorization');
          // this.authService.saveToken(jwt);

          if (roleName == "USER") {
            console.log("A USER has logged in called " + res.body["username"])
            this.router.navigateByUrl("/User/ImmobiliersForSale");
          } else {
            console.log("A ADMIN has logged in called " + res.body["username"])
            this.router.navigateByUrl("/Admin/dashboard");
          }
        });
      } else {
        this.router.navigateByUrl("/Auth/approuveAccount");
      }
    });



  }


}
