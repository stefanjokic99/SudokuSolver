package prs.sudokuSolver;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private SudokuBoard board;
    private Solver boardSolver;

    private Button solveBtn;
    private long start, end;
    private int num_of_threads;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        board = findViewById(R.id.sudokuBoard);
        boardSolver = board.getSolver();

        solveBtn = findViewById(R.id.solveButton);
    }

    /**
     * @param menu
     * @return
     * Izbor inicijalnog broja niti na osnovu optimalnog broja
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        num_of_threads = Runtime.getRuntime().availableProcessors() - 1;
        getMenuInflater().inflate(R.menu.my_options_menu, menu);
        MenuItem item = null;
        if(num_of_threads == 1)
            item = menu.findItem(R.id.thread1);
        if(num_of_threads == 2)
            item = menu.findItem(R.id.thread2);
        if(num_of_threads == 3)
            item = menu.findItem(R.id.thread3);
        if(num_of_threads == 4)
            item = menu.findItem(R.id.thread4);
        if(num_of_threads == 5)
            item = menu.findItem(R.id.thread5);
        if(num_of_threads == 6)
            item = menu.findItem(R.id.thread6);
        if(num_of_threads == 7)
            item = menu.findItem(R.id.thread7);
        if(num_of_threads == 8)
            item = menu.findItem(R.id.thread8);
        item.setChecked(true);
        Toast.makeText(this, "Optimalan izbor za vaš uređaj je : " + item.getTitle(), Toast.LENGTH_LONG).show();

        return true;
    }

    /**
     * @param item
     * @return
     * Rukovalac menu-a za izbor niti
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.thread1:
                    if (item.isChecked()) {
                        item.setChecked(false);
                    } else {
                        item.setChecked(true);
                    }
                    num_of_threads = 1;
                break;
            case R.id.thread2:
                if(item.isChecked()) {
                    item.setChecked(false);
                }
                else {
                    item.setChecked(true);
                }
                num_of_threads = 2;
                break;
            case R.id.thread3:
                if(item.isChecked()) {
                    item.setChecked(false);
                }
                else {
                    item.setChecked(true);
                }
                num_of_threads = 3;
                break;
            case R.id.thread4:
                if(item.isChecked()) {
                    item.setChecked(false);
                }
                else {
                    item.setChecked(true);
                }
                num_of_threads = 4;
                break;
            case R.id.thread5:
                if(item.isChecked()) {
                    item.setChecked(false);
                }
                else {
                    item.setChecked(true);
                }
                num_of_threads = 5;
                break;
            case R.id.thread6:
                if(item.isChecked()) {
                    item.setChecked(false);
                }
                else {
                    item.setChecked(true);
                }
                num_of_threads = 6;
                break;
            case R.id.thread7:
                if(item.isChecked()) {
                    item.setChecked(false);
                }
                else {
                    item.setChecked(true);
                }
                num_of_threads = 7;
                break;
            case R.id.thread8:
                if(item.isChecked()) {
                    item.setChecked(false);
                }
                else {
                    item.setChecked(true);
                }
                num_of_threads = 8;
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }

    /**
     * @param view
     * Unos brojeva u izabrane celije
     */
    public void BTNOnePress(View view) {
        if (solveBtn.getText().toString().equals(getString(R.string.solve))) {
            boolean is_valid = boardSolver.setNumberPosition(1);
            if (!is_valid) {
                Toast.makeText(MainActivity.this, "Popunjavajte polja po sudoku pravilima!!!", Toast.LENGTH_SHORT).show();
            }
            board.invalidate();
        }
    }

    public void BTNTwoPress(View view) {
        if (solveBtn.getText().toString().equals(getString(R.string.solve))) {
            boolean is_valid = boardSolver.setNumberPosition(2);
            if (!is_valid) {
                Toast.makeText(MainActivity.this, "Popunjavajte polja po sudoku pravilima!!!", Toast.LENGTH_SHORT).show();
            }
            board.invalidate();
        }
    }

    public void BTNThreePress(View view) {
        if (solveBtn.getText().toString().equals(getString(R.string.solve))) {

            boolean is_valid = boardSolver.setNumberPosition(3);
            if (!is_valid) {
                Toast.makeText(MainActivity.this, "Popunjavajte polja po sudoku pravilima!!!", Toast.LENGTH_SHORT).show();
            }
            board.invalidate();
        }
    }

    public void BTNFourPress(View view) {
        if (solveBtn.getText().toString().equals(getString(R.string.solve))) {
            boolean is_valid = boardSolver.setNumberPosition(4);
            if (!is_valid) {
                Toast.makeText(MainActivity.this, "Popunjavajte polja po sudoku pravilima!!!", Toast.LENGTH_SHORT).show();
            }
            board.invalidate();
        }
    }

    public void BTNFivePress(View view) {
        if (solveBtn.getText().toString().equals(getString(R.string.solve))) {
            boolean is_valid = boardSolver.setNumberPosition(5);
            if (!is_valid) {
                Toast.makeText(MainActivity.this, "Popunjavajte polja po sudoku pravilima!!!", Toast.LENGTH_SHORT).show();
            }
            board.invalidate();
        }
    }

    public void BTNSixPress(View view) {
        if (solveBtn.getText().toString().equals(getString(R.string.solve))) {
            boolean is_valid = boardSolver.setNumberPosition(6);
            if (!is_valid) {
                Toast.makeText(MainActivity.this, "Popunjavajte polja po sudoku pravilima!!!", Toast.LENGTH_SHORT).show();
            }
            board.invalidate();
        }
    }

    public void BTNSevenPress(View view) {
        if (solveBtn.getText().toString().equals(getString(R.string.solve))) {
            boolean is_valid = boardSolver.setNumberPosition(7);
            if (!is_valid) {
                Toast.makeText(MainActivity.this, "Popunjavajte polja po sudoku pravilima!!!", Toast.LENGTH_SHORT).show();
            }
            board.invalidate();
        }
    }

    public void BTNEightPress(View view) {
        if (solveBtn.getText().toString().equals(getString(R.string.solve))) {
            boolean is_valid = boardSolver.setNumberPosition(8);
            if (!is_valid) {
                Toast.makeText(MainActivity.this, "Popunjavajte polja po sudoku pravilima!!!", Toast.LENGTH_SHORT).show();
            }
            board.invalidate();
        }
    }

    public void BTNNinePress(View view) {
        if (solveBtn.getText().toString().equals(getString(R.string.solve))) {
            boolean is_valid = boardSolver.setNumberPosition(9);
            if (!is_valid) {
                Toast.makeText(MainActivity.this, "Popunjavajte polja po sudoku pravilima!!!", Toast.LENGTH_SHORT).show();
            }
            board.invalidate();
        }
    }

    /**
     * @param start
     * Postavljanje pocetnog vremena rjesavanja
     */
    public void setStart(long start) {
        this.start = start;
    }

    /**
     * @param end
     * Postavljanje zavrsnog vremena rjesavanja
     */
    public void setEnd(long end) {
        this.end = end;
    }

    /**
     * @param view
     * Handler za click na Solve/Clear button
     */
    public void solve(View view) {
        // Slucaj klika na Solve
        if (solveBtn.getText().toString().equals(getString(R.string.solve))) {
            solveBtn.setText(getString(R.string.clear));
            boardSolver.getEmptyBoxIndex();

            // pokretanje broja niti u zavisnosti od vrijednosti varijable num_of_threads
            // finished se postavlja na false
            // Kreira se odredjen broj niti
            // Pokrecu se niti
            // Glavni program se vrti u beskonacnoj petlji dok se Sudoku ne rjesi
            // Terminiraju se niti
            if (num_of_threads == 1) {

                SolveBoardThread.finished = false;

                SolveBoardThread solve = new SolveBoardThread(board, this, "Prva nit", 1);

                solve.start();

                while (!SolveBoardThread.finished)
                    ;

                try {
                    solve.interrupt();

                    solve = null;
                } catch (Exception e) {
                }
            }
            if (num_of_threads == 2) {

                SolveBoardThread.finished = false;

                SolveBoardThread solve = new SolveBoardThread(board, this, "Prva nit", 1);
                SolveBoardThread solve2 = new SolveBoardThread(board, this, "Druga nit", 2);

                solve.start();
                solve2.start();

                while (!SolveBoardThread.finished)
                    ;

                try {
                    solve.interrupt();
                    solve2.interrupt();

                    solve = null;
                    solve2 = null;
                } catch (Exception e) {
                }
            }
            if (num_of_threads == 3) {

                SolveBoardThread.finished = false;

                SolveBoardThread solve = new SolveBoardThread(board, this, "Prva nit", 1);
                SolveBoardThread solve2 = new SolveBoardThread(board, this, "Druga nit", 2);
                SolveBoardThread solve3 = new SolveBoardThread(board, this, "Treća nit", 3);

                solve.start();
                solve2.start();
                solve3.start();

                while (!SolveBoardThread.finished)
                    ;

                try {
                    solve.interrupt();
                    solve2.interrupt();
                    solve3.interrupt();

                    solve = null;
                    solve2 = null;
                    solve3 = null;
                } catch (Exception e) {
                }
            }
            if (num_of_threads == 4) {

                SolveBoardThread.finished = false;

                SolveBoardThread solve = new SolveBoardThread(board, this, "Prva nit", 1);
                SolveBoardThread solve2 = new SolveBoardThread(board, this, "Druga nit", 2);
                SolveBoardThread solve3 = new SolveBoardThread(board, this, "Treća nit", 3);
                SolveBoardThread solve4 = new SolveBoardThread(board, this, "Četvrta nit", 4);

                solve.start();
                solve2.start();
                solve3.start();
                solve4.start();

                while (!SolveBoardThread.finished)
                    ;

                try {
                    solve.interrupt();
                    solve2.interrupt();
                    solve3.interrupt();
                    solve4.interrupt();

                    solve = null;
                    solve2 = null;
                    solve3 = null;
                    solve4 = null;
                } catch (Exception e) {
                }
            }

            if (num_of_threads == 5) {

                SolveBoardThread.finished = false;

                SolveBoardThread solve = new SolveBoardThread(board, this, "Prva nit", 1);
                SolveBoardThread solve2 = new SolveBoardThread(board, this, "Druga nit", 2);
                SolveBoardThread solve3 = new SolveBoardThread(board, this, "Treća nit", 3);
                SolveBoardThread solve4 = new SolveBoardThread(board, this, "Četvrta nit", 4);
                SolveBoardThread solve5 = new SolveBoardThread(board, this, "Peta nit", 5);

                solve.start();
                solve2.start();
                solve3.start();
                solve4.start();
                solve5.start();

                while (!SolveBoardThread.finished)
                    ;

                try {
                    solve.interrupt();
                    solve2.interrupt();
                    solve3.interrupt();
                    solve4.interrupt();
                    solve5.interrupt();

                    solve = null;
                    solve2 = null;
                    solve3 = null;
                    solve4 = null;
                    solve5 = null;
                } catch (Exception e) {
                }
            }
            if (num_of_threads == 6) {

                SolveBoardThread.finished = false;

                SolveBoardThread solve = new SolveBoardThread(board, this, "Prva nit", 1);
                SolveBoardThread solve2 = new SolveBoardThread(board, this, "Druga nit", 2);
                SolveBoardThread solve3 = new SolveBoardThread(board, this, "Treća nit", 3);
                SolveBoardThread solve4 = new SolveBoardThread(board, this, "Četvrta nit", 4);
                SolveBoardThread solve5 = new SolveBoardThread(board, this, "Peta nit", 5);
                SolveBoardThread solve6 = new SolveBoardThread(board, this, "Šesta nit", 6);

                solve.start();
                solve2.start();
                solve3.start();
                solve4.start();
                solve5.start();
                solve6.start();

                while (!SolveBoardThread.finished)
                    ;

                try {
                    solve.interrupt();
                    solve2.interrupt();
                    solve3.interrupt();
                    solve4.interrupt();
                    solve5.interrupt();
                    solve6.interrupt();

                    solve = null;
                    solve2 = null;
                    solve3 = null;
                    solve4 = null;
                    solve5 = null;
                    solve6 = null;
                } catch (Exception e) {
                }
            }
            if (num_of_threads == 7) {

                SolveBoardThread.finished = false;

                SolveBoardThread solve = new SolveBoardThread(board, this, "Prva nit", 1);
                SolveBoardThread solve2 = new SolveBoardThread(board, this, "Druga nit", 2);
                SolveBoardThread solve3 = new SolveBoardThread(board, this, "Treća nit", 3);
                SolveBoardThread solve4 = new SolveBoardThread(board, this, "Četvrta nit", 4);
                SolveBoardThread solve5 = new SolveBoardThread(board, this, "Peta nit", 5);
                SolveBoardThread solve6 = new SolveBoardThread(board, this, "Šesta nit", 6);
                SolveBoardThread solve7 = new SolveBoardThread(board, this, "Sedma nit", 7);

                solve.start();
                solve2.start();
                solve3.start();
                solve4.start();
                solve5.start();
                solve6.start();
                solve7.start();

                while (!SolveBoardThread.finished)
                    ;

                try {
                    solve.interrupt();
                    solve2.interrupt();
                    solve3.interrupt();
                    solve4.interrupt();
                    solve5.interrupt();
                    solve6.interrupt();
                    solve7.interrupt();

                    solve = null;
                    solve2 = null;
                    solve3 = null;
                    solve4 = null;
                    solve5 = null;
                    solve6 = null;
                    solve7 = null;
                } catch (Exception e) {
                }
            }
            if (num_of_threads > 7) {

                SolveBoardThread.finished = false;

                SolveBoardThread solve = new SolveBoardThread(board, this, "Prva nit", 1);
                SolveBoardThread solve2 = new SolveBoardThread(board, this, "Druga nit", 2);
                SolveBoardThread solve3 = new SolveBoardThread(board, this, "Treća nit", 3);
                SolveBoardThread solve4 = new SolveBoardThread(board, this, "Četvrta nit", 4);
                SolveBoardThread solve5 = new SolveBoardThread(board, this, "Peta nit", 5);
                SolveBoardThread solve6 = new SolveBoardThread(board, this, "Šesta nit", 6);
                SolveBoardThread solve7 = new SolveBoardThread(board, this, "Sedma nit", 7);
                SolveBoardThread solve8 = new SolveBoardThread(board, this, "Osma nit", 8);


                solve.start();
                solve2.start();
                solve3.start();
                solve4.start();
                solve5.start();
                solve6.start();
                solve7.start();
                solve8.start();

                while (!SolveBoardThread.finished)
                    ;

                try {
                    solve.interrupt();
                    solve2.interrupt();
                    solve3.interrupt();
                    solve4.interrupt();
                    solve5.interrupt();
                    solve6.interrupt();
                    solve7.interrupt();
                    solve8.interrupt();

                    solve = null;
                    solve2 = null;
                    solve3 = null;
                    solve4 = null;
                    solve5 = null;
                    solve6 = null;
                    solve7 = null;
                    solve8 = null;
                } catch (Exception e) {
                }
            }
            Toast.makeText(MainActivity.this, "Vrijeme: " + (this.end - this.start) + " ms", Toast.LENGTH_LONG).show();
        }
        // Slucaj klika na Clear
        else {
            solveBtn.setText(getString(R.string.solve));
            boardSolver.resetBoard();
            board.invalidate();
        }
    }
}

