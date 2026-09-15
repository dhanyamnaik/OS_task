OS_Task1
Multithreading Assignment
Overview

This project demonstrates two important multithreading problems using Java:

Producer-Consumer Problem using Java Threads
Matrix Multiplication using Java Threads with Animation

The project demonstrates thread creation, synchronization, shared resources, wait(), notify(), concurrent execution, matrix multiplication, and Java Swing visualization.

Files in this Repository
File	Description
ProducerConsumer.java	Main class for Producer-Consumer
SharedBuffer.java	Shared buffer used by Producer and Consumer
Producer.java	Producer thread implementation
Consumer.java	Consumer thread implementation
MatrixMultiplication.java	Main class for matrix multiplication
MatrixThread.java	Thread implementation for matrix multiplication
matrix-multiplication.gif	Animation of matrix multiplication
README.md	Project documentation
1. Producer-Consumer Problem
Description

The Producer-Consumer problem demonstrates communication between two threads using a shared resource.

The Producer generates values from 1 to 5.
The Consumer consumes the produced values.
A shared buffer is used to exchange data.
Synchronization is used to avoid conflicts between the threads.
Working
The Producer checks whether the buffer is available.
If the buffer already contains an item, the Producer waits.
The Producer produces an item and stores it in the buffer.
The Consumer waits if no item is available.
The Consumer consumes the item.
notify() is used to wake up the waiting thread.
Concepts Used
Java Threads
Producer-Consumer Problem
Shared Resource
Synchronization
synchronized
wait()
notify()
Entry Point
public class ProducerConsumer {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer();

        Producer p = new Producer(buffer);
        Consumer c = new Consumer(buffer);

        p.start();
        c.start();
    }
}
How to Run

If the package name is task1:

javac task1/*.java
java task1.ProducerConsumer
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

The exact order may vary because the threads run concurrently.

2. Matrix Multiplication Using Threads
Description

This program performs multiplication of two 100 x 100 matrices using Java Threads.

Every multiplication result C[i][j] is calculated by a separate thread.

Therefore:

Matrix A = 100 x 100
Matrix B = 100 x 100
Result Matrix C = 100 x 100
Total threads used = 10,000
Problem Statement

Implement matrix multiplication of two matrices using Threads.

Minimum 100 rows and 100 columns
Every multiplication operation must be performed using a thread
Display the matrix multiplication process using a graphical interface
Working
Two 100 x 100 matrices are created.
Random values are assigned to both matrices.
A separate MatrixThread is created for every result cell.
Each thread calculates one element of the result matrix.
All threads are started.
join() is used to wait until all threads are completed.
Java Swing is used to display the matrix multiplication process.
Matrix Multiplication Formula
C[i][j] = A[i][0] × B[0][j]
        + A[i][1] × B[1][j]
        + ...
        + A[i][99] × B[99][j]
Animation

The program provides a graphical visualization of the matrix multiplication process.

Matrix A is displayed on the left.
Matrix B is displayed in the middle.
Matrix C is displayed on the right.
The current row and column are highlighted.
Result values are updated as the threads complete their calculations.


How to Run

Make sure all Java files use the same package name, for example task1.

javac task1/MatrixMultiplication.java task1/MatrixThread.java
java task1.MatrixMultiplication
Sample Output
Matrix A: 100 x 100
Matrix B: 100 x 100
Result Matrix C: 100 x 100
Threads used: 10000
Matrix multiplication completed.
Technologies Used
Java
Java Threads
Multithreading
Java Swing
AWT Graphics
Synchronization
Random Number Generation
Requirements
JDK 8 or above
Eclipse, IntelliJ IDEA, VS Code, NetBeans, or Command Prompt
Git and GitHub
Learning Outcomes

Through this assignment, we learned:

How to create and use Java Threads
How multiple threads execute concurrently
How synchronization works
How wait() and notify() are used
How to solve the Producer-Consumer problem
How to perform matrix multiplication using multiple threads
How to use Java Swing for graphical visualization
How to manage multiple threads using join()
Conclusion

This project demonstrates the practical use of multithreading in Java through the Producer-Consumer problem and matrix multiplication. It shows how threads can be used for concurrent execution, synchronization, and improving the understanding of parallel processing.
