package chess;

import java.util.HashSet;

public class BishopMovesCalculator implements PieceMoveCalculator{
    @Override
    public HashSet<ChessMove> moveCalculator(ChessBoard board, ChessPosition position) {
        HashSet<ChessMove> moves = new HashSet<>();

        int row = position.getRow();
        int col = position.getColumn();

        int i = col+1;
        int j = row+1;
        while(i <= 8 && j <= 8){ //UR direction
            ChessPosition endPosition = new ChessPosition(j, i);
            if(isEmpty(board, endPosition)){
                moves.add(new ChessMove(position, endPosition, null));
            } else if(canCapture(board, position, endPosition)){
                moves.add(new ChessMove(position, endPosition, null));
                break;
            } else { break; }
            i++;
            j++;
        }
        i = col+1;
        j = row-1;
        while(i <= 8 && j >= 1){ //DR direction
            ChessPosition endPosition = new ChessPosition(j, i);
            if(isEmpty(board, endPosition)){
                moves.add(new ChessMove(position, endPosition, null));
            } else if(canCapture(board, position, endPosition)){
                moves.add(new ChessMove(position, endPosition, null));
                break;
            } else { break; }
            i++;
            j--;
        }
        i = col-1;
        j = row-1;
        while(i >= 1 && j >= 1){ //DL direction
            ChessPosition endPosition = new ChessPosition(j, i);
            if(isEmpty(board, endPosition)){
                moves.add(new ChessMove(position, endPosition, null));
            } else if(canCapture(board, position, endPosition)){
                moves.add(new ChessMove(position, endPosition, null));
                break;
            } else { break; }
            i--;
            j--;
        }
        i = col-1;
        j = row+1;
        while(i >= 1 && j <= 8){ //UL direction
            ChessPosition endPosition = new ChessPosition(j, i);
            if(isEmpty(board, endPosition)){
                moves.add(new ChessMove(position, endPosition, null));
            } else if(canCapture(board, position, endPosition)){
                moves.add(new ChessMove(position, endPosition, null));
                break;
            } else { break; }
            i--;
            j++;
        }

        return moves;
    }
}
