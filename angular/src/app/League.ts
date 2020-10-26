export class League {
    leagueid: number
    name: string
    imgurl: string

    constructor(leagueid: number, name: string, imgurl: string) {
        this.leagueid = leagueid
        this.name = name
        this.imgurl = imgurl
    }
}