package com.villalobos.covid19.model;

public class Covid {
    public String Country;
    public String CountryCode;
    public String NewConfirmed;
    public String TotalConfirmed;
    public String NewDeaths;
    public String TotalDeaths;
    public String NewRecovered;
    public String TotalRecovered;

    public Covid(){

    }

    public Covid(String country, String countryCode, String newConfirmed, String totalConfirmed,
                 String newDeaths, String totalDeaths, String newRecovered, String totalRecovered) {
        Country = country;
        CountryCode = countryCode;
        NewConfirmed = newConfirmed;
        TotalConfirmed = totalConfirmed;
        NewDeaths = newDeaths;
        TotalDeaths = totalDeaths;
        NewRecovered = newRecovered;
        TotalRecovered = totalRecovered;
    }
}
