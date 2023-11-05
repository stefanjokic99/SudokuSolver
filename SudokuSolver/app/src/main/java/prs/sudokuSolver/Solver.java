package prs.sudokuSolver;

import java.util.ArrayList;

public class Solver {
    int [][] board;
    ArrayList<ArrayList<Object>> emptyBoxIndex;

    int selectedRow;
    int selectedCol;

    Solver() {
        selectedRow = -1;
        selectedCol = -1;

        board = new int[9][9];

        for(int row=0; row<9; row++) {
            for(int col=0; col<9; col++) {
                board[row][col] = 0;
            }
        }

        emptyBoxIndex = new ArrayList<>();
    }
    //Pronalazi 0(prazna mjesta) na tabli
    public void getEmptyBoxIndex() {
        for(int row=0; row<9; row++) {
            for(int col=0; col<9; col++) {
                if(this.board[row][col]==0) {
                    //kreiramo array i tu smjestamo red i kolonu 0 koje smo locirali
                    //Pamtimo ih da znamo koje polje treba da popunimo jer je
                    //0 nepopuljeno polje
                    this.emptyBoxIndex.add(new ArrayList<>());
                    this.emptyBoxIndex.get(this.emptyBoxIndex.size()-1).add(row);
                    this.emptyBoxIndex.get(this.emptyBoxIndex.size()-1).add(col);
                }
            }
        }
    }

    /**
     * Restartuje sve vrijednosti u tabeli na 0, tj. na prazne celije
     */
    public void resetBoard() {

        for(int row=0; row<9; row++) {
            for(int col=0; col<9; col++) {
                board[row][col] = 0;
            }
        }

        this.emptyBoxIndex = new ArrayList<>();
    }

    /**
     * @param num
     * @return true ako je unos uspjesan
     * Upis broja na selektovanu celiju
     */
    public boolean setNumberPosition(int num) {
        if(this.selectedRow != 0 && this.selectedCol != 0) {

            boolean check = checker(num);

            if (check == false) {
                return false;
            }

            if (this.selectedRow != -1 && this.selectedCol != -1) {
                if (this.board[this.selectedRow - 1][this.selectedCol - 1] == num) {
                    this.board[this.selectedRow - 1][this.selectedCol - 1] = 0;
                } else {
                    this.board[this.selectedRow - 1][this.selectedCol - 1] = num;
                }
            }
        }
        return true;
    }

    /**
     * @param num
     * @return
     * Provjerava da li je upis po pravilu Sudoku a
     */
    public boolean checker(int num) {
        boolean check = true;

        for(int i = 0; i < 9; i++) {
            if(this.board[this.selectedRow - 1][i] == num && i != selectedCol - 1) {
                check = false;
                break;
            }
            if(this.board[i][this.selectedCol - 1] == num && i != selectedRow - 1) {
                check = false;
                break;
            }
        }

        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.board[((this.selectedRow - 1) / 3) * 3 + i][((this.selectedCol - 1) / 3) * 3 + j] == num
                        && ((this.selectedRow - 1) != ((this.selectedRow - 1) / 3) * 3 + i) && ((this.selectedCol - 1) != ((this.selectedCol - 1) / 3) * 3 + j)) {
                    check = false;
                    break;
                }
            }
        }
        return check;
    }

    public int[][] getBoard () {
        return this.board;
    }

    /**
     * @param board
     * Postavlja matricu na nacin da klonira primljenu vrijednost
     */
    public void setBoard(int[][] board) {
        this.board = new int[board.length][];

        for(int brojac = 0; brojac < board.length; brojac++)
        {
            int[] aMatrix = board[brojac];
            int   aLength = aMatrix.length;
            this.board[brojac] = new int[aLength];
            System.arraycopy(aMatrix, 0, this.board[brojac], 0, aLength);
        }
    }

    public ArrayList<ArrayList<Object>> getemptyBoxIndex() {
        return emptyBoxIndex;
    }

    public int getSelectedRow() {
        return selectedRow;
    }

    public int getSelectedCol() {
        return selectedCol;
    }

    public void setSelectedRow(int selectedRow) {
        this.selectedRow = selectedRow;
    }

    public void setSelectedCol(int selectedCol) {
        this.selectedCol = selectedCol;
    }
}
