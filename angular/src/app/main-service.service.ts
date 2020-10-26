import { Injectable } from '@angular/core';
import {  HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Club } from './Club';
import { League } from './League';
import { Router } from '@angular/router';
import { Player } from './Player';
import { Clubdto } from './Clubdto';
import { Imagedto } from './Imagedto';
import { Nation } from './Nation';

@Injectable({
  providedIn: 'root'
})
export class MainServiceService {

  //session data
  private id = 0;
  public club = new Club(undefined, '', '', '', undefined, undefined, undefined);

  //urls
  private _url = "http://localhost:8080/club";
  private _url1 = "http://localhost:8080/leagues";
  private _url2  = "http://localhost:8080/playersByClub";
  private _url4  = "http://localhost:8080/login";
  private _url5  = "http://localhost:8080/nations";

  //other data
  public players = [];

  constructor(private http: HttpClient, private router: Router) { }


  getClubId() {
    return this.id;
  }

  setClubId(clubid: number) {
    this.id = clubid;
  }

  getClub(): Club {
    return this.club;
  }

  setClub(club: Club) {
    this.club = club;
  }

  //register club
  register(clubModel: Clubdto) {
      this.http.post<Club>(this._url, clubModel).subscribe(data=>{this.club = data;
                                                    this.id = data.clubid
                                                    this.router.navigate(['/club']);});
  }

  //login club
  login(clubModel: Clubdto) {
    this.http.post<Club>(this._url4, clubModel).subscribe(data=>{this.club = data;
                                                  this.id = data.clubid
                                                  this.router.navigate(['/club']);});
  }

  //get all leagues
  getLeagues(): Observable<League[]> {
    return this.http.get<League[]>(this._url1);
  }

  //get all nations
  getNations(): Observable<Nation[]> {
    return this.http.get<Nation[]>(this._url5);
  }

  //get all player who play in a current club
  getPlayers(clubId: number) {
    return this.http.get<Player[]>(this._url2 + "/" + clubId);
    //on prvo returnuje players pa tek onda izvrsi http poziv zato je lista prazna na pocetku
  }

  editClub(club: Club) {
    this.http.put<Club>(this._url, club).subscribe(data=>{this.id = data.clubid;
                                                          this.club = data;
                                                          this.router.navigate(['/club']);
                                                          
    });
  }

  uploadPhoto(uploadData): Observable<Club> {
    return this.http.put<Club>('http://localhost:8080/image', uploadData);
  }



}