/**
 * Klasa koja predstavlja Thread za izvrsavanje
 */
class SolveBoardThread extends Thread {
    // volatile zbog kesiranja statickih varijabli
    volatile static boolean finished;
    MainActivity mainActivity;
    private String name;

    volatile long start;

    private SudokuBoard board;
    int[][] boardMatrix;
    int i, j;

    /**
     * @param board
     * @param mainActivity
     * @param name
     * Konstruktor Thread a
     */
    SolveBoardThread(SudokuBoard board, MainActivity mainActivity, String name, int serialNumber) {
        this.board = board;
        this.mainActivity = mainActivity;
        this.name = name;

        int temp = 0;
        this. i = 0;
        this.j = 0;
        for(int i = 0; i < board.getSolver().getBoard().length; i++) {
            for(int j = 0; j < board.getSolver().getBoard()[i].length; j++) {
                if(board.getSolver().getBoard()[i][j] == 0) {
                    temp++;
                    if(temp == serialNumber) {
                        this.i = i;
                        this.j = j;
                    }
                }
            }
        }
    }

    /**
     * Glavni program niti
     */
    @Override
    public void run() {
        // u slucaju da se desio interrupt prije pokretanja prekini izvrsenje i terminiraj nit
        if (Thread.currentThread().interrupted()) {
            return;
        }

        //int i, j, value;
        Random generator = new Random(System.currentTimeMillis());
        //i = generator.nextInt(8);
        //j = generator.nextInt(8);
        //value = generator.nextInt(8) + 1;

        int[][] matrix = board.getSolver().getBoard();
        // kloniranje matrice
        boardMatrix = new int[matrix.length][];

        for (int brojac = 0; brojac < matrix.length; brojac++) {
            int[] aMatrix = matrix[brojac];
            int aLength = aMatrix.length;
            boardMatrix[brojac] = new int[aLength];
            System.arraycopy(aMatrix, 0, boardMatrix[brojac], 0, aLength);
        }

        // pocetak izvrsavanja
        start = System.currentTimeMillis();

        // solve metoda za rjesavanje sudoku a
        if (solve(i, j, boardMatrix, 0, 1)) {
            // prva nit koja izvrsi tj za koju je finished == false ce izvrsiti print
            // ostale niti nece biti u mogucnosti
            if (finished == false) {
                // print Tabele
                printBoard(board);
            }
        }
    }

