import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest, HttpResponse} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {Observable, of} from "rxjs";
import {HttpCacheService} from "./admin/service/vegetable/http-cache.service";
import {tap} from "rxjs/operators";

@Injectable()
export class CacheInterceptor implements HttpInterceptor {

  constructor(private cacheService: HttpCacheService) {  }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    //pass all non-cacheable requests and remove cach
    if(req.method !== "GET") {
      console.log(`Invalidating cache : ${req.method} ${req.url}`);
      this.cacheService.invalidateUrl(req.url);
      return next.handle(req);
    }

    //attempt to retrieve cached response
    const cachedResponse: HttpResponse<any> = this.cacheService.get(req.url);

    //return cached response
    if(cachedResponse) {
      console.log(`Returning cached response : ${cachedResponse.url}`);
      return of(cachedResponse);
    }

    //send request to server and add response to cache
    return next.handle(req)
      .pipe(
        tap(event => {
          if(event instanceof HttpResponse) {
            console.log(`Add item to cache : ${req.url}`);
            this.cacheService.put(req.url,event);
          }
        })
      );


    return undefined;
  }

}
