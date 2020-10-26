import { Injectable } from '@angular/core';
import {  HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Club } from './Club';
import { Player } from './Player';
import { SearchclubDTO } from './SearchclubDTO';
import { SearchplayersDTO } from 'src/SearchplayersDTO';

@Injectable({
  providedIn: 'root'
})
export class SearchServiceService {

  //urls
  private _url = "http://localhost:8080/clubs"
  private _url1 = "http://localhost:8080/players"
  private _url2 = "http://localhost:8080/searchclubs"
  private _url3 = "http://localhost:8080/searchplayers"

  constructor(private http: HttpClient) { }

  getClubs(): Observable<Club[]> {
    return this.http.get<Club[]>(this._url);
  }

  getPlayers(): Observable<Player[]> {
    return this.http.get<Player[]>(this._url1);
  }

  searchClubs(searchClub: SearchclubDTO): Observable<Club[]> {
    return this.http.post<Club[]>(this._url2, searchClub);
  }

  searchPlayers(searchPlayer: SearchplayersDTO): Observable<Player[]> {
    return this.http.post<Player[]>(this._url3, searchPlayer);
  }
}
