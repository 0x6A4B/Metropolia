const sayHello = () => "Hello, world!";

const double = (x) => x*2;

const add = (x,y) => x+y;

/* This won't work as lambda function in js won't have this pointing to
 * the object but inherits it, in this case from window or global object
*/

const person = {
    name: "alice",
    sayHi: () => "Hi, " + this.name + "!!",
    sayHello: null,
    _init: function(){
        this.sayHello = () => "Hi, " + this.name + "!"; // inheriting this from function _init
    }
};


const numbers = [1, 2, 3, 4, 5];

const doubled = [];
numbers.forEach((num) => {
  doubled.push(num * 2);
});





console.log(sayHello(), double(2), add(1,2));

console.log(person.sayHi());
person._init(); // initialize the value of sayHello
console.log(person.sayHello());

doubled.forEach((i) => console.log(i));