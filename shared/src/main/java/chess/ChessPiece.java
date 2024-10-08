package chess;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

/**
 * Represents a single chess piece
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessPiece {

    private final ChessGame.TeamColor pieceColor;
    private final PieceType type;

    public ChessPiece(ChessGame.TeamColor pieceColor, PieceType type) {
        this.pieceColor = pieceColor;
        this.type = type;
    }


    /**
     * The various different chess piece options
     */
    public enum PieceType {
        KING,
        QUEEN,
        BISHOP,
        KNIGHT,
        ROOK,
        PAWN
    }

    /**
     * @return Which team this chess piece belongs to
     */
    public ChessGame.TeamColor getTeamColor() {
        return pieceColor;
    }

    /**
     * @return which type of chess piece this piece is
     */
    public PieceType getPieceType() {
        return type;
    }

    /**
     * Calculates all the positions a chess piece can move to
     * Does not take into account moves that are illegal due to leaving the king in
     * danger
     *
     * @return Collection of valid moves
     */
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        if(PieceType.KING == board.getPiece(myPosition).getPieceType()){
            KingMovesCalculator kingMoves = new KingMovesCalculator();
            return kingMoves.moveCalculator(board, myPosition);
        }
        if(PieceType.QUEEN == board.getPiece(myPosition).getPieceType()){
            QueenMovesCalculator queenMoves = new QueenMovesCalculator();
            return queenMoves.moveCalculator(board, myPosition);
        }
        if(PieceType.ROOK == board.getPiece(myPosition).getPieceType()){
            RookMovesCalculator rookMoves = new RookMovesCalculator();
            return rookMoves.moveCalculator(board, myPosition);
        }
        if(PieceType.BISHOP == board.getPiece(myPosition).getPieceType()){
            BishopMovesCalculator bishopMoves = new BishopMovesCalculator();
            return bishopMoves.moveCalculator(board, myPosition);
        }
        if(PieceType.KNIGHT == board.getPiece(myPosition).getPieceType()){
            KnightMovesCalculator knightMoves = new KnightMovesCalculator();
            return knightMoves.moveCalculator(board, myPosition);
        }
        if(PieceType.PAWN == board.getPiece(myPosition).getPieceType()){
            PawnMovesCalculator pawnMoves = new PawnMovesCalculator();
            return pawnMoves.moveCalculator(board, myPosition);
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChessPiece that = (ChessPiece) o;
        return pieceColor == that.pieceColor && type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pieceColor, type);
    }

    @Override
    public String toString() { //todo test output
        return pieceColor + " " + type;
    }
}
