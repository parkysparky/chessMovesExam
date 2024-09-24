package chess;

import java.util.HashSet;

public class RookMovesCalculator implements PieceMoveCalculator{
    @Override
    public HashSet<ChessMove> moveCalculator(ChessBoard board, ChessPosition position) {
        HashSet<ChessMove> moves = new HashSet<>();

        int row = position.getRow();
        int col = position.getColumn();

        int i = col+1;
        int j = row;
        while(i <= 8){ //R direction
            ChessPosition endPosition = new ChessPosition(j, i);
            if(isEmpty(board, endPosition)){
                moves.add(new ChessMove(position, endPosition, null));
            } else if(canCapture(board, position, endPosition)){
                moves.add(new ChessMove(position, endPosition, null));
                break;
            } else { break; }
            i++;
        }
        i = col;
        j = row-1;
        while(j >= 1){ //D direction
            ChessPosition endPosition = new ChessPosition(j, i);
            if(isEmpty(board, endPosition)){
                moves.add(new ChessMove(position, endPosition, null));
            } else if(canCapture(board, position, endPosition)){
                moves.add(new ChessMove(position, endPosition, null));
                break;
            } else { break; }
            j--;
        }
        i = col-1;
        j = row;
        while(i >= 1){ //L direction
            ChessPosition endPosition = new ChessPosition(j, i);
            if(isEmpty(board, endPosition)){
                moves.add(new ChessMove(position, endPosition, null));
            } else if(canCapture(board, position, endPosition)){
                moves.add(new ChessMove(position, endPosition, null));
                break;
            } else { break; }
            i--;
        }
        i = col;
        j = row+1;
        while(j <= 8){ //U direction
            ChessPosition endPosition = new ChessPosition(j, i);
            if(isEmpty(board, endPosition)){
                moves.add(new ChessMove(position, endPosition, null));
            } else if(canCapture(board, position, endPosition)){
                moves.add(new ChessMove(position, endPosition, null));
                break;
            } else { break; }
            j++;
        }

        return moves;
    }
}
