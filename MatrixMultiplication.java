package taask1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class MatrixMultiplication {
    static final int SIZE = 100;
    public static void main(String[] args) {

        int[][] A = new int[SIZE][SIZE];
        int[][] B = new int[SIZE][SIZE];
        int[][] C = new int[SIZE][SIZE];

        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {

            for (int j = 0; j < SIZE; j++) {

                A[i][j] = random.nextInt(10);
                B[i][j] = random.nextInt(10);
                C[i][j] = 0;
            }
        }
        MatrixPanel panel = new MatrixPanel(A, B, C);

        JFrame frame = new JFrame(
                "Matrix Multiplication in Action (100 x 100)"
        );

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setSize(1200, 520);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        Thread[] threads = new Thread[SIZE * SIZE];

        int count = 0;

        for (int i = 0; i < SIZE; i++) {

            for (int j = 0; j < SIZE; j++) {

                threads[count] =
                        new MatrixThread(A, B, C, i, j, panel);

                threads[count].start();

                count++;
            }
        }

        for (int i = 0; i < threads.length; i++) {

            try {
                threads[i].join();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Matrix A: 100 x 100");
        System.out.println("Matrix B: 100 x 100");
        System.out.println("Threads used: 10000");
        System.out.println("Matrix Multiplication Completed!");

        System.out.println(
                "\nFirst 5 x 5 elements of Result Matrix:"
        );

        for (int i = 0; i < 5; i++) {

            for (int j = 0; j < 5; j++) {

                System.out.print(C[i][j] + "\t");
            }

            System.out.println();
        }
    }
}

class MatrixPanel extends JPanel {

    int[][] A;
    int[][] B;
    int[][] C;

    int currentRow = -1;
    int currentCol = -1;

    MatrixPanel(int[][] A, int[][] B, int[][] C) {

        this.A = A;
        this.B = B;
        this.C = C;

        setBackground(Color.WHITE);
    }
    synchronized void setCurrent(int row, int col) {

        currentRow = row;
        currentCol = col;

        repaint();
    }

 
    synchronized void updateCell(int row, int col, int value) {

        C[row][col] = value;

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        int size = 350;

        int startX1 = 20;
        int startX2 = 420;
        int startX3 = 820;

        int startY = 70;

    

        g.setColor(Color.BLACK);

        g.setFont(new Font("Arial", Font.BOLD, 20));

        g.drawString(
                "Matrix A",
                startX1 + 130,
                40
        );

        g.drawString(
                "Matrix B",
                startX2 + 130,
                40
        );

        g.drawString(
                "Matrix C (building live)",
                startX3 + 65,
                40
        );

     
        drawMatrix(
                g,
                A,
                startX1,
                startY,
                size,
                0
        );

        drawMatrix(
                g,
                B,
                startX2,
                startY,
                size,
                1
        );

        drawMatrix(
                g,
                C,
                startX3,
                startY,
                size,
                2
        );
        if (currentRow >= 0) {

            int y = startY
                    + (currentRow * size / MatrixMultiplication.SIZE);

            g.setColor(Color.RED);

            g.fillRect(
                    startX1,
                    y,
                    size,
                    Math.max(
                            2,
                            size / MatrixMultiplication.SIZE
                    )
            );
        }

   

        if (currentCol >= 0) {

            int x = startX2
                    + (currentCol * size / MatrixMultiplication.SIZE);

            g.setColor(Color.RED);

            g.fillRect(
                    x,
                    startY,
                    Math.max(
                            2,
                            size / MatrixMultiplication.SIZE
                    ),
                    size
            );
        }


        g.setColor(Color.BLACK);

        g.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        14
                )
        );

        if (currentRow >= 0) {

            g.drawString(
                    "Processing row: "
                            + currentRow
                            + "   column: "
                            + currentCol,
                    450,
                    465
            );
        }
    }
    void drawMatrix(
            Graphics g,
            int[][] matrix,
            int startX,
            int startY,
            int size,
            int type) {

        int cellSize =
                size / MatrixMultiplication.SIZE;

        for (int i = 0;
             i < MatrixMultiplication.SIZE;
             i++) {

            for (int j = 0;
                 j < MatrixMultiplication.SIZE;
                 j++) {

                int value = matrix[i][j];


                if (type == 0) {

                    int intensity =
                            Math.min(255, value * 25);

                    g.setColor(
                            new Color(
                                    220 - intensity / 2,
                                    240 - intensity / 2,
                                    255
                            )
                    );
                }
                else if (type == 1) {

                    int intensity =
                            Math.min(255, value * 25);

                    g.setColor(
                            new Color(
                                    220 - intensity / 2,
                                    255,
                                    220 - intensity / 2
                            )
                    );
                }
                else {

                    int intensity =
                            Math.min(255, value / 2);

                    g.setColor(
                            new Color(
                                    255,
                                    240 - intensity / 2,
                                    180
                            )
                    );
                }
                g.fillRect(
                        startX + j * cellSize,
                        startY + i * cellSize,
                        cellSize + 1,
                        cellSize + 1
                );
            }
        }
    }
}
