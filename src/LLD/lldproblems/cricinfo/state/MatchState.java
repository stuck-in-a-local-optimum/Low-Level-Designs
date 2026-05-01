package LLD.lldproblems.cricinfo.state;

import LLD.lldproblems.cricinfo.models.Ball;
import LLD.lldproblems.cricinfo.models.Match;

public interface  MatchState {

    void processBall(Match match, Ball ball);

    default void startNextInnings(Match match) {
        System.out.println("ERROR: Cannot start the next innings from the current state.");
    }

}
