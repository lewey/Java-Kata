package flatmaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DeveloperTest {

    public static void main(String args[]){

        List<Developer> team = new ArrayList<>();
        Developer jlew = new Developer("JLew");
        jlew.addLanguage("java");
        jlew.addLanguage("scala");
        jlew.addLanguage("groovy");

        Developer deano = new Developer("deano");
        deano.addLanguage(".NET");
        deano.addLanguage("javascript");

        Collections.addAll(team,jlew,deano);

        // flatmap here takes a developer and returns a Stream<Set<String>>
        List<String> teamLanguages = team.stream()
                                                .flatMap(developer -> developer.getLanguages().stream())
                                                .collect(Collectors.toList());

        System.out.println(teamLanguages);

    }
}
