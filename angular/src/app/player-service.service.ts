import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Player } from './Player';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { PlayerNationdto } from './PlayerNationdto';
import { Nation } from './Nation';

@Injectable({
  providedIn: 'root'
})
export class PlayerServiceService {

  private playerId = 0;

  private _url = "http://localhost:8080/player";
  private _url1= "http://localhost:8080/player";
  private _url2= "http://localhost:8080/addplayer";
  private _url3 = "http://localhost:8080/playernation";
  private _url4 = "http://localhost:8080/playernation";


  constructor(private http: HttpClient, private router: Router) { }

  addPlayer(uploadData: FormData, playernation: PlayerNationdto) {
    console.log("usao u player service");
    this.http.post<Player>(this._url2, uploadData).subscribe(data=>{this.playerId = data.playerid;
                                                                    if (playernation.nationid1!=undefined || playernation.nationid2!=undefined) {
                                                                        playernation.playerid = this.playerId;
                                                                        console.log(playernation);
                                                                        this.addPlayerNation(playernation);
                                                                    }
      this.router.navigate(['/club']);
    });
  }

  addPlayerNation(playernation: PlayerNationdto) {
    console.log(playernation);
    this.http.post<string>(this._url3, playernation).subscribe(data=>console.log(data));
  }

  removePlayer(playerid: number): Observable<string> {
    return this.http.delete<string>(this._url1 + "/" + playerid);
  }

  editPlayer(playerModel: Player) {
    this.http.put<Player>(this._url, playerModel).subscribe(data=>{this.playerId = data.playerid;
      this.router.navigate(['/club']);
    });
  }

  getPlayerNations(playerid: number): Observable<Nation[]> {
    return this.http.get<Nation[]>(this._url4 + '/' + playerid);
  }

  
}
