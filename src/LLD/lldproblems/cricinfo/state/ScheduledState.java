package LLD.lldproblems.cricinfo.state;

import LLD.lldproblems.cricinfo.models.Ball;
import LLD.lldproblems.cricinfo.models.Match;

public class ScheduledState implements MatchState {
    @Override
    public void processBall(Match match, Ball ball) {
        System.out.println("Cannot process a ball for a match that has not started");
    }
}
