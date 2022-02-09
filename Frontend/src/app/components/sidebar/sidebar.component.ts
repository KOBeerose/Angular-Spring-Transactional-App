import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthServiceService } from 'src/app/services/auth-service.service';

declare interface RouteInfo {
  path: string;
  title: string;
  icon: string;
  class: string;
}
export const ROUTES: RouteInfo[] = [
  { path: 'ImmobiliersForSale', title: 'Shop Items', icon: 'ni-building text-primary', class: '' },
  { path: 'profile', title: 'Profile', icon: 'ni-single-02 text-yellow', class: '' },
  { path: 'tables', title: 'Transactions', icon: 'ni-bullet-list-67 text-red', class: '' },
  { path: '/Auth/login', title: 'Login', icon: 'ni-key-25 text-info', class: '' },
  { path: '/Auth/register', title: 'Register', icon: 'ni-circle-08 text-pink', class: '' }
];
export const AdminROUTES: RouteInfo[] = [
  { path: '/Admin/dashboard', title: 'Dashboard', icon: 'ni-tv-2 text-primary', class: '' },
  { path: '/Admin/Immobiliers', title: 'Immobiliers', icon: 'ni-bullet-list-67 text-red', class: '' }
];
export const UserROUTES: RouteInfo[] = [
  { path: 'user-profile', title: 'My profile', icon: 'ni-single-02 text-yellow', class: '' },
  { path: '/User/MyImmobiliers', title: 'My Immobiliers', icon: 'ni-house text-yellow', class: '' },
  { path: '/User/ImmobiliersForSale', title: 'Immobiliers for sale', icon: 'ni-shop text-red', class: '' },
  { path: '/User/AddImmobilier', title: 'Add Immobilier', icon: 'ni-add text-yellow', class: '' },
  { path: '/User/ModifyImmobilier', title: 'Modify Immobilier', icon: 'ni-add text-yellow', class: '' },
];

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.scss']
})
export class SidebarComponent implements OnInit {

  public menuItems: any[];
  public isCollapsed = true;

  constructor(private authService: AuthServiceService, private router: Router) { }

  Logout() {
    this.authService.logout()
    this.router.navigateByUrl("/Auth/login");
  }
  ngOnInit() {
    this.menuItems = ROUTES.filter(menuItem => menuItem);
    this.router.events.subscribe((event) => {
      this.isCollapsed = true;
    });
  }

}
