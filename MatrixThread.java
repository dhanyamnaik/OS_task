package taask1;
import javax.swing.SwingUtilities;
class MatrixThread extends Thread {
    int[][] A;
    int[][] B;
    int[][] C;
    int row;
    int col;
    MatrixPanel panel;
    MatrixThread(
            int[][] A,
            int[][] B,
            int[][] C,
            int row,
            int col,
            MatrixPanel panel) {
        this.A = A;
        this.B = B;
        this.C = C;
        this.row = row;
        this.col = col;
        this.panel = panel;
    }
    @Override
    public void run() {
        panel.setCurrent(row, col);
        int sum = 0;
        for (int k = 0; k < MatrixMultiplication.SIZE; k++) {
            sum = sum + A[row][k] * B[k][col];
        }
        C[row][col] = sum;
        int result = sum;
        SwingUtilities.invokeLater(() -> {

            panel.updateCell(
                    row,
                    col,
                    result
            );
        });

        try {

            Thread.sleep(2);

        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }
}
