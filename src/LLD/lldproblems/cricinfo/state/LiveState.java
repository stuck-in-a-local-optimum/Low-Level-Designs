package LLD.lldproblems.cricinfo.state;

import LLD.lldproblems.cricinfo.enums.MatchStatus;
import LLD.lldproblems.cricinfo.models.Ball;
import LLD.lldproblems.cricinfo.models.Innings;
import LLD.lldproblems.cricinfo.models.Match;
import LLD.lldproblems.cricinfo.models.Team;

public class LiveState implements MatchState {
    @Override
    public void processBall(Match match, Ball ball) {
        Innings currentInning = match.getCurrentInnings();

        currentInning.addBall(ball);

        match.notifyObservers(ball);

        checkForMatchEnd(match);

    }

    private void checkForMatchEnd(Match match){
        Innings currentInning = match.getCurrentInnings();

        int inningsCount = match.getInnings().size();
        boolean isFinalInning = (inningsCount == match.getFormatStrategy().getTotalInnings());

        // --- A. WIN CONDITION: Chasing team surpasses the target ---
        if (isFinalInning) {
            int targetScore = match.getInnings().get(0).getScore() + 1;
            if (currentInning.getScore() >= targetScore) {
                int wicketsRemaining = (currentInning.getBattingTeam().getPlayers().size() - 1) - currentInning.getWickets();
                declareWinner(match, currentInning.getBattingTeam(), "won by " + wicketsRemaining + " wickets");
                return; // Match is over
            }
        }

        // --- B. END OF INNINGS CONDITION: All out or overs completed ---
        if(isInningsOver(match)){
            if(isFinalInning){
                //if final inning then check is target achieved
                int score1 = match.getInnings().get(0).getScore()+1;
                int score2 = currentInning.getScore();

                if(score1 > score2){
                    declareWinner(match, match.getTeam1(), "won by " + (score1 - score2) + " runs");
                } else if ( score2 < score1){
                    int wicketsRemaining = (currentInning.getBattingTeam().getPlayers().size() - 1) - currentInning.getWickets();
                    declareWinner(match, currentInning.getBattingTeam(), "won by " + wicketsRemaining + " wickets");
                } else {
                    declareWinner(match, null, "Match Tied");
                }

            } else {
                System.out.println("End of the Innnings!");
                match.setCurrentStatus(MatchStatus.IN_BREAK);
                match.setCurrentState(new InBreakState());
                match.notifyObservers(null);  //signal innings break to observers
            }
        }
    }

    private void declareWinner(Match match, Team winningTeam, String message){
        System.out.println("MATCH FINISHED");
        match.setWinner(winningTeam);
        String resultMesssage = (winningTeam != null) ? winningTeam.getName() + " " + message : message;
        match.setResultMessage(resultMesssage);

        match.setCurrentState(new FinishedState());
        match.setCurrentStatus(MatchStatus.FINISHED);
        match.notifyObservers(null); //signal message end to observers

    }

    private boolean isInningsOver(Match match){
        Innings currentInnings = match.getCurrentInnings();

        // Condition 1: A team with 11 players is all out when 10 wickets fall.
        boolean allOut = currentInnings.getWickets() >= currentInnings.getBattingTeam().getPlayers().size()-1;

        // Condition 2: All overs have been bowled
        boolean oversFinished = currentInnings.getOvers() >= match.getFormatStrategy().getTotalOvers();

        return allOut || oversFinished;
    }
}
