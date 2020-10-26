import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomePageComponent } from './home-page/home-page.component';
import { NavigationComponent } from './navigation/navigation.component';
import { ClubProfileComponent } from './club-profile/club-profile.component';
import { SearchComponent } from './search/search.component';
import { SearchClubComponent } from './search-club/search-club.component';
import { SearchPlayerComponent } from './search-player/search-player.component';
import { RememberComponent } from './remember/remember.component';
import { AddPlayerComponent } from './add-player/add-player.component';
import { EditPlayerComponent } from './edit-player/edit-player.component';
import { WatchClubComponent } from './watch-club/watch-club.component';
import { WatchPlayerComponent } from './watch-player/watch-player.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { EditClubComponent } from './edit-club/edit-club.component';
import { FooterComponent } from './footer/footer.component';

@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    NavigationComponent,
    ClubProfileComponent,
    SearchComponent,
    SearchClubComponent,
    SearchPlayerComponent,
    RememberComponent,
    AddPlayerComponent,
    EditPlayerComponent,
    WatchClubComponent,
    WatchPlayerComponent,
    EditClubComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
