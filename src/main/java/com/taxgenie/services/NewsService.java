package com.taxgenie.services;

import java.util.List;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.taxgenie.model.NewsArticle;

@Service
public class NewsService {

	private static final String API_KEY = "7b672a1d34024464bfe6dd73411c762e";
    private static final String NEWS_API_URL = "https://newsapi.org/v2/everything?q=finance&apiKey=" + API_KEY;

    public List<NewsArticle> getFinancialNews() {
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(NEWS_API_URL, String.class);

        JsonObject jsonObject = JsonParser.parseString(response).getAsJsonObject();
        JsonArray articles = jsonObject.getAsJsonArray("articles");

        List<NewsArticle> newsList = new ArrayList<>();
        for (JsonElement article : articles) {
            JsonObject articleObj = article.getAsJsonObject();
            NewsArticle newsArticle = new NewsArticle();

            // Check for null values and handle them appropriately
            JsonElement titleElement = articleObj.get("title");
            if (titleElement != null && !titleElement.isJsonNull()) {
                newsArticle.setTitle(titleElement.getAsString());
            } else {
                newsArticle.setTitle("No title available");
            }

            JsonElement descriptionElement = articleObj.get("description");
            if (descriptionElement != null && !descriptionElement.isJsonNull()) {
                newsArticle.setDescription(descriptionElement.getAsString());
            } else {
                newsArticle.setDescription("No description available");
            }

            JsonElement urlElement = articleObj.get("url");
            if (urlElement != null && !urlElement.isJsonNull()) {
                newsArticle.setUrl(urlElement.getAsString());
            } else {
                newsArticle.setUrl("#");
            }

            JsonElement sourceElement = articleObj.getAsJsonObject("source").get("name");
            if (sourceElement != null && !sourceElement.isJsonNull()) {
                newsArticle.setSource(sourceElement.getAsString());
            } else {
                newsArticle.setSource("Unknown source");
            }

            JsonElement publishedAtElement = articleObj.get("publishedAt");
            if (publishedAtElement != null && !publishedAtElement.isJsonNull()) {
                newsArticle.setPublishedAt(LocalDateTime.parse(publishedAtElement.getAsString().replace("Z", "")));
            } else {
                newsArticle.setPublishedAt(null); // or handle appropriately if needed
            }

            newsList.add(newsArticle);
        }

        return newsList;
    }
}
