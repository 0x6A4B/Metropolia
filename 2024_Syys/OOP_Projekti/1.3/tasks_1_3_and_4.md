# 1.3 Probability Distributions


### Task 1

- Create a list of possible ages
    - Add a value to that age or age that corresponds to the percentage
        share of people of that age
- Create a list to hold the amount of generated ages
    - Array with elements as many as maximum age
- Generate a random number between 1 and 100
    - Match the number to age that corresponds to the chance of generating
        that number
    - Advance counter on the array with amount of generated ages in the index of that age
- Repeat for 1000 times to get better randomness for the distribution

For example:
- A two-dimensional array comprised of number determining the percentage of demographics
    and the age of the demographics
- Array with elements as many as the maximum age for tracking the amount of people of that age
- Loop through the array until the randomly generated number is at least as large as the start value
    of the range for that age
- Advance the value in the index corresponding that age in the array, e.g. if the age is 20 advance value in index 20
- Repeat 1000 times for better distribution
- Loop through the resulting array with the amount of people of specific age


#### Random number mapping to a percentage chance


```mermaid
flowchart LR
    draw[Generate a number between 1 and 100] --> num{What number?};
    num -- 1-10 --> 10[10% chance];
    num -- 11-30 --> 20[20% chance];
    num -- 31-60 --> 30[30% chance];
    num -- 61-100 --> 40[40% chance];
```


#### Flowchart of program flow


```mermaid
%%{init: {"flowchart": {"defaultRenderer": "elk"}} }%%
flowchart LR
    subgraph s1 [" "]
        draw[Draw a number between 1 and 100] --> num{What number?};
        num -- 1-10 --> 10[10% chance];
        num -- 11-30 --> 20[20% chance];
        num -- 31-60 --> 30[30% chance];
        num -- 61-100 --> 40[40% chance];
    end
    subgraph s2 [" "]
        10 --> loop[Loop through 2-dimensional array of ages];
        20 --> loop;
        30 --> loop;
        40 --> loop;

        loop --> found{Found a number number as large or larger?};
        found[Advance element in array of hits with index of the age] --> continue{Is it the last iteration?};

        continue -- Yes --> endd[The end];
        continue -- No ----> Continue;
    end
        Continue --> draw;


classDef class1 fill: white, stroke: white
class s1,s2 class1

```


### Task 3

Why can't a Singleton object be created from outside the Singleton class using the new operation?
- New would create a new instance of Singleton class and there can only be one static singleton
    therefore it must not be possible to instantiate the singleton object and it must be handled
    from within the singleton class


### Task 4

- Probability distributions
    - Binomial distribution and normal distribution
        - These could be used in our transportation simulation to decide
            which customers have seasonal tickets and who needs to buy a singletrip ticket and
            whether the passenger is heading to north or south (to city center or to suburbs)
        - If there will be more stations in the simulation this would be a perfect place for the use
            of normal distribution
- Exponential distribution
    - Often used to model customer arrivals so would be a good choice for generating arrival events






