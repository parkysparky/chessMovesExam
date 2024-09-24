package chess;

import java.util.HashSet;

public class QueenMovesCalculator implements PieceMoveCalculator{
    @Override
    public HashSet<ChessMove> moveCalculator(ChessBoard board, ChessPosition position) {
        BishopMovesCalculator bishopMoves = new BishopMovesCalculator();
        RookMovesCalculator rookMoves = new RookMovesCalculator();

        HashSet<ChessMove> moves = new HashSet<>(bishopMoves.moveCalculator(board, position));
        HashSet<ChessMove> moves1 = new HashSet<>(rookMoves.moveCalculator(board, position));
        moves.addAll(moves1);

        return moves;
    }
}
