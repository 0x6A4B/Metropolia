/* Difference between function declaration and expression:
 * when we declare the function it is acessible as it is set to the beginning of the scope
 * unlike variables which aren't initialized before the actual line where the initialization happens
 * same goes for the function expression, it won't be usable before the actual line
 * where it is initialized by the expression and calling the function variable before 
 * the initialization returns a null variable, just like with variables
 * 
 * Compiler/interpreter handles function declarations before else and therefore
 * functions CAN be declared in the end of the code and still be used before the line
 * where declaration happens. This is NOT true for variables and therefore for function expressions
 */


// 1.
const cube = (x) => x * x * x;
  
// 2.
const fullName = (first, last) => first + " " + last;
  
// 3.
const power = (base, exp) => {
    if (exp === 0) {
        return 1;
    }
    return base * power(base, exp - 1);
}

// 4.
const sumCubes = (numbers) => {
    let total = 0;
    for (let i = 0; i < numbers.length; i++) {
        total = total + cube(numbers[i]);
    }
    return total;
}

console.log(cube(2));
console.log(fullName("Joe", "Smith"));
console.log(power(2, 8));   // byte is 8 bits and maximum amount of values is 2^8 == 256
console.log(sumCubes([1, 2, 3]));

/* 1.
 * Because the variable hasn't been initialized yet
 */

/* 2.
 * Let is block scoped as opposed to function/global scoped var
 * The message hasn't been defined in the eyes of the interpreter
 * as opposed to the var example which has been defined but to undefined
 * In this case the var would be a global variable as it's not within a function
 */

/* 3.
 * The function expression is not initialized before the line of it's actual expression
 * therefore there is no such object
 * 
 * If it would be a function declaration instead of expression it would have worked
 * as function declarations are done before running the code by the interpreter
 */

/* 4.
 * As the function is declared instead of an expression it is hoisted => the function
 * is defined and initialized by the interpreter at the start of the execution of the code
 * Like functions normally operate in programming languages, might need to have a prototype
 * in the beginning as in C++ but then it can be placed to the end of the file
 */



// 1.
let values = [10, 20, 30];
for(let i = 0; i < values.length; i++){
    console.log(values[i]);
}  


// 2.
let lastLogin = '1/1/1970';
console.log(welcome('Charlie', 'Munger'));

function welcome(first, last) {
  return `Welcome, ${first} ${last}! You last logged in on ${lastLogin}.`
};

