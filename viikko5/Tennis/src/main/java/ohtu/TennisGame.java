package ohtu;

public class TennisGame {

    private int p1Score = 0;
    private int p2Score = 0;
    private final String player1;
    private final String player2;

    public TennisGame(String player1Name, String player2Name) {
        this.player1 = player1Name;
        this.player2 = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1)) {
            p1Score += 1;
        } else {
            p2Score += 1;
        }
    }

    public String getScore() {
        if (p1Score == p2Score) {
            return evenScore();
        } else if (p1Score >= 4 || p2Score >= 4) {
            return resolveEndGame();
        }
        return resolveScore();
    }

    private String resolveScore() {
        return printScore(p1Score)+"-"+printScore(p2Score);
    }

    private String printScore(int playerScore) {
        switch (playerScore) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";                
            default:
                return "Forty";
        }
    }

    private String resolveEndGame() {
        int scoreDifference = p1Score - p2Score;
        if (scoreDifference == 1) {
            return "Advantage player1";
        } else if (scoreDifference == -1) {
            return "Advantage player2";
        } else if (scoreDifference >= 2) {
            return "Win for player1";
        } else {
            return "Win for player2";
        }
    }

    private String evenScore() {
        switch (p1Score) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            case 3:
                return "Forty-All";
            default:
                return "Deuce";
        }
    }
}
