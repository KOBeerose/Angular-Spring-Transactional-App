import { AuthServiceService } from 'src/app/services/auth-service.service';
import { Router } from '@angular/router';
import { ContractServiceService } from './../../services/contract-service.service';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-approuve-account',
  templateUrl: './approuve-account.component.html',
  styleUrls: ['./approuve-account.component.scss']
})
export class ApprouveAccountComponent implements OnInit {
  form: FormGroup;
  constructor(private formBuilder : FormBuilder,private authService: AuthServiceService,private router:Router) { }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      username: "",
      code : ""
    });
  }
  ApprouveAccount() {
    const data = {
      username: this.form.getRawValue().username,
      code: this.form.getRawValue().code,
      
    }
    console.log(data.username);
    console.log(data.code);

    this.authService.activateAccount(data).subscribe(res => {
      console.log(res);
      this.router.navigateByUrl("/Auth/login");
    });
  }

}
