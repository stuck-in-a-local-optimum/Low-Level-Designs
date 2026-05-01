package LLD.lldproblems.cricinfo.models;

import LLD.lldproblems.cricinfo.enums.ExtraType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Innings {
    private final Team battingTeam;
    private final Team bowlingTeam;
    private int score;
    private int wickets;
    private final List<Ball> balls;
    private final Map<Player, PlayerStats> playerPlayerStatsMap;


    public Innings(Team battingTeam, Team bowlingTeam) {


        this.battingTeam = battingTeam;
        this.bowlingTeam = bowlingTeam;
        this.score = 0;
        this.wickets = 0;
        this.balls = new ArrayList<>();
        this.playerPlayerStatsMap = new ConcurrentHashMap<>();

        for(Player player : this.battingTeam.getPlayers()){
            this.playerPlayerStatsMap.put(player, new PlayerStats());
        }

        for(Player player : this.bowlingTeam.getPlayers()){
            this.playerPlayerStatsMap.put(player, new PlayerStats());
        }
    }


    public void addBall(Ball ball){

        int runScored = ball.getRunsScored();

        if(ball.getExtraType() == ExtraType.NOBALL || ball.getExtraType() == ExtraType.WIDE) {
            //one extra run
            this.score += 1;
        } else {
            ball.getFacedBy().getStats().updateRuns(runScored);
            ball.getFacedBy().getStats().incrementBallsPlayed();

            playerPlayerStatsMap.get(ball.getFacedBy()).updateRuns(runScored);
            playerPlayerStatsMap.get(ball.getFacedBy()).incrementBallsPlayed();
        }

        if(ball.isWicket()){
            this.wickets+=1;

            ball.getBowledBy().getStats().incrementWickets();

            playerPlayerStatsMap.get(ball.getBowledBy()).incrementWickets();

        }


    }

    public void printPlayerStats() {
        for (Map.Entry<Player, PlayerStats> entry : playerPlayerStatsMap.entrySet()) {
            Player player = entry.getKey();
            PlayerStats stats = entry.getValue();

            if (stats.getBallsPlayed() > 0 || stats.getWicketsTaken() > 0) {
                System.out.println("Player: " + player.getName() + " - Stats: " + stats);
            }
        }
    }

    public double getOvers(){
        long validBalls = this.balls.stream()
                .filter(ball -> ball.getExtraType() != ExtraType.NOBALL && ball.getExtraType() != ExtraType.WIDE)
                .count();

        long completedOvers = validBalls / 6;
        long remaining = validBalls % 6;

        return completedOvers + (remaining / 10.0);

    }

    public Team getBattingTeam() {
        return battingTeam;
    }

    public Team getBowlingTeam() {
        return bowlingTeam;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getWickets() {
        return wickets;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }

    public List<Ball> getBalls() {
        return balls;
    }

    public Map<Player, PlayerStats> getPlayerPlayerStatsMap() {
        return playerPlayerStatsMap;
    }
}
