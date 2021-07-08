import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor() { }

  role:string='';

  storeUserDetails(user: string){
    sessionStorage.setItem('user', user);
  }

  retrieveUserDetails(){
    return sessionStorage.getItem('user');
  }

  removeUserDetails(){
    sessionStorage.removeItem('user');
  }

  setRole(role:string){
    sessionStorage.setItem('role', role);
  }
  getRole():any {
    return sessionStorage.getItem('role');
  }
  removeRole(){
    sessionStorage.removeItem('role');
  }

  setActive(active: string){
    sessionStorage.setItem('active', active);
  }

  getActive(): any{
    return sessionStorage.getItem('active');
  }

}
