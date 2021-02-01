package com.sparta.week04.utils;

import com.sparta.week04.model.ItemDto;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component // 이제부터, @RequiredArgsConstructor 와 함께 사용할 경우 스프링이 자동으로 생성합니다.
public class NaverShopSearch {
    public String search(String query) {
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Naver-Client-Id", "xHSamJl2ICyvxYV0VP8D");
        headers.add("X-Naver-Client-Secret", "BsNWe65h_A");
        String body = "";

        HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers);
        ResponseEntity<String> responseEntity = rest.exchange("https://openapi.naver.com/v1/search/shop.json?query=" + query, HttpMethod.GET, requestEntity, String.class);
        HttpStatus httpStatus = responseEntity.getStatusCode();
        int status = httpStatus.value();
        String response = responseEntity.getBody();
        // System.out.println("Response status: " + status);
        // System.out.println(response);

        return response;
    }

    public List<ItemDto> fromJSONtoItems(String result) {
        JSONObject rjson = new JSONObject(result);
        JSONArray items  = rjson.getJSONArray("items");
        List<ItemDto> ret = new ArrayList<>();
        for (int i=0; i<items.length(); i++) {
            JSONObject itemJson = items.getJSONObject(i);
            // System.out.println(itemJson);
            ItemDto itemDto = new ItemDto(itemJson);
            ret.add(itemDto);
        }
        return ret;
    }

    public static void main(String[] args) {
        NaverShopSearch naverShopSearch = new NaverShopSearch();
        String result = naverShopSearch.search("아이맥");
        naverShopSearch.fromJSONtoItems(result);
/*
        System.out.println(result);

        JSONObject rjson = new JSONObject(result);
        JSONArray items = rjson.getJSONArray("items");
        for (int i=0; i<items.length(); i++) {
            JSONObject itemJson = (JSONObject) items.get(i);
            System.out.println(itemJson);

            String title = itemJson.getString("title");
            int lprice = itemJson.getInt("lprice");

            System.out.println(title);
            System.out.println(lprice);
            System.out.println();
        }
 */
    }
}



