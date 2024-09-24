package chess;

import java.util.HashSet;

public class PawnMovesCalculator implements PieceMoveCalculator{
    @Override
    public HashSet<ChessMove> moveCalculator(ChessBoard board, ChessPosition position) {
        HashSet<ChessMove> moves = new HashSet<>();

        final int row = position.getRow();
        final int col = position.getColumn();

        final ChessGame.TeamColor ownColor = board.getPiece(position).getTeamColor();

        if(ChessGame.TeamColor.WHITE == ownColor){
            ChessPosition endPosition = new ChessPosition(row+1, col); //vertical movement
            if(isInBounds(endPosition) && isEmpty(board, endPosition)){
                if(canPromote(ownColor, endPosition)){
                    addPromotionMoves(moves, position, endPosition);
                }else{
                    moves.add(new ChessMove(position, endPosition, null));
                }
                endPosition = new ChessPosition(row+2, col);
                if(2 == row && isEmpty(board, endPosition)){
                    moves.add(new ChessMove(position, endPosition, null));
                }
            }
            endPosition = new ChessPosition(row+1, col-1); //capture left
            if(isInBounds(endPosition) && canCapture(board, position, endPosition)){
                if(canPromote(ownColor, endPosition)){
                    addPromotionMoves(moves, position, endPosition);
                }else{
                    moves.add(new ChessMove(position, endPosition, null));
                }
            }
            endPosition = new ChessPosition(row+1, col+1); //capture right
            if(isInBounds(endPosition) && canCapture(board, position, endPosition)){
                if(canPromote(ownColor, endPosition)){
                    addPromotionMoves(moves, position, endPosition);
                }else{
                    moves.add(new ChessMove(position, endPosition, null));
                }
            }
        }
        if(ChessGame.TeamColor.BLACK == ownColor){
            ChessPosition endPosition = new ChessPosition(row-1, col); //vertical movement
            if(isInBounds(endPosition) && isEmpty(board, endPosition)){
                if(canPromote(ownColor, endPosition)){
                    addPromotionMoves(moves, position, endPosition);
                }else{
                    moves.add(new ChessMove(position, endPosition, null));
                }
                endPosition = new ChessPosition(row-2, col);
                if(7 == row && isEmpty(board, endPosition)){
                    moves.add(new ChessMove(position, endPosition, null));
                }
            }
            endPosition = new ChessPosition(row-1, col-1); //capture left
            if(isInBounds(endPosition) && canCapture(board, position, endPosition)){
                if(canPromote(ownColor, endPosition)){
                    addPromotionMoves(moves, position, endPosition);
                }else{
                    moves.add(new ChessMove(position, endPosition, null));
                }
            }
            endPosition = new ChessPosition(row-1, col+1); //capture right
            if(isInBounds(endPosition) && canCapture(board, position, endPosition)){
                if(canPromote(ownColor, endPosition)){
                    addPromotionMoves(moves, position, endPosition);
                }else{
                    moves.add(new ChessMove(position, endPosition, null));
                }
            }
        }

        return moves;
    }

    private boolean canPromote(ChessGame.TeamColor ownColor, ChessPosition endPosition){
        if( (ChessGame.TeamColor.WHITE == ownColor) && (8 == endPosition.getRow()) ){
            return true;
        }
        if( (ChessGame.TeamColor.BLACK == ownColor) && (1 == endPosition.getRow()) ){
            return true;
        } else {
            return false;
        }
    }

    private void addPromotionMoves(HashSet<ChessMove> moves, ChessPosition startPostion, ChessPosition endPosition){
        moves.add(new ChessMove(startPostion, endPosition, ChessPiece.PieceType.BISHOP));
        moves.add(new ChessMove(startPostion, endPosition, ChessPiece.PieceType.KNIGHT));
        moves.add(new ChessMove(startPostion, endPosition, ChessPiece.PieceType.ROOK));
        moves.add(new ChessMove(startPostion, endPosition, ChessPiece.PieceType.QUEEN));
    }
}
