import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Playerclub } from './Playerclub';
import { Observable } from 'rxjs';
import { Playerclubdto } from './Playerclubdto';
import { Player } from './Player';
import { Club } from './Club';

@Injectable({
  providedIn: 'root'
})
export class RememberServiceService {

  //public playerclubobj = new Playerclub(undefined, undefined, undefined);

  private _url = "http://localhost:8080/playerclub";
  private _url1 = "http://localhost:8080/remembered";
  private _url3 = "http://localhost:8080/player";
  private _url4 = "http://localhost:8080/club";
  private _url5 = "http://localhost:8080/isremembered";
  private _url6 = "http://localhost:8080/deleteplayerclub";
  

  constructor(private http: HttpClient) { }

  rememberPlayerclub(playerclub: Playerclubdto): Observable<Playerclub> {
    return this.http.post<Playerclub>(this._url, playerclub);
  }

  getRememberedPlayers(clubid: number): Observable<Playerclub[]> {
    return this.http.get<Playerclub[]>(this._url1 + "/" + clubid);
  }

  getPlayer(playerid: number): Observable<Player> {
    return this.http.get<Player>(this._url3 + "/" + playerid);
  }

  getClub(clubid: number): Observable<Club> {
    return this.http.get<Club>(this._url4 + "/" + clubid);
  }

  isRemembered(playerclub: Playerclubdto): Observable<number> {
    return this.http.post<number>(this._url5, playerclub);
  }

  deletePlayerClub(playerclubid: number): Observable<string> {
    return this.http.delete<string>(this._url6 + "/" + playerclubid);
  }



}
