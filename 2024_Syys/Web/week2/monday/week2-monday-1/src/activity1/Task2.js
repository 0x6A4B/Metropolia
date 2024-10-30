export default function Task2(){
    return(
        <div>
          <h3>TASK 2/4:</h3>
          <Hello />
          <Bye />
        </div>
    );
}

function Hello(){
    return <p>Hiya</p>;
}
  
function Bye(){
return <p>Goodbye, React!</p>
}