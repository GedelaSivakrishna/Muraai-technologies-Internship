import { bootstrapApplication } from '@angular/platform-browser';

import { AppComponent } from './app/app.component';
import { HTTP_INTERCEPTORS, HttpHandlerFn, HttpRequest, HttpResponse, provideHttpClient, withInterceptors, withInterceptorsFromDi } from '@angular/common/http';
import { tap } from 'rxjs';
import { ClassInterceptorExample } from './interceptors/classInterceptorExp.interceptor';

function loggingInterceptor(request: HttpRequest<unknown>, next: HttpHandlerFn) {
    console.log("outgoing request");
    console.log(request);
    // modifying request
    // const req = request.clone({
    //     headers: request.headers.set("X-header", "Testing")
    // })
    return next(request).pipe(
        tap((event) => {
            if(event instanceof HttpResponse) {
                console.log("Response received: ", event);
            }
        })
    );
}


bootstrapApplication(AppComponent, {
    providers: [provideHttpClient(
        withInterceptors([loggingInterceptor])
    )]
}).catch((err) => console.error(err));

// bootstrapApplication(AppComponent, {
//     providers: [ provideHttpClient(
//         withInterceptorsFromDi()
//     ),
//     {
//         provide: HTTP_INTERCEPTORS, useClass: ClassInterceptorExample, multi: true
//     }
//  ]
// }).catch((err) => console.error(err));
