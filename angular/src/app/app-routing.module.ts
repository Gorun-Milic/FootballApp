import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ClubProfileComponent } from './club-profile/club-profile.component';
import { SearchComponent } from './search/search.component';
import { SearchClubComponent } from './search-club/search-club.component';
import { SearchPlayerComponent } from './search-player/search-player.component';
import { RememberComponent } from './remember/remember.component';
import { HomePageComponent } from './home-page/home-page.component';
import { AddPlayerComponent } from './add-player/add-player.component';
import { WatchPlayerComponent } from './watch-player/watch-player.component';
import { WatchClubComponent } from './watch-club/watch-club.component';
import { EditPlayerComponent } from './edit-player/edit-player.component';
import { EditClubComponent } from './edit-club/edit-club.component';


const routes: Routes = [
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: 'home', component: HomePageComponent},
  {path: 'club', component: ClubProfileComponent},
  {
    path: 'search',
    component: SearchComponent,
    children: [
      {path: 'searchclub', component: SearchClubComponent},
      {path: 'searchplayer', component: SearchPlayerComponent}
    ]
  },
  {path: 'remember', component: RememberComponent},
  {path: 'addplayer', component: AddPlayerComponent},
  {path: 'editplayer/:playerid', component: EditPlayerComponent},
  {path: 'editclub', component: EditClubComponent},
  {path: 'watchplayer/:playerid', component: WatchPlayerComponent},
  {path: 'watchclub/:clubid', component: WatchClubComponent},
  {path: '**', component: HomePageComponent}
]; 

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
