import { Component, OnInit } from '@angular/core';
import { MainServiceService } from '../main-service.service'; 
import { Club } from '../Club';
import { Player } from '../Player';
import { PlayerServiceService } from '../player-service.service';
import { Playerdto } from '../Playerdto';
import { PlayerNationdto } from '../PlayerNationdto';

@Component({
  selector: 'app-add-player',
  templateUrl: './add-player.component.html',
  styleUrls: ['./add-player.component.css']
})
export class AddPlayerComponent implements OnInit {

  //session data
  private id = 0;
  public club = new Club(undefined, '', '', '', undefined, undefined, undefined);

  //player data
  public playerModel = new Playerdto(undefined, undefined, undefined, undefined, '', '', '', '', '', undefined, undefined, '');
  public playernation = new PlayerNationdto(undefined, undefined, undefined);

  //other data
  public positions = ["GK", "RB", "CB", "LB", "DMF", "CMF", "RW", "AMF", "LW", "CF"]
  public nations;
  public nationid1;
  public nationid2;

  //photo data
  public selectedFile;
  imgURL: any;
  convertedImage: any;

  constructor(private _mainService: MainServiceService, private _playerService: PlayerServiceService) { }

  ngOnInit() {
    this.id = this._mainService.getClubId();
    this.playerModel.clubid = this.id;
    this.club = this._mainService.getClub();
    this.getNations();
  }

  getNations() {
    this._mainService.getNations().subscribe(data=>this.nations = data);
  }
  
  addPlayer() {
    const uploadData = new FormData();
    if (this.selectedFile==undefined) {
      this.selectedFile = new Blob();
    }
    uploadData.append('myFile', this.selectedFile, "name");
    uploadData.append('player', JSON.stringify(this.playerModel));

    console.log("usao u metod addPlayer()");

    console.log(this.playernation);

    this._playerService.addPlayer(uploadData, this.playernation);
  }

  public  onFileChanged(event) {
    console.log(event);
    this.selectedFile = event.target.files[0];

    // Below part is used to display the selected image
    let reader = new FileReader();
    reader.readAsDataURL(event.target.files[0]);
    reader.onload = (event2) => {
      this.imgURL = reader.result;
  }}

}
