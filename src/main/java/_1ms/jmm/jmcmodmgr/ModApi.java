package _1ms.jmm.jmcmodmgr;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.LinkedList;
import java.util.concurrent.CompletableFuture;

public class ModApi {

    public static CompletableFuture<LinkedList<String[]>> getMods(String query) {
        CompletableFuture<LinkedList<String[]>> toRet = new CompletableFuture<>();
        Thread.ofVirtual().start(() -> {
            try (var client = HttpClient.newHttpClient()) {
                var req = HttpRequest.newBuilder(URI.create(query == null ? "https://api.modrinth.com/v2/search":"https://api.modrinth.com/v2/search?query="+query)).build();
                var resp = client.send(req, HttpResponse.BodyHandlers.ofString());
                var hits = JsonParser.parseString(resp.body()).getAsJsonObject().getAsJsonArray("hits");
                LinkedList<String[]> list = new LinkedList<>();
                for (JsonElement e : hits) {
                    var jobj = e.getAsJsonObject();
                    list.add(new String[]{jobj.get("icon_url").getAsString(),jobj.get("title").getAsString(),jobj.get("description").getAsString()});
                }
                toRet.complete(list);

            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }

        });
        return toRet;
    }

}
