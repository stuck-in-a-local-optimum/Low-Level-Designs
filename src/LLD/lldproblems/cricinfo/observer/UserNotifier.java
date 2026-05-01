package LLD.lldproblems.cricinfo.observer;

import LLD.lldproblems.cricinfo.enums.MatchStatus;
import LLD.lldproblems.cricinfo.models.Ball;
import LLD.lldproblems.cricinfo.models.Match;

import java.sql.SQLOutput;

public class UserNotifier implements MatchObserver {
    @Override
    public void update(Match match, Ball lastBall) {
        if(match.getCurrentStatus() == MatchStatus.FINISHED){
            System.out.println("[NOTIFICATION]: Match has finished!");
        } else if (match.getCurrentStatus() == MatchStatus.IN_BREAK){
            System.out.println("[NOTIFICATION]: Inning has ended!");
        } else if(lastBall.isWicket()){
            System.out.println("[NOTIFICATION]: A player has out!");
        } else if(lastBall.isBoundary()){
            System.out.println("[NOTIFICATION]: It's a boundary! %d runs.%n"+ lastBall.getRunsScored());
        }
    }
}
