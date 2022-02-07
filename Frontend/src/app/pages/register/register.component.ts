import { Router } from '@angular/router';
import { AuthServiceService } from 'src/app/services/auth-service.service';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  form : FormGroup
  constructor(private Formbuilder : FormBuilder,private authService: AuthServiceService,private router : Router) { }

  ngOnInit() {
    this.form = this.Formbuilder.group({
        username :"",
        password:"",
        confirmedPassword:"",
        address:""
      });
  }
  register() {
    const data = {
      username: this.form.getRawValue().username,
      password: this.form.getRawValue().password,
      confirmedPassword: this.form.getRawValue().confirmedPassword,
      address: this.form.getRawValue().address
    }
    console.log(data.username);
    console.log(data.password);
    console.log(data.confirmedPassword);
    console.log(data.address);
    this.authService.register(data).subscribe(res => {
      console.log(res);
      this.router.navigateByUrl("/Auth/approuveAccount");
    })
  }
}
