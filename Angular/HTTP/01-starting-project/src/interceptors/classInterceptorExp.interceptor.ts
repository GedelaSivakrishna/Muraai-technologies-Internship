import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from "@angular/common/http"
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable()
export class ClassInterceptorExample implements HttpInterceptor {
    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        console.log("This is class interceptor");
        console.log(req);
        return next.handle(req);
    }

}