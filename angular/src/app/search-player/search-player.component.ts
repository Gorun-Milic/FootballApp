import { Component, OnInit } from '@angular/core';
import { MainServiceService } from '../main-service.service'; 
import { Club } from '../Club';
import { SearchServiceService } from '../search-service.service';
import { RememberServiceService } from '../remember-service.service';
import { Playerclub } from '../Playerclub';
import { Playerclubdto } from '../Playerclubdto';
import { Router } from '@angular/router';
import { SearchplayersDTO } from 'src/SearchplayersDTO';

@Component({
  selector: 'app-search-player',
  templateUrl: './search-player.component.html',
  styleUrls: ['./search-player.component.css']
})
export class SearchPlayerComponent implements OnInit {

  //session data
  private id = 0;
  public club = new Club(undefined, '', '', '', undefined, undefined, undefined);

  //searched data
  public searchPlayer = new SearchplayersDTO('', '', '', undefined, '', undefined);
  public players = [];
  public positions = ["GK", "RB", "CB", "LB", "DMF", "CMF", "RW", "AMF", "LW", "CF"]

  constructor(private router: Router, private _mainService: MainServiceService, private _searchService: SearchServiceService, private _rememberService: RememberServiceService) { }

  ngOnInit() {
    this.id = this._mainService.getClubId();
    this.club = this._mainService.getClub();
    this._searchService.getPlayers().subscribe(data=>this.players = data);
  }

  // rememberPlayer(playerid: number) {
  //   let playerclub = new Playerclubdto(undefined, playerid, this.id);
  //   this._rememberService.rememberPlayerclub(playerclub);
  // }

  showPlayer(playerid: number) {
    this.router.navigate(['/watchplayer', playerid]);
  }

  searchPlayers() {
    this._searchService.searchPlayers(this.searchPlayer).subscribe(data=>this.players = data);
  }

  
}
