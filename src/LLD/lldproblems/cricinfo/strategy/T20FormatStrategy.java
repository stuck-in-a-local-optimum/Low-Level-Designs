package LLD.lldproblems.cricinfo.strategy;

import LLD.lldproblems.cricinfo.enums.MatchType;

public class T20FormatStrategy implements MatchFormatStrategy {
    @Override
    public int getTotalInnings() {
        return 2;
    }

    @Override
    public int getTotalOvers() {
        return 20;
    }

    @Override
    public String getFormatName() {
        return MatchType.T20.name();
    }
}
