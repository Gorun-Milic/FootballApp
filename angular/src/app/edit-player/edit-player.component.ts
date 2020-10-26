import { Component, OnInit } from '@angular/core';
import { MainServiceService } from '../main-service.service'; 
import { Club } from '../Club';
import { Player } from '../Player';
import { RememberServiceService } from '../remember-service.service';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { PlayerServiceService } from '../player-service.service';

@Component({
  selector: 'app-edit-player',
  templateUrl: './edit-player.component.html',
  styleUrls: ['./edit-player.component.css']
})
export class EditPlayerComponent implements OnInit {

  //session data
  private id = 0;
  public club = new Club(undefined, '', '', '', undefined, undefined, undefined);

  //player data
  public playerid;
  public playerModel: Player;

  //other data
  public positions = ["GK", "RB", "CB", "LB", "DMF", "CMF", "RW", "AMF", "LW", "CF"]

  constructor(private _playerService: PlayerServiceService,private _mainService: MainServiceService, private _rememberService: RememberServiceService, private route: ActivatedRoute) { }

  ngOnInit() {
    //init data
    this.id = this._mainService.getClubId();
    this.club = this._mainService.getClub();
    console.log(this.id)
    this.playerModel = new Player(undefined, undefined, undefined, undefined, '', '', '', '', '', undefined, undefined, undefined);

    //geting params from navigation
    this.route.paramMap.subscribe((params: ParamMap)=> {
      this.playerid = parseInt(params.get('playerid'))});

    //getting player      
    this._rememberService.getPlayer(this.playerid).subscribe(data=>{this.playerModel = data});
    console.log(this.playerModel);
  }

  editPlayer() {
    this.playerModel.clubid = this.id;
    console.log(this.playerModel);
    this._playerService.editPlayer(this.playerModel);
  }

}
