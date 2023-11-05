package prs.sudokuSolver;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;

/**
 * Klasa SudokuBoard iscrtava tablu i rukuje sa unosom sudoku tablice
 */
public class SudokuBoard extends View {
    private final int boardColor;
    private final int cellFillColor;
    private final int cellHighlightColor;
    private final int letterColor;
    private final int letterColorSolve;

    private final Paint boardColorPaint = new Paint();
    private final Paint cellFillColorPaint = new Paint();
    private final Paint cellHighlightColorPaint = new Paint();
    private final Paint letterColorPaint = new Paint();

    private final Rect letterPainBounds = new Rect();

    private int cellSize;

    private final Solver solver = new Solver();

    public SudokuBoard(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray attributes = context.getTheme().obtainStyledAttributes(attrs, R.styleable.SudokuBoard,0,0);

        try {
            boardColor = attributes.getInteger(R.styleable.SudokuBoard_boardColor,0);
            cellFillColor = attributes.getInteger(R.styleable.SudokuBoard_cellFillColor,0);
            cellHighlightColor = attributes.getInteger(R.styleable.SudokuBoard_cellHighlightCollor,0);
            letterColor = attributes.getInteger(R.styleable.SudokuBoard_letterColor,0);
            letterColorSolve = attributes.getInteger(R.styleable.SudokuBoard_letterColorSolve,0);
        }
        finally {
            attributes.recycle();
        }
    }

    /**
     * @param width
     * @param height
     * Manja dimenzija da bi tabla bila kvadrat
     */
    @Override
    protected void onMeasure(int width, int height){
        super.onMeasure(width, height);

        int dimension = Math.min(this.getMeasuredWidth(), this.getMeasuredHeight());
        cellSize = dimension/9;
        setMeasuredDimension(dimension, dimension);
    }

    /**
     * @param canvas
     * Rukovaoc iscrtavanja Table
     */
    @Override
    protected void onDraw(Canvas canvas) {
        boardColorPaint.setStyle(Paint.Style.STROKE);
        boardColorPaint.setStrokeWidth(16);
        boardColorPaint.setColor(boardColor);
        boardColorPaint.setAntiAlias(true);

        cellFillColorPaint.setStyle(Paint.Style.FILL);
        cellFillColorPaint.setColor(cellFillColor);
        cellFillColorPaint.setAntiAlias(true);

        cellHighlightColorPaint.setStyle(Paint.Style.FILL);
        cellHighlightColorPaint.setColor(cellHighlightColor);
        cellHighlightColorPaint.setAntiAlias(true);

        letterColorPaint.setStyle(Paint.Style.FILL);
        letterColorPaint.setColor(letterColor);
        letterColorPaint.setAntiAlias(true);

        colorCell(canvas,solver.getSelectedRow(),solver.getSelectedCol());
        canvas.drawRect(0,0,getWidth(),getHeight(),boardColorPaint);
        drawBoard(canvas);
        drawNumbers(canvas);

    }

    /**
     * @param event
     * @return
     * GUI reakcija polja na dodir
     */
    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean isValid;

        float x = event.getX();
        float y = event.getY();

        int action = event.getAction();

        if(action == MotionEvent.ACTION_DOWN) {
            solver.setSelectedRow((int)Math.ceil(y/cellSize));
            solver.setSelectedCol((int)Math.ceil(x/cellSize));

            isValid = true;
        }
        else
        {
            isValid = false;
        }

        return isValid;
    }

    /**
     * @param canvas
     * Iscrtavanje brojeva
     */
    private void drawNumbers(Canvas canvas) {
        letterColorPaint.setTextSize(cellSize);
        for(int row=0; row<9; row++) {
            for(int col=0; col<9; col++) {
                if(solver.getBoard()[row][col] != 0) {
                    writeNumber(canvas,row,col);

                }
            }
        }

        letterColorPaint.setColor(letterColorSolve);

        for(ArrayList<Object> num: solver.getemptyBoxIndex()) {
            int row = (int)num.get(0);
            int col = (int)num.get(1);

            writeNumber(canvas,row,col);
        }
    }

    /**
     * @param canvas
     * @param row
     * @param col
     * Upis broja u izabrano polje
     */
    private void writeNumber(Canvas canvas, int row, int col) {
        String number = Integer.toString(solver.getBoard()[row][col]);

        letterColorPaint.getTextBounds(number,0,number.length(),letterPainBounds);
        float numberWidth = letterColorPaint.measureText(number);
        float numberHeight = letterPainBounds.height();
        canvas.drawText(number, (col * cellSize) + ((cellSize - numberWidth) / 2), (row + 1) * cellSize - ((cellSize - numberHeight) / 2), letterColorPaint);

    }

    /**
     * @param canvas
     * @param row
     * @param col
     * Farbanje reda i kolone oznacenog polja
     */
    private void colorCell(Canvas canvas, int row, int col) {
        if(solver.getSelectedCol() != -1 && solver.getSelectedRow() != -1) {
            //hajlajtuje red i kolonu kojoj pripada
            canvas.drawRect((col-1)*cellSize, 0, col*cellSize,cellSize*9,cellHighlightColorPaint );
            canvas.drawRect(0, (row-1)*cellSize, 9*cellSize,cellSize*row,cellHighlightColorPaint );

            //hajljtuje odjeljak u kome se nalazi
            /*
            if(row%3==1 && col%3 ==1) {
                canvas.drawRect((col) * cellSize, (row) * cellSize, (col + 2) * cellSize, cellSize * (row + 2), cellHighlightColorPaint);
            }
            else if (row%3==2 && col%3 ==1) {
                canvas.drawRect((col) * cellSize, (row-2) * cellSize, (col + 2) * cellSize, cellSize * (row-1), cellHighlightColorPaint);
                canvas.drawRect((col) * cellSize, (row) * cellSize, (col + 2) * cellSize, cellSize * (row+1), cellHighlightColorPaint);
            }
            else if (row%3==0 && col%3 ==1) {
                canvas.drawRect((col) * cellSize, (row-3) * cellSize, (col + 2) * cellSize, cellSize * (row-1), cellHighlightColorPaint);
            }*/
            //hajlajtuje kvadratic na koji je kliknuto
            canvas.drawRect((col-1)*cellSize, (row-1)*cellSize, col*cellSize,cellSize*row,cellFillColorPaint );
        }
        invalidate();
    }

    /**
     * Iscrtavanje deblje linije
     */
    private void drawThickLine() {
        boardColorPaint.setStyle(Paint.Style.STROKE);
        boardColorPaint.setStrokeWidth(10);
        boardColorPaint.setColor(boardColor);
    }

    /**
     * Iscrtavanje tanje linije
     */
    private void drawThinLine() {
        boardColorPaint.setStyle(Paint.Style.STROKE);
        boardColorPaint.setStrokeWidth(4);
        boardColorPaint.setColor(boardColor);
    }

    /**
     * @param canvas
     * Iscrtavanje Tablice
     */
    private void drawBoard(Canvas canvas) {
        //kolone
        for(int i =0; i<10; i++) {
            if(i%3==0) {
                drawThickLine();
            }
            else {
                drawThinLine();
            }
            canvas.drawLine(cellSize*i, 0,cellSize*i,getWidth(), boardColorPaint);

        }
        //redovi
        for(int i =0; i<10; i++) {
            if(i%3==0) {
                drawThickLine();
            }
            else {
                drawThinLine();
            }
            canvas.drawLine(0, cellSize*i,getWidth(),cellSize*i, boardColorPaint);
        }

    }

    public Solver getSolver() {
        return solver;
    }
}
