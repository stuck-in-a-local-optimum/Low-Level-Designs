package LLD.lldproblems.cricinfo.strategy;

import LLD.lldproblems.cricinfo.enums.MatchType;

public class ODIFormatStrategy implements MatchFormatStrategy {

    @Override
    public int getTotalInnings() {
        return 2;
    }

    @Override
    public int getTotalOvers() {
        return 50;
    }

    @Override
    public String getFormatName() {
        return MatchType.ODI.name();
    }
}
