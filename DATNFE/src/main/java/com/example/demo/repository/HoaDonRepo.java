package com.example.demo.repository;

import com.example.demo.entity.HoaDon;
import com.example.demo.entity.KhachHang;
import com.example.demo.entity.PageDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Repository
public class HoaDonRepo {
    RestTemplate restTemplate = new RestTemplate();
    String url = "http://localhost:2020/rest/hoadon";

    private String getUrl(String ma) {
        return url + "/" + ma;
    }

    private String getUrl1(UUID ma) {
        return url + "/" + ma;
    }

    public List<HoaDon> getAll() {
        ResponseEntity<List<HoaDon>> responseEntity =
                restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<HoaDon>>() {
                });
        return responseEntity.getBody();
    }

    public PageDTO<HoaDon> searchAndPaginate(Integer page, String keyword) {
        ResponseEntity<PageDTO<HoaDon>> responseEntity = restTemplate.exchange(
                getUrl("phantrang?page=" + page + "&keyword=" + keyword),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<PageDTO<HoaDon>>() {}
        );

        return responseEntity.getBody();
    }
}

