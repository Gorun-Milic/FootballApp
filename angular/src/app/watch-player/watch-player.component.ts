import { Component, OnInit } from '@angular/core';
import { MainServiceService } from '../main-service.service'; 
import { Club } from '../Club';
import { RememberServiceService } from '../remember-service.service';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { Player } from '../Player';
import { Playerclubdto } from '../Playerclubdto';
import { Playerclub } from '../Playerclub';
import { PlayerServiceService } from '../player-service.service';

@Component({
  selector: 'app-watch-player',
  templateUrl: './watch-player.component.html',
  styleUrls: ['./watch-player.component.css']
})
export class WatchPlayerComponent implements OnInit {

  //session data
  private id = 0;
  public club = new Club(undefined, '', '', '', undefined, undefined, undefined);

  //player data
  private playerid;
  public player = new Player(undefined, undefined, undefined, undefined, '', '', '', '', '', undefined, undefined, undefined);
  public playerclubobj = new Playerclub(undefined, undefined, undefined);
  public playerclubid;

  //other data
  public remembered: boolean;
  public deleted: string;
  public nations = [];

  constructor(private router: Router, private _playerService: PlayerServiceService, private _mainService: MainServiceService, private _rememberService: RememberServiceService, private route: ActivatedRoute) { }

  ngOnInit() {
    //init session data
    this.id = this._mainService.getClubId();
    this.club = this._mainService.getClub();

    //geting params from navigation
    this.route.paramMap.subscribe((params: ParamMap)=> {
          this.playerid = parseInt(params.get('playerid'))});
    
    //getting player      
    this._rememberService.getPlayer(this.playerid).subscribe(data=>{this.player = data});

    //see if player is remembered
    this.isRemembered();

    //get player nationality
    this.getPlayerNations(this.playerid);
  }

  isRemembered() {
    console.log('ulaziiiii')
    let pc = new Playerclubdto(undefined, this.playerid, this.id);
    this._rememberService.isRemembered(pc).subscribe(data=>{this.playerclubid = data
                                                  console.log(this.playerclubid)
                                                   this.playerclubid == 0 ? this.remembered=false  : this.remembered= true});
    console.log(this.remembered)
  }

  rememberPlayer(playerid: number) {
    let playerclub = new Playerclubdto(undefined, playerid, this.id);
    this._rememberService.rememberPlayerclub(playerclub).subscribe(data=>{this.playerclubobj = data
                                                                          this.refreshComponent()});
  }

  forget() {
    this._rememberService.deletePlayerClub(this.playerclubid).subscribe(data=>{this.deleted = data
                                                                               this.refreshComponent()},
                                                                               error=>{
                                                                                this.refreshComponent()
                                                                               });
  }

  refreshComponent() {
    this.router.navigateByUrl('/RefreshComponent', { skipLocationChange: true }).then(() => {
      this.router.navigate(['/watchplayer', this.player.playerid]);
  });}

  getPlayerNations(playerid: number) {
    this._playerService.getPlayerNations(playerid).subscribe(data=>this.nations = data);
  }

}
