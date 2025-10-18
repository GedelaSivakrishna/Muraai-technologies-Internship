import { inject, Injectable } from "@angular/core";
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot } from "@angular/router";
import { AuthService } from "../Auth.service";
import { Observable } from "rxjs";

@Injectable({
    providedIn: 'root'
  })
export class AuthGuardService implements CanActivate {

    // constructor(private authService: AuthService, private router: Router) {}

    private authService = inject(AuthService);
    private router = inject(Router);

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
        let isLoggedIn = this.authService.isAuthenticated();
        if(isLoggedIn) {
            return true;
        }
        else {
            this.router.navigate(["/login"]);
            return false;
        }
    }
    
}