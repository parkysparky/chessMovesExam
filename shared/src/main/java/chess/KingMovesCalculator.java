package chess;

import java.util.HashSet;

public class KingMovesCalculator implements PieceMoveCalculator{

    @Override
    public HashSet<ChessMove> moveCalculator(ChessBoard board, ChessPosition position) {
        HashSet<ChessMove> moves = new HashSet<>();

        for(int i = position.getColumn()-1; i <= position.getColumn()+1; i++){
            for( int j = position.getRow()-1; j <= position.getRow()+1; j++){
                ChessPosition endPosition = new ChessPosition(j, i);
                if(isInBounds(endPosition)){
                    if(isEmpty(board, endPosition) || canCapture(board, position,endPosition)) {
                        moves.add(new ChessMove(position, endPosition, null));
                    }
                    if(position.equals(endPosition)){ moves.remove(endPosition); }
                }
            }
        }

        return moves;
    }
}
