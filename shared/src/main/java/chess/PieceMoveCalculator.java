package chess;

import java.util.HashSet;

public interface PieceMoveCalculator {
    public HashSet<ChessMove> moveCalculator(ChessBoard board, ChessPosition position);
    public default boolean isInBounds(ChessPosition position){
        if(position.getRow() > 8 || position.getColumn() > 8){
            return false;
        }
        if(position.getRow() < 1 || position.getColumn() < 1){
            return false;
        }
        return true;
    }
    public default boolean isEmpty(ChessBoard board, ChessPosition position){
        return board.getPiece(position) == null;
    }
    public default boolean canCapture(ChessBoard board, ChessPosition startPosition, ChessPosition endPosition){
        if(board.getPiece(endPosition) != null){
            if(isInBounds(endPosition)){ return board.getPiece(startPosition).getTeamColor() != board.getPiece(endPosition).getTeamColor(); }
        }
        return false;
    }
}
