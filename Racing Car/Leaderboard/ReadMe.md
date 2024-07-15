Difficulties met for creating unit tests for Leaderboard

1) Because of the dependencies between Race and Drive classes, two private methods had to be implemented for using these classes.
2) While trying to implement a test to compare the rankings for a race, there is a difficulty to receive the algorithm version of self-driving car.

SOLID principles that the class Leaderboard violates

1) Single Responsibility Principle : class Leaderboard has many responsibilities (calculating driver's results and sorting drivers)
2) Open - Closed Principle: class Leaderboard is not easily extendable
3) Dependency Inversion Principle : class Leaderboard depends on other implementations rather than abstract classes.