package com.spnikit.lesson4;

import com.fasterxml.jackson.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;


@JsonRootName("Gameplay")
@JsonPropertyOrder(value = {"Player", "Game", "GameResult"})
class Gameplay {
    private Player player1;
    private Player player2;
    private Player gameResult;
    private List<Step> steps = new ArrayList<>();
    private final List<Player> players = new ArrayList<>();

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    @JsonIgnore
    public Player getPlayer1() {
        return player1;
    }
    @JsonIgnore
    public void setPlayer1(Player player1) {
        this.player1 = player1;
        players.add(player1);
    }

    @JsonIgnore
    public Player getPlayer2() {
        return player2;
    }
    @JsonIgnore
    public void setPlayer2(Player player2) {
        this.player2 = player2;
        players.add(player2);
    }

    public void setPlayer(Player player){
        if(player.getToken() == Token.X){
            setPlayer1(player);
        }else {
            setPlayer2(player);
        }
    }

   @JsonIgnore
    public Player getGameResult() {
        return gameResult;
    }

    @JsonIgnore
    public void setGameResult(Player gameResult) {
        this.gameResult = gameResult;
    }

    @JsonIgnore
    public List<Step> getSteps(){
        return List.copyOf(steps);
    }

    public boolean addStep(Step step) {
        return steps.add(step);
    }

    @JsonGetter("Player")
    public List<Player> getPlayers() {
        return players;
    }

    @JsonSetter("Player")
    public void setPlayers(List<Player> players) {
       players.forEach(this::setPlayer);
    }

    @JsonProperty("Game")
    public Map<String ,List<Step>> mapStepsToJson(){
        return Map.of("Step", getSteps());
    }

    @JsonProperty("Game")
    public void getStepsFromJson(Map<String, List<Step>> map){
        var stepsFromJson = map.get("Step");
        setSteps(stepsFromJson);
    }

    @JsonProperty("GameResult")
    public Map<String, Player> mapGameResultJson(){
        if(Objects.isNull(getGameResult())){
            return null;
        }else {
            return Map.of("Player", getGameResult());
        }
    }

    @JsonProperty("GameResult")
    public void getGameResultFromJson(Map<String, Player> map){
        setGameResult(map.get("Player"));
    }

    @Override
    public String toString() {
        return "Gameplay{" +
                "player1=" + player1 +
                ", player2=" + player2 +
                ", winner=" + gameResult +
                ", steps=" + steps +
                '}';
    }
}
