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
  constructor(private authService: AuthServiceService ,private Formbuilder:FormBuilder ,private router :Router) { }
  

  ngOnInit() {
    this.form = this.Formbuilder.group({
        username: '',
        password: ''
      });
  }
  onLogin() {
    const data = {
      username: this.form.getRawValue().username,
      password: this.form.getRawValue().password
    }
    let  status;
    localStorage.setItem("username", data.username);
    localStorage.setItem("password", data.password);
    this.authService.getAccountStatus(data).subscribe((response:any)=>{ 
      console.log(response);
      status = response.actived;
      console.log("this is your account Status : " + status);
      if (status == true) {
        this.authService.login(data).subscribe(res => {
          console.log(res);
          console.log(res.headers.get('Authorization'))
          let jwt = res.headers.get('Authorization');
          this.authService.saveToken(jwt);
          if (localStorage.getItem("roleName") == "1") { 
            
            this.router.navigateByUrl("/User/ImmobiliersForSale");
          } else {
            this.router.navigateByUrl("/Admin/dashboard");
          }
        });
      } else {
        this.router.navigateByUrl("/Auth/approuveAccount");
     }
    });
    

   
  }

  
}
