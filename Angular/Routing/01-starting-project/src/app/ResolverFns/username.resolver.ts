import { ActivatedRouteSnapshot, MaybeAsync, Resolve, RouterStateSnapshot } from "@angular/router";
import { UsersService } from "../users/users.service";
import { Injectable } from "@angular/core";

@Injectable({ providedIn: "root" })
export class UserNameResolver implements Resolve<string>  {
    constructor(private usersService: UsersService) {}
    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const userName = this.usersService.users.find(u => u.id === route.paramMap.get("userId"))?.name || '';
        return userName;
    }
    
}
