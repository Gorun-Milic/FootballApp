import { Component, OnInit } from '@angular/core';
import { MainServiceService } from '../main-service.service'; 
import { Club } from '../Club';
import { RememberServiceService } from '../remember-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-remember',
  templateUrl: './remember.component.html',
  styleUrls: ['./remember.component.css']
})
export class RememberComponent implements OnInit {

  private id = 0;
  public club = new Club(undefined, '', '', '', undefined, undefined, undefined);

  public playerclubs = [];

  constructor(private router: Router, private _mainService: MainServiceService, private _rememberService: RememberServiceService) { }

  ngOnInit() {
    this.id = this._mainService.getClubId();
    this.club = this._mainService.getClub();
    this._rememberService.getRememberedPlayers(this.id).subscribe(data=>{this.playerclubs = data});
  }

  showPlayer(playerid: number) {
    this.router.navigate(['/watchplayer', playerid]);
  }


}
