OS_Task1
 Multithreading Assignment
 Overview

This project demonstrates two important multithreading problems using Java:

Producer-Consumer Problem using Java Threads
Matrix Multiplication using Java Threads with Animation

The project demonstrates concepts such as thread creation, synchronization, shared resources, wait(), notify(), concurrent execution, matrix multiplication, and graphical visualization using Java Swing.

 Files in this Repository
File	                   Description
ProducerConsumer.java	   Main class for Producer-Consumer
SharedBuffer.java	   Shared buffer used by Producer and Consumer
MatrixMultiplication.java  Main class for matrix multiplication
MatrixThread.java	  Thread implementation for matrix multiplication
README.md	          Project documentation

 Producer-Consumer Problem
 Description

The Producer-Consumer Problem is implemented using Java Threads and a shared buffer.

The Producer generates numbers and stores them in the shared buffer, while the Consumer removes and consumes the values from the buffer.

Since both threads access the same shared resource, synchronization is used to ensure correct execution.

 How It Works

The SharedBuffer class stores the value produced by the Producer.

The produce() method is synchronized so that only one thread can access the shared buffer at a time.

If the buffer already contains an item, the Producer waits using wait().

After producing an item, the Producer sets the buffer as available and uses notify() to wake the Consumer.

Similarly, the Consumer waits when there is no item available.

After consuming the item, the Consumer makes the buffer available again and notifies the Producer.

This allows the Producer and Consumer to communicate safely.

🔹 Concepts Used
Java Threads
Producer Thread
Consumer Thread
Shared Resource
Synchronization
synchronized
wait()
notify()
Thread Communication

▶️ How to Run
Using Eclipse
Create a Java project.
Create the package task1.
Add all Producer-Consumer Java files.
Open ProducerConsumer.java.
Run it as a Java Application.
Using Terminal

Compile:

javac task1/*.java

Run:

java task1.ProducerConsumer

🖥️ Sample Output

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

The exact order may vary because the Producer and Consumer execute concurrently.

2️⃣ Matrix Multiplication Using Threads
📖 Description

The second program implements matrix multiplication using Java Threads.

Two matrices of size 100 × 100 are generated and multiplied to produce a third matrix.

Matrix A → 100 × 100
Matrix B → 100 × 100
Matrix C → 100 × 100

Every element of the result matrix C is calculated by a separate thread.

Since the result matrix contains 100 × 100 = 10,000 elements, the program creates 10,000 threads.

📌 Problem Statement

Implement Matrix multiplication of 2 matrices using Threads. Minimum 100 rows & 100 columns. Every multiplication operation must be on a thread.

⚙️ How It Works

First, two 100 × 100 matrices are generated with random values.

For every position (row, column) of Matrix C, a new MatrixThread is created.

Each thread calculates one element of Matrix C using the formula:

C[i][j] = A[i][0] × B[0][j] + A[i][1] × B[1][j] + ... + A[i][99] × B[99][j]

Therefore:

One Thread → One Result Matrix Element

For a 100 × 100 matrix:

100 × 100 = 10,000 Threads

The main program uses join() to wait until all threads complete their calculations.

🧵 Thread Execution

The MatrixThread class extends the Java Thread class.

Each thread receives:

Matrix A
Matrix B
Matrix C
Row number
Column number
GUI panel

The thread calculates its assigned element of Matrix C independently.

After all threads complete, the program displays:

Matrix Multiplication Completed!

🎨 GUI Visualization

The program uses Java Swing to display the matrix multiplication process visually.

The GUI displays:

Matrix A
Matrix B
Matrix C (building live)

A red horizontal marker shows the current row being processed in Matrix A.

A red vertical marker shows the current column being processed in Matrix B.

Matrix C is updated as the threads complete their calculations.

The GUI also displays the current processing row and column.

Example:

Processing row: 25 column: 40

🎬 Matrix Multiplication Animation

The program provides a live animation of the matrix multiplication process.

The animation shows Matrix A, Matrix B, and Matrix C while the threads are executing.

The red row and column indicate the current position being processed, while Matrix C is gradually built during execution.

The GIF above is the recorded output of the Java Swing matrix multiplication program.

🖥️ Sample Console Output

Matrix A: 100 x 100
Matrix B: 100 x 100
Threads used: 10000
Matrix Multiplication Completed!

First 5 x 5 elements of Result Matrix:

The values of the result matrix are randomly generated, so the exact values will be different each time the program is executed.

🔹 Concepts Used
Java Threads
Multithreading
Matrix Multiplication
Thread Creation
Thread Execution
Thread.start()
Thread.join()
Thread.sleep()
Java Swing
JFrame
JPanel
AWT Graphics
SwingUtilities.invokeLater()
GUI Visualization
▶️ How to Run Matrix Multiplication
Using Eclipse
Create a Java project.
Create the package task1.
Add MatrixMultiplication.java and MatrixThread.java.
Open MatrixMultiplication.java.
Run it as a Java Application.
The matrix multiplication window will appear.
The animation will show the execution process.
Using Terminal

Compile:

javac task1/MatrixMultiplication.java task1/MatrixThread.java

Run:

java task1.MatrixMultiplication

🛠️ Technologies Used
Java
Java Threads
Multithreading
Java Swing
AWT Graphics
Synchronization
Random Number Generation
📋 Requirements
Java JDK 8 or above
Eclipse / IntelliJ IDEA / VS Code / NetBeans
Command Prompt or Terminal

🎯 Learning Outcomes

Through this assignment, the following concepts are demonstrated:
Creation and execution of Java Threads.
Understanding multithreading.
Synchronization of shared resources.
Using wait() and notify().
Implementing the Producer-Consumer problem.
Understanding thread communication.
Performing matrix multiplication using multiple threads.
Creating one thread for each result matrix element.
Using Thread.start() and Thread.join().
Using Java Swing for graphical visualization.
Visualizing multithreaded execution using animation.

📌 Conclusion
This project demonstrates multithreading through two different applications.
The Producer-Consumer Problem demonstrates communication between threads using a shared buffer, synchronization, wait(), and notify().
The Matrix Multiplication Problem demonstrates how a 100 × 100 matrix multiplication can be divided into 10,000 independent tasks, with one thread calculating each result element.
The Java Swing animation provides a visual representation of the matrix multiplication process by showing the current row, column, and result matrix while the threads are executing.
