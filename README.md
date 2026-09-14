# Java Thread Programming

This repository contains two Java programs demonstrating the use of Threads and Multithreading in Java.

# Programs Included

# 1. Producer-Consumer Problem

The first program demonstrates the Producer-Consumer problem using Java threads, synchronization, `wait()`, and `notify()`.

# Concepts Used

* Java Threads
* `synchronized` methods
* `wait()`
* `notify()`
* Shared buffer
* Producer and Consumer threads

#How It Works

* The Producer generates numbers from 1 to 5.
* The produced value is stored in a shared buffer.
* The Consumer consumes the values from the shared buffer.
* `wait()` is used when the buffer is not ready.
* `notify()` is used to wake up the waiting thread.
* Synchronization ensures that the Producer and Consumer access the shared buffer safely.

# Files
ProducerConsumer.java


Sample Output

Produced: 1
Consumed: 1
Produced: 2
Consumed: 2
Produced: 3
Consumed: 3
Produced: 4
Consumed: 4
Produced: 5
Consumed: 5


## 2. Matrix Multiplication Using Threads

The second program performs 100 × 100 matrix multiplication using 10,000 threads.

Each multiplication operation for one element of the result matrix is performed by a separate thread.

# Concepts Used

* Java Threads
* Multithreading
* Matrix multiplication
* Swing GUI
* JFrame
* JPanel
* SwingUtilities.invokeLater()
* Thread.sleep()
* Thread.join()

# How It Works

Two matrices are generated:


Matrix A → 100 × 100
Matrix B → 100 × 100


The result matrix is:


Matrix C → 100 × 100


For every element `C[i][j]`, a separate thread calculates:

C[i][j] = A[i][0] × B[0][j]
        + A[i][1] × B[1][j]
        + ...
        + A[i][99] × B[99][j]


Since there are 100 × 100 elements in the result matrix:


100 × 100 = 10,000 threads

# GUI Visualization

The program also provides a graphical visualization using Java Swing.

It displays:

* Matrix A
* Matrix B
* Matrix C (building live)

The current row and column being processed are highlighted while the threads are running.

 Files

text
MatrixMultiplication.java
MatrixThread.java


# Sample Console Output


Matrix A: 100 x 100
Matrix B: 100 x 100
Threads used: 10000
Matrix Multiplication Completed!

First 5 x 5 elements of Result Matrix:
The values of the result matrix are generated randomly, so the exact numerical output will be different each time the program is executed.


 Technologies Used

* Java
* Java Threads
* Java Swing
* Multithreading
* Synchronization

## Requirements

* Java JDK 8 or above
* Eclipse / IntelliJ IDEA / VS Code / Command Prompt

# Producer-Consumer

Compile:

bash
javac ProducerConsumer.java


Run:

bash
java task1.ProducerConsumer


# Matrix Multiplication

Compile:

bash
javac MatrixThread.java MatrixMultiplication.java


Run:

bash
java task1.MatrixMultiplication

# Learning Outcomes

By completing these programs, the following concepts are demonstrated:

1. Creating and using Java threads.
2. Synchronizing shared resources.
3. Using `wait()` and `notify()`.
4. Implementing the Producer-Consumer problem.
5. Performing matrix multiplication using multiple threads.
6. Creating one thread for each result-matrix element.
7. Using Java Swing for graphical visualization.
8. Understanding thread execution and synchronization.


