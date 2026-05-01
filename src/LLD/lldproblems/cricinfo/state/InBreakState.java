package LLD.lldproblems.cricinfo.state;

import LLD.lldproblems.cricinfo.enums.MatchStatus;
import LLD.lldproblems.cricinfo.models.Ball;
import LLD.lldproblems.cricinfo.models.Match;

class InBreakState implements MatchState {
    @Override
    public void processBall(Match match, Ball ball) {
        System.out.println("ERROR: Cannot process a ball. The match is currently in a break.");
    }

    @Override
    public void startNextInnings(Match match) {
        System.out.println("Starting the next innings...");
        match.createNewInnings();
        match.setCurrentState(new LiveState());
        match.setCurrentStatus(MatchStatus.LIVE);
    }
}
