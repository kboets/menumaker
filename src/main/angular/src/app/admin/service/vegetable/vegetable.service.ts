import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpHeaders} from "@angular/common/http";
import {Observable, throwError} from "rxjs";
import {IVegetable} from "../../model/vegetable";
import {catchError} from "rxjs/operators";
import {IngredientError} from "../../model/ingredientError";

@Injectable({
  providedIn: 'root'
})
export class VegetableService {

 constructor(private http: HttpClient) { }

  getAllVegetables() : Observable<IVegetable[] | IngredientError> {
    return this.http.get<IVegetable[]>("/menumaker/vegetable")
      .pipe(
        catchError(err => this.handleHttpError(err))
      );
  }

  getVegetableById(id : number): Observable<IVegetable> {
    return this.http.get<IVegetable>(`/menumaker/vegetable/${id}`)
  }

  addVegetable(vegetable : IVegetable): Observable<IVegetable> {
   return this.http.post<IVegetable>("/menumaker/vegetable", vegetable, {
     headers:new HttpHeaders({
        'Content-Type' : 'application/json'
     })
   });
  }

  updateVegetable(vegetable : IVegetable): Observable<void> {
    return this.http.put<void>("/menumaker/vegetable", vegetable, {
      headers:new HttpHeaders({
        'Content-Type' : 'application/json'
      })
    });
  }

  deleteVegetable(vegetableId : number) : Observable<void> {
   return this.http.delete<void>(`/menumaker/vegetable/${vegetableId}`)
  }

  private handleHttpError(error: HttpErrorResponse) : Observable<IngredientError>{
    let dataError = new IngredientError();
    dataError.errorNumber = error.status;
    dataError.errorMessage = error.message;
    dataError.userFriendlyMessage = "Er liep iets fout bij het ophalen van de data";
    return throwError(dataError);
  }
}
