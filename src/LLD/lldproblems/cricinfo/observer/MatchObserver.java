package LLD.lldproblems.cricinfo.observer;

import LLD.lldproblems.cricinfo.models.Ball;
import LLD.lldproblems.cricinfo.models.Match;

public interface MatchObserver {

    void update(Match match, Ball ball);
}
