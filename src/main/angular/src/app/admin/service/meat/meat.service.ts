import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse} from "@angular/common/http";
import {Observable, throwError} from "rxjs";
import {IVegetable} from "../../model/vegetable";
import {IngredientError} from "../../model/ingredientError";
import {IMeat} from "../../model/meat";
import {catchError} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class MeatService {

  constructor(private http: HttpClient) { }

  getAllMeat(): Observable<IMeat[] | IngredientError> {
    return this.http.get<IMeat[]>("/menumaker/meat")
      .pipe(
        catchError(err => this.handleHttpError(err))
      );
  }

  getMeatById(id: number): Observable<IMeat | IngredientError> {
    return this.http.get<IMeat>(`/menumaker/meat/${id}`)
      .pipe(catchError(err => this.handleHttpError(err)));
  }

  private handleHttpError(error: HttpErrorResponse) : Observable<IngredientError>{
    let dataError = new IngredientError();
    dataError.errorNumber = error.status;
    dataError.errorMessage = error.message;
    dataError.userFriendlyMessage = "Er liep iets fout bij het ophalen van de vlees data";
    return throwError(dataError);
  }
}
