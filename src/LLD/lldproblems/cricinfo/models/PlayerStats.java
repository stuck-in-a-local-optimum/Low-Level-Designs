package LLD.lldproblems.cricinfo.models;

public class PlayerStats {
    private int runsScored;
    private int ballsPlayed;
    private int wicketsTaken;

    public int getRunsScored() {
        return runsScored;
    }

    public void updateRuns(int runsScored){
        this.setRunsScored(this.getRunsScored() + runsScored);
    }

    public void incrementBallsPlayed(){
        this.ballsPlayed+=1;
    }

    public void incrementWickets(){
        this.wicketsTaken+=1;
    }

    public void setRunsScored(int runsScored) {
        this.runsScored = runsScored;
    }

    public int getBallsPlayed() {
        return ballsPlayed;
    }

    public void setBallsPlayed(int ballsPlayed) {
        this.ballsPlayed = ballsPlayed;
    }

    public int getWicketsTaken() {
        return wicketsTaken;
    }

    public void setWicketsTaken(int wicketsTaken) {
        this.wicketsTaken = wicketsTaken;
    }
}
