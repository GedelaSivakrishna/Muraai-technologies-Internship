import { Injectable } from "@angular/core";
import { CanMatch, GuardResult, MaybeAsync, RedirectCommand, Route, Router, UrlSegment } from "@angular/router";

@Injectable({
    providedIn: "root"
})
export class ExampleCanMatchClassGuard implements CanMatch {
    constructor(private router: Router) {}
    canMatch(route: Route, segments: UrlSegment[]): MaybeAsync<GuardResult> {
        const hasAccess = Math.random();
        if(hasAccess < 0.5) {
            return true;
        }
        return new RedirectCommand(this.router.parseUrl("/unauthorized"));
    }
    
}