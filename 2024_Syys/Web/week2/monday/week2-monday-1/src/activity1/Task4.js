import Header from "./Header";
import Footer from "./Footer";
import MainComponent from "./MainComponent";


export default function Task4(props){
    return(
        <div>
            <Header />
            <MainComponent data={props.data} />
            <Footer />
        </div>
    )
}