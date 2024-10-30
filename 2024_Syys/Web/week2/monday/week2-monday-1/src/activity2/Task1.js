import { T1Main } from "./t1Components/Main";
import { Header } from "./t1Components/Header";
import { Footer } from "./t1Components/Footer";

import './t1_styles.css';

export default function Task1(){
    return(
        <div>
            <Header />
            <T1Main />
            <Footer />
        </div>
    )
}