export class Nation {

    private nationid: number
    private name: string
    private imgurl: string
    
    constructor(nationid: number, name: string, imgurl: string) {
        this.nationid = nationid
        this.name = name
        this.imgurl = imgurl
    }
}