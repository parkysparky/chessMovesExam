package chess;

import java.util.HashSet;

public interface PieceMoveCalculator {
    public HashSet<ChessMove> moveCalculator(ChessBoard board, ChessPosition position);
}
