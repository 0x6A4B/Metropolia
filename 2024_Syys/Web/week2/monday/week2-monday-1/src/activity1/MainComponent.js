export default function MainComponent(props){
    return (
        <main>
            <p>
                React is a JavaScript library for building user interfaces. In this lab, we'll create and compose basic React components.
            </p>
            <ul>
            {
            props.data.map(d => {
                    return <li>{d.data}</li>;
                }
            )
        }
        </ul>
        </main>
    );
}