    /**
     * @param row
     * @param col
     * @param board
     * @param xTimes
     * @param startV
     * @return
     * Rekurzivna metoda za rjesavanje Sudoku a
     */
    static boolean solve(int row, int col, int[][] board, int xTimes, int startV) {
        // ako je svako polje posjeceno vrati true
        if (xTimes == 81)
            return true;
        int f = 1;
        // trazi se prvo polje koje je prazno
        for (int p = 0; p <= 8; p++) {
            for (int q = 0; q <= 8; q++) {
                if (board[p][q] == 0) {
                    f = 0;
                }
            }
        }
        // ako ne postoji vraca se true
        if (f == 1)
            return true;

        // kretanje kroz matricu
        if (++col == 9) {
            col = 0;
            if (++row == 9)
                row = 0;
        }

        // ako je polje rijeseno predji na iduce
        if (board[row][col] != 0) {
            return solve(row, col, board, xTimes + 1, startV);
        }

        // ako polje nije rjeseno trazi vrijednost koja pripada
        for (int val = 1; val <= 9; ++val) {
            if (++startV == 10)
                startV = 1;

            // kada nadjes vrijednost koja tu pripada idi dalje
            if (allowedHere(row, col, startV, board)) {
                board[row][col] = startV;
                if (solve(row, col, board, xTimes + 1, startV))
                    return true;
            }
        }

        // u slucaju da nema rjesenja vrati false
        board[row][col] = 0;
        return false;
    }

    /**
     * @param board
     * Sinhrona metoda za ispis ploce
     * Izvrsava je samo ona nit koja prva rijesi plocu
     */
    synchronized void printBoard(SudokuBoard board) {
        if (finished == false) {
            finished = true;

            // cuvanje startnog vremena, kraja, i stampanje Tablice
            board.getSolver().setBoard(boardMatrix);
            this.mainActivity.setStart(this.start);
            this.mainActivity.setEnd(System.currentTimeMillis());
            board.invalidate();
        }
    }

    /**
     * @param row
     * @param col
     * @param value
     * @param board
     * @return
     * Metoda koja provjerava da li broj odgovara izabranoj poziciji
     */
    static boolean allowedHere(int row, int col, int value, int[][] board) {
        int i;

        for (i = 0; i < 9; i++) {

            if (board[row][i] == value)
                return false;

            if (board[i][col] == value)
                return false;

            if (board[row / 3 * 3 + i % 3][col / 3 * 3 + i / 3] == value)
                return false;
        }
        return true;
    }
}