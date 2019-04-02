public class JuegoTennis {

    private int acumulateScore1;
    private int acumulateScore2;
    private static String SCORE_LOVE = "Love";
    private static String SCORE_FIFTEEN = "Fifteen";
    private static String SCORE_THIRTY = "Thirty";
    private static String SCORE_FORTY = "Forty";
    private static String ADVANTAGE = "Advantage ";
    private static String WINNER = "Win for ";

    private void asignarPoints(String player) {
        if ("player1".equals(player))
            acumulateScore1 += 1;
        else
            acumulateScore2 += 1;
    }

    public String optenerPuntajes(int player1, int player2) {
        String score;
        int highScore = Math.max(player1, player2);

        for (int i = 0; i < highScore; i++) {
            if (i < player1) asignarPoints("player1");
            if (i < player2) asignarPoints("player2");
        }

        if (acumulateScore1 == acumulateScore2)
            score = getScoreIfEqual(acumulateScore1);
        else if (acumulateScore1>=4 || acumulateScore2>=4)
            score = getAdvantageOrPlayerWinner( acumulateScore1 - acumulateScore2);
        else
            score = getOtherScores(acumulateScore1) + "-" + getOtherScores(acumulateScore2) ;

        return score;
    }

    private String getOtherScores(int score) {
        switch (score) {
            case 0:
                return SCORE_LOVE;
            case 1:
                return SCORE_FIFTEEN;
            case 2:
                return SCORE_THIRTY;
            case 3:
                return SCORE_FORTY;
            default:
                return "";
        }
    }

    private String getScoreIfEqual(int score) {
        switch (score)  {
            case 0:
                return SCORE_LOVE + "-All";
            case 1:
                return SCORE_FIFTEEN + "-All";
            case 2:
                return SCORE_THIRTY + "-All";
            default:
                return "Deuce";
        }
    }

    private String getAdvantageOrPlayerWinner(int minusResult ) {

        if (minusResult == 1)
            return ADVANTAGE + "player1";
        else if (minusResult ==-1)
            return ADVANTAGE + "player2";
        else if (minusResult >= 2)
            return WINNER + "player1";
        else
            return WINNER + "player2";

    }

}

