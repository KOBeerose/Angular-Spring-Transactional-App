import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.scss']
})
export class UserProfileComponent implements OnInit {

  username; firstname; lastname; email;
  
  constructor(private router:Router) { }
  isReadMore = true

  showText() {
     this.isReadMore = !this.isReadMore
  }

  ngOnInit() {
    if (localStorage.getItem("username") == null) {
      this.router.navigateByUrl("/User/forbidden");
    }
    this.username = localStorage.getItem('username');
    this.email = this.username+"@gmail.com";
    
  }

}
