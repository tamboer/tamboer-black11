package za.co.tamboer.tamboerblack11.player.web;

public class PlayerUrl {

    public static final String BASE_URL = "/players";
    public static final String GET_PLAYER_URL = BASE_URL + "/{id}";
    public static final String CREATE_PLAYER_URL = BASE_URL;
    public static final String GET_PLAYERS_URL = BASE_URL;
    public static final String DELETE_PLAYER_URL = BASE_URL + "/{id}";

    public static final String PLAYER_JSON_V1 = "application/vnd.tvh.project.v1+json";

    private PlayerUrl() {
        //Utility class, constructor not supported
    }
}
