export class Immobilier {
    Id : number ;
    titre : string;
    addressOwner : string ; 
    price : number ;
    surface: number ;
    Ville : string ;
    image : string ;
    Announced : boolean ;

    constructor(){
        this.Id=0;
        this.titre="";
        this.addressOwner="";
        this.price=0;
        this.surface=0;
        this.image="";
        this.Announced=true;
        this.Ville="";
    }
}
