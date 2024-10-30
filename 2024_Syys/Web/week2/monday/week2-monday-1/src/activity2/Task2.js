import Header from "./t2Components/Header";
import Section from "./t2Components/Section";
import Sidebar from "./t2Components/Sidebar";
import Article from "./t2Components/Article";
import Footer from "./t2Components/Footer";


import './t2_styles.css';

const appTitle = 'JSX and Props Showcase';
const section1Content = 'This is the content of section 1.';
const article1Title = 'Article 1';
const article1Text = 'Content of Article 1.';
const sidebarContent = 'Sidebar content goes here.';
const section2Content = 'This is the content of section 2.';
const footerText = 'Copyright © 2024 JSX Props App';

export default function Task2(){
    return(
        <div>
            <Header title={appTitle} />
            <Section heading="Section 1" content={section1Content} />
            <Article title={article1Title} text={article1Text} />
            <Sidebar content={sidebarContent} />
            <Section heading="Section 2" content={section2Content} />
            <Footer text={footerText} />
        </div>
    )
}