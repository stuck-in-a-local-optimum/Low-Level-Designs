package LLD.lldproblems.cricinfo;

import LLD.lldproblems.cricinfo.enums.PlayerRole;
import LLD.lldproblems.cricinfo.models.Ball;
import LLD.lldproblems.cricinfo.models.Match;
import LLD.lldproblems.cricinfo.models.Player;
import LLD.lldproblems.cricinfo.models.Team;
import LLD.lldproblems.cricinfo.observer.MatchObserver;
import LLD.lldproblems.cricinfo.repository.MatchRepository;
import LLD.lldproblems.cricinfo.repository.PlayerRepository;
import LLD.lldproblems.cricinfo.state.FinishedState;
import LLD.lldproblems.cricinfo.state.LiveState;
import LLD.lldproblems.cricinfo.strategy.MatchFormatStrategy;

import java.sql.Statement;
import java.util.UUID;

public class CricInfoService {
    private static CricInfoService INSTANCE;

    private final MatchRepository matchRepository;
    private final PlayerRepository playerRepository;

    private CricInfoService() {
        this.matchRepository = new MatchRepository();
        this.playerRepository = new PlayerRepository();
    }

    public static CricInfoService getInstance(){
        if(INSTANCE == null){
            synchronized (CricInfoService.class){
                if(INSTANCE == null){
                    INSTANCE = new CricInfoService();
                }
            }
        }
        return INSTANCE;

    }

    public Match createMatch(Team team1, Team team2, MatchFormatStrategy formatStrategy){
        String matchId = UUID.randomUUID().toString();
        Match match  = new Match(matchId, team1, team1, formatStrategy);
        matchRepository.save(match);
        System.out.printf("Match %s created between %s and %s.%n", formatStrategy.getFormatName(), team1.getName(), team2.getName());
        return match;
    }

    public void startMatch(String matchId){
        matchRepository.findById(matchId).ifPresent(match ->
                match.setCurrentState(new LiveState()));
        System.out.printf("Match %s is now LIVE.%n", matchId);
    }

    public void processBallUpdate(String matchId, Ball ball){
        matchRepository.findById(matchId).ifPresent(match -> match.processBall(ball));
    }

    public void startNextInnings(String matchId){
        matchRepository.findById(matchId).ifPresent(match -> match.startNextInnings());

    }

    public void subscribeToMatch(String matchId, MatchObserver observer){
        matchRepository.findById(matchId).ifPresent(match -> match.addObserver(observer));
    }

    public void endMatch(String matchId){
        matchRepository.findById(matchId).ifPresent(match ->
                match.setCurrentState(new FinishedState()));
        System.out.printf("Match %s has FINISHED.%n", matchId);

    }

    public Player addPlayer(String playerId, String playerName, PlayerRole playerRole){
        Player player = new Player(playerId, playerName, playerRole);
        playerRepository.save(player);
        return player;

    }

}
