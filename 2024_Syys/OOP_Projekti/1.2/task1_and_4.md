# 1.2 Three Phase Simulation

### Task 1


a) Why does an arrival event need to generate a new arrival event?
  - As a discreet event simulation we do not run it real-time or time-sliced and based on time events, e.g. mminutes or seconds.
    We need to use the actual events to generate a next point in time to step the simulation to.
    The generated arrival event is our base clock that feeds the simulation. Without input or arrival events the conditions for conditional events will not be filled.
    It is also a booked event so isn't conditioned on some other event happening.
    The generation of input or arrival events keep the simulation queue running, without generating them the simulation will process already generated booked or conditional events and stop when finished with them.

b) Which event should be generated by the start of the service?
  - Arrival events for all routers so that we have our first events and time for them.





### Task 4


Call center simulation: Clock 16 (event B4, B3)

|Phase|Router Queue|Router|Oper 1 queue|Oper 1|Oper 2 queue|Oper 2|
|-----|------------|------|------------|------|------------|------|
|  B  |            |      |   X3       |      |            |  Y1  |
|  C  |            |      |            |  X3  |            |  Y1  |


|Event|Time|
|-----|----|
| B5  | 18 |
| B1  | 20 |
| B2  | 20 |
| B4  | 20 |


|Work comp|   |
|---------|---|
|  X      | 2 |
|  Y      | 0 |



Call center simulation: Clock 18 (event B5)

|Phase|Router Queue|Router|Oper 1 queue|Oper 1|Oper 2 queue|Oper 2|
|-----|------------|------|------------|------|------------|------|
|  B  |            |      |            |  X3  |            |      |
|  C  |            |      |            |  X3  |            |      |


|Event|Time|
|-----|----|
|     |    |
| B1  | 20 |
| B2  | 20 |
| B4  | 20 |


|Work comp|   |
|---------|---|
|  X      | 2 |
|  Y      | 1 |



