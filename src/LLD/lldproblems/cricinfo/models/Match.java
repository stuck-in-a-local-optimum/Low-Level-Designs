package LLD.lldproblems.cricinfo.models;

import LLD.lldproblems.cricinfo.state.MatchState;
import LLD.lldproblems.cricinfo.state.ScheduledState;
import LLD.lldproblems.cricinfo.strategy.MatchFormatStrategy;
import LLD.lldproblems.cricinfo.observer.MatchObserver;
import LLD.lldproblems.cricinfo.enums.MatchStatus;

import java.util.ArrayList;
import java.util.List;

public class Match {
    private final String id;
    private final Team team1;
    private final Team team2;

    private final MatchFormatStrategy formatStrategy;
    private List<Innings> innings;

    private MatchState currentState;
    private MatchStatus currentStatus;
    private Team winner;
    private String resultMessage;
    private List<MatchObserver> observers = new ArrayList<>();

    public Match(String id, Team team1, Team team2, MatchFormatStrategy formatStrategy) {
        this.id = id;
        this.team1 = team1;
        this.team2 = team2;
        this.formatStrategy = formatStrategy;
        this.innings = new ArrayList<>();
        this.innings.add(new Innings(team1, team2));
        this.currentState = new ScheduledState();
        this.resultMessage = "";

    }

    public void processBall(Ball ball){
        this.currentState.processBall(this, ball);
    }

    public void startNextInnings() {
        currentState.startNextInnings(this);
    }

    public void createNewInnings() {
        if (innings.size() >= formatStrategy.getTotalInnings()) {
            System.out.println("Cannot create a new innings, match has already reached its limit.");
            return;
        }
        // Swap the teams for the next innings
        Innings nextInnings = new Innings(this.team2, this.team1);
        this.innings.add(nextInnings);
    }

    // Observer Pattern Methods
    public void addObserver(MatchObserver observer) { observers.add(observer); }
    public void removeObserver(MatchObserver observer) { observers.remove(observer); }
    public void notifyObservers(Ball ball) {
        for (MatchObserver observer : observers) {
            observer.update(this, ball);
        }
    }

    public Innings getCurrentInnings() { return innings.get(innings.size() - 1); }

    public String getId() {
        return id;
    }

    public Team getTeam1() {
        return team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public MatchFormatStrategy getFormatStrategy() {
        return formatStrategy;
    }

    public List<Innings> getInnings() {
        return innings;
    }

    public void setInnings(List<Innings> innings) {
        this.innings = innings;
    }

    public MatchState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(MatchState currentState) {
        this.currentState = currentState;
    }

    public MatchStatus getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(MatchStatus currentStatus) {
        this.currentStatus = currentStatus;
    }

    public Team getWinner() {
        return winner;
    }

    public void setWinner(Team winner) {
        this.winner = winner;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public List<MatchObserver> getObservers() {
        return observers;
    }

    public void setObservers(List<MatchObserver> observers) {
        this.observers = observers;
    }
}
