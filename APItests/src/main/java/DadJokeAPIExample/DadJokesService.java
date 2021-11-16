package DadJokeAPIExample;


import java.util.Map;

public class DadJokesService {
    DadJokeApiMethods dadJokeApiMethods= new DadJokeApiMethods();
    public String lastJokeId;
    public String lastJoke;

    public void getRandomDadJoke(){
        Map<String, String> jokes = dadJokeApiMethods.getRandomDadJoke();
        for (Map.Entry<String, String> entry : jokes.entrySet()){
            lastJokeId = entry.getKey();
            lastJoke = entry.getValue();
        }
        System.out.println(lastJokeId + ":");
        System.out.println(lastJoke);
    }

    public void getJoke(String jokeId){
        Map<String, String> jokes = dadJokeApiMethods.getDadJoke(jokeId);
        for (Map.Entry<String, String> entry : jokes.entrySet()){
            lastJokeId = entry.getKey();
            lastJoke = entry.getValue();
        }
        System.out.println(lastJokeId + ":");
        System.out.println(lastJoke);
    }

//    public void searchjokes(){
//        Map<String, String> jokes = dadJokeApiMethods.getDadJoke(lastJokeId);
//        for (Map.Entry<String, String> entry : jokes.entrySet()){
//            lastJokeId = entry.getKey();
//            lastJoke = entry.getValue();
//        }
//        System.out.println(lastJoke);
//    }

}
