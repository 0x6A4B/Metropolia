export class OverloadTest{

    constructor(){
        console.log("construcotr");
    }

    name() {
        console.log("_",1);
        
    }

    name(overload) {console.log(overload); }
    
}
