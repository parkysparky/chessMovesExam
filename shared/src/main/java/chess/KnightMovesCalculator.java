package chess;

import java.util.HashSet;

public class KnightMovesCalculator implements PieceMoveCalculator{
    @Override
    public HashSet<ChessMove> moveCalculator(ChessBoard board, ChessPosition position) {
        HashSet<ChessMove> moves = new HashSet<>();

        final int row = position.getRow();
        final int col = position.getColumn();

        ChessPosition endPositon = new ChessPosition(row+2, col+1);
        if(isValid(board, position, endPositon)){
            moves.add(new ChessMove(position, endPositon, null));
        }
        endPositon = new ChessPosition(row+1, col+2);
        if(isValid(board, position, endPositon)){
            moves.add(new ChessMove(position, endPositon, null));
        }
        endPositon = new ChessPosition(row-1, col+2);
        if(isValid(board, position, endPositon)){
            moves.add(new ChessMove(position, endPositon, null));
        }
        endPositon = new ChessPosition(row-2, col+1);
        if(isValid(board, position, endPositon)){
            moves.add(new ChessMove(position, endPositon, null));
        }
        endPositon = new ChessPosition(row-2, col-1);
        if(isValid(board, position, endPositon)){
            moves.add(new ChessMove(position, endPositon, null));
        }
        endPositon = new ChessPosition(row-1, col-2);
        if(isValid(board, position, endPositon)){
            moves.add(new ChessMove(position, endPositon, null));
        }
        endPositon = new ChessPosition(row+2, col-1);
        if(isValid(board, position, endPositon)){
            moves.add(new ChessMove(position, endPositon, null));
        }
        endPositon = new ChessPosition(row+1, col-2);
        if(isValid(board, position, endPositon)){
            moves.add(new ChessMove(position, endPositon, null));
        }

        return moves;
    }

    private boolean isValid(ChessBoard board, ChessPosition startPosition, ChessPosition endPosition){
        if(!isInBounds(endPosition)){
            return false;
        }
        return isEmpty(board, endPosition) || canCapture(board, startPosition, endPosition);
    }
}
