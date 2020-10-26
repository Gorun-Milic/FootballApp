export class Playerdto {
    playerid: number
    age: number
    assists: number
    goals: number
    position: string
    imgUrl: string
    name: string
    surname: string
    foot: string
    height: number
    clubid: number
    dateofbirth: string

    constructor(playerid: number, age: number, assists: number, goals: number, position: string, imgUrl: string, name: string,surname: string, foot: string, height: number, clubid: number, dateofbirth: string) {
        this.playerid = playerid
        this.age = age
        this.assists = assists
        this.goals = goals
        this.position = position
        this.imgUrl = imgUrl
        this.name = name
        this.surname = surname
        this.foot = foot
        this.height = height
        this.clubid = clubid
        this.dateofbirth = this.dateofbirth
    }

}