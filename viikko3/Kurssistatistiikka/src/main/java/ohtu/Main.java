package ohtu;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        // ÄLÄ laita githubiin omaa opiskelijanumeroasi
        String studentNr = "012345678";
        if (args.length > 0) {
            studentNr = args[0];
        }

        String url = "https://studies.cs.helsinki.fi/courses/students/" + studentNr + "/submissions";
        String courseUrl = "https://studies.cs.helsinki.fi/courses/courseinfo";
        String ohtuStats = "https://studies.cs.helsinki.fi/courses/ohtu2018/stats";
        String railsStats = "https://studies.cs.helsinki.fi/courses/rails2018/stats";

        String bodyText = Request.Get(url).execute().returnContent().asString();
        String courseBodyText = Request.Get(courseUrl).execute().returnContent().asString();
        String ohtuResponse = Request.Get(ohtuStats).execute().returnContent().asString();
        String railsResponse = Request.Get(railsStats).execute().returnContent().asString();

//        System.out.println("json-muotoinen data:");
//        System.out.println( bodyText );
        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);
        Course[] courses = mapper.fromJson(courseBodyText, Course[].class);

        JsonParser parser = new JsonParser();
        JsonObject ohtuData = parser.parse(ohtuResponse).getAsJsonObject();
        JsonObject railsData = parser.parse(railsResponse).getAsJsonObject();

        System.out.println("opiskelijanumero " + studentNr + "\n");

        HashSet<String> kurssit = new HashSet<>();
        Arrays.asList(subs).forEach(a -> kurssit.add(a.getCourse()));

        for (Course course : courses) {
//            System.out.println(course.getName() + ", " + kurssit.contains(course.getName()));
            if (kurssit.contains(course.getName())) {
                System.out.println(course.getFullName() + "\n");
                int tehtavat = 0;
                int tunnit = 0;
                for (Submission submission : subs) {
                    if (submission.getCourse().equals(course.getName())) {
                        tehtavat += submission.getExercises().length;
                        tunnit += submission.getHours();
                        System.out.println("viikko " + submission.getWeek() + ":\n"
                                + " tehtyjä tehtäviä " + submission.getExercises().length
                                + "/" + course.getExercises()[submission.getWeek()]
                                + " aikaa kului " + submission.getHours()
                                + " tehdyt tehtävät: "
                                + Arrays.toString(submission.getExercises()) + "\n");
                    }
                }
                System.out.println("yhteensä: " + tehtavat + "/"
                        + Arrays.stream(course.getExercises()).sum()
                        + " tehtävää " + tunnit + " tuntia\n");
                if (course.getName().equals("rails2018")) {
                    
                    printCourseData(railsData);
                }
                if (course.getName().equals("ohtu2018")) {
                    printCourseData(ohtuData);
                }
            }
        }

    }

    static void printCourseData(JsonObject course) {
        int palautukset = 0, tunnit = 0, tehtavat = 0;
        for (String key : course.keySet()) {
            palautukset += course.get(key).getAsJsonObject().get("students").getAsInt();
            tunnit += course.get(key).getAsJsonObject().get("hour_total").getAsInt();
            tehtavat += course.get(key).getAsJsonObject().get("exercise_total").getAsInt();

        }
        System.out.println("kurssilla yhteensä " + palautukset + " palautusta, " 
                + "palautettuja tehtavia " + tehtavat + " kpl, " + 
                "aikaa käytetty yhteensä " + tunnit + " tuntia \n");

    }
}
