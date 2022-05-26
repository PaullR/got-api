package com.got.gotapi.model;

import lombok.Data;

import java.util.List;

@Data
public class Character {
    private String url;
    private String name;
    private String culture;
    private String born;
    private String died;
    private List<String> titles;
    private List<String> aliases;
    private String father;
    private String mother;
    private String spouse;
    private List<String> allegiances;
    private List<String> books;
    private List<String> povBooks;
    private List<String> tvSeries;
    private List<String> playedBody;
}
